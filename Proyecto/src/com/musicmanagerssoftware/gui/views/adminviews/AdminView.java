package com.musicmanagerssoftware.gui.views.adminviews;

import com.musicmanagerssoftware.base.account.User;
import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.util.AlertUtil;
import com.musicmanagerssoftware.util.DataBaseUtil;
import com.musicmanagerssoftware.util.HibernateUtil;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class AdminView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList list1;
    private JComboBox comboBox1;
    private User usuarioSeleccionado;
    private Model model;
    private DefaultListModel dlm;

    public AdminView() {
        model = new Model();
        dlm = new DefaultListModel();
        list1.setModel(dlm);
        setContentPane(contentPane);
        setModal(true);
        setLocationRelativeTo(null);
        listar();
        getRootPane().setDefaultButton(buttonOK);
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                usuarioSeleccionado = (User) list1.getSelectedValue();
                if (e.getValueIsAdjusting()) {
                    if (usuarioSeleccionado.getTypeOfUser().equals("Lector")) {
                        comboBox1.setSelectedIndex(0);
                    } else if (usuarioSeleccionado.getTypeOfUser().equals("Editor")) {
                        comboBox1.setSelectedIndex(1);
                    } else if (usuarioSeleccionado.getTypeOfUser().equals("Admin")) {
                        comboBox1.setSelectedIndex(2);
                    }
                }
            }
        });

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        pack();
        setVisible(true);

    }

    private void usuarioSeleccionado(){
        usuarioSeleccionado.setTypeOfUser(comboBox1.getSelectedItem().toString());
        model.modificarUsuario(usuarioSeleccionado);

    }

    private void listar(){

        for (User user:model.getUsuario()) {
            dlm.addElement(user);
        }
    }

    private void onOK() {
        usuarioSeleccionado();
        AlertUtil.messageAlert("Se han guardado los cambios");
        HibernateUtil.buildSessionFactory();
        dispose();
    }

    private void onCancel() {
        HibernateUtil.buildSessionFactory();
        dispose();
    }

}
