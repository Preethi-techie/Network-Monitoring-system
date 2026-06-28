package com.preethi.networkmonitor;

import javax.swing.*;
import java.awt.*;

public class MonitorUI extends JFrame {

    JLabel googleLabel;
    JLabel githubLabel;
    JLabel openaiLabel;
    private boolean googleWasOnline = true;
    private boolean githubWasOnline = true;
    private boolean chatgptWasOnline = true;

    public MonitorUI() {

        setTitle("Network Monitoring System");
        setSize(700, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        googleLabel = new JLabel();
        githubLabel = new JLabel();
        openaiLabel = new JLabel();

        panel.add(googleLabel);
        panel.add(githubLabel);
        panel.add(openaiLabel);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshStatus());

        panel.add(refreshButton);

        add(panel);

        refreshStatus();

        Timer timer = new Timer(60000, e -> refreshStatus());
        timer.start();
    }

    public void refreshStatus() {
    	System.out.println("refreshStatus called at : " + new java.util.Date());

        // Google
        NetworkStatus google = NetworkChecker.checkWebsite("https://www.google.com");

        boolean googleOnline = google.getStatus().equals("Reachable");

        if (googleOnline) {
            googleLabel.setForeground(Color.GREEN);

            if (!googleWasOnline) {
                NotificationUtil.showNotification("Network Restored", "Google is Reachable");
            }
        } else {
            googleLabel.setForeground(Color.RED);

            if (googleWasOnline) {
                NotificationUtil.showNotification("Network Alert", "Google is Offline");
            }
        }

        googleWasOnline = googleOnline;

        googleLabel.setText("Google : " + google.getStatus()
                + " | Code : " + google.getResponseCode()
                + " | Time : " + google.getResponseTime() + " ms");

        CsvLogger.log("Google", google);

        // GitHub
        NetworkStatus github = NetworkChecker.checkWebsite("https://github.com");

        boolean githubOnline = github.getStatus().equals("Reachable");

        if (githubOnline) {
            githubLabel.setForeground(Color.GREEN);

            if (!githubWasOnline) {
                NotificationUtil.showNotification("Network Restored", "GitHub is Reachable");
            }
        } else {
            githubLabel.setForeground(Color.RED);

            if (githubWasOnline) {
                NotificationUtil.showNotification("Network Alert", "GitHub is Offline");
            }
        }

        githubWasOnline = githubOnline;

        githubLabel.setText("GitHub : " + github.getStatus()
                + " | Code : " + github.getResponseCode()
                + " | Time : " + github.getResponseTime() + " ms");

        CsvLogger.log("GitHub", github);

        // ChatGPT
        NetworkStatus chatgpt = NetworkChecker.checkWebsite("https://chatgpt.com");

        boolean chatgptOnline = chatgpt.getStatus().equals("Reachable");

        if (chatgptOnline) {
            openaiLabel.setForeground(Color.GREEN);

            if (!chatgptWasOnline) {
                NotificationUtil.showNotification("Network Restored", "ChatGPT is Reachable");
            }
        } else {
            openaiLabel.setForeground(Color.RED);

            if (chatgptWasOnline) {
                NotificationUtil.showNotification("Network Alert", "ChatGPT is Offline");
            }
        }

        chatgptWasOnline = chatgptOnline;

        openaiLabel.setText("ChatGPT : " + chatgpt.getStatus()
                + " | Code : " + chatgpt.getResponseCode()
                + " | Time : " + chatgpt.getResponseTime() + " ms");

        CsvLogger.log("ChatGPT", chatgpt);
    }
}