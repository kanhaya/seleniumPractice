import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.SortedMap;

public class RestTest {

    @Test
    public void makePostCall() throws JsonProcessingException {
        RestAssured.baseURI="https://demoqa.com/Account/v1";
        Credential credential=new Credential("test_rest","Testrest@123");
        RequestSpecification requestSpecification=RestAssured.given();
   Response response=requestSpecification
                .contentType(ContentType.JSON)
                .body(credential)
                .post("/User")
               .then().statusCode(406).extract().response();

        System.out.println(response.getBody().prettyPrint());

        String res=response.asString();
        System.out.println(JsonPath.read(res,"$.code").toString());
        Assert.assertTrue(JsonPath.read(res,"$.code").equals("1204"));


   //serialization
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(credential);
        System.out.println(json);

        // deserialization
        Credential credential1=mapper.readValue(json,Credential.class);
        System.out.println(credential1.getPassword()+"   ::"+credential1.getUserName());
    }
}

class  Credential{

    private String userName;
    private String password;

    public Credential(){

    }
    public Credential(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}