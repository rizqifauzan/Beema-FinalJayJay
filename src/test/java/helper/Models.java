package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

//import static helper.Utility.generateRandomEmail;

//import static helper.Utility.generateRandomEmail;


public class Models {
    private static RequestSpecification request;

    private static void setUpHeaders() {
        request = RestAssured.given()
                .header( "Connection", "keep-alive" )
                .header("Accept-Encoding", "gzip, deflate,br" )
                .header("app-id", "63a804408eb0cb069b57e43a");
    }

    public static Response getUserById(String endpoint) {
        setUpHeaders();
        return request.when().get(endpoint);
    }

    public static Response postCreateUser(String endpoint) {
        String firstName = "Bemaaa11";
        String lastName = "rachsss";
        String email =  "bemaaa11123@testdata.com";
        System.out.println("apa lewat sini");
        JSONObject payload = new JSONObject();
        payload.put("firsName", firstName);
        payload.put("lastName", lastName);
        payload.put("email", email);
        System.out.println("apa lewat sini 2");
//        System.out.println(payload);
//        System.out.println(payload.toString());

        setUpHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }
}
