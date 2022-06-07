package playground.api.buybest.categories;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import playground.api.buybest.constants.EndPoints;
import playground.api.buybest.model.CategoriesPojo;

public class CategoriesSteps {
    @Step("creating categories with name:{0}")
    public ValidatableResponse creatTheCtegories(String name,String id){
        CategoriesPojo categoriesPojo1=new CategoriesPojo();
        categoriesPojo1.setName(name);
        categoriesPojo1.setId(id);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(categoriesPojo1)
                .when()
                .post(EndPoints.GET_ALL_categories)
                .then();
    }
    @Step("Verify all categories list: {0}")
    public ValidatableResponse verifyAllcategories(String id) {
        return SerenityRest.given().log().all()
             //   .contentType(ContentType.JSON)
                .pathParam("categoriesID",id)
                .when()
                .get(EndPoints.GET_SINGLE_categories_BY_ID)
                .then();
    }

    @Step("Update all service data :{0}")
    public ValidatableResponse UpdatecategoriesId(String id,String name) {
        CategoriesPojo categoriesPojo1 = new CategoriesPojo();
        categoriesPojo1.setName(name);



        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("categoriesID",id)
                .body(categoriesPojo1)
                .when()
                .patch(EndPoints.UPDATE_categories_BY_ID)
                .then();


    }
    @Step("Delete id:{0}")
    public ValidatableResponse deletecategoriesid(String id){
        return  SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("categoriesID",id)
                .when()
                .delete(EndPoints.DELETE_categories_BY_ID)
                .then();
    }
    @Step("verify that product id is deleted:{0}")
    public ValidatableResponse VerifydeletedId(String id){
        return  SerenityRest.given().log().all()
                .pathParam("categoriesID",id)
                .when()
                .get(EndPoints.GET_SINGLE_categories_BY_ID)
                .then();
    }

}