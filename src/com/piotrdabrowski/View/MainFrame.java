package com.piotrdabrowski.View;


import com.piotrdabrowski.Controller.Controller;
import com.piotrdabrowski.Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame {
    Controller controller;
    Model model;
    private Dimensions defaultDim = new Dimensions(500, 800);
    Container pane;
    ChoosePanel choosePanel = new ChoosePanel();
    EmployeePanel employeePanel;
    ConnectToDatabasePanel connectPanel = new ConnectToDatabasePanel();

    public MainFrame(String title, Controller controller, Model model) {
        super(title);
        this.setSize(defaultDim.getWidth(), defaultDim.getHeight());
        this.controller = controller;
        employeePanel = new EmployeePanel(model, controller);
        setLayout(new GridBagLayout());

        addPanels();
        addActionListener();

        this.setVisible(true);
    }


    ActionListener employeeListenter = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            controller.employeeManager();
        }
    };

    ActionListener connectBListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            controller.connnectToDatabase();
        }
    };

    public Controller getController() {
        return controller;
    }

    public Dimensions getDefaultDim() {
        return defaultDim;
    }

    public Container getPane() {
        return pane;
    }

    public ChoosePanel getChoosePanel() {
        return choosePanel;
    }

    public EmployeePanel getEmployeePanel() {
        return employeePanel;
    }

    public ConnectToDatabasePanel getConnectPanel() {
        return connectPanel;
    }

    public ActionListener getEmployeeListenter() {
        return employeeListenter;
    }

    public ActionListener getConnectBListener() {
        return connectBListener;
    }

    public void addPanels() {

        GridBagConstraints gc_1 = new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        GridBagConstraints gc_2 = new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        add(choosePanel, gc_1);
        add(connectPanel, gc_2);
        add(employeePanel, gc_2);

    }

    public void addActionListener() {
        choosePanel.getEmployeeButton().addActionListener(employeeListenter);
        connectPanel.getConnectButton().addActionListener(connectBListener);
    }
}
