package com.musicmanagerssoftware.gui.views.settingviews;

import com.musicmanagerssoftware.base.account.User;
import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.util.DataBaseUtil;
import com.musicmanagerssoftware.util.HibernateUtil;
import ownLibs.basic.CompButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountEditView extends JDialog {
    private JPanel contentPane;

    private JTextField textFieldNombre;
    private JTextField textFieldPrimerApellido;
    private JPasswordField passwordFieldContrasenna;
    private JTextField textFieldEmail;
    private JTextField textFieldusuario;
    private CompButton buttonEdit;
    private CompButton buttonAcept;
    private User usuario;

    public AccountEditView(User usuario) {
        this.usuario = usuario;
        setContentPane(contentPane);
        setTitle("Music Manager Software - Editar Cuenta");
        setIconImage(Toolkit.getDefaultToolkit().getImage("ico\\Logo.png"));
        setModal(true);
        setResizable(false);
        getRootPane().setDefaultButton(buttonAcept);
        showData();
        buttonAcept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editInfo();
                onOK();
            }
        });
        buttonEdit.addActionListener(new ActionListener()  {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void onOK() {
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    private void showData(){
        textFieldNombre.setText(usuario.getNombre());
        textFieldPrimerApellido.setText(usuario.getApellidos());
        textFieldEmail.setText(usuario.getEmail());
        textFieldusuario.setText(usuario.getuserName());
        passwordFieldContrasenna.setText(usuario.getUserPassword());
    }

    private void editInfo(){
        connectToUserDatabase();
        DataBaseUtil dataBaseUtil = new DataBaseUtil();
        Model model = new Model();
        usuario.setuserName(textFieldusuario.getText());
        usuario.setNombre(textFieldNombre.getText());
        usuario.setApellidos(textFieldPrimerApellido.getText());
        usuario.setEmail(textFieldEmail.getText());
        usuario.setUserPassword(passwordFieldContrasenna.getText());
        model.modificarUsuario(usuario);
        showData();
        disconnectToUserDatabase();
        dataBaseUtil.conectar();
    }

    /**
     * ES - Conecta a la base de datos de usuarios.
     */
    public void connectToUserDatabase(){
        HibernateUtil.buildSessionFactoryUser();
    }

    /**
     * ES - Desconecta la base de datos de usuarios.
     */
    public void disconnectToUserDatabase(){
        HibernateUtil.closeSessionFactory();
    }
}
