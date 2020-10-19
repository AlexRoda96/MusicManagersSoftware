package ownLibs.basic;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;


public class CompButton extends JButton{

    private Color pressedColor = new Color(180,180,180);
    private Color rolloverColor = Color.GRAY;
    private Color normalColor = Color.LIGHT_GRAY;
    private static boolean defaultColor = true;

    public CompButton(){

        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(true);
        setPreferredSize(new Dimension(110,30));
        setBackground(normalColor);
        setForeground(Color.BLACK);

        setBorder(new LineBorder(Color.BLACK,1));
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(new LineBorder(rolloverColor,2));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(new LineBorder(Color.BLACK,1));
            }
        });
        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent evt) {
                if (getModel().isPressed()) {
                    setBackground(pressedColor);

                } else if(getModel().isPressed()==false){
                    setBackground(normalColor);
                }
            }
        });
    }
}
