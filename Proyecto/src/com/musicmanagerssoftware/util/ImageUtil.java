package com.musicmanagerssoftware.util;

import com.musicmanagerssoftware.base.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Utilidades para las imagenes.
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public class ImageUtil {

    private boolean changeImage;
    private File fichero;

    /**
     * Constructor
     */
    public ImageUtil(){

    }

    /**
     * Selector de imagen y la inserta en una label.
     */
    public void selectImage(JLabel lbl_imagen) {

        this.changeImage = false;
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
        selector.setFileFilter(filtro);
        int opcion = selector.showSaveDialog(null);
        if (JFileChooser.APPROVE_OPTION == opcion) {

            fichero = selector.getSelectedFile();

            try {
                ImageIcon icon = new ImageIcon(fichero.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lbl_imagen.getWidth(), lbl_imagen.getHeight(), Image.SCALE_DEFAULT));
                lbl_imagen.setIcon(icono);
                this.changeImage = true;
            } catch (Exception ex) {
                ex.printStackTrace();
                AlertUtil.errorAlert("Error al abrir la imagen..");
            }
        }
    }

    /**
     * Convierte una imagen de byte a imagen.
     * @param artistaSeleccionado
     * @param lbl_imagen
     * @return icono
     */
    public Icon convertirDeByteAImage(Artista artistaSeleccionado, Grupo grupoSeleccionado,
                                      Cancion cancionSeleccionada, Disco discoSeleccionado,
                                      Gira giraSleccionada,Concierto conciertoSeleccionado,
                                      Sala salaSeleccionada, JLabel lbl_imagen){

        ByteArrayInputStream bis = null;

        if(artistaSeleccionado!=null) {
            bis = new ByteArrayInputStream(artistaSeleccionado.getFoto());
        }else if(grupoSeleccionado!=null){
            bis = new ByteArrayInputStream(grupoSeleccionado.getFoto());
        }else if(cancionSeleccionada!=null){
            bis = new ByteArrayInputStream(cancionSeleccionada.getImagen());
        }else if(discoSeleccionado!=null){
            bis = new ByteArrayInputStream(discoSeleccionado.getCaractula());
        }else if(salaSeleccionada!=null){
            bis = new ByteArrayInputStream(salaSeleccionada.getFoto());
        }else if(conciertoSeleccionado!=null){
            bis = new ByteArrayInputStream(conciertoSeleccionado.getCartel());
        }else if(giraSleccionada!=null){
            bis = new ByteArrayInputStream(giraSleccionada.getCartel());
        }

        BufferedImage bImage2 = null;

        try {
            bImage2 = ImageIO.read(bis);
        } catch (IOException e) {
            e.printStackTrace();
            AlertUtil.errorAlert("Error al convertir la imagen.");
        }

        ImageIcon icon = new ImageIcon(bImage2);

        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lbl_imagen.getWidth(),
                lbl_imagen.getHeight(),
                Image.SCALE_DEFAULT));

        return icono;
    }

    /**
     * Convierte la imagen seleccionada a byte.
     * @return data
     */
    public byte[] convertirImagenaByte() {

        BufferedImage bImage = null;

        try {
            bImage = ImageIO.read(fichero);
        } catch (IOException e) {
            e.printStackTrace();
            AlertUtil.errorAlert("Error al leer la imagen.");
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(bImage, "jpg", bos);
        } catch (IOException e) {
            e.printStackTrace();
            AlertUtil.errorAlert("Error al convertir la imagen a byte.");
        }

        byte[] data = bos.toByteArray();
        return data;
    }

    /**
     * Getter de changeImage
     * @return changeImage Si es true la imagen ha cmabiado, si es false no.
     */
    public boolean isChangeImage() {
        return changeImage;
    }
}
