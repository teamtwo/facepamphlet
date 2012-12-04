package FaceFront;

import panels.ImagePanel;
import FaceBack.*;

import java.util.Arrays;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

/**
 * The application itself. 
 * 
 * @author John Maguire
 * @author Stuart Townsend
 */
public class FacePamphlet extends javax.swing.JFrame {

    public FacePamphletProfile userProfile;
    public FacePamphletProfile displayedProfile;
    public FacePamphletDatabase FP_DB;
    public boolean inTestMode = true; 
                    // ^ is a toggle for creation and population of 'test' social 
                    // network, as laid out in test-network.txt
    
    public enum ViewType {
        FRIEND, SELF
    };

    /**
     * Creates new form FacePamphlet
     */
    public FacePamphlet() {
        this.initComponents();
        if (inTestMode)
            //FP_DB = new FPTestNetwork();
        this.setToolBar(ViewType.FRIEND);
    }

    public void setToolBar(ViewType setTo) {
        leftPane.removeAll();
        switch (setTo) {
            case FRIEND:
                changeProfilePicButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                addPostToProfile.setAlignmentX(Component.CENTER_ALIGNMENT);

                leftPane.add(this.changeProfilePicButton);
                leftPane.add(this.addPostToProfile);

                break;
            case SELF:
                changeProfilePicButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                addPostToProfile.setAlignmentX(Component.CENTER_ALIGNMENT);

                leftPane.add(this.changeProfilePicButton);
                leftPane.add(this.addPostToProfile);

                break;
        }
        //initComponents();
    }
    
    
    //T0D0: get some handling code that actually checks to see if shit's
    //been repainted properly. HW-style Asserts?
    public boolean addPicture(String title, BufferedImage toAdd) {
        ImagePanel y = new ImagePanel(title, toAdd);
        y.setBounds(this.getWidth() / 2 -100, this.getHeight() /2 -100, 200, 200);
        y.repaint();
        y.setVisible(true);
        Canvas.add(y);
        Canvas.repaint();
        
        return true;
    }
    
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        changeProfilePicButton = new javax.swing.JButton();
        addPostToProfile = new javax.swing.JButton();
        Canvas = new PamphletCanvas();
        Testing = new javax.swing.JPanel();
        leftPane = new javax.swing.JPanel();
        MenuBar = new javax.swing.JPanel(){

            public void paintComponent(Graphics g){
                super.paintComponent(g);
                for(Component j:MenuBar.getComponents()){
                    System.out.println(j);
                }
                System.out.println("\n\n");
            }
        };
        SearchField = new javax.swing.JTextField();
        SearchLabel = new javax.swing.JLabel();
        leftCtrlPanel = new javax.swing.JPanel();
        profileSwitchButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();

        changeProfilePicButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImages/PlusPic.png"))); // NOI18N
        changeProfilePicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeProfilePicButtonActionPerformed(evt);
            }
        });

        addPostToProfile.setText("AddPost");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FacePamphlet");
        setBackground(new java.awt.Color(255, 51, 102));
        setForeground(new java.awt.Color(204, 0, 204));
        setName("App Frame"); // NOI18N
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        Canvas.setBackground(new java.awt.Color(255, 255, 255));
        Canvas.setForeground(new java.awt.Color(255, 255, 255));
        Canvas.setToolTipText("");
        Canvas.setName("Canvas"); // NOI18N
        Canvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CanvasMousePressed(evt);
            }
        });
        Canvas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                CanvasMouseDragged(evt);
            }
        });
        Canvas.setLayout(null);

        Testing.setBackground(new java.awt.Color(255, 255, 0));
        Testing.setName("Gadget"); // NOI18N
        Testing.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                TestingComponentMoved(evt);
            }
        });

        javax.swing.GroupLayout TestingLayout = new javax.swing.GroupLayout(Testing);
        Testing.setLayout(TestingLayout);
        TestingLayout.setHorizontalGroup(
            TestingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        TestingLayout.setVerticalGroup(
            TestingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        Canvas.add(Testing);
        Testing.setBounds(130, 80, 0, 0);

        leftPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        leftPane.setPreferredSize(new java.awt.Dimension(100, 0));
        leftPane.setLayout(new javax.swing.BoxLayout(leftPane, javax.swing.BoxLayout.PAGE_AXIS));

        MenuBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));

        SearchField.setForeground(java.awt.Color.lightGray);
        SearchField.setText("search for friends");
        SearchField.setName("SearchField"); // NOI18N
        SearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFieldActionPerformed(evt);
            }
        });
        SearchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchFieldFocusLost(evt);
            }
        });
        SearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SearchFieldKeyTyped(evt);
            }
        });

        SearchLabel.setText("Search:");
        SearchLabel.setName("SearchLabel"); // NOI18N

        javax.swing.GroupLayout MenuBarLayout = new javax.swing.GroupLayout(MenuBar);
        MenuBar.setLayout(MenuBarLayout);
        MenuBarLayout.setHorizontalGroup(
            MenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SearchLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        MenuBarLayout.setVerticalGroup(
            MenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(MenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchLabel)))
        );

        leftCtrlPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        profileSwitchButton.setText("Switch User");
        profileSwitchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileSwitchButtonActionPerformed(evt);
            }
        });

        homeButton.setLabel("Home");

        javax.swing.GroupLayout leftCtrlPanelLayout = new javax.swing.GroupLayout(leftCtrlPanel);
        leftCtrlPanel.setLayout(leftCtrlPanelLayout);
        leftCtrlPanelLayout.setHorizontalGroup(
            leftCtrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftCtrlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftCtrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileSwitchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        leftCtrlPanelLayout.setVerticalGroup(
            leftCtrlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftCtrlPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(profileSwitchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leftCtrlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Canvas, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addComponent(MenuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(leftCtrlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(leftPane, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //------------------------------------------------------------
    //|                                                          |
    //|                    ActionListeners                       |
    //|                                                          |
    //------------------------------------------------------------
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    }//GEN-LAST:event_formMouseClicked

    private void changeProfilePicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeProfilePicButtonActionPerformed
       new PictureSelect(this);
    }//GEN-LAST:event_changeProfilePicButtonActionPerformed

    private void CanvasMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CanvasMouseDragged
        ((MouseMotionListener) Canvas).mouseDragged(evt);
    }//GEN-LAST:event_CanvasMouseDragged

    private void CanvasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CanvasMousePressed
        ((PamphletCanvas) Canvas).mousePressed(evt);
    }//GEN-LAST:event_CanvasMousePressed

    private void TestingComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TestingComponentMoved
    }//GEN-LAST:event_TestingComponentMoved

    private void SearchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            // && !SearchField.getText().trim().equals("")
            
            // DO THE SEARCH


            JOptionPane.showMessageDialog(this, "Enter was pressed, would normally do search now", "To Implement",
                    JOptionPane.INFORMATION_MESSAGE);

        }    }//GEN-LAST:event_SearchFieldKeyPressed

    private void SearchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyTyped
        //SearchFieldKeyPressed(evt);
    }//GEN-LAST:event_SearchFieldKeyTyped

    private void SearchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchFieldFocusGained
        SearchField.setText("");
        SearchField.setForeground(Color.BLACK);    }//GEN-LAST:event_SearchFieldFocusGained

    private void SearchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchFieldFocusLost
        if (SearchField.getText().trim().equals("")) {
            SearchField.setText("search for friends");
            SearchField.setForeground(Color.GRAY);
        }    }//GEN-LAST:event_SearchFieldFocusLost

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void profileSwitchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileSwitchButtonActionPerformed
        // T0D0: wipe Canvas of all current Objects, gracefully kill all current profile's data structures
        // then initialize and display someone else's profile Objects
        
    }//GEN-LAST:event_profileSwitchButtonActionPerformed
    private void formMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formMousePressed
    }// GEN-LAST:event_formMousePressed

    
    //------------------------------------------------------------
    //|                                                          |
    //|              Main, Variable Declarations                 |
    //|                                                          |
    //------------------------------------------------------------    
    /**
     * @param args the command line arguments
     **/
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FacePamphlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacePamphlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacePamphlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacePamphlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacePamphlet().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Canvas;
    private javax.swing.JPanel MenuBar;
    private javax.swing.JTextField SearchField;
    private javax.swing.JLabel SearchLabel;
    private javax.swing.JPanel Testing;
    private javax.swing.JButton addPostToProfile;
    private javax.swing.JButton changeProfilePicButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JPanel leftCtrlPanel;
    private javax.swing.JPanel leftPane;
    private javax.swing.JButton profileSwitchButton;
    // End of variables declaration//GEN-END:variables
}