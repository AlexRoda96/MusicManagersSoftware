package com.musicmanagerssoftware.pruebas;

import com.musicmanagerssoftware.base.Artista;
import com.musicmanagerssoftware.base.account.User;
import com.musicmanagerssoftware.gui.Model;
import com.musicmanagerssoftware.gui.controllers.MainViewController;
import com.musicmanagerssoftware.gui.views.MainView;
import com.musicmanagerssoftware.gui.views.loginview.LoginWindow;
import com.musicmanagerssoftware.gui.views.registerview.RegisterWindow;
import com.musicmanagerssoftware.gui.views.settingviews.AccountEditView;
import com.musicmanagerssoftware.util.HibernateUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PruebasUnitariasControlador extends MainViewController {
    private static Artista artista;
    private MainView vista;
    private Model modelo;
    private MainViewController controlador;
    private LoginWindow loginWindow;
    private AccountEditView accountEditView;
    private RegisterWindow registerWindow;
    private User user;

    public PruebasUnitariasControlador(){
        this.vista = new MainView();
        this.modelo = new Model();
        this.controlador = new MainViewController(vista, modelo,user);
        HibernateUtil.buildSessionFactory();
    }

    @Before
    public void setUp() throws Exception {
       artista=new Artista("alex","roda","!631254d");
    }

    @Test
    public void visualizarArtista(){
        vista.panelArtista.textField_nombreArtistico.setText("" + artista.getNombreArtistico());
        vista.panelArtista.textField_nombre.setText("" + artista.getNombre());
        vista.panelArtista.textField_primeriApellido.setText("" + artista.getPrimerApellido());
        vista.panelArtista.textField_segundoApellido.setText("" + artista.getSegundoApellido());
        vista.panelArtista.textField_dni.setText("" + artista.getDni());
        vista.panelArtista.textField_grupo.setText("" + artista.getGrupo());
        Assert.assertTrue("se ha visualizado correctamente",vista.panelArtista.textField_nombre.getText().equals("alex"));
    }

}
