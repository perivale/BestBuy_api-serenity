package playground.api.buybest.utilitieinfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import playground.api.buybest.testbase.TestBase;
import playground.api.buybest.utilitiesinfo.VersionSteps;

import static org.hamcrest.Matchers.equalTo;


@RunWith(SerenityRunner.class)
public class VersionCURDTestWithStpes extends TestBase {
    static String version;//="string" + TestUtils.getRandomValue();

    int id;

    @Steps
    VersionSteps utilitieSteps;


    ValidatableResponse response;

    @Title("This will create a new versiondata")
    @Test
    public void test001() {

        ValidatableResponse response = utilitieSteps.createverisondata(version);

        response.log().all().statusCode(200);
        id = response.extract().path("id");
    }

    @Title("This will create a new versiondata")
    @Test
    public void test002() {
        response = utilitieSteps.verifyAllversion(id);
        response.body("version", equalTo(version));
    }

}
