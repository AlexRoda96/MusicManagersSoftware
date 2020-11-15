package com.musicmanagerssoftware.gui.views;

import com.musicmanagerssoftware.componentes.panels.*;
import com.musicmanagerssoftware.gui.controllers.MenuController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class MainView extends JFrame {

    private JPanel contentPane;
    public JList list;
    public DefaultListModel dlmLista;
    public DefaultTableModel dtmArtistas;
    public JTable tabla;
    public ArtistPanel panelArtista;
    public DiscPanel panelDisco;
    public ConcertPanel panelConcierto;
    public BandPanel panelGrupo;
    public PanelCancion panelCancion;
    public PanelGira panelGira;
    public JTabbedPane tabbedPane;
    public JLabel artista;
    public MenuView menuView;

    public MainView() {
        setFont(new Font("Consolas", Font.BOLD, 12));
        setTitle("Music Managers Software");
        setBounds(100, 100, 1153, 826);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());
        menu();
        componentes();
        dtmArtistas = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
            }
        };

        tabla.setModel(dtmArtistas);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void menu() {
        menuView = new MenuView();
        MenuController menuController = new MenuController(menuView);
        setJMenuBar(menuView);
    }

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
