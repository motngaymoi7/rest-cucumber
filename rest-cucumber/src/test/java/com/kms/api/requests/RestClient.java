package com.kms.api.requests;

import static io.restassured.RestAssured.given;

import com.kms.api.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;

/**
 * Generic RestClient containing some Rest-Assured methods.
 *
 * @author vihoang Date 1-Jun-2022
 */
public class RestClient extends TestBase {

  /**
   * Perform Get request with params and basic
   *
   * @param requestPath the endpoint
   * @param params list of params
   * @return the response of the Get request
   */
  public static Response doGetRequestWithParams(
      String requestPath, Map<String, String> params, ContentType contentType) {
    return given()
        .queryParams(params)
        .contentType(contentType)
        .accept(contentType)
        .when()
        .get(requestPath)
        .then()
        .log()
        .all()
        .extract()
        .response();
  }

  /**
   * Perform Post request with params and no request payload
   *
   * @param requestPath the endpoint
   * @param contentType list of params
   * @return the response of the Post request
   */
  public static Response doPostRequestWithPayload(
      String requestPath, ContentType contentType, Object body) {
    return given()
        .log()
        .everything()
        .contentType(contentType)
        .with()
        .accept(contentType)
        .body(body)
        .when()
        .post(requestPath)
        .then()
        .log()
        .all()
        .extract()
        .response();
  }

  /**
   * Perform Put request with params and no request payload
   *
   * @param requestPath the endpoint
   * @param contentType list of params
   * @return the response of the Put request
   */
  public static Response doPutRequestWithPayload(
      String requestPath, ContentType contentType, Object body) {
    return given()
            .log()
            .everything()
            .contentType(contentType)
            .with()
            .accept(contentType)
            .body(body)
            .when()
            .put(requestPath)
            .then()
            .log()
            .all()
            .extract()
            .response();
  }

  /**
   * Perform Delete request with params and headers
   *
   * @param requestPath the endpoint
   * @return the response of the Delete request
   */
  public static Response doDeleteRequestWithParams(String requestPath) {
    return given()
            .log()
            .everything()
            .with()
            .when()
            .delete(requestPath)
            .then()
            .log()
            .all()
            .extract()
            .response();
  }
}
