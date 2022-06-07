package playground.api.buybest.utilitiesinfo;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import playground.api.buybest.constants.EndPoints;

public class HealthcheckStepes {
    @Step("get the healthcheckup data: {0}")
    public ValidatableResponse createHweathcheckupdata(String name){
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("healthcheckID",name)
                .when()
                //.get(EndPoints.GET_ALL_Utilities_healthcheck)

                 .post(EndPoints.GET_ALL_Utilities)
                .then();

    }
    @Step("Verify all healthcheckup list: {0}")
    public ValidatableResponse verifyAllHealthcheckup(int id){
        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .pathParam("healthcheckID",id)
                .when()
                .get(EndPoints.GET_SINGLE_Utilities_healthcheck_BY_ID)
                .then();

    }

}
