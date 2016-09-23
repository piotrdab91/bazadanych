package com.piotrdabrowski.Controller;

import com.piotrdabrowski.Model.Employee;
import com.piotrdabrowski.Model.Model;
import com.piotrdabrowski.View.View;

import javax.swing.*;

;

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
        view.getMainFrame().getConnectPanel().setVisible(false);
        view.getMainFrame().getEmployeePanel().setVisible(true);
        try {
            view.displayEmployees();
            JOptionPane error = new JOptionPane("Error");
        } catch (Exception ex) {

        }
        view.getMainFrame().validate();
        view.getMainFrame().repaint();
    }

    public void newEmployeeManager() {
        view.getMainFrame().getEmployeePanel().getEmployeeModifyPanel().setVisible(false);
        view.getMainFrame().getEmployeePanel().getNewEmployeePanel().setVisible(true);
        view.getMainFrame().getEmployeePanel().validate();
        view.getMainFrame().getEmployeePanel().repaint();
        /*
        Employee newEmployee;
        newEmployee = view.getMainFrame().getEmployeePanel().getNewEmployeePanel().createNewEmployee();
        model.getEmployeeDAO().addEmployee(newEmployee.getPersonalIdNumber(),
                                            newEmployee.getName(),newEmployee.getLast_name(),newEmployee.getSalary(),newEmployee.getHeadquaterId(),
                                            newEmployee.getJob_title()); */
    }

    public void addEmploeyeeToModel() {
        Employee newEmployee;
        newEmployee = view.getMainFrame().getEmployeePanel().getNewEmployeePanel().createNewEmployee();
        model.getEmployeeDAO().addEmployee(newEmployee.getPersonalIdNumber(),
                newEmployee.getName(), newEmployee.getLast_name(), newEmployee.getSalary(), newEmployee.getHeadquaterId(),
                newEmployee.getJob_title());
        view.getMainFrame().getEmployeePanel().getNewEmployeePanel().setVisible(false);
        view.refreshEmployees();
        view.getMainFrame().validate();
        view.getMainFrame().repaint();
    }


}
