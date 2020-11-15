package com.musicmanagerssoftware.gui.views;


import ownLibs.menu.CompMenu;
import ownLibs.menu.CompMenuItem;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JMenuBar {

    public CompMenu menuObjeto;
    public CompMenu menuAdd;
    public CompMenu menuDelete;
    public CompMenu menuModify;
    public CompMenu menuSearch;

    //ADD
    public CompMenuItem addItemArtista;
    public CompMenuItem addItemGrupo;
    public CompMenuItem addItemDisco;
    public CompMenuItem addItemCancion;
    public CompMenuItem addItemGira;
    public CompMenuItem addItemConcierto;
    public CompMenuItem addItemSala;
    public CompMenuItem addItemReunion;

    //DELETE
    public CompMenuItem deleteItemArtista;
    public CompMenuItem deleteItemGrupo;
    public CompMenuItem deleteItemDisco;
    public CompMenuItem deleteItemCancion;
    public CompMenuItem deleteItemGira;
    public CompMenuItem deleteItemConcierto;
    public CompMenuItem deleteItemSala;
    public CompMenuItem deleteItemReunion;

    //MODIFY
    public CompMenuItem modifyItemArtista;
    public CompMenuItem modifyItemGrupo;
    public CompMenuItem modifyItemDisco;
    public CompMenuItem modifyItemCancion;
    public CompMenuItem modifyItemGira;
    public CompMenuItem modifyItemConcierto;
    public CompMenuItem modifyItemSala;
    public CompMenuItem modifyItemReunion;

    /**
     * Consutructor de BarraMenu
     */
    public MenuView(){
        setBackground(new Color(245, 245, 245));
        MenuArchivo();
        initMenuEditar();
        initMenuAccion();
        //MenuMostrar();
        MenuHerramientas();
        MenuAjustes();
        MenuAyuda();
    }

    /**
     * Método que contiene el Menu Archivo, el cual contiene 3 Menu Items (Guardar, exportar y
     * salir)
     */
    private void MenuArchivo(){

        CompMenu menuArchivo = new CompMenu("Archivo",null,null);

        CompMenu menuItemGuardar = new CompMenu("Guardar","Menu Guardar",
                "ico\\Guardar.png");
        CompMenu menuItemExportar = new CompMenu("Exportar","Menu Exportar",
                "ico\\Exportar.png");
        CompMenu menuItemSalir = new CompMenu("Salir","Menu Salir",
                "ico\\Salir.png");

        JSeparator separador = new JSeparator();
        JSeparator separador1 = new JSeparator();

        add(menuArchivo);
        menuArchivo.add(menuItemGuardar);
        menuArchivo.add(separador);
        menuArchivo.add(menuItemExportar);
        menuArchivo.add(separador1);
        menuArchivo.add(menuItemSalir);
    }

    /**
     * Menu que contiene el Menu Editar, el cual contienen 4 Menu Items (Cortar, copiar, pegar y
     * portapapeles)
     */
    private void initMenuEditar(){

        CompMenu menuEditar = new CompMenu("Editar",null,null);

        CompMenu menuItemCortar = new CompMenu("Cortar","Menu Cortar",
                "ico\\Cortar.png");
        CompMenu menuItemCopiar = new CompMenu("Copiar","Menu Copiar",
                "ico\\Copiar.png");
        CompMenu menuItemPegar = new CompMenu("Pegar","Menu Pegar",
                "ico\\Pegar.png");
        CompMenu menuItemPortapapeles = new CompMenu("Portapapeles", "Menu Portapapeles",
               "ico\\Salir.png");

        add(menuEditar);
        menuEditar.add(menuItemCortar);
        menuEditar.add(menuItemCopiar);
        menuEditar.add(menuItemPegar);
        menuEditar.add(menuItemPortapapeles);
    }

    /**
     * Método que contiene el Menu Acción, el cual contiene 3 Menu Items (Añadir, eliminar y
     * buscar):
     */
    private void initMenuAccion(){

        menuObjeto = new CompMenu("Acción",null,null);

        menuAdd = new CompMenu("Añadir",null,
                "ico\\Añadir.png");
        menuDelete = new CompMenu("Eliminar",null,
                "ico\\Eliminar.png");
        menuModify = new CompMenu("Modificar",null,
                "ico\\Eliminar.png");
        menuSearch = new CompMenu("Buscar",null,
                "ico\\Buscar.png");

        add(menuObjeto);
        initSubMenuAdd();
        initSubMenuDelete();
        initSubMenuModify();
        menuObjeto.add(menuSearch);


    }

    private void initSubMenuAdd(){
        menuObjeto.add(menuAdd);

        addItemArtista = new CompMenuItem("Artista","Add Artista");
        addItemGrupo = new CompMenuItem("Grupo", "Add Grupo");
        addItemDisco = new CompMenuItem("Disco", "Add Disco");
        addItemCancion = new CompMenuItem("Canción", "Add Cancion");
        addItemConcierto = new CompMenuItem("Concierto", "Add Concierto");
        addItemGira = new CompMenuItem("Gira", "Add Gira");
        addItemSala = new CompMenuItem("Sala", "Add Sala");
        addItemReunion = new CompMenuItem("Reunion", "Add Reunion");

        menuAdd.add(addItemArtista);
        menuAdd.add(addItemGrupo);
        menuAdd.add(addItemCancion);
        menuAdd.add(addItemDisco);
        menuAdd.add(addItemGira);
        menuAdd.add(addItemConcierto);
        menuAdd.add(addItemSala);
        menuAdd.add(addItemReunion);
    }

    private void initSubMenuDelete(){
        menuObjeto.add(menuDelete);

        deleteItemArtista = new CompMenuItem("Artista","Delete Artista");
        deleteItemGrupo = new CompMenuItem("Grupo", "Delete Grupo");
        deleteItemDisco = new CompMenuItem("Disco", "Delete Disco");
        deleteItemCancion = new CompMenuItem("Canción", "Delete Cancion");
        deleteItemConcierto = new CompMenuItem("Concierto", "Delete Concierto");
        deleteItemGira = new CompMenuItem("Gira", "Delete Gira");
        deleteItemSala = new CompMenuItem("Sala", "Delete Sala");
        deleteItemReunion = new CompMenuItem("Reunion", "Delete Reunion");

        menuDelete.add(deleteItemArtista);
        menuDelete.add(deleteItemGrupo);
        menuDelete.add(deleteItemCancion);
        menuDelete.add(deleteItemDisco);
        menuDelete.add(deleteItemGira);
        menuDelete.add(deleteItemConcierto);
        menuDelete.add(deleteItemSala);
        menuDelete.add(deleteItemReunion);
    }

    private void initSubMenuModify(){
        menuObjeto.add(menuModify);

        modifyItemArtista = new CompMenuItem("Artista","Modify Artista");
        modifyItemGrupo = new CompMenuItem("Grupo", "Modify Grupo");
        modifyItemDisco = new CompMenuItem("Disco", "Modify Disco");
        modifyItemCancion = new CompMenuItem("Canción", "Modify Cancion");
        modifyItemConcierto = new CompMenuItem("Concierto", "Modify Concierto");
        modifyItemGira = new CompMenuItem("Gira", "Modify Gira");
        modifyItemSala = new CompMenuItem("Sala", "Modify Sala");
        modifyItemReunion = new CompMenuItem("Reunion", "Modify Reunion");

        menuModify.add(modifyItemArtista);
        menuModify.add(modifyItemGrupo);
        menuModify.add(modifyItemCancion);
        menuModify.add(modifyItemDisco);
        menuModify.add(modifyItemGira);
        menuModify.add(modifyItemConcierto);
        menuModify.add(modifyItemSala);
        menuModify.add(modifyItemReunion);
    }

    /*
    private void MenuMostrar(){

        CompMenu menuMostrar = new CompMenu("Mostrar");

        CompMenuItem menuItemAnnadir = new CompMenuItem("Añadir","Menu Añadir",KeyEvent.VK_INSERT,
                "iconos\\Guardar.png");
        CompMenuItem menuItemEliminar= new CompMenuItem("Eliminar","Menu Eliminar",
                KeyEvent.VK_DELETE,"iconos\\Guardar.png");
        CompMenuItem menuItemBuscar = new CompMenuItem("Buscar","Menu Buscar",
                KeyEvent.VK_F,"iconos\\Guardar.png");
    }
     */

    /**
     * Método que contiene el Menu Herramientas, el cual contienen 3 Menu Items (Estadisticas,
     * planificar y calenadrio).
     */
    private void MenuHerramientas(){

        CompMenu menuHerramientas = new CompMenu("Herramientas",null,null);

        CompMenuItem menuItemEstadisticas = new CompMenuItem("Estadística","Estadisitica");
        CompMenuItem menuItemPlanificar = new CompMenuItem("Planificar","Planifi");
        CompMenuItem menuItemCalendario = new CompMenuItem("Calenadrio","Calendario");

        add(menuHerramientas);
        menuHerramientas.add(menuItemEstadisticas);
        menuHerramientas.add(menuItemPlanificar);
        menuHerramientas.add(menuItemCalendario);
    }

    /**
     * Método que contiene el Menu Ajustes, el cual contiene 3 Menu Items (Cuenta, preferencias y
     * idioma).
     */
    private void MenuAjustes(){

        CompMenu menuAjustes = new CompMenu("Ajustes",null,null);

        CompMenuItem menuItemCuenta = new CompMenuItem("Cuenta",null);
        CompMenuItem menuItemPreferencias = new CompMenuItem("Preferencias",null);
        CompMenuItem menuItemIdioma = new CompMenuItem("Idioma",null);

        add(menuAjustes);
        menuAjustes.add(menuItemCuenta);
        menuAjustes.add(menuItemPreferencias);
        menuAjustes.add(menuItemIdioma);
    }

    /**
     * Método que contiene el Menu Ayuda el cual contiene 3 Menu Items (Acerca de, indice de ayuda y
     * versiones).
     */
    private void MenuAyuda(){

        CompMenu menuAyuda = new CompMenu("Ayuda",null,null);

        CompMenuItem menuItemAcercaDe = new CompMenuItem("Acerca de",null);
        CompMenuItem menuItemIndiceAyuda = new CompMenuItem("Indice de Ayuda",null);
        CompMenuItem menuItemVersiones = new CompMenuItem("Versiones",null);

        add(menuAyuda);
        menuAyuda.add(menuItemAcercaDe);
        menuAyuda.add(menuItemIndiceAyuda);
        menuAyuda.add(menuItemVersiones);

    }
}
