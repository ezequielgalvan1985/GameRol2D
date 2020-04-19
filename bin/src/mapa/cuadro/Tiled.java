package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

//en el curso se llama cuadro
public abstract class Tiled {
	public int x;
	public int y;
	
	public Sprite sprite;
	
	public Tiled(Sprite sprite) {
		this.sprite = sprite;
	}

	//coleccion de cuadros
	public static final Tiled PASTO = new TiledPasto(Sprite.PASTO);

	public void mostrar(int x, int y, Pantalla pantalla) {
		
	}
	public boolean solid() {
		return false;
	}
}

