import com.sun.org.glassfish.gmbal.Description;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static io.restassured.RestAssured.given;

public class Tests extends BaseTest {


    @Test
    @Description("Search a movie with name on BySearch area")
    public void searchMovieWithNameAndTakeId(){
        List<String> response = bySearchRequest(searchData)
                .get(baseUrl)
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("Search.Title");

        //Get a movie id from search result
         imdbId = bySearchRequest(searchData)
                .get(baseUrl)
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("Search[" +helpers.indexFinder(response,findKey)+"].imdbID");
    }

    @Test
    @Description("Search a movie with id on ById or Title area")
    public void searchMovieWithId(){
        byIdOrTitleRequest(imdbId)
                .when()
                .get(baseUrl)
                .then()
                .statusCode(200)
                .body("Title", Matchers.equalTo(findKey)).and()
                .body("Year", Matchers.equalTo(year)).and()
                .body("Released", Matchers.equalTo(released));
    }

    @Description("BySearch Request")
    public RequestSpecification bySearchRequest(String searchData){

        requestParameters = given().
                param(RequestData.API_KEY, apikey).
                param(RequestData.MOVIE_TITLE, searchData);
        return requestParameters;
    }

    @Description("ById or Title Request")
    public RequestSpecification byIdOrTitleRequest(String imdbId){

        requestParameters = given().
                param(RequestData.API_KEY, apikey).
                param(RequestData.IMDB_ID, imdbId);

        return requestParameters;
    }

}
