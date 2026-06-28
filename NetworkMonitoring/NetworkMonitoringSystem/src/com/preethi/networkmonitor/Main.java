package com.preethi.networkmonitor;

public class Main {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {

            MonitorUI ui = new MonitorUI();
            ui.setVisible(true);
            
            NotificationUtil.showNotification(
                    "Test Notification",
                    "Network Monitoring System Started");

        });

    }

}