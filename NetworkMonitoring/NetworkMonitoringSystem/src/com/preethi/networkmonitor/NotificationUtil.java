package com.preethi.networkmonitor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.image.BufferedImage;

public class NotificationUtil {

    private static TrayIcon trayIcon;

    static {

        if (SystemTray.isSupported()) {

            try {

                SystemTray tray = SystemTray.getSystemTray();

                BufferedImage image = new BufferedImage(
                        16,
                        16,
                        BufferedImage.TYPE_INT_ARGB);

                Graphics2D g = image.createGraphics();

                g.setColor(Color.BLUE);
                g.fillOval(0, 0, 16, 16);

                g.dispose();

                trayIcon = new TrayIcon(image, "Network Monitoring System");
                trayIcon.setImageAutoSize(true);

                tray.add(trayIcon);

                System.out.println("Tray Icon Added Successfully");

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

            System.out.println("System Tray is not supported.");

        }

    }

    public static void showNotification(String title, String message) {

        if (trayIcon != null) {

            trayIcon.displayMessage(
                    title,
                    message,
                    TrayIcon.MessageType.INFO);

        }

    }

}