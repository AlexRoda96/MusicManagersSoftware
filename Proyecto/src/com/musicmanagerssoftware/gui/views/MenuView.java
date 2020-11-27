package com.musicmanagerssoftware.gui.views;

import ownLibs.menu.CompMenu;
import ownLibs.menu.CompMenuItem;

import javax.swing.*;
import java.awt.*;

/**
 * Barra de Menu
 * @author Alejandro Roda
 * @since 13/11/2020
 * @version 1.0
 */
public class MenuView extends JMenuBar {

    public CompMenu menuObjeto;
    public CompMenu menuAdd;
    public CompMenu menuDelete;
    public CompMenu menuModify;
    public CompMenuItem menuSearch;

    //ADD
    public CompMenuItem addItemArtista;
    public CompMenuItem addItemGrupo;
    public CompMenuItem addItemDisco;
    public CompMenuItem addItemCancion;
    public CompMenuItem addItemGira;
    public CompMenuItem addItemConcierto;
    public CompMenuItem addItemSala;

    //DELETE
    public CompMenuItem deleteItemArtista;
    public CompMenuItem deleteItemGrupo;
    public CompMenuItem deleteItemDisco;
    public CompMenuItem deleteItemCancion;
    public CompMenuItem deleteItemGira;
    public CompMenuItem deleteItemConcierto;
    public CompMenuItem deleteItemSala;

    //MODIFY
    public CompMenuItem modifyItemArtista;
    public CompMenuItem modifyItemGrupo;
    public CompMenuItem modifyItemDisco;
    public CompMenuItem modifyItemCancion;
    public CompMenuItem modifyItemGira;
    public CompMenuItem modifyItemConcierto;
    public CompMenuItem modifyItemSala;

    //HELP
    public CompMenuItem menuItemAbout;
    public CompMenuItem menuItemVersions;

    //HERRAMIENTAS
    public CompMenuItem menuItemEstadisticas;
    public CompMenuItem menuItemInformes;

    //SETTINGS
    public CompMenuItem menuItemCuenta;
    public CompMenuItem menuItemPreferencias;
    public CompMenu menuHerramientas;
    public CompMenu menuArchivo;
    public CompMenu menuAyuda;

    //ADMIN
    public CompMenuItem menuItemGestionCuenta;
    //FILE
    public CompMenuItem menuItemConecct;
    public CompMenuItem menuItemDisconnect;
    public CompMenuItem menuItemSalir;

    /**
     * Consutructor
     */
    public MenuView(){
        setBackground(new Color(245, 245, 245));
        menuArchivo();
        initMenuAccion();
        menuHerramientas();
        menuAjustes();
        menuAdmin();
        menuAyuda();
    }

    /**
     * Menu Archivo
     */
    private void menuArchivo(){

        menuArchivo = new CompMenu("Archivo",null,null);

        menuItemConecct = new CompMenuItem("Conectar","Menu Connect","ico\\Conectar.png");
        menuItemDisconnect= new CompMenuItem("Desconectar","Menu Disconnect","ico\\Desconectar.png");
        menuItemSalir = new CompMenuItem("Salir","Menu Exit","ico\\Salir.png");

        JSeparator separador = new JSeparator();
        JSeparator separador1 = new JSeparator();

        add(menuArchivo);
        menuArchivo.add(menuItemConecct);
        menuArchivo.add(menuItemDisconnect);
        menuArchivo.add(separador);
        menuArchivo.add(menuItemSalir);
    }

    /**
     * Menu Acción
     */
    private void initMenuAccion(){

        menuObjeto = new CompMenu("Acción",null,null);

        menuAdd = new CompMenu("Añadir",null,
                "ico\\Añadir.png");
        menuDelete = new CompMenu("Eliminar",null,
                "ico\\Eliminar.png");
        menuModify = new CompMenu("Modificar",null,
                "ico\\Modificar.png");
        menuSearch = new CompMenuItem("Buscar","Buscar","ico\\Buscar.png");

        add(menuObjeto);
        initSubMenuAdd();
        initSubMenuDelete();
        initSubMenuModify();
        menuObjeto.add(menuSearch);
    }

    /**
     * SubMenusAñadir
     */
    private void initSubMenuAdd(){
        menuObjeto.add(menuAdd);

        addItemArtista = new CompMenuItem("Artista","Add Artista",null);
        addItemGrupo = new CompMenuItem("Grupo", "Add Grupo",null);
        addItemDisco = new CompMenuItem("Disco", "Add Disco",null);
        addItemCancion = new CompMenuItem("Canción", "Add Cancion",null);
        addItemConcierto = new CompMenuItem("Concierto", "Add Concierto",null);
        addItemGira = new CompMenuItem("Gira", "Add Gira",null);
        addItemSala = new CompMenuItem("Sala", "Add Sala",null);

        menuAdd.add(addItemArtista);
        menuAdd.add(addItemGrupo);
        menuAdd.add(addItemCancion);
        menuAdd.add(addItemDisco);
        menuAdd.add(addItemGira);
        menuAdd.add(addItemConcierto);
        menuAdd.add(addItemSala);
    }

    /**
     * SubMenusEliminar
     */
    private void initSubMenuDelete(){
        menuObjeto.add(menuDelete);

        deleteItemArtista = new CompMenuItem("Artista","Delete Artista",null);
        deleteItemGrupo = new CompMenuItem("Grupo", "Delete Grupo",null);
        deleteItemDisco = new CompMenuItem("Disco", "Delete Disco",null);
        deleteItemCancion = new CompMenuItem("Canción", "Delete Cancion",null);
        deleteItemConcierto = new CompMenuItem("Concierto", "Delete Concierto",null);
        deleteItemGira = new CompMenuItem("Gira", "Delete Gira",null);
        deleteItemSala = new CompMenuItem("Sala", "Delete Sala",null);

        menuDelete.add(deleteItemArtista);
        menuDelete.add(deleteItemGrupo);
        menuDelete.add(deleteItemCancion);
        menuDelete.add(deleteItemDisco);
        menuDelete.add(deleteItemGira);
        menuDelete.add(deleteItemConcierto);
        menuDelete.add(deleteItemSala);
    }

    /**
     * SubMenuModificar
     */
    private void initSubMenuModify(){
        menuObjeto.add(menuModify);

        modifyItemArtista = new CompMenuItem("Artista","Modify Artista",null);
        modifyItemGrupo = new CompMenuItem("Grupo", "Modify Grupo",null);
        modifyItemDisco = new CompMenuItem("Disco", "Modify Disco",null);
        modifyItemCancion = new CompMenuItem("Canción", "Modify Cancion",null);
        modifyItemConcierto = new CompMenuItem("Concierto", "Modify Concierto",null);
        modifyItemGira = new CompMenuItem("Gira", "Modify Gira",null);
        modifyItemSala = new CompMenuItem("Sala", "Modify Sala",null);

        menuModify.add(modifyItemArtista);
        menuModify.add(modifyItemGrupo);
        menuModify.add(modifyItemCancion);
        menuModify.add(modifyItemDisco);
        menuModify.add(modifyItemGira);
        menuModify.add(modifyItemConcierto);
        menuModify.add(modifyItemSala);
    }

    /**
     * Menu Herramientas
     */
    private void menuHerramientas(){

        menuHerramientas = new CompMenu("Herramientas",null,null);

        menuItemEstadisticas = new CompMenuItem("Estadística","Estadistica","ico\\Estadistica.png");
        menuItemInformes = new CompMenuItem("Informes","Informes","ico\\Planificar.png");

        add(menuHerramientas);
        menuHerramientas.add(menuItemEstadisticas);
        menuHerramientas.add(menuItemInformes);

    }

    /**
     * Menu Ajustas
     */
    private void menuAjustes(){

        CompMenu menuAjustes = new CompMenu("Ajustes",null,null);

        menuItemCuenta = new CompMenuItem("Cuenta","Account","ico\\Usuarios.png");
        menuItemPreferencias = new CompMenuItem("Preferencias","Settings","ico\\Preferencias.png");

        add(menuAjustes);
        menuAjustes.add(menuItemCuenta);
        menuAjustes.add(menuItemPreferencias);

    }

    /**
     * Menu Ajustas
     */
    private void menuAdmin(){

        CompMenu menuAjustes = new CompMenu("Administrador",null,null);

        menuItemGestionCuenta = new CompMenuItem("Gestión de Cuentas","Administrador","ico\\Usuarios.png");
        add(menuAjustes);
        menuAjustes.add(menuItemGestionCuenta);


    }

    /**
     * Menu Ayuda
     */
    private void menuAyuda(){

        menuAyuda = new CompMenu("Ayuda",null,null);

        menuItemAbout = new CompMenuItem("Acerca de","About","ico\\AcercaDe.png");
        menuItemVersions = new CompMenuItem("Versiones","Versions","ico\\Versiones.png");

        add(menuAyuda);
        menuAyuda.add(menuItemAbout);
        menuAyuda.add(menuItemVersions);

    }
}
