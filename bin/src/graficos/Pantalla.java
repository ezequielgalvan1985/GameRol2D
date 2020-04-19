package graficos;

import mapa.cuadro.Tiled;

public final class Pantalla {
	private final int ancho;
	private final int alto;
	public final int[] pixeles;
	
	//temporal
	private final static int lado_sprite = 32;
	private final static int mask_sprite = lado_sprite -1;
	//fin temporal


	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

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

				//temporal
				pixeles[posX + posY * ancho] = Sprite.PASTO.pixeles[(x & mask_sprite) + (y & mask_sprite ) * lado_sprite];

			}
		}

	}
	//mostrarcuadro en el tutorial
	public void mostrar(int compX, int compY, Tiled tiled){
		//compX,  compY se pasa los nuevos valores de donde estamos posicionados.
		for (int y = 0; y < tiled.sprite.getLado(); y++){
			int posY = y + compY;

			for (int x =0; x< tiled.sprite.getLado();x++){
				int posX = x+ compX;

				//controla que se dibuje dentro de la pantalla
				if (posX <0 || posX > ancho || posY<0 ||posY > alto ){
					break;
				}

				pixeles[posX +  posY * ancho]= tiled.sprite.pixeles[x+y*tiled.sprite.getLado()];

			}
		}
	}
}
