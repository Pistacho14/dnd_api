package org.iesteis;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.iesteis.model.Response;
import org.iesteis.repository.abilityScore.SkillsRepositoryImpl;

import tools.jackson.databind.ObjectMapper;


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
    static void readAPIRest() {
        ObjectMapper mapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create("https://www.dnd5eapi.co/api/2024"))
                                    .GET()
                                    .build();
            HttpResponse<String> response = client
                                            .send(
                                    request,
                                    HttpResponse.BodyHandlers.ofString());
            
            Response r = mapper.readValue(response.body(), Response.class);
            System.out.println(r.getDamageTypes());                        
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        // launch(args);
        readAPIRest();
        SkillsRepositoryImpl skillsRepository = new SkillsRepositoryImpl();
        
    }

    

}