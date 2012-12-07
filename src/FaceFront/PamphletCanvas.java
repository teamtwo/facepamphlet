package FaceFront;

import FaceBack.*;
import panels.FPPanel;
import panels.ImagePanel;
import panels.TextPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

/**
 * This is the white canvas on the face pamphlet. It supports dragging and will
 * change the Z-level when an item is pressed. It extends ImagePanel so it may
 * have a background. <i>But I honestly didn't want FP to look like MySpace, and
 * the team agreed, so I dropped that feature. -Stuart</i>
 *
 * @author John Maguire
 * @author Stuart Townsend
 */
public class PamphletCanvas extends JPanel implements MouseInputListener {

    private Component dragTarget = null;
    private Component clickTarget = null;

    public FacePamphletProfile userProfile;
    public FacePamphletProfile displayedProfile;
    public FacePamphletDatabase FP_DB;
    private JLabel messageLabel;
    private JLabel messageDisplayLabel;
    private Dimension msgLabel = new Dimension (60, 30);
    private Dimension msgText = new Dimension (640, 30);
    
    private int dx = 0;
    private int dy = 0;
    private int mode = 0; //DRAG=0, INCREASE SIZE=1
    
    public PamphletCanvas() {
    	//this.removeAll();
    	//this.repaint();
        this.setOpaque(true);
        this.setForeground(Color.WHITE);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        messageLabel = new JLabel();
        messageDisplayLabel = new JLabel();
        
    }

    public void paintComponent(Graphics g) {
        if (this.getBorder() != null) {
            // this.setBorder(null);
        }

        super.paintComponent(g);
    }




    /**
     * This method displays a message string near the bottom of the canvas.
     * Every time this method is called, the previously displayed message (if
     * any) is replaced by the new message text passed in.
     */
    public void showMessage(String msg) {    	
    	messageDisplayLabel.setText(msg);
    	messageDisplayLabel.repaint();

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
        this.removeAll();
        this.repaint();
        
        //init message-bar
        messageLabel.setText("Message:");
        messageLabel.setBounds(10, 580, msgLabel.width, msgLabel.height);
        this.add(messageLabel);

        messageDisplayLabel.setText("msg goes here");
        messageDisplayLabel.setBounds(70, 580, msgText.width, msgText.height);
        this.add(messageDisplayLabel);
        
        //init basic profile data
        TextPanel userInfo = new TextPanel(profile.getName());
        userInfo.setText("B-Day: "+profile.getBirthdayMonth()+"/"+profile.getBirthdayDate());
        userInfo.setBounds(20, 20, 300, 150);

        TextPanel userBio = new TextPanel("About Me:");
        userBio.setText(profile.getBio());
        userBio.setBounds(330, 20, 300, 150);
        
        this.add(userInfo);
        this.add(userBio);
        
        this.repaint();
    }
    
    
    
    //T0D0: get some handling code that actually checks to see if shit's
    //been repainted properly. HW-style Asserts?
    public boolean addPicture(String title, BufferedImage toAdd) {
        ImagePanel y = new ImagePanel(title, toAdd);
        y.setBounds(this.getWidth() / 2 -100, this.getHeight() /2 -100, 200, 200);
        y.repaint();
        y.setVisible(true);
        this.add(y);
        this.repaint();
        
        return true;
    }
    
    

    //------------------------------------------------------------
    //|                                                          |
    //|                    Action Listeners                      |
    //|                                                          |
    //------------------------------------------------------------
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
            } 
            else {
                this.mouseClicked2(evt);
            }
            this.setComponentZOrder(dragTarget,0);
        }
        else {
            clickTarget = null;
        }
    }

    public void mouseDragged(MouseEvent evt) {
        if (dragTarget != null) {
            if (mode == 0) {
                dragTarget.setBounds(evt.getX() + dx, evt.getY() + dy, dragTarget.getWidth(), dragTarget.getHeight());
            } 
            else {
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