package com.piotrdabrowski.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pdabrow on 24.08.16.
 */
public class EmployeePanel extends JPanel {
    private static final Insets insets = new Insets(0, 0, 0, 0);

    EmployeePanel() {
        Dimension size = getPreferredSize();
        size.width = 550;
        setPreferredSize(size);
        setLayout(new GridBagLayout());
        /*GridBagConstraints gc_1 = new GridBagConstraints();
        gc_1.gridx = 0;
        gc_1.gridy= 1;
        gc_1.weightx = 1;
        gc_1.weighty = 1;
        gc_1.fill = GridBagConstraints.BOTH;
        GridBagConstraints gc_2 = new GridBagConstraints();
        gc_1.gridx = 1;
        gc_1.gridy= 0;
        gc_2.weightx = 1;
        gc_2.weighty = 1;
        gc_2.fill = GridBagConstraints.BOTH;*/

        setBorder(BorderFactory.createTitledBorder("Pracownicy"));
        String[] columnNames = {"Pesel",
                "id_siedizby",
                "imię",
                "Nazwisko",
                "Wynagrodzenie"};
        Object[][] data = {
                {1, "id_1",
                        "janusz", "Eugeniusz", 5000, "Konstruktor"},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false)}
        };
        JTable empTable = new JTable(data, columnNames);
        JScrollPane scroll = new JScrollPane(empTable, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scroll.getViewport().setView(empTable);
        JButton button = new JButton("Przycisk");
        addComponent(this, scroll, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(this, button, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        /*add(scroll,gc_1);
        add(button,gc_2);*/

    }

    private static void addComponent(Container container, Component component,
                                     int gridx, int gridy, int gridwidth, int gridheight, int anchor,
                                     int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0, 1.0, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }
}


