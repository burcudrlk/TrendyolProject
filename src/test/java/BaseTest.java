import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseTest
{

    public RequestSpecification requestParameters;
    static String baseUrl;
    public static String searchData;
    public static String apikey;
    public static String findKey;
    public static String year;
    public static String released;
    public static String imdbId;
    Helpers helpers = new Helpers();



    @Before
    public void initialization()
    {
        baseUrl="http://www.omdbapi.com/";
        searchData="Harry Potter";
        apikey = "ae0004f9";
        findKey = "Harry Potter and the Sorcerer's Stone";
        year = "2001";
        released = "16 Nov 2001";
    }

}