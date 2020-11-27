package ownLibs.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

public class CompMenuItem extends JMenuItem {

    public CompMenuItem(String titulo,String actionCommand, String icon) {
        setText(titulo);
        setActionCommand(actionCommand);
        setIcon(new ImageIcon(icon));
    }
}