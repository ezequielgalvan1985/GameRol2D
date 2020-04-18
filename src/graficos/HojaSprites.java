package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HojaSprites {
	public final int[] pixeles;
	private final int ancho;
	private final int alto;
	
	
	//coleccion hoja de sprites
	public static HojaSprites desierto = new HojaSprites("/texturas/mapa2.png", 320,320);
	
	
	
	public HojaSprites(final String ruta, final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;
		
		pixeles = new int[ancho * alto];
		try {
			BufferedImage imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	
	
}
