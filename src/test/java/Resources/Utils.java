package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

    public static RequestSpecification request;
    ResponseSpecification response;
    JsonPath js;

    public RequestSpecification requestSpecification() throws IOException{

        if(request == null){
        PrintStream log = new PrintStream(new FileOutputStream("logging.text"));
        
        request =  new RequestSpecBuilder().setBaseUri(getGlobalValues("baseURL"))
        .addQueryParam("key", "qaclick123")
        .addFilter(RequestLoggingFilter.logRequestTo(log))
        .addFilter(ResponseLoggingFilter.logResponseTo(log))
        .setContentType(ContentType.JSON).build();

        return request;
        }
        return request;
    }

    public ResponseSpecification responseSpecification()
    {
        response = new ResponseSpecBuilder().expectStatusCode(200)
        .expectContentType(ContentType.JSON).build();
        return response;
    }

    public static String getGlobalValues(String key) throws IOException{

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\n" + //
                        "durthu\\eclipse-workspace\\CucumberBDD\\cucumberbdd\\src\\test\\java\\Resources\\Global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }

    public String getJsonPath(Response response, String key)
    {
        String resp = response.asString();
        js = new JsonPath(resp);
        return js.get(key).toString();
    }
}
