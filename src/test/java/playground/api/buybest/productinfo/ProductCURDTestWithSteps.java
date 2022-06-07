package playground.api.buybest.productinfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import playground.api.buybest.testbase.TestBase;
import playground.api.buybest.utils.TestUtils;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasValue;

/**
 * Created by Jay
 */
@RunWith(SerenityRunner.class)
public class ProductCURDTestWithSteps extends TestBase {


    static String name = "string" + TestUtils.getRandomValue();
    static String type = "string" + TestUtils.getRandomValue();
    static int price = 00;
    static int shipping = 00;
    static String upc = "string";
    static String description = "string";
    static String manufacturer = "string";
    static String model = "string";
    static String url = "string";
    static String image = "string";
    static int id;
    ValidatableResponse response;

    @Steps
    ProductSteps productSteps;

    @Title("This will create a new productdata")
    @Test
    public void test001() {
        ValidatableResponse response = productSteps.CreateTheProductes(name, type, price, shipping, upc, description, manufacturer, model,
                url, image);
        response.log().all().statusCode(201);
        id = response.extract().path("id");
        System.out.println(id);
    }

    @Title("Verify if the productdata was added to the application")
    @Test
    public void test002() {
        response = productSteps.verifyAllproduct(id);
        response.body("name", equalTo(name));


    }

    @Title("Update the user information and verify the updated information")
    @Test
    public void test003() {
        name = name + "_updated01";
        ValidatableResponse response = productSteps.updateTheProductes(id, name);
        response.log().all().statusCode(200);
        response = productSteps.verifyAllproduct(id);
        response.body("name", equalTo(name));


    }

    @Title("Delete the product and verify if the product is deleted!")
    @Test
    public void test004() {
        productSteps.deleteProductid(id).statusCode(200);
        productSteps.VerifydeletedId(id).statusCode(404);

    }


}





