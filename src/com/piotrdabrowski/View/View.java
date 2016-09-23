package com.piotrdabrowski.View;

import com.piotrdabrowski.Controller.Controller;
import com.piotrdabrowski.Model.Model;

/**
 * Created by pdabrow on 14.09.16.
 */
public class View {
    private Controller controller;
    private Model model;

    private MainFrame mainFrame;


    public View(Model model) {
        this.model = model;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void startView() {
        mainFrame = new MainFrame("Database Manager", controller, model);

    }

    void addController(Controller controller) {
        this.controller = controller;
    }

    public void displayEmployees() {
        getMainFrame().getEmployeePanel().loadAndShowData();
    }

    public void refreshEmployees() {
        getMainFrame().getEmployeePanel().UpdateTable();
    }

}
