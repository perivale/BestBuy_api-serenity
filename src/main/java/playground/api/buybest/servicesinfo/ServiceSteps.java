package playground.api.buybest.servicesinfo;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import playground.api.buybest.constants.EndPoints;
import playground.api.buybest.model.ServicePojo;

import static io.restassured.RestAssured.given;

public class ServiceSteps {
    @Step("Creating product with Name : {0} ")

    public ValidatableResponse CreateTheProductes(String name){
        ServicePojo servicePojo=new ServicePojo();
        servicePojo.setName(name);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(servicePojo)
                .when()
                .post(EndPoints.GET_ALL_services)
                .then();

    }
    @Step("Verify all service list: {0}")
    public ValidatableResponse verifyAllServices(int id){
        return SerenityRest.given()
              //  .contentType(ContentType.JSON)
                .pathParam("servicesID",id)
                .when()
                .get(EndPoints.GET_SINGLE_services_BY_ID)
                .then();

    }
    @Step("Update all service data :{0}")
    public ValidatableResponse UpdateServiceId(int id,String name){
        ServicePojo servicePojo=new ServicePojo();
        servicePojo.setName(name);

        return  SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("servicesID",id)
                .body(servicePojo)
                .when()
                .patch(EndPoints.UPDATE_services_BY_ID)
                .then();


    }
    @Step("Delete id:{0}")
    public ValidatableResponse deleteServiceId(int id){
        return  SerenityRest.given().log().all()
                .pathParam("servicesID",id)
                .when()
                .delete(EndPoints.DELETE_services_BY_ID)
                .then();
    }
    @Step("verify that service id is delete:{0}")
    public ValidatableResponse verifySrviceid(int id){
        return SerenityRest.given().log().all()
                .pathParam("servicesID",id)
                .when()
                .get(EndPoints.GET_SINGLE_services_BY_ID)
                .then();

    }




    }
