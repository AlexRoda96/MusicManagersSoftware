package ownLibs.menu;

import javax.swing.*;
import java.awt.*;

public class CompMenu extends JMenu {

    public CompMenu(String archivo) {
        setText(archivo);
        setFont(new Font("Consolas", Font.BOLD, 12));
    }
}