package com.preethi.networkmonitor;

public class NetworkStatus {

    private String status;
    private int responseCode;
    private long responseTime;

    public NetworkStatus(String status, int responseCode, long responseTime) {
        this.status = status;
        this.responseCode = responseCode;
        this.responseTime = responseTime;
    }

    public String getStatus() {
        return status;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public long getResponseTime() {
        return responseTime;
    }
}
