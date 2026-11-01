package org.iesteis;

import tools.jackson.core.type.TypeReference;

import org.iesteis.api.DndApiClient;
import org.iesteis.model.ApiListResponse;
import org.iesteis.repository.abilityScore.SkillsRepository;
import org.iesteis.repository.abilityScore.SkillsRepositoryImpl;
import org.iesteis.model.Response;
import org.iesteis.model.abilityScore.Skill;


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

        ApiListResponse<Skill> skills = DndApiClient.readAPIRest(response.getSkills(), new TypeReference<ApiListResponse<Skill>>() {});

        SkillsRepositoryImpl skillsRepository = new SkillsRepositoryImpl();

        skills.getResults().stream().forEach(skillsRepository::save);

        

    }
}