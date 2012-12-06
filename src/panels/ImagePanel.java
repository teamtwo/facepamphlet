package panels;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImagePanel extends FPPanel {

    private BufferedImage dsPic;
    private String picTitle;
    private int xOffset = 0;
    private int yOffset = 0;
    private int width = 0;
    private int height = 0;

    public ImagePanel(String photoName, String imagePath) {
        super();
        this.setSize(500, 500);
        this.setMinimumSize(new Dimension(500,500));
        this.setPreferredSize(new Dimension(500,500));
        this.setMaximumSize(new Dimension(500,500));
        this.changeImage(photoName, imagePath);

        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                ImagePanel.this.componentResized(e);
            }
        });
        this.componentResized(null);

    }

    public ImagePanel(String photoName, BufferedImage newImage) {
        super();
                //System.out.println(photoName );

        this.changeImage(photoName, newImage);

        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                ImagePanel.this.componentResized(e);
            }
        });
        this.componentResized(null);

    }

    private void componentResized(ComponentEvent e) {
        if (dsPic == null) {
            return;
        }
        int newWidth = ImagePanel.this.getWidth();
        int newHeight = ImagePanel.this.getHeight();
        if (newWidth == 0 || newHeight == 0) {
            return;// What to do I do not know
        }

        int picWidth = dsPic.getWidth();
        int picHeight = dsPic.getHeight();

        double widthRatio = ((double) newWidth) / picWidth;
        double heightRatio = ((double) newHeight) / picHeight;

        double scaleBy = Math.min(Math.min(widthRatio, heightRatio), 1.0);
        ImagePanel.this.width = (int) (scaleBy * picWidth);
        ImagePanel.this.height = (int) (scaleBy * picHeight);
        ImagePanel.this.xOffset = (newWidth - width) / 2;
        ImagePanel.this.yOffset = (newHeight - height) / 2;

    }

    /**
     * Returns this ImagePanel's current image. This is useful if another
     * program wants to edit it.
     *
     * @return The current picture being displayed.
     */
    public BufferedImage getImage() {
        return this.dsPic;
    }

    /**
     * Sets an image with a specific title to the currently displayed.
     *
     * @return Whether the image loaded or not is determined if it returns null
     * or not
     */
    public BufferedImage changeImage(String photoName, String imagePath) {

        BufferedImage newPic = loadImage(photoName);
        if (newPic == null) {
            return null;
        }
        changeImage(photoName, imagePath);
        return newPic;

    }

    /**
     * Sets an image with a specific title to the currently displayed. This does
     * not copy the given image,
     */
    public void changeImage(String photoName, BufferedImage toMakeInto) {
        dsPic = toMakeInto;
        picTitle = photoName;
        if (picTitle != null && !picTitle.equals("")) {
            this.setBorder(BorderFactory.createTitledBorder(picTitle));
        } else {
            this.setBorder(BorderFactory.createEmptyBorder());
        }
    }

    
    public static BufferedImage loadImage(String aPicFile) {
		try {
			BufferedImage loaded = ImageIO.read(new File(aPicFile));
			return loaded;
		} catch (IOException e) {
			// e.printStackTrace();
			return null;
		}
	}
    
    public void paintComponent(Graphics g) {

        if (dsPic != null) {
            g.drawImage(dsPic, xOffset, yOffset, width, height, null);
        }
        super.paintComponents(g);
    }
    
    
}
