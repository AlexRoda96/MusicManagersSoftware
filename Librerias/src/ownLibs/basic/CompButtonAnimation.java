package ownLibs.basic;

import elevacion.ElevationEffect;
import elevacion.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D.Double;
import java.awt.geom.RoundRectangle2D.Float;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToolTip;
import javax.swing.plaf.basic.BasicButtonUI;

public class CompButtonAnimation extends JButton {
    private RippleEffect ripple = null;
    private rojerusan.RSMaterialButton.EFFECTBUTTON effectButton;
    private Color rippleColor;
    private Cursor cursor;
    private ElevationEffect elevation;
    private ElevationEffectRound elevationRound;
    private boolean isMousePressed;
    private boolean isMouseOver;
    private rojerusan.RSMaterialButton.TYPEBUTTON typeButton;
    private rojerusan.RSMaterialButton.TYPEBORDER typeBorder;
    private rojerusan.RSMaterialButton.THEMETOOLTIP themeTooltip;
    Shape shape;
    private String toolTipTheme;

    public CompButtonAnimation() {
        this.setBackground(new Color(157,183,240));
        this.effectButton = rojerusan.RSMaterialButton.EFFECTBUTTON.RIPPLE;
        this.rippleColor = new Color(157,183,240);
        this.cursor = super.getCursor();
        this.isMousePressed = false;
        this.isMouseOver = false;
        this.typeButton = rojerusan.RSMaterialButton.TYPEBUTTON.DEFAULT;
        this.typeBorder = rojerusan.RSMaterialButton.TYPEBORDER.RECT;
        this.themeTooltip = rojerusan.RSMaterialButton.THEMETOOLTIP.DARK;
        this.toolTipTheme = "dark";
        this.setPreferredSize(new Dimension(110,30));
        this.setSize(new Dimension(200, 50));
        this.setCursor(new Cursor(12));
        this.setContentAreaFilled(false);
        this.ripple = RippleEffect.applyTo(this);
        this.elevation = ElevationEffect.applyTo(this, 0);
        this.elevationRound = ElevationEffectRound.applyTo(this, 0);
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                CompButtonAnimation.this.isMousePressed = true;
            }

            public void mouseReleased(MouseEvent mouseEvent) {
                CompButtonAnimation.this.isMousePressed = false;
                CompButtonAnimation.this.repaint();
            }

            public void mouseEntered(MouseEvent e) {
                CompButtonAnimation.this.isMouseOver = true;
                CompButtonAnimation.this.repaint();
            }

            public void mouseExited(MouseEvent e) {
                CompButtonAnimation.this.isMouseOver = false;
                CompButtonAnimation.this.repaint();
            }
        });
        this.setUI(new BasicButtonUI() {
            public boolean contains(JComponent c, int x, int y) {
                return x > 3 && y > 3 && x < CompButtonAnimation.this.getWidth() - 3 && y < CompButtonAnimation.this.getHeight() - 3;
            }
        });
        this.__init__();
    }

    protected void paintComponent(Graphics g) {
        this.setContentAreaFilled(false);
        this.setOpaque(false);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        boolean offset_lr = true;
        boolean offset_td = true;
        FontMetrics metrics;
        int x;
        int y;
        Color fg;
        if (this.getTypeBorder() == rojerusan.RSMaterialButton.TYPEBORDER.RECT) {
            if (this.isEnabled()) {
                this.elevation.paint(g);
            }

            g2.translate(3, 3);
            if (this.getEffectButton() == rojerusan.RSMaterialButton.EFFECTBUTTON.RIPPLE) {
                if (this.isEnabled()) {
                    if (this.getModel().isSelected()) {
                        g.setColor(Color.decode((String)this.getColours().get("secondary")));
                    } else if (this.getModel().isRollover()) {
                        g.setColor(Color.decode((String)this.getColours().get("secondary")));
                    } else {
                        g.setColor(Color.decode((String)this.getColours().get("primary")));
                    }
                } else {
                    g.setColor(new Color(204, 204, 204));
                }

                this.__init__();
                g2.fill(new Float(0.0F, 0.0F, (float)(this.getWidth() - 6), (float)(this.getHeight() - 6), 0.0F, 0.0F));
                metrics = g.getFontMetrics(this.getFont());
                x = (this.getWidth() - 6 - metrics.stringWidth(this.getText())) / 2;
                y = (this.getHeight() - 6 - metrics.getHeight()) / 2 + metrics.getAscent();
                g2.setFont(this.getFont());
                if (this.isEnabled()) {
                    g2.setColor(this.getForeground());
                } else {
                    fg = new Color(0, 0, 0);
                    g2.setColor(new Color((float)fg.getRed() / 255.0F, (float)fg.getGreen() / 255.0F, (float)fg.getBlue() / 255.0F, 0.6F));
                }

                g2.drawString(this.getText(), x, y);
                if (this.isEnabled()) {
                    g2.setClip(new Float(0.0F, 0.0F, (float)(this.getWidth() - 6), (float)(this.getHeight() - 6), 0.0F, 0.0F));
                    this.ripple.paint(g2);
                }
            }

            if (this.getEffectButton() == rojerusan.RSMaterialButton.EFFECTBUTTON.RAISED) {
                if (this.isEnabled()) {
                    if (this.getModel().isRollover()) {
                        g.setColor(Color.decode((String)this.getColours().get("secondary")));
                    } else {
                        g.setColor(Color.decode((String)this.getColours().get("primary")));
                    }
                } else {
                    g.setColor(new Color(204, 204, 204));
                }

                this.__init__();
                g2.fill(new Float(0.0F, 0.0F, (float)(this.getWidth() - 6), (float)(this.getHeight() - 6), 0.0F, 0.0F));
                metrics = g.getFontMetrics(this.getFont());
                x = (this.getWidth() - 6 - metrics.stringWidth(this.getText())) / 2;
                y = (this.getHeight() - 6 - metrics.getHeight()) / 2 + metrics.getAscent();
                g2.setFont(this.getFont());
                if (this.isEnabled()) {
                    g2.setColor(this.getForeground());
                } else {
                    fg = new Color(0, 0, 0);
                    g2.setColor(new Color((float)fg.getRed() / 255.0F, (float)fg.getGreen() / 255.0F, (float)fg.getBlue() / 255.0F, 0.6F));
                }

                if (this.isEnabled()) {
                    if (this.getModel().isSelected()) {
                        g.setColor(Color.decode((String)this.getColours().get("secondary")));
                        g2.drawString(this.getText().toUpperCase(), x, y + 1);
                    } else if (this.getModel().isPressed()) {
                        g2.drawString(this.getText(), x, y + 1);
                    } else {
                        g2.drawString(this.getText(), x, y);
                    }
                } else {
                    g2.drawString(this.getText(), x, y);
                }

                if (this.isEnabled()) {
                    g2.setClip(new Float(0.0F, 0.0F, (float)(this.getWidth() - 6), (float)(this.getHeight() - 6), 0.0F, 0.0F));
                    this.ripple.paint(g2);
                }
            }
        }

        if (this.getTypeBorder() == rojerusan.RSMaterialButton.TYPEBORDER.ROUND) {
            if (this.isEnabled()) {
                this.elevationRound.paint(g);
            }

            g2.translate(3, 3);
            if (this.getEffectButton() == rojerusan.RSMaterialButton.EFFECTBUTTON.RIPPLE) {
                if (this.isEnabled()) {
                    if (this.getModel().isSelected()) {
                        g.setColor(Color.decode((String)this.getColours().get("secondary")));
                    } else if (this.getModel().isRollover()) {
                        g.setColor(Color.decode((String)this.getColours().get("secondary")));
                    } else {
                        g.setColor(Color.decode((String)this.getColours().get("primary")));
                    }
                } else {
                    g.setColor(new Color(204, 204, 204));
                }

                this.__init__();
                g2.fill(new Double(0.0D, 0.0D, (double)(this.getWidth() - 6), (double)(this.getHeight() - 6), 7.0D, 7.0D));
                metrics = g.getFontMetrics(this.getFont());
                x = (this.getWidth() - 6 - metrics.stringWidth(this.getText())) / 2;
                y = (this.getHeight() - 6 - metrics.getHeight()) / 2 + metrics.getAscent();
                g2.setFont(this.getFont());
                if (this.isEnabled()) {
                    g2.setColor(this.getForeground());
                } else {
                    fg = new Color(0, 0, 0);
                    g2.setColor(new Color((float)fg.getRed() / 255.0F, (float)fg.getGreen() / 255.0F, (float)fg.getBlue() / 255.0F, 0.6F));
                }

                g2.drawString(this.getText(), x, y);
                if (this.isEnabled()) {
                    g2.setClip(new Double(0.0D, 0.0D, (double)(this.getWidth() - 6), (double)(this.getHeight() - 6), 7.0D, 7.0D));
                    this.ripple.paint(g2);
                }
            }

            if (this.getEffectButton() == rojerusan.RSMaterialButton.EFFECTBUTTON.RAISED) {
                if (this.isEnabled()) {
                    if (this.getModel().isRollover()) {
                        g.setColor(Color.decode((String)this.getColours().get("secondary")));
                    } else {
                        g.setColor(Color.decode((String)this.getColours().get("primary")));
                    }
                } else {
                    g.setColor(new Color(204, 204, 204));
                }

                this.__init__();
                g2.fill(new Float(0.0F, 0.0F, (float)(this.getWidth() - 6), (float)(this.getHeight() - 6), 7.0F, 7.0F));
                metrics = g.getFontMetrics(this.getFont());
                x = (this.getWidth() - 6 - metrics.stringWidth(this.getText())) / 2;
                y = (this.getHeight() - 6 - metrics.getHeight()) / 2 + metrics.getAscent();
                g2.setFont(this.getFont());
                if (this.isEnabled()) {
                    g2.setColor(this.getForeground());
                } else {
                    fg = new Color(0, 0, 0);
                    g2.setColor(new Color((float)fg.getRed() / 255.0F, (float)fg.getGreen() / 255.0F, (float)fg.getBlue() / 255.0F, 0.6F));
                }

                if (this.isEnabled()) {
                    if (this.getModel().isSelected()) {
                        g.setColor(Color.decode((String)this.getColours().get("secondary")));
                        g2.drawString(this.getText(), x, y + 1);
                    } else if (this.getModel().isPressed()) {
                        g2.drawString(this.getText(), x, y + 1);
                    } else {
                        g2.drawString(this.getText(), x, y);
                    }
                } else {
                    g2.drawString(this.getText(), x, y);
                }

                if (this.isEnabled()) {
                    g2.setClip(new Float(0.0F, 0.0F, (float)(this.getWidth() - 6), (float)(this.getHeight() - 6), 7.0F, 7.0F));
                    this.ripple.paint(g2);
                }
            }
        }

    }

    protected void paintBorder(Graphics g) {
    }

    public boolean contains(int x, int y) {
        if (this.shape == null || !this.shape.getBounds().equals(this.getBounds())) {
            this.shape = new java.awt.geom.Ellipse2D.Float(0.0F, 0.0F, (float)this.getWidth(), (float)this.getHeight());
        }

        return this.shape.contains((double)x, (double)y);
    }

    public rojerusan.RSMaterialButton.EFFECTBUTTON getEffectButton() {
        return this.effectButton;
    }

    public void setEffectButton(rojerusan.RSMaterialButton.EFFECTBUTTON effectButton) {
        if (effectButton != null) {
            this.effectButton = effectButton;
        }

        this.repaint();
    }

    public Color getRippleColor() {
        return this.rippleColor;
    }

    public void setRippleColor(Color rippleColor) {
        this.rippleColor = rippleColor;
    }

    public void setEnabled(boolean b) {
        super.setEnabled(b);
        if (this.getTypeBorder() == rojerusan.RSMaterialButton.TYPEBORDER.RECT) {
            this.elevation.setLevel(this.getElevation());
        } else {
            this.elevationRound.setLevel(this.getElevationRound());
        }

        super.setCursor(b ? this.cursor : Cursor.getPredefinedCursor(0));
    }

    public void setCursor(Cursor cursor) {
        super.setCursor(cursor);
        this.cursor = cursor;
    }

    protected void processFocusEvent(FocusEvent focusEvent) {
        super.processFocusEvent(focusEvent);
        if (this.getTypeBorder() == rojerusan.RSMaterialButton.TYPEBORDER.RECT) {
            this.elevation.setLevel(this.getElevation());
        } else {
            this.elevationRound.setLevel(this.getElevationRound());
        }

    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        super.processMouseEvent(mouseEvent);
        if (this.getTypeBorder() == rojerusan.RSMaterialButton.TYPEBORDER.RECT) {
            this.elevation.setLevel(this.getElevation());
        } else {
            this.elevationRound.setLevel(this.getElevationRound());
        }

    }

    private int getElevation() {
        if (this.isMousePressed) {
            return 2;
        } else {
            return !this.isFocusOwner() && !this.isMouseOver ? 0 : 1;
        }
    }

    private int getElevationRound() {
        if (this.isMousePressed) {
            return 2;
        } else {
            return !this.isFocusOwner() && !this.isMouseOver ? 0 : 1;
        }
    }

    private HashMap<String, String> getColours() {
        HashMap<String, String> color_kv = new HashMap();
        switch(this.getTypeButton()) {
            case DEFAULT:
                color_kv.put("primary", "#939CAD");
                color_kv.put("secondary", "#939CAD");
                break;
            case PRIMARY:
                color_kv.put("primary", "#939CAD");
                color_kv.put("secondary", "#939CAD");
                break;
            case SECONDARY:
                color_kv.put("primary", "#939CAD");
                color_kv.put("secondary", "#939CAD");
        }

        return color_kv;
    }

    private void default_type() {
        this.setBackground(new Color(147,156,173));
        this.setForeground(Color.BLACK);
    }

    private void primary_type() {
        this.setBackground(new Color(147,156,173));
        this.setForeground(Color.BLACK);
    }

    private void secondary_type() {
        this.setBackground(new Color(147,156,173));
        this.setForeground(new Color(147,156,173));
    }

    public JToolTip createToolTip() {
        if (this.getThemeTooltip() == rojerusan.RSMaterialButton.THEMETOOLTIP.DARK) {
            this.toolTipTheme = "dark";
        }

        if (this.getThemeTooltip() == rojerusan.RSMaterialButton.THEMETOOLTIP.LIGHT) {
            this.toolTipTheme = "light";
        }

        return new Tooltip(this, this.toolTipTheme);
    }

    private void __init__() {
        switch(this.getTypeButton()) {
            case DEFAULT:
                this.default_type();
                break;
            case PRIMARY:
                this.primary_type();
                break;
            case SECONDARY:
                this.secondary_type();
        }

    }

    public rojerusan.RSMaterialButton.TYPEBUTTON getTypeButton() {
        return this.typeButton;
    }

    public void setTypeButton(rojerusan.RSMaterialButton.TYPEBUTTON typeButton) {
        if (typeButton != null) {
            this.typeButton = typeButton;
        }

    }

    public rojerusan.RSMaterialButton.TYPEBORDER getTypeBorder() {
        return this.typeBorder;
    }

    public void setTypeBorder(rojerusan.RSMaterialButton.TYPEBORDER typeBorder) {
        if (typeBorder != null) {
            this.typeBorder = typeBorder;
        }

    }

    public rojerusan.RSMaterialButton.THEMETOOLTIP getThemeTooltip() {
        return this.themeTooltip;
    }

    public void setThemeTooltip(rojerusan.RSMaterialButton.THEMETOOLTIP themeTooltip) {
        this.themeTooltip = themeTooltip;
    }

    public static enum THEMETOOLTIP {
        DARK,
        LIGHT;

        private THEMETOOLTIP() {
        }
    }

    public static enum TYPEBORDER {
        RECT,
        ROUND;

        private TYPEBORDER() {
        }
    }

    public static enum TYPEBUTTON {
        DEFAULT,
        PRIMARY,
        SECONDARY;

        private TYPEBUTTON() {
        }
    }

    public static enum EFFECTBUTTON {
        RIPPLE,
        RAISED;

        private EFFECTBUTTON() {
        }
    }
}

