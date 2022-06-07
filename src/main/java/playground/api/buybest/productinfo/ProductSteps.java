package playground.api.buybest.productinfo;


import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import playground.api.buybest.constants.EndPoints;
import playground.api.buybest.model.ProductsPojo;

import static io.restassured.RestAssured.given;

/**
 * Created by Jay
 */

public class ProductSteps {

    @Step("Creating product with Name : {0}, type: {1}, price: {2}, shiping: {3}  upc: {4}, description :{5},manufacturer:{6}, model:{7}, url :{8},image :{9} ")

    public ValidatableResponse CreateTheProductes(String name, String type, int price, int shipping, String upc, String description, String manufacturer, String model,
                                                  String url, String image) {


        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName(name);
        productsPojo.setType(type);
        productsPojo.setPrice(price);
        productsPojo.setShipping(shipping);
        productsPojo.setUpc(upc);
        productsPojo.setDescription(description);
        productsPojo.setManufacturer(manufacturer);
        productsPojo.setModel(model);
        productsPojo.setUrl(url);
        productsPojo.setImage(image);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(productsPojo)
                .when()
                .post(EndPoints.GET_ALL_Products)
                .then();



    }
    @Step("Verify all product list: {0}")
    public ValidatableResponse verifyAllproduct(int id){
        return SerenityRest.given()
                .pathParam("ProductsID",id)
                .when()
                .get(EndPoints.GET_SINGLE_Products)
                .then();

    }


    @Step("Creating product with Name : {0}, type: {1}, price: {2}, shiping: {3}  upc: {4}, description :{5},manufacturer:{6}, model:{7}, url :{8},image :{9} ")

    public ValidatableResponse updateTheProductes(int id,String name) {
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setName(name);


        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("ProductsID",id)
                .body(productsPojo)
                .when()
                .patch(EndPoints.UPDATE_Products_BY_ID)
                .then();


    }
    @Step("Delete id:{0}")
    public ValidatableResponse deleteProductid(int id){
        return  SerenityRest.given().log().all()
                .pathParam("ProductsID",id)
                .when()
                .delete(EndPoints.DELETE_Products_BY_ID)
                .then();
    }
    @Step("verify that product id is deleted:{0}")
    public ValidatableResponse VerifydeletedId(int id){
        return  SerenityRest.given().log().all()
                .pathParam("ProductsID",id)
                .when()
                .get(EndPoints.GET_SINGLE_Products)
                .then();
    }


}
