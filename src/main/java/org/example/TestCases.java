package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestCases {

    @BeforeClass
    public void setup() {
        Config.load();
        RestAssured.baseURI = Config.get("base.uri");
    }

    @Test
    public void testGetPost() {
        System.out.println(".......Running testcase1.........");
      Response response= given()
                .when()
                .get("https://dummy.restapiexample.com/api/v1/employees");
                System.out.println(response.prettyPrint());


    }

    @Test
    public void testInvalidPost() {
        System.out.println(".......Running testcase2.........");
        Response response= given()
                .when().get("https://dummy.restapiexample.com/api/v1/employee/1");

        System.out.println(response.asString());
    }
}
