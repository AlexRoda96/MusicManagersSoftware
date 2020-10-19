package ownLibs.basic;

import javax.swing.*;

public class CompTextFieldNoEditable extends JTextField {

    public CompTextFieldNoEditable(){
        setEditable(false);
        setColumns(10);
    }
}
