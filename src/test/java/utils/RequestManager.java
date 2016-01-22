package utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import steps.ResourcesSteps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RequestManager {

    private ResourcesSteps projectSteps;
    private static CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    private static HttpResponse response;

    public static String postRequest(String url, String authorization, String jsonData) throws IOException {
        HttpPost postRequest = new HttpPost(url + ".json");
        postRequest.addHeader("Authorization", authorization);
        postRequest.addHeader("accept", "application/json");
        StringEntity input = new StringEntity(jsonData);
        postRequest.setEntity(input);
        response = httpClient.execute(postRequest);
        return status(response, httpClient);
    }

    public static String getRequest(String url, String authorization) throws IOException {
        HttpGet getRequest = new HttpGet(url + ".json");
        getRequest.addHeader("Authorization", authorization);
        getRequest.addHeader("accept", "application/json");
        response = httpClient.execute(getRequest);
        return status(response, httpClient);
    }

    public static String getRequestId(String url, String authorization, String id) throws IOException {
        HttpGet getRequest = new HttpGet(url + "/" + id + ".json");
        getRequest.addHeader("Authorization", authorization);
        getRequest.addHeader("accept", "application/json");
        response = httpClient.execute(getRequest);
        return status(response, httpClient);
    }

    public static String putRequest(String url, String authorization, String id, String jsonData) throws IOException {
        HttpPut putRequest = new HttpPut(url + "/" + id + ".json");
        putRequest.addHeader("Authorization", authorization);
        putRequest.addHeader("accept", "application/json");
        StringEntity input = new StringEntity(jsonData);
        putRequest.setEntity(input);
        response = httpClient.execute(putRequest);
        return status(response, httpClient);
    }

    public static String deleteRequest(String url, String authorization, String id) throws IOException {
        HttpDelete deleteRequest = new HttpDelete(url + "/" + id + ".json");
        deleteRequest.addHeader("Authorization", authorization);
        deleteRequest.addHeader("accept", "application/json");
        response = httpClient.execute(deleteRequest);
        return status(response, httpClient);
    }

    public static String status(HttpResponse response, CloseableHttpClient httpClient) throws IOException {
        String result = "";
        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        String output;

        //Get the json response
        while ((output = br.readLine()) != null) {
            if (output.contains("{\"")) {
                System.out.println(output);
                result = output;
                break;
            }
        }
        return result;
    }

    public static void closeHttpConnection()throws IOException {
        httpClient.close();
    }
}
