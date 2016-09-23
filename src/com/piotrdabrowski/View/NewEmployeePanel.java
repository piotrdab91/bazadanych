package com.piotrdabrowski.View;

import com.piotrdabrowski.Controller.Controller;
import com.piotrdabrowski.Model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pdabrow on 16.09.16.
 */
public class NewEmployeePanel extends JPanel {
    private static final Insets insets = new Insets(0, 0, 0, 0);
    Controller controller;

    private JLabel message = new JLabel("Wprowadz dane pracownika:");
    private JLabel nameLabel = new JLabel("Imię: ");
    private JLabel lastNameLabel = new JLabel("Nazwisko: ");
    private JLabel personalIdNumLabel = new JLabel("Pesel: ");
    private JLabel salaryLabel = new JLabel("Wynagrodzenie: ");
    private JLabel jobPostitionLabel = new JLabel("Stanowisko: ");
    private JLabel headquaterIdLabel = new JLabel("ID siedziby: ");

    private JTextField nameTextField = new JTextField(10);
    private JTextField lastNameTextField = new JTextField(10);
    private JTextField personalIdNumTextField = new JTextField();
    private JTextField salaryTextField = new JTextField();
    private JTextField jobPositionTextField = new JTextField();
    private JTextField headquaterIDTextField = new JTextField();

    private JButton acceptButton = new JButton("zatwierdz");

    String name;
    String lastName;
    String personalIdNum;
    String salary;
    String jobPosition;
    String headquaterIdNum;


    public NewEmployeePanel(Controller controller) {
        this.controller = controller;
        setLayout(new GridBagLayout());
        addLabels();
        addTextFields();
        addComponent(this, new JPanel(), 4, 0, 1, 6, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(this, acceptButton, 0, 6, 3, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addListeners();
        setVisible(false);

    }

    private static void addComponent(Container container, Component component,
                                     int gridx, int gridy, int gridwidth, int gridheight, int anchor,
                                     int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
                1.0, 1.0, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    private void addLabels() {
        addComponent(this, message, 0, 0, 4, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        addComponent(this, nameLabel, 0, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComponent(this, lastNameLabel, 2, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComponent(this, personalIdNumLabel, 0, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComponent(this, salaryLabel, 2, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComponent(this, jobPostitionLabel, 0, 3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComponent(this, headquaterIdLabel, 2, 3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
    }

    private void addTextFields() {
        addComponent(this, nameTextField, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        addComponent(this, lastNameTextField, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        addComponent(this, personalIdNumTextField, 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        addComponent(this, salaryTextField, 3, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        addComponent(this, jobPositionTextField, 1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        addComponent(this, headquaterIDTextField, 3, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
    }


    ActionListener textListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == nameTextField)
                name = nameTextField.getText();
            else if (e.getSource() == lastNameTextField)
                lastName = lastNameTextField.getText();
            else if (e.getSource() == salaryTextField)
                salary = salaryTextField.getText();
            else if (e.getSource() == personalIdNumTextField)
                personalIdNum = personalIdNumTextField.getText();
            else if (e.getSource() == jobPositionTextField)
                jobPosition = jobPositionTextField.getText();
            else if (e.getSource() == headquaterIDTextField)
                headquaterIdNum = headquaterIDTextField.getText();
            System.out.println("The entered text is: " + personalIdNum);
        }
    };
    ActionListener acceptListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            controller.addEmploeyeeToModel();

        }
    };

    private void addListeners() {
        nameTextField.addActionListener(textListener);
        lastNameTextField.addActionListener(textListener);
        salaryTextField.addActionListener(textListener);
        personalIdNumTextField.addActionListener(textListener);
        jobPositionTextField.addActionListener(textListener);
        headquaterIDTextField.addActionListener(textListener);
        acceptButton.addActionListener(acceptListener);

    }

    public Employee createNewEmployee() {
        return new Employee(91082606574L, "5", "ccc", "chuj", 3456, "dupa");
    }
}
