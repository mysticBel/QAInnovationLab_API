package com.nttdata.glue;

import com.nttdata.steps.OrderStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class OrderStepsDef {
    @Steps
    OrderStep orderStep;

    @When("creo el pedido con id {string}, pedID {string}, quantity {string}, shipDate {string}, status {string}, complete, {string}")
    public void creoElPedidoConIdPedIDQuantityShipDateStatusComplete(String id, String petId, String quantity, String shipDate, String status, String complete) {
        orderStep.createOrder(id,petId,quantity,shipDate,status,complete);

    }
    @Then("el código de respuesta es {int}")
    public void elCódigoDeRespuestaEs(int statusCode) {
        orderStep.validateStatusCode(statusCode);
    }


    @And("el status es {string}")
    public void elStatusEs(String status) {
        orderStep.validateStatus(status);
    }

    @Given("consulto el pedido con ID {string}")
    public void consultoElPedidoConID(String id) {
        Assert.assertTrue("No existe pedido",orderStep.getOrder(id));
    }

}
