package com.piotrdabrowski.View;

import com.piotrdabrowski.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeletePanel extends JPanel implements ActionListener {
    Controller controller;
    private JLabel commandLabel = new JLabel("Zaznacz wiersze do usunięcia");
    ;
    private JButton deleteButton = new JButton("Usuń");
    private JButton undoButton = new JButton("Cofnij");
    private JButton backButton = new JButton("Wróć");

    public DeletePanel(Controller controller) {
        super(new GridBagLayout());
        this.controller = controller;
        addComponent(this, commandLabel, 0, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComponent(this, deleteButton, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        //addComponent(this,undoButton,1,1,1,1,GridBagConstraints.CENTER, GridBagConstraints.NONE);
        addComponent(this, backButton, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        addActionListeners();
        setVisible(false);
    }


    private static void addComponent(Container container, Component component,
                                     int gridx, int gridy, int gridwidth, int gridheight, int anchor,
                                     int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
                1.0, 1.0, anchor, fill, new Insets(0, 0, 0, 0), 0, 0);
        container.add(component, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == deleteButton) {
            int response = JOptionPane.showConfirmDialog(null, "Czy napewno chcesz usunac ten rekord ?", "Potwierdzenie",
                    JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION)
                controller.deleteEmployee();
        }
        if (e.getSource() == backButton) {
            int response = JOptionPane.showConfirmDialog(null, " Czy zatwierdzić zmiany ?", "Potwierdzenie zmian",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                controller.confirmChanges();
            }
            if (response == JOptionPane.NO_OPTION)
                controller.disposeChanges();

        }
    }

    private void addActionListeners() {
        deleteButton.addActionListener(this);
        backButton.addActionListener(this);
    }
}
