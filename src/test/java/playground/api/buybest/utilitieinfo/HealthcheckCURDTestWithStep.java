package playground.api.buybest.utilitieinfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import playground.api.buybest.testbase.TestBase;
import playground.api.buybest.utilitiesinfo.HealthcheckStepes;

import static org.hamcrest.Matchers.equalTo;
@RunWith(SerenityRunner.class)
public class HealthcheckCURDTestWithStep extends TestBase {
    static String uptime;//="string" + TestUtils.getRandomValue();
    int id;

    @Steps
    HealthcheckStepes healthcheckStepes;
    ValidatableResponse response;

    @Title("This will create a new  healthcheck data")
    @Test
    public void test001() {

        ValidatableResponse response =healthcheckStepes.createHweathcheckupdata(uptime);

        response.log().all();
      //  id = response.extract().path("id");
    }

    @Title("This will create a new healthcheckup data")
    @Test
    public void test002() {
        response =healthcheckStepes.verifyAllHealthcheckup(id);
        response.body("uptime", equalTo(uptime));
    }

}
