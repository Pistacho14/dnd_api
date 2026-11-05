package org.iesteis.service;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;

import org.iesteis.api.DndApiClient;
import org.iesteis.model.ApiListResponse;
import org.iesteis.model.Response;
import org.iesteis.model.abilityScores.AbilityScores;
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
import org.iesteis.model.skills.Skills;
import org.iesteis.model.species.Species;
import org.iesteis.model.spells.Spells;
import org.iesteis.model.subclasses.Subclasses;
import org.iesteis.model.subspecies.Subspecies;
import org.iesteis.model.traits.Traits;
import org.iesteis.model.weaponMasteryProperties.WeaponMasteryProperties;
import org.iesteis.model.weaponProperties.WeaponProperties;
import org.iesteis.repository.abilityScore.AbilityScoresRepositoryImpl;
import org.iesteis.repository.alignments.AlignmentsRepositoryImpl;
import org.iesteis.repository.background.BackgroundRepositoryImpl;
import org.iesteis.repository.classes.ClassesRepositoryImpl;
import org.iesteis.repository.conditions.ConditionsRepositoryImpl;
import org.iesteis.repository.damageTypes.DamageTypesRepositoryImpl;
import org.iesteis.repository.equipment.EquipmentRepositoryImpl;
import org.iesteis.repository.equipmentCategories.EquipmentCategoriesRepositoryImpl;
import org.iesteis.repository.feats.FeatsRepositoryImpl;
import org.iesteis.repository.features.FeaturesRepositoryImpl;
import org.iesteis.repository.languages.LanguagesRepositoryImpl;
import org.iesteis.repository.levels.LevelsRepositoryImpl;
import org.iesteis.repository.magicItems.MagicItemsRepositoryImpl;
import org.iesteis.repository.magicSchools.MagicSchoolsRepositoryImpl;
import org.iesteis.repository.monsters.MonstersRepositoryImpl;
import org.iesteis.repository.poisons.PoisonsRepositoryImpl;
import org.iesteis.repository.skills.SkillsRepositoryImpl;
import org.iesteis.repository.species.SpeciesRepositoryImpl;
import org.iesteis.repository.spells.SpellsRepositoryImpl;
import org.iesteis.repository.subclasses.SubclassesRepositoryImpl;
import org.iesteis.repository.subspecies.SubspeciesRepositoryImpl;
import org.iesteis.repository.traits.TraitsRepositoryImpl;
import org.iesteis.repository.weaponMasteryProperties.WeaponMasteryPropertiesRepositoryImpl;
import org.iesteis.repository.weaponProperties.WeaponPropertiesRepositoryImpl;

import tools.jackson.core.type.TypeReference;

public class ApiImport {



        private static final ExecutorService DETAIL_EXECUTOR = Executors.newFixedThreadPool(32, runnable -> {
                Thread thread = new Thread(runnable, "api-detail-loader");
                thread.setDaemon(true);
                return thread;
        });

        // Descarga en paralelo los detalles para reducir el tiempo de espera de la API.
        private static <S, D> void fetchDetailsInParallel(
                        List<S> summaries,
                        Function<S, String> urlExtractor,
                        TypeReference<D> typeReference,
                        Consumer<D> detailConsumer) {
                List<Callable<D>> tasks = summaries.stream()
                                .map(summary -> (Callable<D>) () -> DndApiClient.readAPIRest(
                                                urlExtractor.apply(summary), typeReference))
                                .toList();

                try {
                        for (Future<D> result : DETAIL_EXECUTOR.invokeAll(tasks)) {
                                detailConsumer.accept(result.get());
                        }
                } catch (InterruptedException exception) {
                        Thread.currentThread().interrupt();
                        throw new IllegalStateException("Se interrumpió la descarga de detalles de la API", exception);
                } catch (ExecutionException exception) {
                        throw new IllegalStateException("No se pudo descargar un detalle de la API",
                                        exception.getCause());
                }
        }

        private static <S, D> List<D> fetchDetailsInParallel(
                        List<S> summaries,
                        Function<S, String> urlExtractor,
                        TypeReference<D> typeReference) {
                List<D> details = new ArrayList<>();
                fetchDetailsInParallel(summaries, urlExtractor, typeReference, details::add);
                return details;
        }

        public static void apiImport() {
                Response response = DndApiClient.readAPIRest();

                ApiListResponse<AbilityScores> abilityScores = DndApiClient.readAPIRest(
                                response.getAbilityScores(),
                                new TypeReference<ApiListResponse<AbilityScores>>() {
                                });
                AbilityScoresRepositoryImpl abilityScoresRepository = new AbilityScoresRepositoryImpl();
                fetchDetailsInParallel(abilityScores.getResults(), AbilityScores::getUrl,
                                new TypeReference<AbilityScores>() {
                                }, abilityScoresRepository::save);

                ApiListResponse<Alignments> alignments = DndApiClient.readAPIRest(
                                response.getAlignments(),
                                new TypeReference<ApiListResponse<Alignments>>() {
                                });
                AlignmentsRepositoryImpl alignmentsRepository = new AlignmentsRepositoryImpl();
                fetchDetailsInParallel(alignments.getResults(), Alignments::getUrl,
                                new TypeReference<Alignments>() {
                                }, alignmentsRepository::save);

                ApiListResponse<Background> backgrounds = DndApiClient.readAPIRest(
                                response.getBackgrounds(),
                                new TypeReference<ApiListResponse<Background>>() {
                                });
                BackgroundRepositoryImpl backgroundsRepository = new BackgroundRepositoryImpl();
                fetchDetailsInParallel(backgrounds.getResults(), Background::getUrl,
                                new TypeReference<Background>() {
                                }, backgroundsRepository::save);

                ApiListResponse<Classes> classes = DndApiClient.readAPIRest(
                                response.getClasses(),
                                new TypeReference<ApiListResponse<Classes>>() {
                                });
                ClassesRepositoryImpl classesRepository = new ClassesRepositoryImpl();
                LevelsRepositoryImpl levelsRepository = new LevelsRepositoryImpl();
                List<Classes> classDetails = fetchDetailsInParallel(
                                classes.getResults(), Classes::getUrl, new TypeReference<Classes>() {
                                });
                classDetails.forEach(detail -> {
                        classesRepository.save(detail);
                        List<Levels> levels = DndApiClient.readAPIRest(
                                        detail.getClassLevels(),
                                        new TypeReference<List<Levels>>() {
                                        });
                        fetchDetailsInParallel(levels, Levels::getUrl,
                                        new TypeReference<Levels>() {
                                        }, levelsRepository::save);
                });

                ApiListResponse<Conditions> conditions = DndApiClient.readAPIRest(
                                response.getConditions(),
                                new TypeReference<ApiListResponse<Conditions>>() {
                                });
                ConditionsRepositoryImpl conditionsRepository = new ConditionsRepositoryImpl();
                fetchDetailsInParallel(conditions.getResults(), Conditions::getUrl,
                                new TypeReference<Conditions>() {
                                }, conditionsRepository::save);

                ApiListResponse<DamageTypes> damageTypes = DndApiClient.readAPIRest(
                                response.getDamageTypes(),
                                new TypeReference<ApiListResponse<DamageTypes>>() {
                                });
                DamageTypesRepositoryImpl damageTypesRepository = new DamageTypesRepositoryImpl();
                fetchDetailsInParallel(damageTypes.getResults(), DamageTypes::getUrl,
                                new TypeReference<DamageTypes>() {
                                }, damageTypesRepository::save);

                ApiListResponse<EquipmentCategories> equipmentCategories = DndApiClient.readAPIRest(
                                response.getEquipmentCategories(),
                                new TypeReference<ApiListResponse<EquipmentCategories>>() {
                                });
                EquipmentCategoriesRepositoryImpl equipmentCategoriesRepository = new EquipmentCategoriesRepositoryImpl();
                fetchDetailsInParallel(equipmentCategories.getResults(), EquipmentCategories::getUrl,
                                new TypeReference<EquipmentCategories>() {
                                }, equipmentCategoriesRepository::save);

                ApiListResponse<Equipment> equipment = DndApiClient.readAPIRest(
                                response.getEquipment(),
                                new TypeReference<ApiListResponse<Equipment>>() {
                                });
                EquipmentRepositoryImpl equipmentRepository = new EquipmentRepositoryImpl();
                fetchDetailsInParallel(equipment.getResults(), Equipment::getUrl,
                                new TypeReference<Equipment>() {
                                }, equipmentRepository::save);

                ApiListResponse<Feats> feats = DndApiClient.readAPIRest(
                                response.getFeats(),
                                new TypeReference<ApiListResponse<Feats>>() {
                                });
                FeatsRepositoryImpl featsRepository = new FeatsRepositoryImpl();
                fetchDetailsInParallel(feats.getResults(), Feats::getUrl,
                                new TypeReference<Feats>() {
                                }, featsRepository::save);

                ApiListResponse<Skills> skills = DndApiClient.readAPIRest(
                                response.getSkills(),
                                new TypeReference<ApiListResponse<Skills>>() {
                                });
                SkillsRepositoryImpl skillsRepository = new SkillsRepositoryImpl();
                fetchDetailsInParallel(skills.getResults(), Skills::getUrl,
                                new TypeReference<Skills>() {
                                }, skillsRepository::save);

                ApiListResponse<Features> features = DndApiClient.readAPIRest(
                                response.getFeatures(),
                                new TypeReference<ApiListResponse<Features>>() {
                                });
                FeaturesRepositoryImpl featuresRepository = new FeaturesRepositoryImpl();
                fetchDetailsInParallel(features.getResults(), Features::getUrl,
                                new TypeReference<Features>() {
                                }, featuresRepository::save);

                ApiListResponse<Languages> languages = DndApiClient.readAPIRest(
                                response.getLanguages(),
                                new TypeReference<ApiListResponse<Languages>>() {
                                });
                LanguagesRepositoryImpl languagesRepository = new LanguagesRepositoryImpl();
                fetchDetailsInParallel(languages.getResults(), Languages::getUrl,
                                new TypeReference<Languages>() {
                                }, languagesRepository::save);

                ApiListResponse<MagicItems> magicItems = DndApiClient.readAPIRest(
                                response.getMagicItems(),
                                new TypeReference<ApiListResponse<MagicItems>>() {
                                });
                MagicItemsRepositoryImpl magicItemsRepository = new MagicItemsRepositoryImpl();
                fetchDetailsInParallel(magicItems.getResults(), MagicItems::getUrl,
                                new TypeReference<MagicItems>() {
                                }, magicItemsRepository::save);

                ApiListResponse<MagicSchools> magicSchools = DndApiClient.readAPIRest(
                                response.getMagicSchools(),
                                new TypeReference<ApiListResponse<MagicSchools>>() {
                                });
                MagicSchoolsRepositoryImpl magicSchoolsRepository = new MagicSchoolsRepositoryImpl();
                fetchDetailsInParallel(magicSchools.getResults(), MagicSchools::getUrl,
                                new TypeReference<MagicSchools>() {
                                }, magicSchoolsRepository::save);

                ApiListResponse<Monster> monsters = DndApiClient.readAPIRest(
                                response.getMonsters(),
                                new TypeReference<ApiListResponse<Monster>>() {
                                });
                MonstersRepositoryImpl monstersRepository = new MonstersRepositoryImpl();
                fetchDetailsInParallel(monsters.getResults(), Monster::getUrl,
                                new TypeReference<Monster>() {
                                }, monstersRepository::save);

                ApiListResponse<Poisons> poisons = DndApiClient.readAPIRest(
                                response.getPoisons(),
                                new TypeReference<ApiListResponse<Poisons>>() {
                                });
                PoisonsRepositoryImpl poisonsRepository = new PoisonsRepositoryImpl();
                fetchDetailsInParallel(poisons.getResults(), Poisons::getUrl,
                                new TypeReference<Poisons>() {
                                }, poisonsRepository::save);
                /*
                 * ApiListResponse<Proficiencies> proficiencies = DndApiClient.readAPIRest(
                 * response.getProficiencies(),
                 * new TypeReference<ApiListResponse<Proficiencies>>() {});
                 * ProficienciesRepositoryImpl proficienciesRepository = new
                 * ProficienciesRepositoryImpl();
                 * proficiencies.getResults().forEach(item -> {
                 * Proficiencies detail = DndApiClient.readAPIRest(
                 * item.getUrl(),
                 * new TypeReference<Proficiencies>() {});
                 * proficienciesRepository.save(detail);
                 * });
                 */

                ApiListResponse<Species> species = DndApiClient.readAPIRest(
                                response.getSpecies(),
                                new TypeReference<ApiListResponse<Species>>() {
                                });
                SpeciesRepositoryImpl speciesRepository = new SpeciesRepositoryImpl();
                fetchDetailsInParallel(species.getResults(), Species::getUrl,
                                new TypeReference<Species>() {
                                }, speciesRepository::save);

                ApiListResponse<Spells> spells = DndApiClient.readAPIRest(
                                response.getSpells(),
                                new TypeReference<ApiListResponse<Spells>>() {
                                });
                SpellsRepositoryImpl spellsRepository = new SpellsRepositoryImpl();
                fetchDetailsInParallel(spells.getResults(), Spells::getUrl,
                                new TypeReference<Spells>() {
                                }, spellsRepository::save);

                ApiListResponse<Subclasses> subclasses = DndApiClient.readAPIRest(
                                response.getSubclasses(),
                                new TypeReference<ApiListResponse<Subclasses>>() {
                                });
                SubclassesRepositoryImpl subclassesRepository = new SubclassesRepositoryImpl();
                fetchDetailsInParallel(subclasses.getResults(), Subclasses::getUrl,
                                new TypeReference<Subclasses>() {
                                }, subclassesRepository::save);

                ApiListResponse<Subspecies> subspecies = DndApiClient.readAPIRest(
                                response.getSubspecies(),
                                new TypeReference<ApiListResponse<Subspecies>>() {
                                });
                SubspeciesRepositoryImpl subspeciesRepository = new SubspeciesRepositoryImpl();
                fetchDetailsInParallel(subspecies.getResults(), Subspecies::getUrl,
                                new TypeReference<Subspecies>() {
                                }, subspeciesRepository::save);

                ApiListResponse<Traits> traits = DndApiClient.readAPIRest(
                                response.getTraits(),
                                new TypeReference<ApiListResponse<Traits>>() {
                                });
                TraitsRepositoryImpl traitsRepository = new TraitsRepositoryImpl();
                fetchDetailsInParallel(traits.getResults(), Traits::getUrl,
                                new TypeReference<Traits>() {
                                }, traitsRepository::save);

                ApiListResponse<WeaponMasteryProperties> weaponMasteryProperties = DndApiClient.readAPIRest(
                                response.getWeaponMasteryProperties(),
                                new TypeReference<ApiListResponse<WeaponMasteryProperties>>() {
                                });
                WeaponMasteryPropertiesRepositoryImpl weaponMasteryPropertiesRepository = new WeaponMasteryPropertiesRepositoryImpl();
                fetchDetailsInParallel(weaponMasteryProperties.getResults(), WeaponMasteryProperties::getUrl,
                                new TypeReference<WeaponMasteryProperties>() {
                                }, weaponMasteryPropertiesRepository::save);

                ApiListResponse<WeaponProperties> weaponProperties = DndApiClient.readAPIRest(
                                response.getWeaponProperties(),
                                new TypeReference<ApiListResponse<WeaponProperties>>() {
                                });
                WeaponPropertiesRepositoryImpl weaponPropertiesRepository = new WeaponPropertiesRepositoryImpl();
                fetchDetailsInParallel(weaponProperties.getResults(), WeaponProperties::getUrl,
                                new TypeReference<WeaponProperties>() {
                                }, weaponPropertiesRepository::save);
        }
}
