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
    public JLabel panelText = new JLabel("");
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
        this.add(panelText);
        //panelText.setBorder(BorderFactory.createTitledBorder(""));
       
        this.repaint();
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                TextPanel.this.componentResized(e);
            }
        });
        this.componentResized(null);
    }
	
    public TextPanel(String titleName) {
        super();
        this.setSize(500, 500);
        //this.setMinimumSize(new Dimension(500,500));
        this.setPreferredSize(new Dimension(250,250));
        this.setMaximumSize(new Dimension(500,500));
        panelText.setBorder(BorderFactory.createTitledBorder(titleName));
        this.add(panelText);

        this.repaint();
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                TextPanel.this.componentResized(e);
            }
        });
        this.componentResized(null);
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

    }
	
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
    }
	
	
}
