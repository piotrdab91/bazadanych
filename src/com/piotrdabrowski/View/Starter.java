package com.piotrdabrowski.View;

import javax.swing.*;

public class Starter {
    public Starter() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame mainWindow = new MainFrame("Database Manager");

            }
        });
    }
}
