package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class OrderStep {

    private static String BASE_URL_ORDER = "https://petstore.swagger.io/v2/store/order";
    public void createOrder(String id, String petId, String quantity, String shipDate, String status, String complete) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": \""+id+"\",\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"shipDate\": \""+shipDate+"\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"complete\": \""+complete+"\" " +
                        "}")
                .log().all()
                .post(BASE_URL_ORDER)
                .then()
                .log().all()
        ;
    }

    public void validateStatusCode(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }



    public void validateStatus(String status) {
        restAssuredThat(response -> response.body("'status'", equalTo(status)));
        System.out.println("Status: " + lastResponse().body().path("status").toString());
        System.out.println(lastResponse().print());
    }

    public boolean getOrder(String id) {
        boolean existsOrder = false;
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .get(BASE_URL_ORDER + "/" + id)
                .then()
                .log().all()
        ;
        if(lastResponse().statusCode() == 200){ existsOrder = true;}
        return existsOrder;
    }
}
