package juego;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import control.Teclado;
import graficos.Pantalla;

public class Juego extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	private static JFrame ventana;
	private static final int ANCHO = 800;
	private static final int ALTO = 600;
	private static final String NOMBRE = "Game Rol";
	private static Thread thread;
	private static volatile boolean running = false;
	
	private static int aps = 0 ;
	private static int fps = 0;
	private static Teclado  teclado;
	
	
	private static int x=0;
	private static int y=0;
	
	private static Pantalla pantalla;
	
	//se crea imagen en blanco 
	private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
	
	//rompe la imagene en pixeles, obteniene un array de int por los pixeles de la imagenes
	private static int[] pixeles = ((DataBufferInt)imagen.getRaster().getDataBuffer()).getData(); 
	
	
	public Juego () {
		setPreferredSize(new Dimension(ANCHO, ALTO));
		pantalla = new Pantalla(ANCHO, ALTO);
		teclado = new Teclado();
		ventana = new JFrame(NOMBRE);
		addKeyListener(teclado);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
	}
	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.start();
	}
	
	@Override
	public void run() {
		
		final int NS_POR_SEGUNDO = 1000000000;
		final byte APS_OBJETIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
		long referenciaActualizacion = System.nanoTime();
		long refContador = System.nanoTime();
		double tiempoTranscurrido;
		double delta = 0;
		
		while(running) {
			final long inicioBucle = System.nanoTime();
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
			while(delta>= 1) {
				actualizar();
				delta--;
			}
			
			mostrar();
			if(System.nanoTime() - refContador > NS_POR_SEGUNDO) {
				//refContador++;
				
				ventana.setTitle(NOMBRE + " APS: " + aps + " - FPS: " + fps);
				aps = 0;
				fps = 0;
				refContador = System.nanoTime();
			}
			
		}
	}
	
	public synchronized void start() {
		
		running = true;
		thread = new Thread(this, "Graficos");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		System.nanoTime();
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//thread.stop();
	}
	
	
	
	public void actualizar() {
		teclado.actualizar();
		if (teclado.arriba) { System.out.println("Arriba"); y++;} ;
		if (teclado.abajo) {System.out.println("Abajo"); y--;}
		if (teclado.izquierda) {System.out.println("Izquierda"); x++;}
		if (teclado.derecha) {System.out.println("Derecha"); x--;} 
		aps++;
		
	}
	
	public void mostrar() {
		//almacena espacio en memoria, es para dibuja mas suave la animacion
		BufferStrategy estrategia = getBufferStrategy();
		if (estrategia==null) {
			createBufferStrategy(3);
			return;
		}
		pantalla.limpiar();
		pantalla.mostrar(x, y);
		
		System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);
		
		Graphics g = estrategia.getDrawGraphics();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null); //dibuja la imagen 
		g.dispose(); //una vez q se dibuja, se destruye de memoria. 
		estrategia.show();
		
		
		fps++;
	}
}
