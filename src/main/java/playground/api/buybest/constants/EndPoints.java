package playground.api.buybest.constants;

/**
 * Created by Jay
 */
public class EndPoints {

    /**
     * This is Endpoints of best buy api
     */
    public static final String GET_ALL_Products = "/Products";
    public static final String GET_SINGLE_Products = "/Products/{ProductsID}";
    public static final String UPDATE_Products_BY_ID = "/Products/{ProductsID}";
    public static final String DELETE_Products_BY_ID = "/Products/{ProductsID}";


    public static final String GET_ALL_stores = "/stores";
    public static final String GET_SINGLE_stores_BY_ID = "/stores/{storesID}";
    public static final String UPDATE_stores_BY_ID = "/stores/{storesID}";
    public static final String DELETE_stores_BY_ID = "/stores/{storesID}";


    public static final String GET_ALL_services = "/services";
    public static final String GET_SINGLE_services_BY_ID = "/services/{servicesID}";
    public static final String UPDATE_services_BY_ID = "/services/{servicesID}";
    public static final String DELETE_services_BY_ID = "/services/{servicesID}";



    public static final String GET_ALL_categories = "/categories";
    public static final String GET_SINGLE_categories_BY_ID = "/categories/{categoriesID}";
    public static final String UPDATE_categories_BY_ID = "/categories/{categoriesID}";
    public static final String DELETE_categories_BY_ID = "/categories/{categoriesID}";


    public static final String GET_ALL_Utilities = "/version";
    public static final String GET_SINGLE_Utilities_BY_ID = "/version/{versionID}";

    public static final String GET_ALL_Utilities_healthcheck= "/healthcheck";
    public static final String GET_SINGLE_Utilities_healthcheck_BY_ID = "/healthcheck/{healthcheckID}";


}
