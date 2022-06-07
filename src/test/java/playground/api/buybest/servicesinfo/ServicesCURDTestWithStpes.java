package playground.api.buybest.servicesinfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import playground.api.buybest.testbase.TestBase;
import playground.api.buybest.utils.TestUtils;

import static org.hamcrest.Matchers.equalTo;


@RunWith(SerenityRunner.class)
public class ServicesCURDTestWithStpes extends TestBase {
    static String name = "string" + TestUtils.getRandomValue();
    static int id;
    ValidatableResponse response;

    @Steps
    ServiceSteps serviceSteps;

    @Title("This will create a new services data")
    @Test
    public void test001() {
        ValidatableResponse response=serviceSteps.CreateTheProductes(name);
        response.log().all().statusCode(201);
        id=response.extract().path("id");
        System.out.println(id);
    }
    @Title("Verify if the servicesdata was added to the application")
    @Test
    public void test002() {
        response = serviceSteps.verifyAllServices(id);
        response.body("name", equalTo(name));

    }
    @Title("update the user information and verify the update info ")
    @Test
    public void test003 (){
        name=name+"_update03";
        ValidatableResponse response=serviceSteps.UpdateServiceId(id,name);
        response.log().all().statusCode(200);
        response=serviceSteps.verifyAllServices(id);
        response.body("name",equalTo(name));

    }
    @Title("Delete the product and verify if the product is deleted!")
    @Test
    public void test004() {
        serviceSteps.deleteServiceId(id).statusCode(200);
        serviceSteps.verifySrviceid(id).statusCode(404);
    }
}
