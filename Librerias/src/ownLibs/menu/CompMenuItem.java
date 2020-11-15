package ownLibs.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

public class CompMenuItem extends JMenuItem {

    public CompMenuItem(String titulo,String actionCommand) {
        setText(titulo);
        setActionCommand(actionCommand);
    }
}