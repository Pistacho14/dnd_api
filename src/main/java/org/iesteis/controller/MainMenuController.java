package org.iesteis.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.iesteis.database.DatabaseService;
import org.iesteis.repository.BaseRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.animation.PauseTransition;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import javafx.util.Duration;
import javafx.collections.transformation.FilteredList;

public class MainMenuController {

    // Define las columnas más útiles para mostrar las tres primeras tablas al usuario.
    private static final Map<String, List<String>> RELEVANT_COLUMNS = Map.of(
            "ability_scores", List.of("name", "full_name", "description"),
            "alignments", List.of("name", "abbreviation", "description"),
            "backgrounds", List.of("name", "ability_scores", "feat", "proficiencies"));

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
    private final ObservableList<Map<String, Object>> allTableRows = FXCollections.observableArrayList();
    private FilteredList<Map<String, Object>> filteredTableRows;

    // Servicio usado para consultar las tablas y sus datos en la base de datos.
    private final DatabaseService databaseService = new DatabaseService();

    @FXML
    private void initialize() {
        // Carga las tablas al iniciar la pantalla y escucha los cambios de selección.
        tables.getItems().setAll(databaseService.listTables().stream()
                .map(this::formatTableName)
                .toList());
        filteredTableRows = new FilteredList<>(allTableRows);
        tableContent.setItems(filteredTableRows);
        tableSearch.textProperty().addListener((observable, oldValue, newValue) -> updateTableFilter(newValue));
        tables.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldTable, newTable) -> loadTable(newTable));
    }

    private void loadTable(String tableName) {
        // Convierte el nombre visible al nombre real antes de consultar la base de
        // datos.
        String databaseTableName = tableName == null
                ? null
                : databaseService.listTables().stream()
                        .filter(name -> formatTableName(name).equals(tableName))
                        .findFirst()
                        .orElse(null);

        // Ignora selecciones inválidas para evitar consultar una tabla no disponible.
        if (databaseTableName == null) {
            return;
        }

        // Elimina la vista anterior antes de construir las columnas de la nueva tabla.
        selectedTableName.setText(tableName);
        tableContent.getColumns().clear();
        tableSearch.clear();

        // Muestra solo las columnas configuradas; las demás tablas conservan todas sus columnas.
        List<String> columns = databaseService.listTableColumns(databaseTableName);
        List<String> visibleColumns = RELEVANT_COLUMNS.getOrDefault(
                databaseTableName, columns);
        for (String columnName : visibleColumns) {
            TableColumn<Map<String, Object>, String> column = new TableColumn<>(columnName);
            column.setCellValueFactory(cellData -> {
                // Convierte el valor de cada celda a texto para mostrarlo en la tabla.
                Object value = cellData.getValue().get(columnName);
                return new javafx.beans.property.SimpleStringProperty(
                        value == null ? "" : String.valueOf(value));
            });
            column.setCellFactory(tableColumn -> {
                // Permite varias líneas y hace que la altura de la fila se adapte al contenido.
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
            });
            column.setPrefWidth(160);
            tableContent.getColumns().add(column);
        }

        // Protege el nombre de tabla antes de consultar todos sus registros.
        String safeTableName = databaseTableName.replace("`", "``");
        // Sustituye las filas base; el FilteredList actualiza automáticamente la vista.
        allTableRows.setAll(
                databaseService.select("SELECT * FROM `" + safeTableName + "`"));
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
        String visibleTableName = tables.getSelectionModel().getSelectedItem();
        if (visibleTableName == null) {
            showMessage(AlertType.WARNING, "Añadir registro",
                    "Selecciona una tabla antes de añadir un registro.");
            return;
        }

        String databaseTableName = databaseService.listTables().stream()
                .filter(name -> formatTableName(name).equals(visibleTableName))
                .findFirst()
                .orElse(null);
        if (databaseTableName == null) {
            return;
        }

        // Crea un campo de formulario por cada columna de la tabla seleccionada.
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
            input.setPromptText("Introduce " + formatColumnName(columnName));
            input.setPrefRowCount(1);
            input.setWrapText(true);
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
        dialog.setTitle("Añadir registro");
        dialog.setHeaderText("Nueva ocurrencia en " + visibleTableName);
        dialog.getDialogPane().setContent(formScrollPane);
        dialog.getDialogPane().setPrefSize(820, 650);
        dialog.setResizable(true);
        // Los diálogos tienen una escena independiente y necesitan cargar el estilo manualmente.
        dialog.getDialogPane().getStylesheets().add(
                getClass().getResource("/styles/Styles.css").toExternalForm());
        ButtonType saveButton = new ButtonType("Guardar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButton, ButtonType.CANCEL);

        // El formulario solo recoge los valores; la inserción se conectará al back-end.
        dialog.setResultConverter(button -> button == saveButton ? saveButton : null);
        dialog.showAndWait().ifPresent(result -> {
            if (result == saveButton) {
                Map<String, String> values = new LinkedHashMap<>();
                fields.forEach((column, input) -> values.put(column, input.getText()));
                showMessage(AlertType.INFORMATION, "Formulario preparado",
                        "Los datos se han recogido. Falta conectarlos con el back-end.");
            }
        });
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
        // Impide exportar si todavía no se ha seleccionado ninguna tabla.
        String visibleTableName = tables.getSelectionModel().getSelectedItem();
        if (visibleTableName == null) {
            return;
        }

        // Abre el selector para que el usuario indique dónde guardar el archivo CSV.
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Seleccionar directorio de exportación");
        Window window = tables.getScene().getWindow();
        java.io.File selectedDirectory = directoryChooser.showDialog(window);
        if (selectedDirectory == null) {
            return;
        }

        String databaseTableName = databaseService.listTables().stream()
                .filter(name -> formatTableName(name).equals(visibleTableName))
                .findFirst()
                .orElse(null);
        if (databaseTableName == null) {
            return;
        }

        try {
            // Reutiliza la exportación CSV común y genera el archivo dentro del directorio
            // elegido.
            BaseRepository.exportTableAsCsv(
                    databaseService, databaseTableName, selectedDirectory.toPath());

            // Informa al usuario cuando el archivo CSV se ha creado correctamente.
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Exportación completada");
            successAlert.setHeaderText(null);
            successAlert.setContentText(
                    "La tabla se ha exportado correctamente como "
                            + databaseTableName + ".csv.");
            successAlert.initOwner(window);
            successAlert.setOnShown(event -> {
                // Coloca el aviso en la esquina inferior derecha de la ventana principal.
                Window alertWindow = successAlert.getDialogPane().getScene().getWindow();
                // Parte de una ventana completamente visible antes de iniciar el aviso.
                alertWindow.setOpacity(1.0);
                alertWindow.setX(window.getX() + window.getWidth()
                        - alertWindow.getWidth() - 20);
                alertWindow.setY(window.getY() + window.getHeight()
                        - alertWindow.getHeight() - 20);

                // Mantiene el aviso visible dos segundos antes de comenzar a ocultarlo.
                PauseTransition closeTimer = new PauseTransition(Duration.seconds(1));
                closeTimer.setOnFinished(closeEvent -> {
                    // Reduce la opacidad de toda la ventana durante el último segundo.
                    Timeline fadeOut = new Timeline(
                            new KeyFrame(Duration.ZERO, new KeyValue(alertWindow.opacityProperty(), 1.0)),
                            new KeyFrame(Duration.seconds(1), new KeyValue(alertWindow.opacityProperty(), 0.0)));
                    fadeOut.setOnFinished(fadeEvent -> alertWindow.hide());
                    fadeOut.play();
                });
                closeTimer.play();
            });
            successAlert.show();
        } catch (IOException exception) {
            throw new IllegalStateException("No se pudo exportar la tabla a CSV", exception);
        }
    }

    @FXML
    private void exportAsJSON() {
        // Impide exportar si todavía no se ha seleccionado ninguna tabla.
        String visibleTableName = tables.getSelectionModel().getSelectedItem();
        if (visibleTableName == null) {
            return;
        }

        // Abre el selector para que el usuario indique dónde guardar el archivo CSV.
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Seleccionar directorio de exportación");
        Window window = tables.getScene().getWindow();
        java.io.File selectedDirectory = directoryChooser.showDialog(window);
        if (selectedDirectory == null) {
            return;
        }

        String databaseTableName = databaseService.listTables().stream()
                .filter(name -> formatTableName(name).equals(visibleTableName))
                .findFirst()
                .orElse(null);
        if (databaseTableName == null) {
            return;
        }

        try {
            // Reutiliza la exportación CSV común y genera el archivo dentro del directorio
            // elegido.
            BaseRepository.exportAsJSON(
                    databaseService, databaseTableName, selectedDirectory.toPath());

            // Informa al usuario cuando el archivo CSV se ha creado correctamente.
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Exportación completada");
            successAlert.setHeaderText(null);
            successAlert.setContentText(
                    "La tabla se ha exportado correctamente como "
                            + databaseTableName + ".JSON.");
            successAlert.initOwner(window);
            successAlert.setOnShown(event -> {
                // Coloca el aviso en la esquina inferior derecha de la ventana principal.
                Window alertWindow = successAlert.getDialogPane().getScene().getWindow();
                // Parte de una ventana completamente visible antes de iniciar el aviso.
                alertWindow.setOpacity(1.0);
                alertWindow.setX(window.getX() + window.getWidth()
                        - alertWindow.getWidth() - 20);
                alertWindow.setY(window.getY() + window.getHeight()
                        - alertWindow.getHeight() - 20);

                // Mantiene el aviso visible dos segundos antes de comenzar a ocultarlo.
                PauseTransition closeTimer = new PauseTransition(Duration.seconds(1));
                closeTimer.setOnFinished(closeEvent -> {
                    // Reduce la opacidad de toda la ventana durante el último segundo.
                    Timeline fadeOut = new Timeline(
                            new KeyFrame(Duration.ZERO, new KeyValue(alertWindow.opacityProperty(), 1.0)),
                            new KeyFrame(Duration.seconds(1), new KeyValue(alertWindow.opacityProperty(), 0.0)));
                    fadeOut.setOnFinished(fadeEvent -> alertWindow.hide());
                    fadeOut.play();
                });
                closeTimer.play();
            });
            successAlert.show();
        } catch (Exception exception) {
            throw new IllegalStateException("No se pudo exportar la tabla a JSON", exception);
        }
    }

    @FXML
    private void deleteFromTable() {

        Map<String, Object> selectedRow = tableContent.getSelectionModel().getSelectedItem();
        String selectedTable =
        tables.getSelectionModel().getSelectedItem();
        String databaseTableName = databaseService.listTables().stream()
        .filter(name -> formatTableName(name).equals(selectedTable))
        .findFirst()
        .orElse(null);

        try {
            if (selectedRow == null) {
            Alert successAlert = new Alert(Alert.AlertType.ERROR);
            successAlert.setTitle("Error en el borrado");
            successAlert.setHeaderText(null);
            successAlert.setContentText(
                    "Selecciona una fila para poder borrarla");
        }
        else {
            System.out.println((String) selectedRow.get("index"));
            databaseService.delete("DELETE FROM `" + databaseTableName + "` WHERE `index` = ?",(String) selectedRow.get("index"));
            recargarDatos(databaseTableName);
        }
        } catch (Exception e) {
            // TODO: handle exception, display window
        }
    }

    private void recargarDatos(String tableName) {
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
