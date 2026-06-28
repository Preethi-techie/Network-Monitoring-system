package com.preethi.networkmonitor;

import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkChecker {

    public static NetworkStatus checkWebsite(String website) {

        try {

            long startTime = System.currentTimeMillis();

            URL url = new URL(website);
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setConnectTimeout(3000);
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();

            long endTime = System.currentTimeMillis();

            long responseTime = endTime - startTime;

            if (responseCode == 200) {

                return new NetworkStatus(
                        "Reachable",
                        responseCode,
                        responseTime);

            } else {

                return new NetworkStatus(
                        "Unreachable",
                        responseCode,
                        responseTime);
            }

        } catch (Exception e) {

            return new NetworkStatus(
                    "Offline",
                    -1,
                    0);
        }

    }

}