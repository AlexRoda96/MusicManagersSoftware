package com.musicmanagerssoftware.componentes;

import com.musicmanagerssoftware.gui.Model;

import javax.swing.*;
import java.awt.*;

public class Hilo extends Thread {

    Model model;
    JLabel label;
    int panel;
    boolean suspender;

    public Hilo(JLabel label,int panel) {
    model = new Model();
    this.label=label;
    this.panel=panel;
    }

    public void run() {

        while(isAlive()) {
            if (panel == 0) {
                for (int i = 0; i < model.getArtista().size(); i++) {
                    try {
                        sleep(800);
                    } catch (InterruptedException e) {

                    }

                    label.setIcon(setImageArtista(i));

                    synchronized (this) {
                        while (suspender) {
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }else if(panel==1) {
                for (int i = 0; i < model.getGrupo().size(); i++) {
                    try {
                        sleep(800);
                    } catch (InterruptedException e) {


                    }
                        label.setIcon(setImageGrupo(i));

                        synchronized (this) {
                            while (suspender) {
                                try {
                                    wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                }
                }else if (panel == 2) {
                    for (int i = 0; i < model.getDisco().size(); i++) {
                        try {
                            sleep(800);
                        } catch (InterruptedException e) {

                        }

                        label.setIcon(setImageDisco(i));

                        synchronized (this) {
                            while (suspender) {
                                try {
                                    wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }else if (panel == 3) {
                    for (int i = 0; i < model.getConcierto().size(); i++) {
                        try {
                            sleep(800);
                        } catch (InterruptedException e) {

                        }

                        label.setIcon(setImageConcierto(i));

                        synchronized (this) {
                            while (suspender) {
                                try {
                                    wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }else if (panel == 4) {
                for (int i = 0; i < model.getGira().size(); i++) {
                    try {
                        sleep(800);
                    } catch (InterruptedException e) {

                    }

                    label.setIcon(setImageGira(i));

                    synchronized (this) {
                        while (suspender) {
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }else if (panel == 5) {
                for (int i = 0; i < model.getSala().size(); i++) {
                    try {
                        sleep(800);
                    } catch (InterruptedException e) {

                    }

                    label.setIcon(setImageSala(i));

                    synchronized (this) {
                        while (suspender) {
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }else if (panel == 6) {
                for (int i = 0; i < model.getCancion().size(); i++) {
                    try {
                        sleep(800);
                    } catch (InterruptedException e) {

                    }

                    label.setIcon(setImageCancion(i));

                    synchronized (this) {
                        while (suspender) {
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            }
        }

    private Icon setImageArtista(int i){
        Icon icono = null;

        ImageIcon icon = new ImageIcon(model.getArtista().get(i).getFoto());
        icono = new ImageIcon(icon.getImage().getScaledInstance(100, 100,
                        Image.SCALE_DEFAULT));

        return icono;
    }

    private Icon setImageGrupo(int i){
        Icon icono = null;

        ImageIcon icon = new ImageIcon(model.getGrupo().get(i).getFoto());

        icono = new ImageIcon(icon.getImage().getScaledInstance(100, 100,
                    Image.SCALE_DEFAULT));

        return icono;
    }

    private Icon setImageDisco(int i){
        Icon icono = null;

        ImageIcon icon = new ImageIcon(model.getDisco().get(i).getCaractula());

        icono = new ImageIcon(icon.getImage().getScaledInstance(100, 100,
                    Image.SCALE_DEFAULT));

        return icono;
    }

    private Icon setImageConcierto(int i){
        Icon icono = null;

        ImageIcon icon = new ImageIcon(model.getConcierto().get(i).getCartel());

        icono = new ImageIcon(icon.getImage().getScaledInstance(100, 100,
                    Image.SCALE_DEFAULT));

        return icono;
    }

    private Icon setImageGira(int i){
        Icon icono = null;
            ImageIcon icon = new ImageIcon(model.getGira().get(i).getCartel());

            icono = new ImageIcon(icon.getImage().getScaledInstance(100, 100,
                    Image.SCALE_DEFAULT));
        return icono;
    }

    private Icon setImageSala(int i){
        Icon icono = null;
        ImageIcon icon = new ImageIcon(model.getSala().get(i).getFoto());

        icono = new ImageIcon(icon.getImage().getScaledInstance(100, 100,
                Image.SCALE_DEFAULT));
        return icono;
    }

    private Icon setImageCancion(int i){
        Icon icono = null;
        ImageIcon icon = new ImageIcon(model.getCancion().get(i).getImagen());

        icono = new ImageIcon(icon.getImage().getScaledInstance(100, 100,
                Image.SCALE_DEFAULT));
        return icono;
    }

    public synchronized void pausarHilo(){

        suspender=true;
    }

    public synchronized void renaudarhilo(){
        suspender=false;
        notify();
    }

}
