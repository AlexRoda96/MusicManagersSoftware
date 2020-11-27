package com.musicmanagerssoftware.gui.views.estadisticasviews;

import com.musicmanagerssoftware.base.Artista;
import com.musicmanagerssoftware.base.Disco;
import com.musicmanagerssoftware.base.Gira;
import com.musicmanagerssoftware.base.Sala;
import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.util.ComboBoxUtil;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Ventana que muestra estadisiticas
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public class Estadisticas extends JDialog {
    //Atributos
    private JPanel contentPane;
    private JPanel panel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JComboBox comboBox;
    private JComboBox comboBox3;

    DefaultCategoryDataset dataset;
    DefaultPieDataset dataset1;
    DefaultPieDataset dataset2;
    DefaultCategoryDataset dataset3;


    Model model;
    ComboBoxUtil comboBoxUtil;
    DefaultComboBoxModel dcm;
    DefaultComboBoxModel dcm1;

    /**
     * Constructor de Estadisiticas
     */
    public Estadisticas() {
        model = new Model();
        comboBoxUtil = new ComboBoxUtil();
        setTitle("Music Manager Software - Estadísticas");
        setIconImage(Toolkit.getDefaultToolkit().getImage("ico\\Logo.png"));
        setContentPane(contentPane);
        setModal(true);

        construirGarficoPrecioDisco();
        construirGarficoDiscosArtista();
        construirGarficoConciertosGiras();
        construirGarficoPrecioSala();

        initDcm();
        fillCombos();
        comboBox.setSelectedIndex(-1);
        comboBox3.setSelectedIndex(-1);
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                graficoPrecioDisco();

            }
        });
        comboBox3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                graficoConciertosGira();

            }
        });

        graficoDiscosDeArtistas();
        graficoPrecioSala();


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Inicia los dcm
     */
    private void initDcm(){
        dcm = new DefaultComboBoxModel();
        comboBox.setModel(dcm);

        dcm1 = new DefaultComboBoxModel();
        comboBox3.setModel(dcm1);
    }

    /**
     * Rellena los comboBox
     */
    private void fillCombos(){
        comboBoxUtil.fillComboArtista(dcm,model);
        comboBoxUtil.fillComboArtista(dcm1,model);
    }

    /**
     * Construye el panel
     */
    private void construirGarficoPrecioDisco(){
        panel.setLayout(new GridLayout(1, 0, 0,10));
        dataset=new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createBarChart3D("Precio Disco", "disco",
                "Precio Disco", dataset, PlotOrientation.VERTICAL, true,
                true, false);
        ChartPanel panelGraf= new ChartPanel(chart);
        panel.add(panelGraf);
    }

    /**
     * Construye el panel
     */
    private void construirGarficoPrecioSala(){
        panel2.setLayout(new GridLayout(1, 0, 0,10));
        dataset3=new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createBarChart3D("Precio Sala", "sala",
                "Precio Sala", dataset3, PlotOrientation.VERTICAL, true,
                true, false);
        ChartPanel panelGraf= new ChartPanel(chart);
        panel2.add(panelGraf);
    }

    /**
     * Construye el panel
     */
    private void construirGarficoDiscosArtista(){
        panel1.setLayout(new GridLayout(1, 0, 0,10));
        dataset1=new DefaultPieDataset();
        JFreeChart chart = ChartFactory.createPieChart(// char t
                "Discos",// title
                dataset1, // data
                true, // include legend
                true, false);
        ChartPanel panelGraf= new ChartPanel(chart);
        panel1.add(panelGraf);
    }

    /**
     * Construye el panel
     */
    private void construirGarficoConciertosGiras(){
        panel3.setLayout(new GridLayout(1, 0, 0,10));
        dataset2=new DefaultPieDataset();
        JFreeChart chart = ChartFactory.createPieChart(// char t
                "Conciertos",// title
                dataset2, // data
                true, // include legend
                true, false);
        ChartPanel panelGraf= new ChartPanel(chart);
        panel3.add(panelGraf);
    }


    /**
     * Muetras el gráfico de precio de discos
     */
    private void graficoPrecioDisco(){
        Artista artistaSeleccionado = (Artista) comboBox.getSelectedItem();
        for (Disco disco: artistaSeleccionado.getDiscos() ) {
            dataset.setValue(disco.getPrecio(),disco.getTitulo(),disco.getTitulo());
        }
    }

    /**
     * Muestra el gráfico de precio de salas
     */
    private void graficoPrecioSala(){
        for (Sala sala: model.getSala() ) {
            dataset3.setValue(sala.getPrecioAlquiler(),sala.getNombre(),sala.getNombre());
        }
    }

    /**
     * Muetra el grafico de giras
     */
    private void graficoConciertosGira(){
        Artista artistaSeleccionado = (Artista) comboBox3.getSelectedItem();
        for (Gira gira: artistaSeleccionado.getGiras() ) {
            dataset2.setValue(gira.getNombre(), gira.getConciertos().size());
        }
    }

    /**
     * Muestra el gráfico de discos
     */
    private void graficoDiscosDeArtistas() {
        int cantidad = 0;
        for (Artista artista : model.getArtista()) {
            for (Disco disco : artista.getDiscos()) {
                cantidad++;
            }
            dataset1.setValue(artista.getNombreArtistico(), cantidad);
        }

    }

    }
