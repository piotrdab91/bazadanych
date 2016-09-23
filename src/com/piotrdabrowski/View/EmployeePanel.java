package com.piotrdabrowski.View;

import com.piotrdabrowski.Controller.Controller;
import com.piotrdabrowski.Model.Employee;
import com.piotrdabrowski.Model.Model;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by pdabrow on 24.08.16.
 */
public class EmployeePanel extends JPanel {
    private static final Insets insets = new Insets(0, 0, 0, 0);
    private Model model;
    private Controller controller;
    private List<Employee> employees;

    private JTable table;
    private EmployeeModifyPanel employeeModifyPanel;
    private NewEmployeePanel newEmployeePanel;
    private JScrollPane scroll;

    EmployeePanel(Model model, Controller controller) {

        this.model = model;
        this.controller = controller;

        employees = null;

        Dimension size = getPreferredSize();
        size.width = 550;
        setPreferredSize(size);
        setLayout(new GridBagLayout());
    }

    void loadAndShowData() {

        try {
            employees = model.getEmployeeDAO().getAllEmployees();
        } catch (Exception ex) {

        }
        addScrollPaneAndTable();
        addEmployeeModifyPanel();
        addNewEmployeePanel();
        setVisible(true);
    }

    void UpdateTable() {
        try {
            employees = model.getEmployeeDAO().getAllEmployees();
        } catch (Exception ex) {

        }
        this.remove(scroll);
        this.remove(employeeModifyPanel);
        addScrollPaneAndTable();
        addEmployeeModifyPanel();

    }

    private static void addComponent(Container container, Component component,
                                     int gridx, int gridy, int gridwidth, int gridheight, int anchor,
                                     int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight,
                1.0, 1.0, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    private void addScrollPaneAndTable() {
        table = new JTable(new EmployeeTableModel(employees));
        scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        addComponent(this, scroll, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
    }

    private void addEmployeeModifyPanel() {
        employeeModifyPanel = new EmployeeModifyPanel(controller);
        addComponent(this, employeeModifyPanel, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
    }

    public void addNewEmployeePanel() {
        newEmployeePanel = new NewEmployeePanel(controller);
        addComponent(this, newEmployeePanel, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        setVisible(false);

    }

    public EmployeeModifyPanel getEmployeeModifyPanel() {
        return employeeModifyPanel;
    }

    public NewEmployeePanel getNewEmployeePanel() {
        return newEmployeePanel;
    }
}


