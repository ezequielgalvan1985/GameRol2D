package graficos;

public final class Pantalla {
	private final int ancho;
	private final int alto;
	public final int[] pixeles;
	
	
	
	//temporal
	private final static int lado_sprite = 32;
	private final static int mask_sprite = lado_sprite -1;
	//fin temporal
	
	
	public Pantalla(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;
		
		pixeles = new int[ancho * alto];
		
		
	}
	
	public void limpiar() {
		for (int i=0; i< pixeles.length; i++) {
			pixeles[i] = 0 ;
		}
	}
	
	public void mostrar(final int compX, final int compY) {
		for (int y = 0; y < alto; y++) {
			int posY = y + compY;
			
			if (posY < 0 || posY >= alto) {
				continue;
			}
		
			
			for (int x = 0; x < ancho; x++) {
				int posX = x + compX;
				if (posX < 0 || posX >= ancho) {
					continue;
				}
				
				//dibujar  la pantalla
				
				pixeles[posX + posY * ancho] = Sprite.pasto.pixeles[(x & mask_sprite) + (y & mask_sprite ) * lado_sprite]; 
			
			}
			
			
			
			
			
		}
	}
}
