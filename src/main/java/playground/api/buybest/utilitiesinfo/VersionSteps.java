package playground.api.buybest.utilitiesinfo;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import playground.api.buybest.constants.EndPoints;

public class VersionSteps {

    @Step("get the versoin data: {0}")
    public ValidatableResponse createverisondata(String name){
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("versionID",name)
                .when()
                .get(EndPoints.GET_ALL_Utilities)

               // .post(EndPoints.GET_ALL_Utilities)
                .then();

    }
    @Step("Verify all version list: {0}")
    public ValidatableResponse verifyAllversion(int id){
        return SerenityRest.given()
                .pathParam("versionID",id)
                .when()
                .get(EndPoints.GET_SINGLE_Utilities_BY_ID)
                .then();

    }



}
