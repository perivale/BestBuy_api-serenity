package playground.api.buybest.storeinfo;

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


@RunWith(SerenityRunner.class)
public class StoreCURDTestWithSteps extends TestBase {
    static String name = "string" + TestUtils.getRandomValue();
    static String type = "string" + TestUtils.getRandomValue();
    static String address = "string";
    static String address2 = "string";
    static String city = "string";
    static String state = "string";
    static String zip = "string";
    static int lat = 0;
    static int lng = 0;
    static String hours = "string";


    static int id;
    ValidatableResponse response;

    @Steps
    StoreSteps storeSteps;

    @Title("This will create a new store data")
    @Test
    public void test001() {
        ValidatableResponse response = storeSteps.createTheStore(name, type, address, address2, city, state, zip, lat, lng, hours);

        response.log().all().statusCode(201);
        id = response.extract().path("id");
    }

    @Title("Verify if the storedata was added to the application")
    @Test
    public void test002() {
        response = storeSteps.verifyAllstore(id);
        response.body("name", equalTo(name));

    }
    @Title("Update the user information and verify the updated information")
    @Test
    public void test003() {
        name = name + "_updated02";
        ValidatableResponse response = storeSteps.updateTheStoreData(id, name);
        response.log().all().statusCode(200);
        response = storeSteps.verifyAllstore(id);
        response.body("name", equalTo(name));


    }
    @Title("Delete the store data and verify if the store data is deleted!")
    @Test
    public void test004() {
        storeSteps.deletestoreid(id).statusCode(200);
        storeSteps.VerifydeletedId(id).statusCode(404);

    }

    }