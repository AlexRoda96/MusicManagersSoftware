package com.musicmanagerssoftware.gui.controllers;

import com.musicmanagerssoftware.gui.views.adminviews.AdminView;
import com.musicmanagerssoftware.util.DataBaseUtil;
import com.musicmanagerssoftware.gui.views.MenuView;
import com.musicmanagerssoftware.gui.views.deleteviews.DeleteView;
import com.musicmanagerssoftware.gui.views.estadisticasviews.Estadisticas;
import com.musicmanagerssoftware.gui.views.estadisticasviews.Informes;
import com.musicmanagerssoftware.gui.views.helpviews.AboutViews;
import com.musicmanagerssoftware.gui.views.helpviews.VersionsView;
import com.musicmanagerssoftware.gui.views.searchviews.SearchView;
import com.musicmanagerssoftware.gui.views.settingviews.AccountView;
import com.musicmanagerssoftware.gui.views.settingviews.SettingsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que controla el menu superior alojado en la vista principal.
 * @author Alejandro Roda
 * @version 1.0
 * @since 13/11/2020
 */
public class MenuViewController implements ActionListener {

    private MenuView menuView;
    private DeleteView deleteView;
    private DataBaseUtil dataBaseUtil;
    private DeleteViewController deleteViewController;

    /**
     * Constructor de MenuControll.
     */
    public MenuViewController(MenuView menuView){
        this.menuView=menuView;
        addActionListener(this);
    }

    /**
     * Método que añade los listener a los items del menu
     * @param listener
     */
    private void addActionListener(ActionListener listener){
        addActionListenerAddItems(listener);
        addActionListenerDeleteItems(listener);
        addActionListenerModifyItems(listener);
        addActionListenerHelpItems(listener);
        addActionListenerSettingsItems(listener);
        addActionListenerFileItems(listener);
    }

    private void addActionListenerAddItems(ActionListener listener){
        menuView.addItemArtista.addActionListener(listener);
        menuView.addItemGrupo.addActionListener(listener);
        menuView.addItemDisco.addActionListener(listener);
        menuView.addItemCancion.addActionListener(listener);
        menuView.addItemGira.addActionListener(listener);
        menuView.addItemConcierto.addActionListener(listener);
        menuView.addItemSala.addActionListener(listener);
    }

    private void addActionListenerDeleteItems(ActionListener listener){
        menuView.deleteItemArtista.addActionListener(listener);
        menuView.deleteItemGrupo.addActionListener(listener);
        menuView.deleteItemCancion.addActionListener(listener);
        menuView.deleteItemDisco.addActionListener(listener);
        menuView.deleteItemConcierto.addActionListener(listener);
        menuView.deleteItemGira.addActionListener(listener);
        menuView.deleteItemSala.addActionListener(listener);
    }

    private void addActionListenerModifyItems(ActionListener listener){
        menuView.modifyItemArtista.addActionListener(listener);
        menuView.modifyItemGrupo.addActionListener(listener);
        menuView.modifyItemCancion.addActionListener(listener);
        menuView.modifyItemDisco.addActionListener(listener);
        menuView.modifyItemConcierto.addActionListener(listener);
        menuView.modifyItemGira.addActionListener(listener);
        menuView.modifyItemSala.addActionListener(listener);
    }

    private void addActionListenerHelpItems(ActionListener listener){
        menuView.menuItemAbout.addActionListener(listener);
        menuView.menuItemVersions.addActionListener(listener);
    }

    private void addActionListenerSettingsItems(ActionListener listener){
        menuView.menuItemPreferencias.addActionListener(listener);
        menuView.menuSearch.addActionListener(listener);
        menuView.menuItemEstadisticas.addActionListener(listener);
        menuView.menuItemInformes.addActionListener(listener);
    }

    private void addActionListenerFileItems(ActionListener listener){
       menuView.menuItemSalir.addActionListener(listener);
       menuView.menuItemGestionCuenta.addActionListener(listener);
    }

    /**
     * Método que ejecuta las acciones al reaccionar con el action command del item
     * con el que se interacciona.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {

            case "Buscar":
                SearchView searchView = new SearchView();
                break;

            case "About":
                AboutViews aboutViews = new AboutViews();
                break;

            case "Versions":
                VersionsView versionsView = new VersionsView();
                break;

            case "Settings":
                SettingsView settingsView = new SettingsView(menuView);
                break;

            case "Menu Exit":
                System.exit(0);
                break;

            case "Estadistica":
                Estadisticas estadisticas = new Estadisticas();
                break;

            case "Informes":
                Informes informes = new Informes();
                break;

            case "Administrador":
                AdminView adminView = new AdminView();
                break;

        }
    }
}
