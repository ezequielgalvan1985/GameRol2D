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
	
	public void mostrar(int x, int y, Pantalla pantalla) {
		
	}
	public boolean solid() {
		return false;
	}
}

