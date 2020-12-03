/**
 * @author AlejandroRoda
 */
package com.musicmanagerssoftware.gui.views.loginview;


import com.musicmanagerssoftware.base.account.User;
import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.gui.controllers.MainViewController;
import com.musicmanagerssoftware.gui.views.MainView;
import com.musicmanagerssoftware.gui.views.registerview.RegisterWindow;
import com.musicmanagerssoftware.util.AlertUtil;
import com.musicmanagerssoftware.util.HibernateUtil;
import org.hibernate.Session;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import javax.persistence.Query;
import javax.swing.*;
import javax.swing.border.*;

/**
 Ventana de acceso a la aplicación, consta de control de usuarios, elección de
 * idioma, opción de recordar el último usuario introducido y opción de acceder a
 * la ventana de registro en caso de no tener cuenta.
 */
public class LoginWindow extends JDialog implements MouseListener, ItemListener {

    //JPanel
    private JPanel panel1;
    Container contentPane;
    //JLabel
    private JLabel label_ImageLogin;
    private JLabel label_User;
    private JLabel label_Password;
    private JLabel label_ImageLanguage;
    private JLabel label_Account;
    private JLabel label_SignUp;
    private JLabel label_Wallpaper;
    private JLabel label_DevelopedBy;
    //JComboBox
    private JComboBox comboBox_Language;
    //JPasswordField
    private JPasswordField passwordField_Password;
    //JTextField
    private JTextField textField_User;
    //JButton
    private JButton button_Login;
    //JCheckBox
    private JCheckBox checkBox_RememberMe;
    //File
    private File save;
    //Properties
    private Properties configLogin;
    private Properties configLanguage;
    private Properties configDictionary;
    //String
    private String currentLanguage;
    private String rol;
    private User usuarioActual;

    /**
     * Constructor de Login.
     */
    public LoginWindow() {
        buildWindow();
        addMouseListener(this);
        addItemListener(this);
        createConfigurationFile();
        createLanguageFile();
        loadConfigurationFile();
        loadLanguageFile();
        loadLastUser();
        translate();
        connectToUserDatabase();
        setVisible(true);
    }

    /**
     * EN - Add the MouseListeners to the necessary components.
     * ES - Añade los MouseListener a los componentes necesarios.
     *
     * @param listener
     */
    public void addMouseListener(MouseListener listener) {
        label_SignUp.addMouseListener(listener);
    }

    private void addItemListener(ItemListener listener) {
        comboBox_Language.addItemListener(listener);
        checkBox_RememberMe.addItemListener(listener);
    }

    /**
     * EN - It contains all the necessary methods to build the window.
     * ES - Contiene todos los métodos necessarios para contruir la ventana.
     */
    private void buildWindow() {
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

    /**
     * EN - Init the window
     * ES - Inicia la ventana.
     */
    private void initWindow() {
        setTitle("Music Manager Software");
        setIconImage(Toolkit.getDefaultToolkit().getImage("ico\\Logo.png"));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    /**
     * EN - Launch the components that will appear in the window.
     * ES - Inicia los componentes que aparecerán en la ventana.
     */
    private void initComponents() {

        //Properties
        configLogin = new Properties();
        configLanguage = new Properties();
        configDictionary = new Properties();
        //JPanel
        panel1 = new JPanel();
        //JLabel
        label_ImageLogin = new JLabel();
        label_User = new JLabel();
        label_Password = new JLabel();
        label_ImageLanguage = new JLabel();
        label_Account = new JLabel();
        label_SignUp = new JLabel();
        label_Wallpaper = new JLabel();
        label_DevelopedBy = new JLabel();
        //JComboBox
        comboBox_Language = new JComboBox();
        //JPassworField
        passwordField_Password = new JPasswordField();
        //JTextField
        textField_User = new JTextField();
        //JButton
        button_Login = new JButton();
        //JCheckBox
        checkBox_RememberMe = new JCheckBox();

    }

    /**
     * Edita las propiedades de los componentes como el tamaño, color, color de
     * letra o tezto que muestran.
     */
    private void editComponents() {

        //---- label_ImageLogin ----
        label_ImageLogin.setText("text");
        label_ImageLogin.setIcon(new ImageIcon(getClass().getResource("/Loginn.png")));
        contentPane.add(label_ImageLogin);
        label_ImageLogin.setBounds(320, 70, 120, 110);

        //---- label_User ----
        label_User.setText("USUARIO");
        label_User.setForeground(Color.white);
        contentPane.add(label_User);
        label_User.setBounds(175, 250, 80, label_User.getPreferredSize().height);

        //---- label_Password ----
        label_Password.setText("CONTRASE\u00d1A");
        label_Password.setForeground(Color.white);
        contentPane.add(label_Password);
        label_Password.setBounds(175, 300, 80, 30);

        //---- textField_User ----
        textField_User.setBackground(new Color(102, 102, 102));
        textField_User.setForeground(Color.white);
        textField_User.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        contentPane.add(textField_User);
        textField_User.setBounds(280, 250, 245, 20);

        //---- passwordField_Password----
        passwordField_Password.setBackground(new Color(102, 102, 102));
        passwordField_Password.setForeground(Color.white);
        passwordField_Password.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
        contentPane.add(passwordField_Password);
        passwordField_Password.setBounds(280, 300, 245, 20);


        //---- button_Login ----
        button_Login.setText("LOGIN");
        button_Login.setForeground(Color.white);
        button_Login.setBackground(new Color(102, 102, 102));
        button_Login.setBorder(new MatteBorder(2, 2, 2, 2, Color.black));
        button_Login.setFont(button_Login.getFont().deriveFont
                (button_Login.getFont().getStyle() | Font.BOLD));
        contentPane.add(button_Login);
        button_Login.setBounds(455, 380, 100, 35);

        button_Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validateAccount();
            }
        });

        //---- chuckBox_RememberMe ----
        checkBox_RememberMe.setText("Recordar Usuario");
        checkBox_RememberMe.setForeground(Color.LIGHT_GRAY);
        checkBox_RememberMe.setBackground(Color.GRAY);
        checkBox_RememberMe.setOpaque(false);
        contentPane.add(checkBox_RememberMe);
        checkBox_RememberMe.setBounds(173, 360, 130, 20);


        //---- label_Account ----
        label_Account.setText("\u00bfNo tienes una cuenta?");
        label_Account.setForeground(Color.WHITE);
        contentPane.add(label_Account);
        label_Account.setBounds(265, 450, 140, label_Account.getPreferredSize().height);

        //---- label_SignUp ----
        label_SignUp.setText("Registrate");
        label_SignUp.setForeground(Color.white);
        label_SignUp.setFont(label_SignUp.getFont().deriveFont
                (label_SignUp.getFont().getStyle() | Font.BOLD));
        contentPane.add(label_SignUp);
        label_SignUp.setBounds(417, 450, 62, label_SignUp.getPreferredSize().height);

        //---- label_ImageLanguage ----
        label_ImageLanguage.setText("text");
        label_ImageLanguage.setIcon(new ImageIcon(getClass().getResource
                ("/Idioma.png")));
        contentPane.add(label_ImageLanguage);
        label_ImageLanguage.setBounds(615, 20, 20, 20);

        // ---- combobox_Language ----
        comboBox_Language.setBackground(new Color(102, 102, 102));
        comboBox_Language.setForeground(Color.white);
        comboBox_Language.setModel(new DefaultComboBoxModel
                (new String[]{"English", "Germany", "Italian", "Spanish"}));
        comboBox_Language.setOpaque(false);
        contentPane.add(comboBox_Language);
        comboBox_Language.setBounds(640, 20, 100, 20);

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

    /**
     * ES - Edita el tamaño del contentPane.
     */
    private void editSizeContentPane() {
        Dimension preferredSize = new Dimension();
        for (int i = 0; i < contentPane.getComponentCount(); i++) {
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
     * ES - Edita el tamaño del pane1.
     */
    private void editSizePane1() {
        Dimension preferredSize = new Dimension();
        for (int i = 0; i < panel1.getComponentCount(); i++) {
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

    /**
     * ES - Crea el fichero de configuración si no existe.
     *
     * @throws IOException
     */
    public void createConfigurationFile() {

        save = new File("config\\login.conf");

        if (!save.exists()) {

            try {
                save.createNewFile();
            } catch (IOException e) {
                AlertUtil.errorAlert("Error creating configuration file");
            }

            assignDefaultPropertiesLogin();
        }
    }

    /**
     * ES - Crea el fichero de configuración si no existe.
     *
     * @throws IOException
     */
    public void createLanguageFile() {

        save = new File("config\\language.conf");
        if (!save.exists()) {

            try {
                save.createNewFile();
            } catch (IOException e) {
                AlertUtil.errorAlert("Error creating language file");
            }

            assignDefaultPropertiesLanguage();
        }
    }

    /**
     * ES - Asigna valores por defecto a las propiedades del archivo de configuración.
     */
    private void assignDefaultPropertiesLanguage() {

        configLanguage.setProperty("language", "Spanish");
        try {

            configLanguage.store(new FileWriter(save.getAbsolutePath()),
                    "Language Settings");
        } catch (IOException e) {

            AlertUtil.errorAlert("Error when assigning default properties");
        }
    }

    /**
     * ES - Asigna valores por defecto a las propiedades del archivo de configuración.
     */
    private void assignDefaultPropertiesLogin() {

        configLogin.setProperty("remember", "true");
        configLogin.setProperty("lastUser", "default");
        try {

            configLogin.store(new FileWriter(save.getAbsolutePath()),
                    "Login Settings");
        } catch (IOException e) {

            AlertUtil.errorAlert("Error when assigning default properties");
        }
    }

    /**
     * ES - Actualiza los datos del fichero de configuración.
     *
     * @throws IOException
     */
    private void updateConfigurationFile() {

        File file = new File("config\\login.conf");
        if (checkBox_RememberMe.isSelected() == true) {
            configLogin.setProperty("remember", "true");
            configLogin.setProperty("lastUser", textField_User.getText());

            try {
                configLogin.store(new FileWriter(file.getAbsolutePath()),
                        "Login Settings");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (checkBox_RememberMe.isSelected() == false) {
            configLogin.setProperty("remember", "false");
            configLogin.setProperty("lastUser", "");
            try {
                configLogin.store(new FileWriter(file.getAbsolutePath()),
                        "Login Settings");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * ES - Actualiza los datos del fichero de configuración.
     *
     * @throws IOException
     */
    private void updateLanguageFile() {

        configLanguage.setProperty("language", (String) comboBox_Language.getSelectedItem());

        try {
            configLanguage.store(new FileWriter(save.getAbsolutePath()),
                    "Login Settings");
        } catch (IOException e) {

            AlertUtil.errorAlert("Error while saving data");
        }
    }

    /**
     * ES - Carga los datos del archivo de configuración.
     */
    public void loadConfigurationFile() {

        try {
            configLogin.load(new FileReader("config\\login.conf"));
        } catch (IOException e) {

            AlertUtil.errorAlert("Error loading configuration file");
        }
    }

    /**
     * ES - Carga los datos del archivo de configuración.
     */
    public void loadLanguageFile() {

        try {
            configLanguage.load(new FileReader("config\\language.conf"));
        } catch (IOException e) {

            AlertUtil.errorAlert("Error loading configuration file");
        }
    }


    /**
     * ES - Si el CheckBox de recordar se activó, se carga el último usuario utilizado
     * para acceder.
     */
    private void loadLastUser() {

        if (configLogin.getProperty("remember").equalsIgnoreCase("true")) {
            checkBox_RememberMe.setSelected(true);
            textField_User.setText(configLogin.getProperty("lastUser"));

        } else if (configLogin.getProperty("remember").equalsIgnoreCase("false")) {
            checkBox_RememberMe.setSelected(false);
        }
    }


    /**
     * ES - Asigna el idioma actual seleccionado a la variable currentLanguage.
     */
    private void currentLanguage() {

        String[] languageList = {"English", "Spanish", "Italian", "Germany", "Chinese"};

        for (int i = 0; i < languageList.length; i++) {

            if (configLanguage.getProperty("language").equalsIgnoreCase(languageList[i])) {
                currentLanguage = configLanguage.getProperty("language");
            }
        }
    }

    /**
     * ES - Carga el archivo de lenguaje, selecciona el item en el
     * ComboBox.
     */
    private void loadLanguage() {

        try {
            if (currentLanguage.equalsIgnoreCase("spanish")) {
                configDictionary.load(new FileReader("languages\\language_Es.conf"));

            } else if (currentLanguage.equalsIgnoreCase("english")) {
                configDictionary.load(new FileReader("languages\\language_En.conf"));
                label_Account.setBounds(240, 450, 180,
                        label_Account.getPreferredSize().height);

            } else if (currentLanguage.equalsIgnoreCase("italian")) {
                configDictionary.load(new FileReader("languages\\language_It.conf"));

            } else if (currentLanguage.equalsIgnoreCase("germany")) {
                configDictionary.load(new FileReader("languages\\language_Ge.conf"));

            } else if (currentLanguage.equalsIgnoreCase("chinese")) {
                configDictionary.load(new FileReader("languages\\language_Ch.conf"));
            }

        } catch (IOException e) {
            AlertUtil.errorAlert("Error loading language file");
        }
        comboBox_Language.setSelectedItem(currentLanguage);
    }

    /**
     * ES - Traduce todos los textos de la ventana de Login al idioma seleccionado.
     */
    private void translate() {

        currentLanguage();
        loadLanguage();

        label_User.setText(configDictionary.getProperty("user").toUpperCase());
        label_Password.setText(configDictionary.getProperty("password").toUpperCase());
        checkBox_RememberMe.setText(configDictionary.getProperty("rememberMe"));
        button_Login.setText(configDictionary.getProperty("login").toUpperCase());
        label_Account.setText(configDictionary.getProperty("account"));
        label_SignUp.setText(configDictionary.getProperty("signUp"));
        label_DevelopedBy.setText(configDictionary.getProperty("developedBy"));
        setTitle("Movie Manager - " + configDictionary.getProperty("titleLogin"));
    }

    /**
     * ES - Valida que la cuenta introducida existe en la base de datos.
     */
    private void validateAccount() {
        boolean accepted = false;

        for (User user : getUsers()) {

            if (textField_User.getText().equals(user.getuserName()) &&
                    passwordField_Password.getText().equals(user.getUserPassword())) {
                usuarioActual =user;
                accepted = true;
                updateConfigurationFile();
                disconnectToUserDatabase();
            }
        }

        if (!accepted) {
            JOptionPane.showMessageDialog(null,
                    configDictionary.getProperty("userInvalid"));

        } else if (accepted) {
            JOptionPane.showMessageDialog(null,
                    configDictionary.getProperty("userAccepted"));
            updateLanguageFile();

            if (usuarioActual.getTypeOfUser().equalsIgnoreCase("Lector")) {
                rol = "Lector";
            } else if (usuarioActual.getTypeOfUser().equalsIgnoreCase("Editor")) {
                rol = "Editor";
            }else if (usuarioActual.getTypeOfUser().equalsIgnoreCase("Admin")) {
                rol = "Admin";
            }
            MainView view = new MainView();
            Model model = new Model();
            MainViewController controller = new MainViewController(view, model, rol, usuarioActual);
            dispose();
        }
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

    /**
     * ES - Devuelve la lista de usuarios existente en la base de datos en forma de
     * ArrayList.
     * @return userList
     */
    private ArrayList<User> getUsers() {
        Session sesion = HibernateUtil.getCurrentSession();
        Query query = sesion.createQuery("FROM User ");
        ArrayList<User> userList= (ArrayList<User>)query.getResultList();
        sesion.close();
        return userList;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Font font= label_SignUp.getFont();
        Map attributes=font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE,TextAttribute.UNDERLINE_ON);
        label_SignUp.setFont(font.deriveFont(attributes));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Font font = label_SignUp.getFont();
        Map attributes=font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        label_SignUp.setFont(font.deriveFont(attributes));
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboBox_Language) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                updateLanguageFile();
                translate();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==1){
            RegisterWindow registerWindow = new RegisterWindow();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public User getUsuarioActual() {
        return usuarioActual;
    }
}
