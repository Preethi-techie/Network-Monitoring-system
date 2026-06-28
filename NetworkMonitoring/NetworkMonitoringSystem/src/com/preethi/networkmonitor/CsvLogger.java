package com.preethi.networkmonitor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvLogger {

    public static void log(String website, NetworkStatus status) {

        try {

            File file = new File("NetworkLog.csv");

            FileWriter writer = new FileWriter(file, true);

            writer.write(
                    website + "," +
                    status.getStatus() + "," +
                    status.getResponseCode() + "," +
                    status.getResponseTime() +
                    " ms\n");

            writer.close();



        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}