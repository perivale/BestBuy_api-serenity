package playground.api.buybest.categoriesinfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import playground.api.buybest.categories.CategoriesSteps;
import playground.api.buybest.testbase.TestBase;
import playground.api.buybest.utils.TestUtils;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class CategoriesCURDTestWithSteps extends TestBase {
    static String name = "string" + TestUtils.getRandomValue();
    static String id = "string" + TestUtils.getRandomValue();
    ValidatableResponse response;
    static int ID;

    @Steps
    CategoriesSteps categoriesSteps;

    @Title("This will create a new categoriesdata")
    @Test
    public void test001() {
        ValidatableResponse response=categoriesSteps.creatTheCtegories(name,id);
        response.log().all().statusCode(201);
        id=response.extract().path("id");
        System.out.println(id);


    }
    @Title("Verify if the categoriesdata was added to the application")
    @Test
    public void test002() {
        response = categoriesSteps.verifyAllcategories(id);
        response.body("name", equalTo(name));

    }
    @Title("Update the categories information and verify the updated information")
    @Test
    public void test003() {
        name = name + "_updated00";
        ValidatableResponse response = categoriesSteps.UpdatecategoriesId(id,name);
        response.log().all().statusCode(200);
        response = categoriesSteps.verifyAllcategories(id);
        response.body("name", equalTo(name));


    }
    @Title("Delete the categories and verify if the product is deleted!")
    @Test
    public void test004() {
      categoriesSteps.deletecategoriesid(id).statusCode(200);
      categoriesSteps.VerifydeletedId(id).statusCode(404);

    }

}