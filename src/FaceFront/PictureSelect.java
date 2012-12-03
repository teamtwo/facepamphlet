package FaceFront;

/**
 * 
 * 
 * @authors John Maguire, Stuart Townsend
 */
import java.awt.Color;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class PictureSelect extends javax.swing.JFrame {

    private final FacePamphlet parentProfile;
    
    /**
     * Creates new form PictureSelect
     */
    public PictureSelect(FacePamphlet returnTo) {
        this.parentProfile = returnTo;
        parentProfile.setVisible(true);
        initComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PictureChoose = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        FilepathField = new javax.swing.JTextField();
        submitPicSelectionButton = new javax.swing.JButton();
        TextTitleField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Submit = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        PictureChoose.setFileFilter(new FileNameExtensionFilter("Image Files", "GIF", "PNG", "JPG","JPEG", "BMP", "WBMP"));
        PictureChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PictureChooseActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Choose Profile Picture");
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setName("Picture Selection"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setLabelFor(FilepathField);
        jLabel1.setText("Picture Selected:");

        FilepathField.setToolTipText("");
        FilepathField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilepathFieldActionPerformed(evt);
            }
        });

        submitPicSelectionButton.setText("Browse");
        submitPicSelectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPicSelectionButtonActionPerformed(evt);
            }
        });

        jLabel2.setLabelFor(TextTitleField);
        jLabel2.setText("Picture Title:");

        Submit.setText("Add Picture To Pamphlet");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addGap(17, 17, 17)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(submitPicSelectionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FilepathField)
                    .addComponent(TextTitleField))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FilepathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Submit)
                    .addComponent(submitPicSelectionButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void FilepathFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilepathFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FilepathFieldActionPerformed

    private void submitPicSelectionButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        PictureChoose.showOpenDialog(this);
        File selPic = PictureChoose.getSelectedFile();
        if (selPic != null) {
            FilepathField.setText(selPic.getAbsolutePath());
        }
    }// GEN-LAST:event_jButton1ActionPerformed

    private void PictureChooseActionPerformed(java.awt.event.ActionEvent evt) {
    }// GEN-LAST:event_PictureChooseActionPerformed

    private void TextTitleFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TextTitleFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_TextTitleFieldActionPerformed

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_SubmitActionPerformed

        try {
            // GEN-FIRST:event_PictureChooseActionPerformed
            BufferedImage toAdd = ImageIO.read(new File(FilepathField.getText()));
            this.parentProfile.addPicture(TextTitleField.getText(), toAdd);
            this.formWindowClosed(null);
        } catch (IOException ex) {
            FilepathField.setBorder(BorderFactory.createLineBorder(Color.RED));
            //Logger.getLogger(PictureSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_SubmitActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PictureSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PictureSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PictureSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PictureSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PictureSelect(null).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FilepathField;
    private javax.swing.JFileChooser PictureChoose;
    private javax.swing.JButton Submit;
    private javax.swing.JTextField TextTitleField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton submitPicSelectionButton;
    // End of variables declaration//GEN-END:variables
}
