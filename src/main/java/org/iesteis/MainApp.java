package org.iesteis;

import tools.jackson.core.type.TypeReference;

import org.iesteis.api.DndApiClient;
import org.iesteis.model.ApiListResponse;
import org.iesteis.repository.abilityScore.AbilityScoresRepositoryImpl;
import org.iesteis.repository.abilityScore.SkillRepositoryImpl;
import org.iesteis.repository.skills.SkillsRepositoryImpl;
import org.iesteis.model.Response;
import org.iesteis.model.abilityScores.AbilityScores;
import org.iesteis.model.abilityScores.Skill;
import org.iesteis.model.skills.Skills;


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

        ApiListResponse<Skill> skill = DndApiClient.readAPIRest(response.getSkills(), new TypeReference<ApiListResponse<Skill>>() {});

        SkillRepositoryImpl skillRepository = new SkillRepositoryImpl();

        skill.getResults().stream().forEach(skillRepository::save);

        ApiListResponse<AbilityScores> abilityScore = DndApiClient.readAPIRest(response.getAbilityScores(), new TypeReference<ApiListResponse<AbilityScores>>() {});

        AbilityScoresRepositoryImpl abilityScoreRepository = new  AbilityScoresRepositoryImpl();
        
        abilityScore.getResults().forEach(abilityScoreDetail -> {
            AbilityScores detail = DndApiClient.readAPIRest(
                    abilityScoreDetail.getUrl(),
                    new TypeReference<AbilityScores>() {});
            abilityScoreRepository.save(detail);
        });

        ApiListResponse<Skill> skills = DndApiClient.readAPIRest(
                response.getSkills(),
                new TypeReference<ApiListResponse<Skill>>() {});

        SkillsRepositoryImpl skillsRepository = new SkillsRepositoryImpl();

        skills.getResults().forEach(skillDetail -> {
            Skills detail = DndApiClient.readAPIRest(
                    skillDetail.getUrl(),
                    new TypeReference<Skills>() {});
            skillsRepository.save(detail);
        });

    }
}