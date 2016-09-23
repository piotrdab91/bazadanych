package com.piotrdabrowski.View;

import com.piotrdabrowski.Controller.Controller;
import com.piotrdabrowski.Model.Model;

import javax.swing.*;

public class Starter {

    private Controller controller;
    private Model model;
    private View view;

    public Starter() {
        model = new Model();
        view = new View(model);
        controller = new Controller(model, view);
        view.addController(controller);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                controller.launchApplication();
            }
        });
    }
}
