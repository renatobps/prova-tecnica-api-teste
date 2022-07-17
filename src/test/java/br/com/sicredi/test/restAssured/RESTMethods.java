package br.com.sicredi.test.restAssured;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.internal.RequestSpecificationImpl;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.io.File;
import java.util.Map;
import org.apache.groovy.json.internal.LazyMap;
public class RESTMethods {

    private static RequestSpecification rs;
    private static RequestSpecification rsAux;
    private static Response response;

    public RESTMethods() {
    }

    public static Response getResponse() {
        Allure.addAttachment("application/json", response.asString());
        return response;
    }

    private static void setResponse(Response response) {
        RESTMethods.response = response;
    }

    public static void clearRs() {
        rs = null;
    }

    private static RequestSpecification buildBaseRequestSpecification() {
        clearRs();
        if (rsAux != null) {
            rs.headers(((RequestSpecificationImpl)rsAux).getHeaders());
            rs.cookies(((RequestSpecificationImpl)rsAux).getCookies());
        }

        rs = RestAssured.given().when().accept(ContentType.JSON);
        return rs;
    }

    public static void addHeader(Header h) {
        if (h != null) {
            rsAux.header(h);
        }

    }

    public static void addCookies(Map<String, String> c) {
        if (c != null) {
            rsAux.cookies(c);
        }

    }

    public static Response executeGet(String endpoint, LazyMap headCustom, LazyMap camposParams) {
        response = (Response)((ValidatableResponse)((Response)buildBaseRequestSpecification().headers(headCustom).queryParams(camposParams).get(endpoint, new Object[0])).then()).extract().response();
        printLogStart("GET", endpoint, "");
        printLog("GET", response);
        setResponse(response);
        return response;
    }

    public static Response executeGetpathParams(String endpoint, LazyMap headCustom, LazyMap camposParams) {
        response = (Response)((ValidatableResponse)((Response)buildBaseRequestSpecification().headers(headCustom).pathParams(camposParams).get(endpoint, new Object[0])).then()).extract().response();
        printLogStart("GET", endpoint, "");
        printLog("GET", response);
        setResponse(response);
        return response;
    }

    public static Response executePost(String endpoint, Object json, LazyMap headCustom, LazyMap camposParams) {
        response = (Response)((ValidatableResponse)((Response)buildBaseRequestSpecification().headers(headCustom).queryParams(camposParams).body(json).post(endpoint, new Object[0])).then()).extract().response();
        printLogStart("POST", endpoint, json.toString());
        printLog("POST", response);
        return response;
    }

    public static Response executePut(String endpoint, Object json, LazyMap headCustom, LazyMap camposParams, String path) {
        response = (Response)((ValidatableResponse)((Response)buildBaseRequestSpecification().headers(headCustom).queryParams(camposParams).body(json).put(endpoint + path, new Object[0])).then()).extract().response();
        printLogStart("PUT", endpoint, json.toString());
        printLog("PUT", response);
        return response;
    }

    public static Response executePutPathParams(String endpoint, Object json, LazyMap headCustom, LazyMap camposParams) {
        response = (Response)((ValidatableResponse)((Response)buildBaseRequestSpecification().headers(headCustom).pathParams(camposParams).body(json).put(endpoint, new Object[0])).then()).extract().response();
        printLogStart("PUT", endpoint, json.toString());
        printLog("PUT", response);
        return response;
    }

    public static Response executeDelete(String endpoint, LazyMap headCustom, LazyMap camposParams) {
        response = (Response)((ValidatableResponse)((Response)buildBaseRequestSpecification().headers(headCustom).queryParams(camposParams).delete(endpoint, new Object[0])).then()).extract().response();
        printLogStart("DELETE", endpoint, "");
        printLog("DELETE", response);
        return response;
    }

    public static Response executeOptions(String endpoint, LazyMap headCustom, LazyMap camposParams) {
        response = (Response)((ValidatableResponse)((Response)buildBaseRequestSpecification().headers(headCustom).queryParams(camposParams).options(endpoint, new Object[0])).then()).extract().response();
        printLogStart("OPTIONS", endpoint, "");
        printLog("OPTIONS", response);
        return response;
    }

    public static Response executePatch(String endpoint, Object json, LazyMap headCustom, LazyMap camposParams) {
        response = (Response)((ValidatableResponse)((Response)buildBaseRequestSpecification().headers(headCustom).queryParams(camposParams).body(json).patch(endpoint, new Object[0])).then()).extract().response();
        printLogStart("PATCH", endpoint, json.toString());
        printLog("PATCH", response);
        return response;
    }

    public static void executegetFile(String endpoint, LazyMap headCustom, LazyMap camposParams, String caminhoFile, String extensaoFile, String paramFile) {
        File file = new File(caminhoFile);
        response = (Response)((ValidatableResponse)((Response)buildBaseRequestSpecification().headers(headCustom).queryParams(camposParams).multiPart(paramFile, file, extensaoFile).post(endpoint, new Object[0])).then()).extract().response();
        printLogStart("POST", endpoint, "");
        printLog("POST", response);
        setResponse(response);
    }

    private static void printLogStart(String method, String url, String json) {
        System.out.println("");
        System.out.println("====================================");
        System.out.println("");
        System.out.println("METHOD: [ " + method + " (Request) ]");
        System.out.println("Endpoint: [ " + url + " ]");
        System.out.println("Headers: [ " + ((RequestSpecificationImpl)rs).getHeaders().toString() + " ]");
        System.out.println("Body - Request: [ " + json + " ]");
    }

    private static void printLog(String method, Response response) {
        System.out.println("");
        System.out.println("------------------------------------");
        System.out.println("");
        System.out.println("METHOD: [ " + method + " (Response) ]");
        System.out.println("Headers: [ " + response.getHeaders().toString() + " ]");
        System.out.println("Status Code: [ " + String.valueOf(response.statusCode()) + " ]");
        System.out.println("Response: [ " + response.getBody().asString() + " ]");
        System.out.println("");
        System.out.println("====================================");
    }

    public static Integer getResponseCode() {
        return response.getStatusCode();
    }

    public static String key(String field) {
        return (String)response.getBody().jsonPath().get(field);
    }

    public static String validarHeader(String header) {
        return response.header(header);
    }}
