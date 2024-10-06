package Functions;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageScale {
	public ImageIcon getScaledImage(int width, int height, String path) {
		ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(path)));
		Image img1 = myImage.getImage();
		
		Image img2 = img1.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img2);
		return i;
	}
}
