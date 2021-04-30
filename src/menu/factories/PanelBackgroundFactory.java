package menu.factories;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import util.Constants;
import util.Strings;

public class PanelBackgroundFactory extends JPanel{

	private static final long serialVersionUID = 1L;
	private Image image;
	private Image resizedImage;
	
	public PanelBackgroundFactory() {
		try {
			image = ImageIO.read(new File(Strings.PANEL_BACKGROUND));
			this.resizedImage = image.getScaledInstance(Constants.preferDimension.width, Constants.preferDimension.height, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			System.out.println("There was an error with the panel background");
			this.setOpaque(false);
		}
	}

	@Override
	 protected void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 g.drawImage(resizedImage, 0, 0, this);          
	 }
}