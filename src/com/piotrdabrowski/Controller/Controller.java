package com.piotrdabrowski.Controller;

import com.piotrdabrowski.Model.Employee;
import com.piotrdabrowski.Model.Model;
import com.piotrdabrowski.View.View;

import javax.swing.*;
import java.sql.SQLException;



public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void launchApplication() {
        view.startView();
    }

    public void connnectToDatabase() {
        model.connectToDatabase();
        view.getMainFrame().getChoosePanel().ButtonsEnable();
        view.getMainFrame().validate();
        view.getMainFrame().repaint();
    }

    public void employeeManager() {
        view.getMainFrame().getChoosePanel().getEmployeeButton().setEnabled(false);
        view.getMainFrame().getConnectPanel().setVisible(false);
        view.getMainFrame().getEmployeePanel().setVisible(true);
        try {
            view.displayEmployees();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Blad wyswietlenia danych");
        }
        view.getMainFrame().validate();
        view.getMainFrame().repaint();
    }

    public void newEmployeeManager() {
        view.getMainFrame().getEmployeePanel().getEmployeeModifyPanel().setVisible(false);
        view.getMainFrame().getEmployeePanel().getNewEmployeePanel().setVisible(true);
        view.getMainFrame().getEmployeePanel().validate();
        view.getMainFrame().getEmployeePanel().repaint();
    }

    public void addEmploeyeeToModel() {
        Employee newEmployee = view.getMainFrame().getEmployeePanel().getNewEmployeePanel().createNewEmployee();
        model.getEmployeeDAO().addEmployee(newEmployee.getPersonalIdNumber(),
                newEmployee.getName(), newEmployee.getLast_name(), newEmployee.getSalary(), newEmployee.getHeadquaterId(),
                newEmployee.getJob_title());
        view.getMainFrame().getEmployeePanel().getNewEmployeePanel().setVisible(true);
        view.refreshEmployees();
        view.getMainFrame().validate();
        view.getMainFrame().repaint();
    }

    public void backToEmployeeManager() {
        view.getMainFrame().getEmployeePanel().getNewEmployeePanel().setVisible(false);
        view.getMainFrame().getEmployeePanel().getEmployeeModifyPanel().setVisible(true);
        view.getMainFrame().validate();
        view.getMainFrame().repaint();

    }

    public void deleteManager() {
        view.getMainFrame().getEmployeePanel().getEmployeeModifyPanel().setVisible(false);
        view.getMainFrame().getEmployeePanel().getDeletePanel().setVisible(true);

        try {
            model.setSavepoint();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view.getMainFrame(), "Blad setSavepoint " + e.toString());
        }
        view.getMainFrame().validate();
        view.getMainFrame().repaint();
    }

    public void deleteEmployee() {
        int row = view.getMainFrame().getEmployeePanel().getTable().getSelectedRow();
        JTable table = view.getMainFrame().getEmployeePanel().getTable();
        long employeePersonalIdNum = (long) table.getValueAt(row, 0);
        model.getEmployeeDAO().deleteEmployee(employeePersonalIdNum);
        view.refreshEmployees();
        view.getMainFrame().validate();
        view.getMainFrame().repaint();
    }

    public void confirmChanges() {
        try {
            model.commit();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view.getMainFrame(), "Blad Confirm changes " + e.toString());
        }

        view.refreshEmployees();
        view.getMainFrame().getEmployeePanel().getDeletePanel().setVisible(false);
        view.getMainFrame().getEmployeePanel().getEmployeeModifyPanel().setVisible(true);
        view.getMainFrame().validate();
        view.getMainFrame().repaint();
    }

    public void disposeChanges() {
        try {
            model.rollback();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view.getMainFrame(), "Blad dispose changes " + e.toString());
        }

        view.refreshEmployees();
        view.getMainFrame().getEmployeePanel().getDeletePanel().setVisible(false);
        view.getMainFrame().getEmployeePanel().getEmployeeModifyPanel().setVisible(true);
        view.getMainFrame().validate();
        view.getMainFrame().repaint();

    }

}
