package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import com.pojo.*;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class RestServiceActions {

    Response response;
    GetResponse getResponse;
    PostResponse postResponse;
    PutResponse putResponse;
    DeleteResponse deleteResponse;
    ObjectMapper objectMapper = new ObjectMapper();

    public void restActions(String action) {

        switch (action) {
            case "post":

                response = given().spec(requestSpecification()).body(setPostBody()).
                        when().post("api/v1/create").then().assertThat().
                        statusCode(200).log().all().extract().response();
                break;
            case "get":
                response = given().spec(requestSpecification()).pathParam("id", 21).
                        when().get("api/v1/employee/{id}").then().assertThat().
                        statusCode(200).log().all()
                        .extract().response();
                break;
            case "put":
                response = given().spec(requestSpecification()).body(setPutBody()).pathParam("id", 21).
                        when().put("api/v1/update/{id}").then().assertThat().
                        statusCode(200).log().all()
                        .extract().response();

                break;
            case "delete":
                response = given().spec(requestSpecification()).pathParam("id", 21).
                        when().delete("api/v1/delete/{id}").then().assertThat().
                        statusCode(200).log().all()
                        .extract().response();
                break;
            default:
                throw new IllegalArgumentException("Actions are not matched");
        }
    }

    private <T> T setObjectMapper(Class<T> action) throws JsonProcessingException {
        T responseValue;
        responseValue = objectMapper.readValue(response.asString(), action);
        return responseValue;
    }

    public void validateResponse(String action) {
        try {
            switch (action) {

                case "post":
                    postResponse = setObjectMapper(PostResponse.class);
                    Assert.assertEquals(postResponse.getStatus(), "success");
                    Assert.assertEquals(postResponse.getData().getName(), "David");
                    break;
                case "get":
                    getResponse = setObjectMapper(GetResponse.class);
                    Assert.assertEquals(getResponse.getStatus(), "success");
                    Assert.assertEquals(getResponse.getData().getId(), 21);
                    break;
                case "put":
                    putResponse = setObjectMapper(PutResponse.class);
                    Assert.assertEquals(putResponse.getStatus(), "success");
                    Assert.assertEquals(putResponse.getData().getSalary(), "60000");
                    break;
                case "delete":
                    deleteResponse = setObjectMapper(DeleteResponse.class);
                    Assert.assertEquals(deleteResponse.getStatus(), "success");
                    break;
                default:
                    throw new IllegalArgumentException("Actions are not matched");

            }
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
    }

    private Post setPostBody() {
        Post post = new Post();
        post.setName("David");
        post.setSalary("50000");
        post.setAge("26");
        return post;
    }

    private Put setPutBody() {
        Put put = new Put();
        put.setName("David");
        put.setSalary("60000");
        put.setAge("26");
        return put;
    }

    private RequestSpecification requestSpecification() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/";
        return new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(baseURI).
                addHeader("Content-Type", "application/json").build();
    }
}
