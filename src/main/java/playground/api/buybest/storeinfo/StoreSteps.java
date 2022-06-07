package playground.api.buybest.storeinfo;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import playground.api.buybest.constants.EndPoints;
import playground.api.buybest.model.StoresPojo;

import static io.restassured.RestAssured.given;

public class StoreSteps {
       @Step("Creating product with Name : {0}, type: {1}, add: {2}, add2: {3} city: {4}, zip :{5},state:{6}, lat:{7}, lag :{8},hours :{9} ")

      public ValidatableResponse createTheStore(String name, String type, String address, String address2, String city, String zip, String state, int lat,
                                                int lag, String hours) {


        StoresPojo createStorePojo=new StoresPojo();

        createStorePojo.setName(name);
        createStorePojo.setType(type);
        createStorePojo.setAddress(address);
        createStorePojo.setAddress2(address2);
        createStorePojo.setCity(city);
        createStorePojo.setState(zip);
        createStorePojo.setZip(state);
        createStorePojo.setLat(lat);
        createStorePojo.setLng(lag);
        createStorePojo.setHours(hours);


        return SerenityRest.given().log().all()

                   .contentType(ContentType.JSON)
                   .body(createStorePojo)
                   .when()
                   .post(EndPoints.GET_ALL_stores)
                   .then();
       }
    @Step("Verify all store list: {0}")
    public ValidatableResponse verifyAllstore(int id){
        return SerenityRest.given()
                .pathParam("storesID",id)
                .when()
                .get(EndPoints.GET_SINGLE_stores_BY_ID)
                .then();

       }
       @Step("updata store data :{0}")
    public ValidatableResponse updateTheStoreData(int id,String name) {

           StoresPojo storesPojo=new StoresPojo();
           storesPojo.setName(name);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("storesID",id)
                .body(storesPojo)
                .when()
                .patch(EndPoints.UPDATE_stores_BY_ID)
                .then();


    }
    @Step("Delete id:{0}")
    public ValidatableResponse deletestoreid(int id){
        return  SerenityRest.given().log().all()
                .pathParam("storesID",id)
                .when()
                .delete(EndPoints.DELETE_stores_BY_ID)
                .then();
    }
    @Step("verify that product id is deleted:{0}")
    public ValidatableResponse VerifydeletedId(int id){
        return  SerenityRest.given().log().all()
                .pathParam("storesID",id)
                .when()
                .get(EndPoints.GET_SINGLE_stores_BY_ID)
                .then();
    }

}
