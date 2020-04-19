package mapa;

import graficos.Pantalla;

public abstract class Mapa {
	protected int ancho;
	protected int alto;
	
	protected int[] cuadros;
	
	public Mapa (int ancho, int alto) {
		this.ancho = ancho;
		this.alto  = alto;
		cuadros = new int[ancho * alto];
		generarMapa();
	}
	
	public Mapa(String ruta) {
		cargarMapa(ruta);
	}
	
	protected void generarMapa() {
		
	}
	
	protected void cargarMapa(String ruta) {
		
	}
	
	public void mostrar(int compX, int compY, Pantalla pantalla) {
		int oeste = compX/32;
		int este = (compX + pantalla.getAncho())/32;

		int norte =compY/32;
		int sur =  (compY + pantalla.getAlto())/32;
	}
}
