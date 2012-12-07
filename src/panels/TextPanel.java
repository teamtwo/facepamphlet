package panels;

/**
 * @author Stuart Townsend
 */

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class TextPanel extends FPPanel{

	public String panelTitle;
    public JLabel panelText = new JLabel();
    private int xOffset = 0;
    private int yOffset = 0;
    private int width = 0;
    private int height = 0;
    
    public TextPanel(){
    	super();
        this.setSize(500, 500);
        //this.setMinimumSize(new Dimension(500,500));
        this.setPreferredSize(new Dimension(250,250));
        this.setMaximumSize(new Dimension(500,500));
        this.setBorder(BorderFactory.createTitledBorder(""));

        panelText.setPreferredSize(new Dimension (400, 400));
        panelText.setBounds(20, 10, this.getSize().width-10, this.getSize().height-10);
        //panelText.setBorder(BorderFactory.createLoweredBevelBorder());


        this.add(panelText);
       
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                TextPanel.this.componentResized(e);
            }
        });
        this.componentResized(null);
        this.repaint();

    }
	
    public TextPanel(String titleName) {
        super();
        this.setSize(500, 500);
        //this.setMinimumSize(new Dimension(500,500));
        this.setPreferredSize(new Dimension(250,250));
        this.setMaximumSize(new Dimension(500,500));
        this.setBorder(BorderFactory.createTitledBorder(titleName));
        
        panelText.setPreferredSize(new Dimension (400, 400));
        panelText.setBounds(20, 10, this.getSize().width-10, this.getSize().height-10);
        //panelText.setBorder(BorderFactory.createLoweredBevelBorder());
        

        this.add(panelText);

        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                TextPanel.this.componentResized(e);
            }
        });
        this.componentResized(null);
        this.repaint();

    }
    
    
    public String getText() {
    	return panelText.getText();
    }
    public void setText(String textIn) {
    	panelText.setText(textIn);
    	//repaint();
    }
	
	private void componentResized(ComponentEvent e) {
        if (panelText == null) {
            return;
        }
        int newWidth = TextPanel.this.getWidth();
        int newHeight = TextPanel.this.getHeight();
        if (newWidth == 0 || newHeight == 0) {
            return;// What to do I do not know
        }

        int picWidth = panelText.getWidth();
        int picHeight = panelText.getHeight();

        double widthRatio = ((double) newWidth) / picWidth;
        double heightRatio = ((double) newHeight) / picHeight;

        double scaleBy = Math.min(Math.min(widthRatio, heightRatio), 1.0);
        TextPanel.this.width = (int) (scaleBy * picWidth);
        TextPanel.this.height = (int) (scaleBy * picHeight);
        TextPanel.this.xOffset = (newWidth - width) / 2;
        TextPanel.this.yOffset = (newHeight - height) / 2;
        
        panelText.setBounds(20, 0, this.getSize().width-10, this.getSize().height-10);

        
    }
	
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
    }
	
	
}
