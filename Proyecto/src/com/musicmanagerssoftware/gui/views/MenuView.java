package com.musicmanagerssoftware.gui.views;


import ownLibs.menu.CompMenu;
import ownLibs.menu.CompMenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuView extends JMenuBar {

    public CompMenuItem menuItemAdd;
    public CompMenuItem menuItemDelete;
    public CompMenuItem menuItemModify;
    public CompMenuItem menuItemSearch;

    /**
     * Consutructor de BarraMenu
     */
    public MenuView(){
        setBackground(new Color(245, 245, 245));
        MenuArchivo();
        MenuEditar();
        MenuAccion();
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

        CompMenu menuArchivo = new CompMenu("Archivo");

        CompMenuItem menuItemGuardar = new CompMenuItem("Guardar","Menu Guardar", KeyEvent.VK_S,
                "ico\\Guardar.png");
        CompMenuItem menuItemExportar = new CompMenuItem("Exportar","Menu Exportar", KeyEvent.VK_E,
                "ico\\Exportar.png");
        CompMenuItem menuItemSalir = new CompMenuItem("Salir","Menu Salir",KeyEvent.VK_F4,
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
    private void MenuEditar(){

        CompMenu menuEditar = new CompMenu("Editar");

        CompMenuItem menuItemCortar = new CompMenuItem("Cortar","Menu Cortar",KeyEvent.VK_X,
                "ico\\Cortar.png");
        CompMenuItem menuItemCopiar = new CompMenuItem("Copiar","Menu Copiar",KeyEvent.VK_C,
                "ico\\Copiar.png");
        CompMenuItem menuItemPegar = new CompMenuItem("Pegar","Menu Pegar", KeyEvent.VK_V,
                "ico\\Pegar.png");
        CompMenuItem menuItemPortapapeles = new CompMenuItem("Portapapeles", "Menu Portapapeles",
                KeyEvent.VK_P,"ico\\Salir.png");

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
    private void MenuAccion(){

        CompMenu menuObjeto = new CompMenu("Acción");

        menuItemAdd = new CompMenuItem("Añadir","Menu Add",KeyEvent.VK_INSERT,
                "ico\\Añadir.png");
        menuItemDelete= new CompMenuItem("Eliminar","Menu Delete",
                KeyEvent.VK_DELETE, "ico\\Eliminar.png");
        menuItemModify= new CompMenuItem("Modificar","Menu Modify",
                KeyEvent.VK_DELETE, "ico\\Eliminar.png");
        menuItemSearch = new CompMenuItem("Buscar","Menu Search",KeyEvent.VK_F,
                "ico\\Buscar.png");

        add(menuObjeto);
        menuObjeto.add(menuItemAdd);
        menuObjeto.add(menuItemDelete);
        menuObjeto.add(menuItemModify);
        menuObjeto.add(menuItemSearch);
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

        CompMenu menuHerramientas = new CompMenu("Herramientas");

        CompMenuItem menuItemEstadisticas = new CompMenuItem("Estadística","Menu Estadisticas",
                KeyEvent.VK_INSERT,"ico\\Estadistica.png");
        CompMenuItem menuItemPlanificar = new CompMenuItem("Planificar","Menu Planificar",
                KeyEvent.VK_DELETE,"ico\\Planificar.png");
        CompMenuItem menuItemCalendario = new CompMenuItem("Calenadrio","Menu Calendario",
                KeyEvent.VK_F,"ico\\Calendario.png");

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

        CompMenu menuAjustes = new CompMenu("Ajustes");

        CompMenuItem menuItemCuenta = new CompMenuItem("Cuenta","Menu Cuenta",KeyEvent.VK_INSERT,
                "ico\\Usuarios.png");
        CompMenuItem menuItemPreferencias = new CompMenuItem("Preferencias","Menu Preferencias",
                KeyEvent.VK_DELETE,"ico\\Preferencias.png");
        CompMenuItem menuItemIdioma = new CompMenuItem("Idioma","Menu Idioma",KeyEvent.VK_F,
                "ico\\Idioma.png");

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

        CompMenu menuAyuda = new CompMenu("Ayuda");

        CompMenuItem menuItemAcercaDe = new CompMenuItem("Acerca de","Menu Acerca de",
                KeyEvent.VK_INSERT,"ico\\AcercaDe.png");
        CompMenuItem menuItemIndiceAyuda = new CompMenuItem("Indice de Ayuda","Menu Indice ayuda",
                KeyEvent.VK_DELETE,"ico\\IndiceAyuda.png");
        CompMenuItem menuItemVersiones = new CompMenuItem("Versiones","Menu Versiones",
                KeyEvent.VK_F,"ico\\Versiones.png");

        add(menuAyuda);
        menuAyuda.add(menuItemAcercaDe);
        menuAyuda.add(menuItemIndiceAyuda);
        menuAyuda.add(menuItemVersiones);

    }
}
