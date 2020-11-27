package com.musicmanagerssoftware.gui.views;

import com.musicmanagerssoftware.components.mainpanels.*;
import com.musicmanagerssoftware.gui.controllers.MenuViewController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Vista principal.
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public class MainView extends JFrame {

    //Panel
    private JPanel contentPane;
    //List
    public JList list;
    //DefaultTableModel
    public DefaultTableModel dtmArtistas;
    //Tabla
    public JTable tabla;
    //Panels
    public ArtistPanel panelArtista;
    public DiscPanel panelDisco;
    public ConcertPanel panelConcierto;
    public BandPanel panelGrupo;
    public PanelCancion panelCancion;
    public PanelGira panelGira;
    public JTabbedPane tabbedPane;
    public JLabel artista;
    //Menu
    public MenuView menuView;

    /**
     * Constructor
     */
    public MainView() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("ico\\Logo.png"));
        setTitle("Music Managers Software");
        setBounds(100, 100, 1153, 826);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());
        dtmArtistas = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
            }
        };
        componentes();
        tabla.setModel(dtmArtistas);
        menu();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Inicializa el menu.
     */
    public void menu() {
        menuView = new MenuView();
        MenuViewController menuViewController = new MenuViewController(menuView);
        setJMenuBar(menuView);
    }

    /**
     * Inicializa los componentes.
     */
    private void componentes(){
        JSplitPane splitPaneGeneral = new JSplitPane();//SplitPanel General
        splitPaneGeneral.setOneTouchExpandable(true);
        splitPaneGeneral.setResizeWeight(0.8);
        contentPane.add(splitPaneGeneral);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new java.awt.Dimension(200, 200));
        splitPaneGeneral.setLeftComponent(scrollPane);

        tabla = new JTable();

        scrollPane.setViewportView(tabla);

        JLabel lblNewLabel = new JLabel("ART\u00CDSTAS");
        scrollPane.setColumnHeaderView(lblNewLabel);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        splitPaneGeneral.setRightComponent(tabbedPane);

        loadPanels();
    }

    /**
     * Carga los paneles.
     */
    public void loadPanels(){
        panelArtista = new ArtistPanel();
        tabbedPane.addTab("Art\u00EDsta", null, panelArtista, null);

        panelGrupo = new BandPanel();
        tabbedPane.addTab("Grupo", null, panelGrupo, null);

        panelDisco = new DiscPanel();
        tabbedPane.addTab("Discos", null, panelDisco, null);

        panelCancion = new PanelCancion();
        tabbedPane.addTab("Canciones", null, panelCancion, null);

        panelConcierto = new ConcertPanel();
        tabbedPane.addTab("Conciertos", null, panelConcierto, null);

        panelGira = new PanelGira();
        tabbedPane.addTab("Giras", null, panelGira, null);
    }
}
