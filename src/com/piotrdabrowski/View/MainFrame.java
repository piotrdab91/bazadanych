package com.piotrdabrowski.View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame {
    private Dimensions defaultDim = new Dimensions(500, 800);
    Container pane;

    public MainFrame(String title) {
        super(title);
        this.setSize(defaultDim.getWidth(), defaultDim.getHeight());
        setLayout(new BorderLayout());
        pane = getContentPane();
        ChoosePanel choosePanel = new ChoosePanel();
        pane.add(choosePanel, BorderLayout.WEST);
        choosePanel.getEmployeeButton().addActionListener(employeeListenter);
        this.setVisible(true);
    }


    ActionListener employeeListenter = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            EmployeePanel employeePanel = new EmployeePanel();
            pane.add(employeePanel, BorderLayout.EAST);
            validate();
            repaint();
        }
    };


}
