package com.piotrdabrowski.View;

import javax.swing.*;
import java.awt.*;
// TODO: 16.09.16 add starting image 

/**
 * Created by pdabrow on 27.08.16.
 */
public class ConnectToDatabasePanel extends JPanel {
    JButton connectButton = new JButton("Połącz");

    public JButton getConnectButton() {
        return connectButton;
    }

    public ConnectToDatabasePanel() {
        super(new GridBagLayout());
        GridBagConstraints gc_1 = new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.SOUTH,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);

        GridBagConstraints gc_2 = new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);

        JLabel text = new JLabel("Połącz się z bazą danych");
        add(text, gc_1);
        add(connectButton, gc_2);
    }

}
