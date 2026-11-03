package org.iesteis;

import tools.jackson.core.type.TypeReference;
import java.util.List;

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
import org.iesteis.repository.features.FeaturesRepositoryImpl;
import org.iesteis.repository.languages.LanguagesRepositoryImpl;
import org.iesteis.repository.levels.LevelsRepositoryImpl;
import org.iesteis.repository.magicItems.MagicItemsRepositoryImpl;
import org.iesteis.repository.magicSchools.MagicSchoolsRepositoryImpl;
import org.iesteis.repository.monsters.MonstersRepositoryImpl;
import org.iesteis.repository.poisons.PoisonsRepositoryImpl;
import org.iesteis.repository.proficiencies.ProficienciesRepositoryImpl;
import org.iesteis.repository.species.SpeciesRepositoryImpl;
import org.iesteis.repository.spells.SpellsRepositoryImpl;
import org.iesteis.repository.subclasses.SubclassesRepositoryImpl;
import org.iesteis.repository.subspecies.SubspeciesRepositoryImpl;
import org.iesteis.repository.traits.TraitsRepositoryImpl;
import org.iesteis.repository.weaponMasteryProperties.WeaponMasteryPropertiesRepositoryImpl;
import org.iesteis.repository.weaponProperties.WeaponPropertiesRepositoryImpl;
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
import org.iesteis.model.features.Features;
import org.iesteis.model.languages.Languages;
import org.iesteis.model.levels.Levels;
import org.iesteis.model.magicItems.MagicItems;
import org.iesteis.model.magicSchools.MagicSchools;
import org.iesteis.model.monsters.Monster;
import org.iesteis.model.poisons.Poisons;
import org.iesteis.model.proficiencies.Proficiencies;
import org.iesteis.model.species.Species;
import org.iesteis.model.spells.Spells;
import org.iesteis.model.subclasses.Subclasses;
import org.iesteis.model.subspecies.Subspecies;
import org.iesteis.model.traits.Traits;
import org.iesteis.model.weaponMasteryProperties.WeaponMasteryProperties;
import org.iesteis.model.weaponProperties.WeaponProperties;

import javafx.application.Application;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static Scene scene;

    @Override 
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));
        
        scene = new Scene(loader.load(), 1280, 800);
        stage.setTitle("Dungeon and Dragons API");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

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
        LevelsRepositoryImpl levelsRepository = new LevelsRepositoryImpl();
        classes.getResults().forEach(item -> {
            Classes detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Classes>() {});
            classesRepository.save(detail);
            List<Levels> levels = DndApiClient.readAPIRest(
                    detail.getClassLevels(),
                    new TypeReference<List<Levels>>() {});
            levels.forEach(levelItem -> {
                Levels levelDetail = DndApiClient.readAPIRest(
                        levelItem.getUrl(),
                        new TypeReference<Levels>() {});
                levelsRepository.save(levelDetail);
            });
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

        ApiListResponse<Features> features = DndApiClient.readAPIRest(
                response.getFeatures(),
                new TypeReference<ApiListResponse<Features>>() {});
        FeaturesRepositoryImpl featuresRepository = new FeaturesRepositoryImpl();
        features.getResults().forEach(item -> {
            Features detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Features>() {});
            featuresRepository.save(detail);
        });

        ApiListResponse<Languages> languages = DndApiClient.readAPIRest(
                response.getLanguages(),
                new TypeReference<ApiListResponse<Languages>>() {});
        LanguagesRepositoryImpl languagesRepository = new LanguagesRepositoryImpl();
        languages.getResults().forEach(item -> {
            Languages detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Languages>() {});
            languagesRepository.save(detail);
        });

        ApiListResponse<MagicItems> magicItems = DndApiClient.readAPIRest(
                response.getMagicItems(),
                new TypeReference<ApiListResponse<MagicItems>>() {});
        MagicItemsRepositoryImpl magicItemsRepository = new MagicItemsRepositoryImpl();
        magicItems.getResults().forEach(item -> {
            MagicItems detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<MagicItems>() {});
            magicItemsRepository.save(detail);
        });

        ApiListResponse<MagicSchools> magicSchools = DndApiClient.readAPIRest(
                response.getMagicSchools(),
                new TypeReference<ApiListResponse<MagicSchools>>() {});
        MagicSchoolsRepositoryImpl magicSchoolsRepository = new MagicSchoolsRepositoryImpl();
        magicSchools.getResults().forEach(item -> {
            MagicSchools detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<MagicSchools>() {});
            magicSchoolsRepository.save(detail);
        });

        ApiListResponse<Monster> monsters = DndApiClient.readAPIRest(
                response.getMonsters(),
                new TypeReference<ApiListResponse<Monster>>() {});
        MonstersRepositoryImpl monstersRepository = new MonstersRepositoryImpl();
        monsters.getResults().forEach(item -> {
            Monster detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Monster>() {});
            monstersRepository.save(detail);
        });

        ApiListResponse<Poisons> poisons = DndApiClient.readAPIRest(
                response.getPoisons(),
                new TypeReference<ApiListResponse<Poisons>>() {});
        PoisonsRepositoryImpl poisonsRepository = new PoisonsRepositoryImpl();
        poisons.getResults().forEach(item -> {
            Poisons detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Poisons>() {});
            poisonsRepository.save(detail);
        });
        /*ApiListResponse<Proficiencies> proficiencies = DndApiClient.readAPIRest(
                response.getProficiencies(),
                new TypeReference<ApiListResponse<Proficiencies>>() {});
        ProficienciesRepositoryImpl proficienciesRepository = new ProficienciesRepositoryImpl();
        proficiencies.getResults().forEach(item -> {
            Proficiencies detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Proficiencies>() {});
            proficienciesRepository.save(detail);
        }); */

        ApiListResponse<Species> species = DndApiClient.readAPIRest(
                response.getSpecies(),
                new TypeReference<ApiListResponse<Species>>() {});
        SpeciesRepositoryImpl speciesRepository = new SpeciesRepositoryImpl();
        species.getResults().forEach(item -> {
            Species detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Species>() {});
            speciesRepository.save(detail);
        });

        ApiListResponse<Spells> spells = DndApiClient.readAPIRest(
                response.getSpells(),
                new TypeReference<ApiListResponse<Spells>>() {});
        SpellsRepositoryImpl spellsRepository = new SpellsRepositoryImpl();
        spells.getResults().forEach(item -> {
            Spells detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Spells>() {});
            spellsRepository.save(detail);
        });

        ApiListResponse<Subclasses> subclasses = DndApiClient.readAPIRest(
                response.getSubclasses(),
                new TypeReference<ApiListResponse<Subclasses>>() {});
        SubclassesRepositoryImpl subclassesRepository = new SubclassesRepositoryImpl();
        subclasses.getResults().forEach(item -> {
            Subclasses detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Subclasses>() {});
            subclassesRepository.save(detail);
        });

        ApiListResponse<Subspecies> subspecies = DndApiClient.readAPIRest(
                response.getSubspecies(),
                new TypeReference<ApiListResponse<Subspecies>>() {});
        SubspeciesRepositoryImpl subspeciesRepository = new SubspeciesRepositoryImpl();
        subspecies.getResults().forEach(item -> {
            Subspecies detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Subspecies>() {});
            subspeciesRepository.save(detail);
        });

        ApiListResponse<Traits> traits = DndApiClient.readAPIRest(
                response.getTraits(),
                new TypeReference<ApiListResponse<Traits>>() {});
        TraitsRepositoryImpl traitsRepository = new TraitsRepositoryImpl();
        traits.getResults().forEach(item -> {
            Traits detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<Traits>() {});
            traitsRepository.save(detail);
        });

        ApiListResponse<WeaponMasteryProperties> weaponMasteryProperties = DndApiClient.readAPIRest(
                response.getWeaponMasteryProperties(),
                new TypeReference<ApiListResponse<WeaponMasteryProperties>>() {});
        WeaponMasteryPropertiesRepositoryImpl weaponMasteryPropertiesRepository =
                new WeaponMasteryPropertiesRepositoryImpl();
        weaponMasteryProperties.getResults().forEach(item -> {
            WeaponMasteryProperties detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<WeaponMasteryProperties>() {});
            weaponMasteryPropertiesRepository.save(detail);
        });

        ApiListResponse<WeaponProperties> weaponProperties = DndApiClient.readAPIRest(
                response.getWeaponProperties(),
                new TypeReference<ApiListResponse<WeaponProperties>>() {});
        WeaponPropertiesRepositoryImpl weaponPropertiesRepository = new WeaponPropertiesRepositoryImpl();
        weaponProperties.getResults().forEach(item -> {
            WeaponProperties detail = DndApiClient.readAPIRest(
                    item.getUrl(),
                    new TypeReference<WeaponProperties>() {});
            weaponPropertiesRepository.save(detail);
        });
    }  
}