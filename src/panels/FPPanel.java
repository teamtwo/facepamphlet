package panels;

import java.awt.*;
import javax.swing.*;

/**
 * This is an abstract class for any of the Panels that will be a part of a user's FacePamplet. Currently nothing
 * specialized except that the panel is transparent.
 * 
 * @author John Maguire
 * 
 */
public abstract class FPPanel extends JPanel {
	public FPPanel() {
		super();
		this.setOpaque(false);
	}

	public FPPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		this.setOpaque(false);
	}

	public FPPanel(LayoutManager layout) {
		super(layout);
		this.setOpaque(false);
	}

	public FPPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		this.setOpaque(false);
	}

	public void makeBorder() {
		this.makeBorder(1, Color.BLACK);
	}

	public void makeBorder(int thickness, Color bordColor) {
		this.setBorder(BorderFactory.createLineBorder(bordColor));
	}
}
