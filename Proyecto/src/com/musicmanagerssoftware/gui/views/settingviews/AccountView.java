package com.musicmanagerssoftware.gui.views.settingviews;

import com.musicmanagerssoftware.base.account.User;
import ownLibs.basic.CompButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountView extends JDialog {
    private JPanel contentPane;

    private JTextField textFieldNombre;
    private JTextField textFieldPrimerApellido;
    private JPasswordField passwordFieldContrasenna;
    private JTextField textFieldEmail;
    private JTextField textFieldUsuario;
    private CompButton buttonEdit;
    private CompButton buttonExit;
    private User usuario;

    public AccountView(User usuario) {
        this.usuario=usuario;
        setContentPane(contentPane);
        setModal(true);
        setTitle("Music Manager Software - Cuenta");
        setIconImage(Toolkit.getDefaultToolkit().getImage("ico\\Logo.png"));
        setResizable(false);
        getRootPane().setDefaultButton(buttonExit);
        showData();
        buttonEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountEditView accountEditView = new AccountEditView(usuario);
            }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showData(){
        textFieldNombre.setText(usuario.getNombre());
        textFieldPrimerApellido.setText(usuario.getApellidos());
        textFieldEmail.setText(usuario.getEmail());
        textFieldUsuario.setText(usuario.getuserName());
        passwordFieldContrasenna.setText(usuario.getUserPassword());
    }
}
