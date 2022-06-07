package playground.api.buybest.testbase;


import io.restassured.RestAssured;
import org.junit.BeforeClass;
import playground.api.buybest.utils.PropertyReader;

/**
 * Created by Jay
 */
public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));
       // RestAssured.basePath = Path;
    }

}
