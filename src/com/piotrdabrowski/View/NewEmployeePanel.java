package com.piotrdabrowski.View;

import com.piotrdabrowski.Controller.Controller;
import com.piotrdabrowski.Model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by pdabrow on 16.09.16.
 */
public class NewEmployeePanel extends JPanel implements FocusListener, ActionListener {
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

    private JButton acceptButton = new JButton("Dodaj");
    private JButton cancelButton = new JButton("Anuluj");

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
        addButtonsPanel();
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
        addListeners();
    }

    private void addButtonsPanel() {
        addComponent(this, new JPanel(), 4, 0, 1, 6, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(this, acceptButton, 0, 6, 3, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        addComponent(this, cancelButton, 2, 6, 3, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == acceptButton)
            controller.addEmploeyeeToModel();
        else if (e.getSource() == cancelButton)
            controller.backToEmployeeManager();
        clearTextFields();

    }

    private void addListeners() {
        nameTextField.addFocusListener(this);
        lastNameTextField.addFocusListener(this);
        salaryTextField.addFocusListener(this);
        personalIdNumTextField.addFocusListener(this);
        jobPositionTextField.addFocusListener(this);
        headquaterIDTextField.addFocusListener(this);
        acceptButton.addActionListener(this);
        cancelButton.addActionListener(this);

    }

    public Employee createNewEmployee() {
        return new Employee(Long.valueOf(personalIdNum), headquaterIdNum, name, lastName,
                Integer.valueOf(salary), jobPosition);
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == nameTextField) {
            name = nameTextField.getText();
            System.out.println("imię " + name);
        } else if (e.getSource() == lastNameTextField) {
            lastName = lastNameTextField.getText();
            System.out.println("nazwisko " + lastName);
        } else if (e.getSource() == salaryTextField) {
            salary = salaryTextField.getText();
            System.out.println("wynagrodzenie " + salary);
        } else if (e.getSource() == personalIdNumTextField) {
            personalIdNum = personalIdNumTextField.getText();
            System.out.println("pesel " + personalIdNum);
        } else if (e.getSource() == jobPositionTextField) {
            jobPosition = jobPositionTextField.getText();
            System.out.println("stanowisko " + jobPosition);
        } else if (e.getSource() == headquaterIDTextField) {
            headquaterIdNum = headquaterIDTextField.getText();
            System.out.println("siedziba " + headquaterIdNum);
        }


    }

    void clearTextFields() {
        nameTextField.setText("");
        lastNameTextField.setText("");
        headquaterIDTextField.setText("");
        personalIdNumTextField.setText("");
        salaryTextField.setText("");
        jobPositionTextField.setText("");
    }
}
