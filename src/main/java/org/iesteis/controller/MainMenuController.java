package org.iesteis.controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.iesteis.database.DatabaseService;
import org.iesteis.repository.BaseRepository;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import javafx.util.Duration;

public final class MainMenuController {

    private static final String STYLESHEET_PATH = "/styles/Styles.css";

    // Define las columnas más útiles para mostrar en cada tabla.
    private static final Map<String, List<String>> RELEVANT_COLUMNS = Map.ofEntries(
            Map.entry("ability_scores", List.of("name", "full_name", "description")),
            Map.entry("alignments", List.of("name", "abbreviation", "description")),
            Map.entry("backgrounds", List.of("name", "ability_scores", "feat", "proficiencies")),
            Map.entry("classes", List.of("name", "primary_ability", "hit_die", "class_levels")),
            Map.entry("conditions", List.of("name", "description")),
            Map.entry("damage_types", List.of("name", "description")),
            Map.entry("equipment_categories", List.of("name", "equipment")),
            Map.entry("equipment", List.of("name", "equipment_categories", "cost", "weight", "description")),
            Map.entry("feats", List.of("name", "type", "description", "prerequisites")),
            Map.entry("features", List.of("name", "level", "class", "subclass", "description")),
            Map.entry("languages", List.of("name", "is_rare", "note")),
            Map.entry("levels", List.of("name", "level", "prof_bonus", "class", "subclass")),
            Map.entry("magic_items", List.of("name", "equipment_category", "rarity", "attunement", "variant")),
            Map.entry("magic_schools", List.of("name", "description")),
            Map.entry("monsters", List.of("name", "size", "type", "alignment", "hit_points", "challenge_rating", "xp")),
            Map.entry("poisons", List.of("name", "type", "cost", "description")),
            Map.entry("proficiencies", List.of("name", "type", "backgrounds", "classes", "reference")),
            Map.entry("skills", List.of("name", "description", "ability_score_index")),
            Map.entry("species", List.of("name", "type", "size", "speed")),
            Map.entry("spells", List.of("name", "level", "range", "duration", "casting_time", "school")),
            Map.entry("subclasses", List.of("name", "class", "summary", "description")),
            Map.entry("subspecies", List.of("name", "species", "traits", "damage_type")),
            Map.entry("traits", List.of("name", "species", "subspecies", "description")),
            Map.entry("weapon_mastery_properties", List.of("name", "description")),
            Map.entry("weapon_properties", List.of("name", "description")));

    // Lista de tablas disponibles para seleccionar en el panel izquierdo.
    @FXML
    private ListView<String> tables;

    // Muestra el nombre de la tabla seleccionada.
    @FXML
    private Label selectedTableName;

    // Tabla dinámica donde se muestran las columnas y filas de la selección.
    @FXML
    private TableView<Map<String, Object>> tableContent;

    // Campo de texto usado para filtrar las filas visibles de la tabla
    // seleccionada.
    @FXML
    private TextField tableSearch;

    // Conserva las filas cargadas para poder aplicar y quitar el filtro sin repetir
    // la consulta.
    private final ObservableList<Map<String, Object>> allTableRows =
            FXCollections.observableArrayList();
    private final FilteredList<Map<String, Object>> filteredTableRows =
            new FilteredList<>(allTableRows);

    // Servicio usado para consultar las tablas y sus datos en la base de datos.
    private final DatabaseService databaseService = new DatabaseService();

    @FXML
    private void initialize() {
        // Configura las tablas, el filtro y la interacción de la vista principal.
        loadAvailableTables();
        tableContent.setItems(filteredTableRows);
        configureListeners();
    }

    private void loadAvailableTables() {
        // Carga los nombres visibles de las tablas disponibles en la base de datos.
        tables.getItems().setAll(databaseService.listTables().stream()
                .map(this::formatTableName)
                .toList());
    }

    private void configureListeners() {
        // Centraliza los listeners para evitar lógica de interacción en initialize.
        tableSearch.textProperty().addListener(
                (observable, oldValue, newValue) -> updateTableFilter(newValue));
        tables.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldTable, newTable) -> loadTable(newTable));
    }

    private void loadTable(String tableName) {
        String databaseTableName = resolveDatabaseTableName(tableName);
        if (databaseTableName == null) {
            return;
        }

        selectedTableName.setText(tableName);
        tableSearch.clear();
        configureTableColumns(databaseTableName);
        String safeTableName = databaseTableName.replace("`", "``");
        allTableRows.setAll(
                databaseService.select("SELECT * FROM `" + safeTableName + "`"));
    }

    private String resolveDatabaseTableName(String visibleTableName) {
        // Convierte el nombre mostrado en la lista al nombre real de la tabla.
        if (visibleTableName == null) {
            return null;
        }
        return databaseService.listTables().stream()
                .filter(name -> formatTableName(name).equals(visibleTableName))
                .findFirst()
                .orElse(null);
    }

    private void configureTableColumns(String tableName) {
        // Genera las columnas visibles usando la configuración de cada tabla.
        tableContent.getColumns().clear();
        List<String> columns = databaseService.listTableColumns(tableName);
        List<String> visibleColumns = RELEVANT_COLUMNS.getOrDefault(tableName, columns);
        visibleColumns.forEach(columnName -> tableContent.getColumns().add(createTableColumn(columnName)));
    }

    private TableColumn<Map<String, Object>, String> createTableColumn(String columnName) {
        // Crea una columna con texto ajustable para valores largos.
        TableColumn<Map<String, Object>, String> column = new TableColumn<>(columnName);
        column.setCellValueFactory(cellData -> {
            Object value = cellData.getValue().get(columnName);
            return new javafx.beans.property.SimpleStringProperty(
                    value == null ? "" : String.valueOf(value));
        });
        column.setCellFactory(tableColumn -> createWrappedCell());
        column.setPrefWidth(160);
        return column;
    }

    private TableCell<Map<String, Object>, String> createWrappedCell() {
        // Permite varias líneas y adapta la altura de la fila al contenido.
        return new TableCell<>() {
            private final Label valueLabel = new Label();

            {
                valueLabel.setWrapText(true);
                valueLabel.getStyleClass().add("table-cell-value");
                valueLabel.maxWidthProperty().bind(widthProperty().subtract(16));
            }

            @Override
            protected void updateItem(String value, boolean empty) {
                super.updateItem(value, empty);
                valueLabel.setText(value == null ? "" : value);
                setGraphic(empty ? null : valueLabel);
                setText(null);
            }
        };
    }

    private void updateTableFilter(String searchText) {
        // Busca el texto introducido en cualquier valor de la fila, ignorando
        // mayúsculas.
        String normalizedSearch = searchText == null
                ? ""
                : searchText.trim().toLowerCase(Locale.ROOT);
        filteredTableRows.setPredicate(row -> normalizedSearch.isEmpty()
                || row.values().stream()
                        .anyMatch(value -> value != null
                                && String.valueOf(value).toLowerCase(Locale.ROOT)
                                        .contains(normalizedSearch)));
    }

    @FXML
    private void openAddDialog() {
        // Comprueba que exista una tabla seleccionada antes de construir el formulario.
        String visibleTableName = getSelectedVisibleTableName();
        String databaseTableName = getSelectedDatabaseTableName();
        if (visibleTableName == null || databaseTableName == null) {
            showMessage(AlertType.WARNING, "Añadir registro",
                    "Selecciona una tabla antes de añadir un registro.");
            return;
        }

        openRecordDialog(visibleTableName, databaseTableName, null, null);
    }

    @FXML
    private void openEditDialog() {
        // Comprueba que exista una fila seleccionada antes de abrir la edición.
        Map<String, Object> selectedRow = getSelectedRow();
        String visibleTableName = getSelectedVisibleTableName();
        String databaseTableName = getSelectedDatabaseTableName();
        if (selectedRow == null || visibleTableName == null || databaseTableName == null) {
            showMessage(AlertType.WARNING, "Modificar registro",
                    "Selecciona una fila antes de modificar un registro.");
            return;
        }

        Object originalIndex = selectedRow.get("index");
        if (originalIndex == null) {
            showMessage(AlertType.ERROR, "Modificar registro",
                    "El registro seleccionado no tiene un índice válido.");
            return;
        }

        openRecordDialog(visibleTableName, databaseTableName, selectedRow,
                String.valueOf(originalIndex));
    }

    private void openRecordDialog(String visibleTableName, String databaseTableName,
            Map<String, Object> existingRow, String originalIndex) {
        // Crea el mismo formulario para añadir y modificar registros.
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);
        form.getStyleClass().add("add-record-form");

        Map<String, TextArea> fields = new LinkedHashMap<>();
        List<String> columns = databaseService.listTableColumns(databaseTableName);
        for (int row = 0; row < columns.size(); row++) {
            String columnName = columns.get(row);
            Label label = new Label(columnName);
            TextArea input = new TextArea();
            input.setPromptText((existingRow == null ? "Introduce " : "Modifica ")
                    + formatColumnName(columnName));
            input.setPrefRowCount(1);
            input.setWrapText(true);
            if (existingRow != null && existingRow.get(columnName) != null) {
                input.setText(String.valueOf(existingRow.get(columnName)));
            }
            GridPane.setHgrow(input, Priority.ALWAYS);
            form.add(label, 0, row);
            form.add(input, 1, row);
            fields.put(columnName, input);
        }

        // Permite recorrer formularios grandes sin hacer crecer indefinidamente la ventana.
        ScrollPane formScrollPane = new ScrollPane(form);
        formScrollPane.setFitToWidth(true);
        formScrollPane.setPrefViewportWidth(760);
        formScrollPane.setPrefViewportHeight(520);
        formScrollPane.getStyleClass().add("add-record-scroll");

        Dialog<ButtonType> dialog = new Dialog<>();
        boolean editing = existingRow != null;
        dialog.setTitle(editing ? "Modificar registro" : "Añadir registro");
        dialog.setHeaderText((editing ? "Modificar ocurrencia en " : "Nueva ocurrencia en ")
                + visibleTableName);
        dialog.getDialogPane().setContent(formScrollPane);
        dialog.getDialogPane().setPrefSize(820, 650);
        dialog.setResizable(true);
        // Los diálogos tienen una escena independiente y necesitan cargar el estilo manualmente.
        dialog.getDialogPane().getStylesheets().add(
                getClass().getResource(STYLESHEET_PATH).toExternalForm());
        ButtonType saveButton = new ButtonType("Guardar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButton, ButtonType.CANCEL);

        dialog.setResultConverter(button -> button == saveButton ? saveButton : null);
        dialog.showAndWait().ifPresent(result -> {
            if (result == saveButton) {
                Map<String, String> values = new LinkedHashMap<>();
                fields.forEach((column, input) -> values.put(column, input.getText()));
                if (editing) {
                    updateRecord(databaseTableName, values, originalIndex);
                } else {
                    saveNewRecord(databaseTableName, values);
                }
            }
        });
    }

    private void saveNewRecord(String tableName, Map<String, String> values) {
        // Inserta todos los campos mediante parámetros JDBC.
        List<String> columns = databaseService.listTableColumns(tableName);
        String columnSql = columns.stream()
                .map(this::quoteIdentifier)
                .collect(java.util.stream.Collectors.joining(", "));
        String placeholders = String.join(", ",
                java.util.Collections.nCopies(columns.size(), "?"));
        String sql = "INSERT INTO " + quoteIdentifier(tableName) + " ("
                + columnSql + ") VALUES (" + placeholders + ")";
        Object[] parameters = columns.stream()
                .map(column -> databaseValue(values.get(column)))
                .toArray();

        int affectedRows = databaseService.insert(sql, parameters);
        if (affectedRows == 1) {
            reloadTableData(tableName);
            showMessage(AlertType.INFORMATION, "Registro guardado",
                    "El registro se ha añadido correctamente.");
        } else {
            showMessage(AlertType.ERROR, "Error al guardar",
                    "No se pudo añadir el registro. Comprueba los campos obligatorios.");
        }
    }

    private void updateRecord(String tableName, Map<String, String> values,
            String originalIndex) {
        // Actualiza el registro usando el índice original como identificador.
        List<String> columns = databaseService.listTableColumns(tableName);
        String assignments = columns.stream()
                .map(this::quoteIdentifier)
                .map(column -> column + " = ?")
                .collect(java.util.stream.Collectors.joining(", "));
        String sql = "UPDATE " + quoteIdentifier(tableName) + " SET "
                + assignments + " WHERE `index` = ?";
        Object[] parameters = new Object[columns.size() + 1];
        for (int i = 0; i < columns.size(); i++) {
            parameters[i] = databaseValue(values.get(columns.get(i)));
        }
        parameters[columns.size()] = originalIndex;

        int affectedRows = databaseService.update(sql, parameters);
        if (affectedRows == 1) {
            reloadTableData(tableName);
            showMessage(AlertType.INFORMATION, "Registro modificado",
                    "El registro se ha modificado correctamente.");
        } else {
            showMessage(AlertType.ERROR, "Error al modificar",
                    "No se pudo modificar el registro. Comprueba los campos obligatorios.");
        }
    }

    private String getSelectedDatabaseTableName() {
        // Traduce el nombre visible de la lista al nombre real de la tabla.
        String visibleTableName = getSelectedVisibleTableName();
        return databaseService.listTables().stream()
                .filter(name -> formatTableName(name).equals(visibleTableName))
                .findFirst()
                .orElse(null);
    }

    private String getSelectedVisibleTableName() {
        // Encapsula el acceso al nombre seleccionado en la vista de navegación.
        return tables.getSelectionModel().getSelectedItem();
    }

    private Map<String, Object> getSelectedRow() {
        // Encapsula el acceso a la fila seleccionada en la tabla principal.
        return tableContent.getSelectionModel().getSelectedItem();
    }

    private Object databaseValue(String value) {
        // Envía NULL para campos vacíos, permitiendo omitir columnas opcionales.
        return value == null || value.isBlank() ? null : value;
    }

    private String quoteIdentifier(String identifier) {
        // Protege nombres dinámicos de tablas y columnas para las consultas SQL.
        return "`" + identifier.replace("`", "``") + "`";
    }

    private String formatColumnName(String columnName) {
        // Hace más legible el nombre de cada columna dentro del formulario.
        String formattedName = columnName.replace('_', ' ').toLowerCase(Locale.ROOT);
        return formattedName.substring(0, 1).toUpperCase(Locale.ROOT)
                + formattedName.substring(1);
    }

    private void showMessage(AlertType type, String title, String message) {
        // Muestra mensajes breves reutilizables para acciones del formulario.
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void exportSelectedTableAsCsv() {
        String databaseTableName = getSelectedDatabaseTableName();
        if (databaseTableName == null) {
            return;
        }

        Window window = tables.getScene().getWindow();
        File selectedDirectory = chooseExportDirectory(window);
        if (selectedDirectory == null) {
            return;
        }

        try {
            BaseRepository.exportTableAsCsv(
                    databaseService, databaseTableName, selectedDirectory.toPath());
            showExportSuccess(window, databaseTableName + ".csv");
        } catch (IOException exception) {
            showMessage(AlertType.ERROR, "Error de exportación",
                    "No se pudo exportar la tabla a CSV.");
        }
    }

    @FXML
    private void exportAsJSON() {
        String databaseTableName = getSelectedDatabaseTableName();
        if (databaseTableName == null) {
            return;
        }

        Window window = tables.getScene().getWindow();
        File selectedDirectory = chooseExportDirectory(window);
        if (selectedDirectory == null) {
            return;
        }

        try {
            BaseRepository.exportAsJSON(
                    databaseService, databaseTableName, selectedDirectory.toPath());
            showExportSuccess(window, databaseTableName + ".json");
        } catch (RuntimeException exception) {
            showMessage(AlertType.ERROR, "Error de exportación",
                    "No se pudo exportar la tabla a JSON.");
        }
    }

    private File chooseExportDirectory(Window owner) {
        // Abre el selector común para las exportaciones CSV y JSON.
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Seleccionar directorio de exportación");
        return directoryChooser.showDialog(owner);
    }

    private void showExportSuccess(Window owner, String fileName) {
        // Muestra un aviso temporal de éxito en la esquina inferior derecha.
        Alert successAlert = new Alert(AlertType.INFORMATION);
        successAlert.setTitle("Exportación completada");
        successAlert.setHeaderText(null);
        successAlert.setContentText("La tabla se ha exportado correctamente como " + fileName + ".");
        successAlert.initOwner(owner);
        successAlert.setOnShown(event -> {
            Window alertWindow = successAlert.getDialogPane().getScene().getWindow();
            alertWindow.setOpacity(1.0);
            alertWindow.setX(owner.getX() + owner.getWidth() - alertWindow.getWidth() - 20);
            alertWindow.setY(owner.getY() + owner.getHeight() - alertWindow.getHeight() - 20);

            PauseTransition closeTimer = new PauseTransition(Duration.seconds(1));
            closeTimer.setOnFinished(closeEvent -> {
                Timeline fadeOut = new Timeline(
                        new KeyFrame(Duration.ZERO,
                                new KeyValue(alertWindow.opacityProperty(), 1.0)),
                        new KeyFrame(Duration.seconds(1),
                                new KeyValue(alertWindow.opacityProperty(), 0.0)));
                fadeOut.setOnFinished(fadeEvent -> alertWindow.hide());
                fadeOut.play();
            });
            closeTimer.play();
        });
        successAlert.show();
    }

    @FXML
    private void deleteFromTable() {
        Map<String, Object> selectedRow = getSelectedRow();
        String databaseTableName = getSelectedDatabaseTableName();
        if (selectedRow == null || databaseTableName == null) {
            showMessage(AlertType.WARNING, "Borrar registro",
                    "Selecciona una fila antes de borrarla.");
            return;
        }

        Object index = selectedRow.get("index");
        if (index == null) {
            showMessage(AlertType.ERROR, "Borrar registro",
                    "El registro seleccionado no tiene un índice válido.");
            return;
        }

        int affectedRows = databaseService.delete(
                "DELETE FROM " + quoteIdentifier(databaseTableName)
                        + " WHERE `index` = ?",
                index);
        if (affectedRows == 1) {
            reloadTableData(databaseTableName);
            showMessage(AlertType.INFORMATION, "Registro borrado",
                    "El registro se ha borrado correctamente.");
        } else {
            showMessage(AlertType.ERROR, "Error al borrar",
                    "No se pudo borrar el registro.");
        }
    }

    private void reloadTableData(String tableName) {
        // Recarga las filas después de una operación de escritura.
        String safeTableName = tableName.replace("`", "``");
        allTableRows.setAll(
                databaseService.select("SELECT * FROM `" + safeTableName + "`"));
    }

    private String formatTableName(String tableName) {
        // Sustituye guiones bajos por espacios y pone en mayúscula solo la primera
        // letra.
        String formattedName = tableName.replace('_', ' ').toLowerCase(Locale.ROOT);
        return formattedName.substring(0, 1).toUpperCase(Locale.ROOT)
                + formattedName.substring(1);
    }
}
