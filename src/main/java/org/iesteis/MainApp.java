package org.iesteis;

import tools.jackson.core.type.TypeReference;

import org.iesteis.api.DndApiClient;
import org.iesteis.model.ApiListResponse;
import org.iesteis.repository.alignments.AlignmentsRepositoryImpl;
import org.iesteis.repository.background.BackgroundRepositoryImpl;
import org.iesteis.repository.classes.ClassesRepositoryImpl;
import org.iesteis.repository.conditions.ConditionsRepositoryImpl;
import org.iesteis.repository.damageTypes.DamageTypesRepositoryImpl;
import org.iesteis.repository.equipment.EquipmentRepositoryImpl;
import org.iesteis.repository.equipmentCategories.EquipmentCategoriesRepositoryImpl;
import org.iesteis.repository.feats.FeatsRepositoryImpl;
import org.iesteis.repository.abilityScore.AbilityScoresRepositoryImpl;
import org.iesteis.repository.skills.SkillsRepositoryImpl;
import org.iesteis.model.Response;
import org.iesteis.model.abilityScores.AbilityScores;
import org.iesteis.model.skills.Skills;
import org.iesteis.model.alignments.Alignments;
import org.iesteis.model.background.Background;
import org.iesteis.model.classes.Classes;
import org.iesteis.model.conditions.Conditions;
import org.iesteis.model.damageTypes.DamageTypes;
import org.iesteis.model.equipment.Equipment;
import org.iesteis.model.equipmentCategories.EquipmentCategories;
import org.iesteis.model.feats.Feats;

public class MainApp{
/*    private static Stage stage;

    @Override
    public void start(@SuppressWarnings("exports") Stage s) throws IOException {
        stage=s;
        setRoot("primary","");
    }

    static void setRoot(String fxml) throws IOException {
        setRoot(fxml,stage.getTitle());
    }

    static void setRoot(String fxml, String title) throws IOException {
        Scene scene = new Scene(loadFXML(fxml));
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }
*/

    public static void main(String[] args) {
        // launch(args);

        Response response = DndApiClient.readAPIRest();

        ApiListResponse<AbilityScores> abilityScores = DndApiClient.readAPIRest(
                response.getAbilityScores(),
                new TypeReference<ApiListResponse<AbilityScores>>() {});
        AbilityScoresRepositoryImpl abilityScoresRepository = new AbilityScoresRepositoryImpl();
        abilityScores.getResults().forEach(item -> {
            AbilityScores detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<AbilityScores>() {});
            abilityScoresRepository.save(detail);
        });

        ApiListResponse<Alignments> alignments = DndApiClient.readAPIRest(
                response.getAlignments(),
                new TypeReference<ApiListResponse<Alignments>>() {});
        AlignmentsRepositoryImpl alignmentsRepository = new AlignmentsRepositoryImpl();
        alignments.getResults().forEach(item -> {
            Alignments detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Alignments>() {});
            alignmentsRepository.save(detail);
        });

        ApiListResponse<Background> backgrounds = DndApiClient.readAPIRest(
                response.getBackgrounds(),
                new TypeReference<ApiListResponse<Background>>() {});
        BackgroundRepositoryImpl backgroundsRepository = new BackgroundRepositoryImpl();
        backgrounds.getResults().forEach(item -> {
            Background detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Background>() {});
            backgroundsRepository.save(detail);
        });

        ApiListResponse<Classes> classes = DndApiClient.readAPIRest(
                response.getClasses(),
                new TypeReference<ApiListResponse<Classes>>() {});
        ClassesRepositoryImpl classesRepository = new ClassesRepositoryImpl();
        classes.getResults().forEach(item -> {
            Classes detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Classes>() {});
            classesRepository.save(detail);
        });

        ApiListResponse<Conditions> conditions = DndApiClient.readAPIRest(
                response.getConditions(),
                new TypeReference<ApiListResponse<Conditions>>() {});
        ConditionsRepositoryImpl conditionsRepository = new ConditionsRepositoryImpl();
        conditions.getResults().forEach(item -> {
            Conditions detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Conditions>() {});
            conditionsRepository.save(detail);
        });

        ApiListResponse<DamageTypes> damageTypes = DndApiClient.readAPIRest(
                response.getDamageTypes(),
                new TypeReference<ApiListResponse<DamageTypes>>() {});
        DamageTypesRepositoryImpl damageTypesRepository = new DamageTypesRepositoryImpl();
        damageTypes.getResults().forEach(item -> {
            DamageTypes detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<DamageTypes>() {});
            damageTypesRepository.save(detail);
        });

        ApiListResponse<EquipmentCategories> equipmentCategories = DndApiClient.readAPIRest(
                response.getEquipmentCategories(),
                new TypeReference<ApiListResponse<EquipmentCategories>>() {});
        EquipmentCategoriesRepositoryImpl equipmentCategoriesRepository =
                new EquipmentCategoriesRepositoryImpl();
        equipmentCategories.getResults().forEach(item -> {
            EquipmentCategories detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<EquipmentCategories>() {});
            equipmentCategoriesRepository.save(detail);
        });

        ApiListResponse<Equipment> equipment = DndApiClient.readAPIRest(
                response.getEquipment(),
                new TypeReference<ApiListResponse<Equipment>>() {});
        EquipmentRepositoryImpl equipmentRepository = new EquipmentRepositoryImpl();
        equipment.getResults().forEach(item -> {
            Equipment detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Equipment>() {});
            equipmentRepository.save(detail);
        });

        ApiListResponse<Feats> feats = DndApiClient.readAPIRest(
                response.getFeats(),
                new TypeReference<ApiListResponse<Feats>>() {});
        FeatsRepositoryImpl featsRepository = new FeatsRepositoryImpl();
        feats.getResults().forEach(item -> {
            Feats detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Feats>() {});
            featsRepository.save(detail);
        });

        ApiListResponse<Skills> skills = DndApiClient.readAPIRest(
                response.getSkills(),
                new TypeReference<ApiListResponse<Skills>>() {});
        SkillsRepositoryImpl skillsRepository = new SkillsRepositoryImpl();
        skills.getResults().forEach(item -> {
            Skills detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Skills>() {});
            skillsRepository.save(detail);
        });
    }
}