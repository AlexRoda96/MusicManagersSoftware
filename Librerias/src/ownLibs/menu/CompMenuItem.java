package ownLibs.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

public class CompMenuItem extends JMenuItem {

    public CompMenuItem(String titulo, String comando, int tecla, String icon) {
        setText(titulo);
        setActionCommand(comando);
        setIcon(new ImageIcon(icon));
        setFont(new Font("Consolas", Font.PLAIN, 12));
        setAccelerator(KeyStroke.getKeyStroke(tecla, InputEvent.CTRL_MASK));
    }
}