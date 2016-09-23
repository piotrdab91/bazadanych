package com.piotrdabrowski.View;

import com.piotrdabrowski.Model.Employee;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by pdabrow on 16.09.16.
 */

public class EmployeeTableModel extends AbstractTableModel {
    private static final int PERSONAL_ID_NUMBER_COL = 0;
    private static final int HEADQUATER_ID_COL = 1;
    private static final int NAME_COL = 2;
    private static final int LAST_NAME_COL = 3;
    private static final int SALARY_COL = 4;
    private static final int JOB_TITLE_COL = 5;


    private java.util.List<Employee> employeesList;
    private String[] columnNames = {"Pesel", "imię", "Nazwisko", "Wynagrodzenie", "id_siedziby", "Stanowisko"};


    public EmployeeTableModel(List<Employee> list) {
        employeesList = list;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return employeesList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee tempEmployee = employeesList.get(rowIndex);
        switch (columnIndex) {
            case HEADQUATER_ID_COL:
                return tempEmployee.getHeadquaterId();
            case NAME_COL:
                return tempEmployee.getName();
            case LAST_NAME_COL:
                return tempEmployee.getLast_name();
            case SALARY_COL:
                return tempEmployee.getSalary();
            case JOB_TITLE_COL:
                return tempEmployee.getJob_title();
            default:
                return tempEmployee.getPersonalIdNumber();

        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}

