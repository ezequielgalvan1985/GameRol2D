package graficos;

public final class Sprite {
	private final int lado;
	private int x;
	private int y;
	private final HojaSprites hoja;
	public int[] pixeles;
	
	
	public static Sprite pasto = new Sprite(32,0,0, HojaSprites.desierto);
	
	
	
	public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja) {
		this.lado = lado;
		pixeles = new int[this.lado * this.lado];
		this.x = columna * lado;
		this.y = fila * lado;
		this.hoja = hoja; 
		
		//contador para recorrer la hoja de sprite de lado a lado 
		//obtieje el sprite de la hoja de sprite
		for (int y = 0; y < lado ; y++) {//se dibuja de izquiera a derecha esto es la fila de la fija
			for (int x =0; x < lado; x++) { // esto es la columna de la hoja
				
				pixeles[x + y * lado] = hoja.pixeles[( (x + this.x) + (y + this.y) * hoja.getAncho())];
			}
		}
	}
	
}
