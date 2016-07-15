package com.piotrdabrowski.View;


import javax.swing.*;

/**
 * Created by pdabrow on 15.07.16.
 */
public class MainWindow {
    private Dimensions defaultDim = new Dimensions(500,500);

    public MainWindow() {
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(defaultDim.getWidth(),defaultDim.getHeight());
        mainFrame.setTitle("Database Manager");
        mainFrame.setVisible(true);
    }




}
