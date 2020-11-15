package com.musicmanagerssoftware.gui.controllers;

import com.musicmanagerssoftware.gui.views.MenuView;
import com.musicmanagerssoftware.gui.views.addviews.*;
import com.musicmanagerssoftware.gui.views.deleteViews.DeleteView;
import com.musicmanagerssoftware.gui.views.modifyViews.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que controla el menu superior alojado en la vista principal.
 * @author Alejandro Roda
 * @version 1.0
 * @since 13/11/2020
 */
public class MenuController implements ActionListener {

    private MenuView menuView;
    private DeleteView deleteView;
    private DeleteViewController deleteViewController;

    /**
     * Constructor de MenuControll.
     */
    public MenuController(MenuView menuView){
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
        menuView.modifyItemArtista.addActionListener(listener);
        menuView.modifyItemGrupo.addActionListener(listener);
        menuView.modifyItemCancion.addActionListener(listener);
        menuView.modifyItemDisco.addActionListener(listener);
        menuView.modifyItemConcierto.addActionListener(listener);
        menuView.modifyItemGira.addActionListener(listener);
        menuView.modifyItemSala.addActionListener(listener);
        menuView.modifyItemReunion.addActionListener(listener);
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

    /**
     * Método que ejecuta las acciones al reaccionar con el action command del item
     * con el que se interacciona.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {

            case "Add Artista":
                ViewAddArtista viewAddArtista = new ViewAddArtista(0);
                break;

            case "Add Grupo":
                ViewAddGrupo viewAddGrupo = new ViewAddGrupo();
                break;

            case "Add Disco":
                ViewAddDisco viewAddDisco = new ViewAddDisco();
                break;

            case "Add Cancion":
                ViewAddCancion viewAddCancion = new ViewAddCancion();
                break;

            case "Add Gira":
                ViewAddGira musicGira = new ViewAddGira();
                break;

            case "Add Concierto":
                ViewAddConcierto viewAddConcierto = new ViewAddConcierto();
                break;

            case "Add Sala":
                ViewAddSala viewAddSala = new ViewAddSala();
                break;

            case "Delete Artista":
                deleteView = new DeleteView();
                deleteViewController = new DeleteViewController(deleteView,0);
                break;

            case "Delete Grupo":
                deleteView = new DeleteView();
                deleteViewController = new DeleteViewController(deleteView,1);
                break;

            case "Delete Cancion":
                deleteView = new DeleteView();
                deleteViewController = new DeleteViewController(deleteView,2);
                break;

            case "Delete Disco":
                deleteView = new DeleteView();
                deleteViewController = new DeleteViewController(deleteView,3);
                break;

            case "Delete Gira":
                deleteView = new DeleteView();
                deleteViewController = new DeleteViewController(deleteView,4);
                break;

            case "Delete Concierto":
                deleteView = new DeleteView();
                deleteViewController = new DeleteViewController(deleteView,5);
                break;

            case "Delete Sala":
                deleteView = new DeleteView();
                deleteViewController = new DeleteViewController(deleteView,6);
                break;

            case "Modify Artista":
                ViewModifyArtista viewModifyArtista = new ViewModifyArtista();
                break;

            case "Modify Grupo":
                ViewModifyGrupo viewModifyGrupo = new ViewModifyGrupo();
                break;

            case "Modify Cancion":
                ViewModifyCancion viewModifyCancion = new ViewModifyCancion();
                break;

            case "Modify Disco":
                ViewModifyDisco viewModifyDisco = new ViewModifyDisco();
                break;

            case "Modify Gira":
                ViewModifyGira viewModifyGira= new ViewModifyGira();
                break;

            case "Modify Concierto":
                ViewModifyConcierto viewModifyConcierto = new ViewModifyConcierto();
                break;

            case "Modify Sala":
                ViewModifySala viewModifySala = new ViewModifySala();
                break;
        }
    }
}
