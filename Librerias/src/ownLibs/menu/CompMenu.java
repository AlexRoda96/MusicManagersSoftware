package ownLibs.menu;

import javax.swing.*;
import java.awt.*;

public class CompMenu extends JMenu {

    public CompMenu(String archivo ,String comando ,String icon) {
        setText(archivo);
        setActionCommand(comando);
        setIcon(new ImageIcon(icon));
    }
}