package FaceFront;

import FaceBack.*;
import Panels.FPPanel;
import Panels.ImagePanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

/**
 * This is the white canvas on the face pamphlet. It supports dragging and will
 * change the Z-level when an item is pressed. It extends ImagePanel so it may
 * have a background.
 *
 * @author John Maguire
 */
public class PamphletCanvas extends JPanel implements MouseInputListener {

    private Component dragTarget = null;

    public PamphletCanvas(String imagePath) {
        this.setOpaque(true);
        this.setForeground(Color.WHITE);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
    }

    public PamphletCanvas() {
        this("");
    }

    public void paintComponent(Graphics g) {
        // g.drawRect(0, 0, this.getHeight(), this.getWidth());
        if (this.getBorder() != null) {
            // this.setBorder(null);
        }

        super.paintComponent(g);

    }
    private int dx = 0;
    private int dy = 0;
    private int mode = 0; //DRAG=0, INCREASE SIZE=1

    public void mousePressed(MouseEvent evt) {

        dragTarget = this.getComponentAt(evt.getX(), evt.getY());
        dragTarget = (dragTarget == this) ? null : dragTarget;
        
        // See Api for getComponentAt(x,y). It returns itself on some conditions.

        if (dragTarget != null) {
            dx = dragTarget.getX() - evt.getX();
            dy = dragTarget.getY() - evt.getY();
            mode = 0;//assume
            if ((dragTarget.getWidth() + dx) < 7 && (dragTarget.getHeight() + dy) < 7) {
                dx = dragTarget.getX();
                dy = dragTarget.getY();
                mode = 1;
            } else {
                this.mouseClicked2(evt);

            }
                     this.setComponentZOrder(dragTarget,0);

            //System.out.printf("%d, %d\n", dragTarget.getWidth()+dx,dragTarget.getHeight()-dy);

        } else {
            clickTarget = null;
        }
        // System.out.println(dragTarget);
    }

    public void mouseDragged(MouseEvent evt) {
        if (dragTarget != null) {
            if (mode == 0) {
                dragTarget.setBounds(evt.getX() + dx, evt.getY() + dy, dragTarget.getWidth(), dragTarget.getHeight());
            } else {
                int newX = Math.min(evt.getX(), dx);
                int newY = Math.min(evt.getY(), dy);
                int newWidth = Math.abs(evt.getX() - dx);
                int newHeight = Math.abs(evt.getY() - dy);

                dragTarget.setBounds(newX, newY, newWidth, newHeight);
            }//this.repaint();
        }
        clickTarget = null;
        super.repaint();
    }

    public void mouseMoved(MouseEvent e) {
    }

    /**
     * This method displays a message string near the bottom of the canvas.
     * Every time this method is called, the previously displayed message (if
     * any) is replaced by the new message text passed in.
     */
    public void showMessage(String msg) {
        // You fill this in
    }

    /**
     * This method displays the given profile on the canvas. The canvas is first
     * cleared of all existing items (including messages displayed near the
     * bottom of the screen) and then the given profile is displayed. The
     * profile display includes the name of the user from the profile, the
     * corresponding image (or an indication that an image does not exist), the
     * status of the user, and a list of the user's friends in the social
     * network.
     */
    public void displayProfile(FacePamphletProfile profile) {
        // You fill this in
    }
    private Component clickTarget = null;

    /**
     * Couldn't get click to work but pressed works.
     */
    private void mouseClicked2(MouseEvent evt) {
        Component thisClick = this.getComponentAt(evt.getX(), evt.getY());

        thisClick = (thisClick == this) ? null : thisClick;
        if (clickTarget == thisClick && thisClick != null) {
            JOptionPane.showMessageDialog(null, "You may want to enable this to have double-click support.", "Potential", JOptionPane.INFORMATION_MESSAGE);
            clickTarget = null;
        } else {
            clickTarget = thisClick;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        throw new UnsupportedOperationException("how this happen?");
    }
}
