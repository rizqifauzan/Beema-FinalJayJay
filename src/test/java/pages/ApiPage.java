package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import java.io.File;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;


public class ApiPage {

    String setURL, global_id;
    Response res;

    public void prepareUrlFor(String url) {
        switch (url) {
            case "GET_USER_BY_ID":
                setURL = Endpoint.GET_USER_BY_ID;
                break;
            case "CREATE_USER":
                setURL = Endpoint.CREATE_USER;
                break;
            case "DELETE_USER":
                setURL = Endpoint.DELETE_USER;
                break;
            case "UPDATE_USER":
                setURL = Endpoint.UPDATE_USER;
                break;
            default:
                System.out.println("input right url");
        }
    }


    public  void hitApiGetUserById(){
        res =getUserById(setURL);
    }

    public  void hitApiGetNewUser(){
        res =postCreateUser(setURL);
    }

    public  void validationStatusCodeIsEquals(int status_code){
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseBodyGetUserByid(){
        JsonPath jsonPath = res.jsonPath();

// Ambil data sebagai objek langsung, bukan List
        String id = jsonPath.getString("id");
        String title = jsonPath.getString("title");
        String firstName = jsonPath.getString("firstName");
        String lastName = jsonPath.getString("lastName");
        String email = jsonPath.getString("email");
        String picture = jsonPath.getString("picture");
        String gender = jsonPath.getString("gender");
        String dateOfBirth = jsonPath.getString("dateOfBirth");
        String phone = jsonPath.getString("phone");

// Ambil data dari nested object 'location'
        String street = jsonPath.getString("location.street");
        String city = jsonPath.getString("location.city");
        String state = jsonPath.getString("location.state");
        String country = jsonPath.getString("location.country");
        String timezone = jsonPath.getString("location.timezone");

// Ambil tanggal pendaftaran dan update
        String registerDate = jsonPath.getString("registerDate");
        String updatedDate = jsonPath.getString("updatedDate");

// Logging response body untuk debugging
        System.out.println("Response Body: " + res.getBody().asString());

// Validasi bahwa setiap field tidak null
        assertThat(id).isNotNull();
        assertThat(title).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
        assertThat(picture).isNotNull();
        assertThat(gender).isNotNull();
        assertThat(dateOfBirth).isNotNull();
        assertThat(phone).isNotNull();
        assertThat(street).isNotNull();
        assertThat(city).isNotNull();
        assertThat(state).isNotNull();
        assertThat(country).isNotNull();
        assertThat(timezone).isNotNull();
        assertThat(registerDate).isNotNull();
        assertThat(updatedDate).isNotNull();
    }

    public void validationResponseJsonWithJSONSchema(String filename){
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }
    public void validationResponseBodyCreteNewUser(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.getString("firstName");
        String lastName = jsonPathEvaluator.getString("lastName");
        String email = jsonPathEvaluator.getString("email");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();

        global_id = id;
    }
    public  void hitApiDeleteUser(){
        res =deleteUser(setURL,global_id);
    }

    public  void hitApiUpdateUser(){
        res =updateUser(setURL,global_id);
    }

    public void validationResponseBodyUpdateUser(){
        JsonPath jsonPathEvaluator = res.jsonPath();
        String id = jsonPathEvaluator.get("id");
        String firstName = jsonPathEvaluator.getString("firstName");
        String lastName = jsonPathEvaluator.getString("lastName");
        String email = jsonPathEvaluator.getString("email");

        assertThat(id).isNotNull();
        assertThat(firstName).isNotNull();
        assertThat(lastName).isNotNull();
        assertThat(email).isNotNull();
    }
}
