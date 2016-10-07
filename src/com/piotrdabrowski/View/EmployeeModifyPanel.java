package com.piotrdabrowski.View;

import com.piotrdabrowski.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pdabrow on 16.09.16.
 */
public class EmployeeModifyPanel extends JPanel implements ActionListener {
    private static final Insets insets = new Insets(0, 0, 0, 0);
    Controller controller;

    JButton buttonNew = new JButton("Nowy");
    JButton buttonDelete = new JButton("Usuń");
    JButton buttonUpdate = new JButton("Aktualizuj");

    public EmployeeModifyPanel(Controller controller) {
        super(new GridBagLayout());
        this.controller = controller;
        addButtons();
        addButtonsListeners();


    }

    private static void addComponent(Container container, Component component,
                                     int gridx, int gridy, int gridwidth, int gridheight, int anchor,
                                     int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
                1.0, 1.0, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    private void addButtons() {
        addComponent(this, buttonNew, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        addComponent(this, buttonDelete, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        addComponent(this, buttonUpdate, 2, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
    }
    private void addButtonsListeners() {
        buttonNew.addActionListener(this);
        buttonDelete.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonNew)
            controller.newEmployeeManager();
        else if (e.getSource() == buttonDelete)
            controller.deleteManager();
    }
}
