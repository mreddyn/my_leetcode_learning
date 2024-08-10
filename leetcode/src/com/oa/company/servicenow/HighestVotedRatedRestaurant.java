package com.oa.company.servicenow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

public class HighestVotedRatedRestaurant {
    /*
     * Given city name and votes, query the URL :
     * https://jsonmock.hackerrank.com/api/food_outlets?city=<city>&page=1
     * and process the json response.
     * The response indicates the total results, number of pages
     * Return the restaurant which has more votes than given and highest rating.
     */
    private String baseUrl;

    HighestVotedRatedRestaurant() {
        baseUrl = "https://jsonmock.hackerrank.com/api/food_outlets?city";
    }

    public String getHighestRatedRestaurant(String city, int votes) throws URISyntaxException, IOException {
        getTotalPagesOfFoodOutletsForCity(city);
        return "";
    }

    private int getTotalPagesOfFoodOutletsForCity(String city) throws URISyntaxException, IOException {
        String urlString = getUrlForCityFoodOutlets(city);
        // set connection
        URL urlConnection = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) urlConnection.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        // check for response code (200 OK)
        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Request Failed: " + connection.getResponseCode());
        }

        // process response
        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String output = null;
        while ((output = bufferedReader.readLine()) != null) {
            System.out.println("Output from server ");
            System.out.println(output);
        }

        connection.disconnect();
        return 0;
    }

    private CityFoodOutlets getFoodOutletsDataForCity(String city) {
        
        return null;
    }

    private String getUrlForCityFoodOutlets(String city) {
        return baseUrl + "=" + city;
    }

    private String getPageUrlForCityFoodOutlets(String city, int page) {
        return baseUrl + "=" + city + "&" + "page=" + page;
    }

    record UserRating(double average_rating, int votes) {
    };

    record RestaurantData(String city, String name, int estimated_cost, UserRating user_rating, int id) {
    };

    record CityFoodOutlets(int page, int per_page, int total, int total_pages, RestaurantData[] data) {
    };

    public static void main(String[] args) throws URISyntaxException, IOException {
        HighestVotedRatedRestaurant highestVotedRatedRestaurant = new HighestVotedRatedRestaurant();
        highestVotedRatedRestaurant.getHighestRatedRestaurant("seattle", 0);
    }
}
