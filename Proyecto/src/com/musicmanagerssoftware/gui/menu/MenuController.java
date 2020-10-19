package com.musicmanagerssoftware.gui.menu;

import com.musicmanagerssoftware.componentes.selectionDialog.SelectTypeDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class MenuController implements ActionListener {

    private MenuView menuView;

    /**
     * MenuController constructor.
     */
    public MenuController(MenuView menuView){
      this.menuView=menuView;
      addActionListener(this);
    }

    private void addActionListener(ActionListener listener){
        menuView.menuItemAdd.addActionListener(listener);
        menuView.menuItemDelete.addActionListener(listener);
        menuView.menuItemModify.addActionListener(listener);
        menuView.menuItemSearch.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {

            case "Menu Add":
                SelectTypeDialog viewSelectTypeAdd = new SelectTypeDialog("¿Que desea añadir?");
                break;
            case "Menu Delete":
                SelectTypeDialog viewSelectTypeDelete = new SelectTypeDialog("¿Que desea eliminar?");
                break;
            case "Menu Modify":
                SelectTypeDialog viewSelectTypeModify = new SelectTypeDialog("¿Que desea modificar?");
                break;
            case "Menu Search":

                break;
        }
    }
}
