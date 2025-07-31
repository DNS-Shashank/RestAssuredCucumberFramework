package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;


public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException{

        StepDefinitions m = new StepDefinitions();
        if(StepDefinitions.place_id == null){
            m.add_place_payload_with("DNSS", "Hindi", "Asia");
            m.user_calls_with_post_http_request("AddPlaceAPI", "POST");
            m.verify_place_id_created_to_using("DNSS", "GetPlaceAPI");
        }

        System.out.println("Sourced fom hoooks");

    }



}
