package com.musicmanagerssoftware.gui.views.estadisticasviews;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Clae Informes.
 * Ventana en la que se muestran dos botones, cada uno muestra un informe diferente.
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public class Informes extends JDialog {

    private JPanel contentPane;
    JButton informe1;
    JButton informe2;

    /**
     * Constructor de Informes
     */
    public Informes() {

        setTitle("Music Manager Software - Informes");
        setIconImage(Toolkit.getDefaultToolkit().getImage("ico\\Logo.png"));
        setContentPane(contentPane);
        setModal(true);
        informe1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReport("Informes/InformeArtistas.jasper", "Informes/InformeArtistas.pdf");
            }
        });

        informe2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReport("Informes/InformeDiscos.jasper", "Informes/InformeDiscos.pdf");
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Genera los informes en pdf y los muetra en una ventana.
     * @param jasper
     * @param pdf
     */
    private void generateReport(String jasper, String pdf){
        Connection conexion = null;
        try {
            conexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/musicDb",
                    "root",
                    "");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JasperPrint jasperPrint = null;
        JasperReport report = null;
        try {
            report = (JasperReport) JRLoader.loadObjectFromFile(jasper);
        } catch (JRException e2) {
            e2.printStackTrace();
        }

        Map<String, Object> parametros = new HashMap<String,Object>();

        try {
            jasperPrint= JasperFillManager.fillReport(report,parametros,conexion);
        } catch (JRException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

        JRPdfExporter exp=new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput(pdf));
        SimplePdfExporterConfiguration conf=new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        try {
            exp.exportReport();
        } catch (JRException e1) {
            // TODO Auto-generated catch block
            System.out.println("Error al exportar");
        }

        JasperViewer jasperViewver=new JasperViewer(jasperPrint,false);
        jasperViewver.setVisible(true);
        dispose();

    }
}
