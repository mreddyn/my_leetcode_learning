package com.oa.company.DataAnotation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient {
    public static void main(String[] args) {
        try {
            // Create URL object with the endpoint
            URL url = new URL("https://google.com");

            // Create HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method to GET
            connection.setRequestMethod("GET");

            // Set timeout for connection and read
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Send GET request
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print JSON response
            System.out.println("Response Body:");
            System.out.println(response.toString());

            // Disconnect the HttpURLConnection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
