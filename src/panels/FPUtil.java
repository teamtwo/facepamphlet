package panels;

import java.awt.image.*;
import java.io.*;
import java.util.*;

import javax.imageio.*;

public class FPUtil {

	public static BufferedImage loadImage(String aPicFile) {
		try {
			BufferedImage loaded = ImageIO.read(new File(aPicFile));
			return loaded;
		} catch (IOException e) {
			// e.printStackTrace();
			return null;
		}
	}

	/**
	 * Loads the given images. If a file fails to load, it will not be included in the map.
	 * 
	 * Not checks for collisions.
	 */
	public static Map<String, BufferedImage> loadImages(String... files) {
		TreeMap<String, BufferedImage> imageMap = new TreeMap<String, BufferedImage>();
		for (String aPic : files) {
			BufferedImage loaded;
			if ((loaded = loadImage(aPic)) != null) {
				imageMap.put(aPic, loaded);
			}

		}
		return imageMap;

	}
}
