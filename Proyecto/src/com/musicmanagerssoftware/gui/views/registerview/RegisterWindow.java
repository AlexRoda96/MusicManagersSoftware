package com.musicmanagerssoftware.gui.views.registerview;

import com.musicmanagerssoftware.base.account.User;
import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.util.AlertUtil;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Properties;

public class RegisterWindow extends JDialog{

    //JPanel
    private JPanel panel1;
    Container contentPane;
    //JLabel
    private JLabel label_User;
    private JLabel label_Password;
    private JLabel label_RepeatPassword;
    private JLabel label_ImageLanguage;
    private JLabel label_Name;
    private JLabel label_LastName;
    private JLabel label_Email;
    private JLabel label_Wallpaper;
    private JLabel label_DevelopedBy;
    //JPasswordField
    private JPasswordField passwordField_Password;
    private JPasswordField passwordField_RepeatPassword;
    //JTextField
    private JTextField textField_User;
    private JTextField textField_Name;
    private JTextField textField_LastName;
    private JTextField textField_Email;
    //JButton
    private JButton button_Cancel;
    private JButton button_Accept;
    //File
    //Nodelo
    Model model;

    public RegisterWindow(){
        model = new Model();
        buildWindow();
        setVisible(true);
    }

    private void buildWindow(){
        initWindow();
        contentPane = getContentPane();
        contentPane.setLayout(null);
        initComponents();
        editComponents();
        editSizeContentPane();
        editSizePane1();
        pack();
        setLocationRelativeTo(null);
    }

    private void initWindow(){
        setTitle("Music Managers Software - Registrar");
        setIconImage(Toolkit.getDefaultToolkit().getImage("ico\\Logo.png"));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setAlwaysOnTop(false);
    }

    /**
     * EN - Launch the components that will appear in the window.
     * ES - Inicia los componentes que aparecerán en la ventana.
     */
    private void initComponents() {
        //JPanel
        panel1 = new JPanel();
        //JLabel
        label_User = new JLabel();
        label_RepeatPassword = new JLabel();
        label_Password = new JLabel();
        label_ImageLanguage = new JLabel();
        label_Name= new JLabel();
        label_LastName = new JLabel();
        label_Email =  new JLabel();
        label_Wallpaper = new JLabel();
        label_DevelopedBy = new JLabel();
        //JPassworField
        passwordField_Password = new JPasswordField();
        passwordField_RepeatPassword = new JPasswordField();
        //JTextField
        textField_User = new JTextField();
        textField_Name = new JTextField();
        textField_LastName = new JTextField();
        textField_Email = new JTextField();
        //JButton
        button_Accept= new JButton();
        button_Cancel = new JButton();
    }

    /**
     * EN - Edit the size of the contentPane.
     * ES - Edita el tamaño del contentPane.
     */
    private void editSizeContentPane(){
        Dimension preferredSize = new Dimension();
        for(int i = 0; i < contentPane.getComponentCount(); i++) {
            Rectangle bounds = contentPane.getComponent(i).getBounds();
            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
            preferredSize.height = Math.max(bounds.y + bounds.height,
                    preferredSize.height);
        }
        Insets insets = contentPane.getInsets();
        preferredSize.width += insets.right;
        preferredSize.height += insets.bottom;
        contentPane.setMinimumSize(preferredSize);
        contentPane.setPreferredSize(preferredSize);
    }


    /**
     * EN - Edit the size of the pane1.
     * ES - Edita el tamaño del pane1.
     */
    private void editSizePane1(){
        Dimension preferredSize = new Dimension();
        for(int i = 0; i < panel1.getComponentCount(); i++) {
            Rectangle bounds = panel1.getComponent(i).getBounds();
            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
            preferredSize.height = Math.max(bounds.y + bounds.height,
                    preferredSize.height);
        }
        Insets insets = panel1.getInsets();
        preferredSize.width += insets.right;
        preferredSize.height += insets.bottom;
        panel1.setMinimumSize(preferredSize);
        panel1.setPreferredSize(preferredSize);
    }

    private void editComponents(){

        //---- label_Name ----
        label_Name.setText("Nombre:");
        label_Name.setForeground(Color.white);
        contentPane.add(label_Name);
        label_Name.setBounds(165, 150, 80, 30);

        //---- label_LastName ----
        label_LastName.setText("Apellidos:");
        label_LastName.setForeground(Color.white);
        contentPane.add(label_LastName);
        label_LastName.setBounds(165, 200, 80, 30);

        //---- label_Email ----
        label_Email.setText("Email:");
        label_Email.setForeground(Color.white);
        contentPane.add(label_Email);
        label_Email.setBounds(165, 250, 80, 30);

        //---- label_UserName----
        label_User.setText("Nombre de Usuario:");
        label_User.setForeground(Color.white);
        contentPane.add(label_User);
        label_User.setBounds(165, 300, 130, 30);

        //---- label_Password ----
        label_Password.setText("Contraseña:");
        label_Password.setForeground(Color.white);
        contentPane.add(label_Password);
        label_Password.setBounds(165, 350, 80, 30);

        //---- label_RepeatPassword ----
        label_RepeatPassword.setText("Repetir Contraseña:");
        label_RepeatPassword.setForeground(Color.white);
        contentPane.add(label_RepeatPassword);
        label_RepeatPassword.setBounds(165, 400, 150, 30);

        //---- textField_User ----
        textField_User.setBackground(new Color(102, 102, 102));
        textField_User.setForeground(Color.white);
        textField_User.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        contentPane.add(textField_User);
        textField_User.setBounds(300, 300, 245, 20);

        //---- textField_Name ----
        textField_Name.setBackground(new Color(102, 102, 102));
        textField_Name.setForeground(Color.white);
        textField_Name.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        contentPane.add(textField_Name);
        textField_Name.setBounds(300, 155, 245, 20);

        //---- textField_LastName ----
        textField_LastName.setBackground(new Color(102, 102, 102));
        textField_LastName.setForeground(Color.white );
        textField_LastName.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        contentPane.add(textField_LastName);
        textField_LastName.setBounds(300, 205, 245, 20);

        //---- textField_Email ----
        textField_Email.setBackground(new Color(102, 102, 102));
        textField_Email.setForeground(Color.white);
        textField_Email.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        contentPane.add(textField_Email);
        textField_Email.setBounds(300, 255, 245, 20);

        //---- passwordField_Password----
        passwordField_Password.setBackground(new Color(102, 102, 102));
        passwordField_Password.setForeground(Color.white);
        passwordField_Password.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        contentPane.add(passwordField_Password);
        passwordField_Password.setBounds(300, 355, 245, 20);

        //---- passwordField_Password----
        passwordField_RepeatPassword.setBackground(new Color(102, 102, 102));
        passwordField_RepeatPassword.setForeground(Color.white);
        passwordField_RepeatPassword.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        contentPane.add(passwordField_RepeatPassword);
        passwordField_RepeatPassword.setBounds(300, 405, 245, 20);

        //---- button_Accept ----
        button_Accept.setText("ACEPTAR");
        button_Accept.setForeground(Color.white);
        button_Accept.setBackground(new Color(102, 102, 102));
        button_Accept.setBorder(new MatteBorder(2, 2, 2, 2, Color.black));
        button_Accept.setFont(button_Accept.getFont().deriveFont
                (button_Accept.getFont().getStyle() | Font.BOLD));
        contentPane.add(button_Accept);
        button_Accept.setBounds(455, 450, 100, 35);


        button_Accept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });

        //---- button_Cancel ----
        button_Cancel.setText("CANCELAR");
        button_Cancel.setForeground(Color.white);
        button_Cancel.setBackground(new Color(102, 102, 102));
        button_Cancel.setBorder(new MatteBorder(2, 2, 2, 2, Color.black));
        button_Cancel.setFont(button_Cancel.getFont().deriveFont
                (button_Cancel.getFont().getStyle() | Font.BOLD));
        contentPane.add(button_Cancel);
        button_Cancel.setBounds(290, 450, 100, 35);

        //---- label_ImageLanguage ----
        label_ImageLanguage.setText("text");
        label_ImageLanguage.setIcon(new ImageIcon(getClass().getResource
                ("/Idioma.png")));
        contentPane.add(label_ImageLanguage);
        label_ImageLanguage.setBounds(615, 20, 20, 20);

        //---- label_Wallpaper ----
        label_Wallpaper.setText("text");
        label_Wallpaper.setIcon(new ImageIcon(getClass().
                getResource("/fondos/BackgroundLogin.jpg")));
        contentPane.add(label_Wallpaper);
        label_Wallpaper.setBounds(0, 0, 750, 600);

        // ---- label_DevelopedBy----
        label_DevelopedBy.setText("Desarrollado por Alejandro Roda©");
        label_DevelopedBy.setForeground(Color.GRAY);
        label_Wallpaper.add(label_DevelopedBy);
        label_DevelopedBy.setBounds(280, 560, 300,
                label_DevelopedBy.getPreferredSize().height);
    }

    private void addUser(){
        boolean ok=false;
        User user = new User();
        for (User users:model.getUsuario()) {
            if(users.getuserName().equalsIgnoreCase(textField_User.getText())){
                ok=false;
            }else{
                ok=true;
            }
        }

        if(ok==false){
            AlertUtil.errorAlert("El usuario ya existe");
            textField_User.setText("");
        }else{
            user.setNombre(textField_Name.getText());
            user.setApellidos(textField_LastName.getText());
            user.setuserName(textField_User.getText());
            if(textField_Email==null){
                ok=false;
            }else{
                user.setEmail(textField_Email.getText());
            }
            user.setTypeOfUser("Lector");
            if(passwordField_Password.getText().equals(passwordField_RepeatPassword.getText())) {
                user.setUserPassword(passwordField_Password.getText());
                model.altaUsuario(user);
                dispose();
            }else{
                AlertUtil.errorAlert("Las contraseñas no coinciden");
                passwordField_RepeatPassword.setText("");
                passwordField_Password.setText("");
            }
        }

    }

    private void clear(){
        textField_Name.setText("");
        textField_LastName.setText("");
        textField_Email.setText("");
        textField_User.setText("");
        passwordField_Password.setText("");
        passwordField_RepeatPassword.setText("");
    }
}
