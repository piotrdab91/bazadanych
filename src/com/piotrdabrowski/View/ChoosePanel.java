package com.piotrdabrowski.View;

import javax.swing.*;
import java.awt.*;

// TODO: 16.09.16 improve code, divide code on parts, make better SetButton method  
public class ChoosePanel extends JPanel {

    JButton employeeButton = new JButton("Pracownicy");
    JButton projectsButton = new JButton("Projekty");
    JButton supervisorsButton = new JButton("Kierownicy");
    JButton clientsButton = new JButton("Klienci");
    JButton headquatersButton = new JButton("Siedziba");
    JButton worksOnButton = new JButton("Pracuje");

    public JButton getEmployeeButton() {
        return employeeButton;
    }

    public ChoosePanel() {
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Wybierz tabele"));
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        SetButtons(gc);

    }

    void SetButtons(GridBagConstraints gc) {

        gc.weightx = 0.75;
        gc.weighty = 0.75;
        gc.fill = 2;

        gc.gridx = 0;
        gc.gridy = 1;
        add(employeeButton, gc);


        gc.gridx = 0;
        gc.gridy = 2;
        add(projectsButton, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(supervisorsButton, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        add(clientsButton, gc);

        gc.gridx = 0;
        gc.gridy = 5;
        add(headquatersButton, gc);

        gc.gridx = 0;
        gc.gridy = 6;
        add(worksOnButton, gc);
        allButtonDisenable();

    }

    void allButtonDisenable() {
        employeeButton.setEnabled(false);
        projectsButton.setEnabled(false);
        supervisorsButton.setEnabled(false);
        clientsButton.setEnabled(false);
        headquatersButton.setEnabled(false);
        worksOnButton.setEnabled(false);
    }

    public void ButtonsEnable() {
        employeeButton.setEnabled(true);
        projectsButton.setEnabled(true);
        supervisorsButton.setEnabled(true);
        clientsButton.setEnabled(true);
        headquatersButton.setEnabled(true);
        worksOnButton.setEnabled(true);
    }
}


