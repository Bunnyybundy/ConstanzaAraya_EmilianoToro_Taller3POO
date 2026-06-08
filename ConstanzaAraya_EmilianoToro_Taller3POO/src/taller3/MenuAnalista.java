package taller3;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Panel Analista.
 * Permite generar reportes y rankings de magos y hechizos.
 */
public class MenuAnalista {
	private GestorMagos gestor;
	private GestorHechizos gestorHechizos;
	static Scanner s = new Scanner(System.in);
	
	/**
     * Constructor del menú analista.
     * @param gestor Gestor de magos.
     * @param gestorHechizos Gestor de hechizos.
     */
	public MenuAnalista(GestorMagos gestor, GestorHechizos gestorHechizos) {
		this.gestor = gestor;
		this.gestorHechizos = gestorHechizos;
	}
    /** Muestra el menú de opciones del analista. */
	public void mostrarMenu() {
		int opcion;
		do {
			System.out.println("=== Panel Analista ===");
			System.out.println("1. Top 10 mejores Hechizos");
			System.out.println("2. Top 3 mejores Magos");
			System.out.println("3. Mostrar todos los hechizos");
			System.out.println("4. Mostrar todos los magos");
			System.out.println("5. Mostrar todos los hechizos junto con su puntuación");
			System.out.println("6. Mostrar todos los magos junto con su puntuacion");
			System.out.println("0. Salir");
			try{
				opcion = s.nextInt();
			}catch(NumberFormatException e) {
				System.out.println("Entrada invalida, intenta de nuevo.");
				opcion = -1;
			}
			s.nextLine();
			switch(opcion) {
			case 1:
				topHechizos();
				break;
			case 2:
				topMagos();
				break;
			case 3:
				gestorHechizos.mostrarHechizos();
				break;
			case 4:
				gestor.mostrarMagos();
				break;
			case 5:
				mostrarHechizosConPuntuacion();
				break;
			case 6:
				mostrarMagosConPuntuacion();
				break;
			case 0:
				System.out.println("Saliendo de menu analista...Hasta luego!!");
				break;
			default:
				System.out.println("Opcion incorrecta. Por favor intenta nuevamente...");
				
			}
			
		}while(opcion != 0);
	}
    /** Muestra todos los magos con su puntuación. */
	private void mostrarMagosConPuntuacion() {
		for(Mago m: gestor.getMagos()) {
			System.out.println("Mago: " + m.getNombreMago() + " | Puntuacion: " + m.calcularPuntuacionTotal());
		}
	}
    /** Muestra todos los hechizos con su puntuación. */
	private void mostrarHechizosConPuntuacion() {
		for(Hechizo h: gestorHechizos.getHechizos()) {
			System.out.println("Hechizo: " + h.getNombreHechizo() + " | Tipo: " + h.getTipo() + " | Puntuacion: " + h.calcularPuntuacion());
		}
	}
    /** Muestra el Top 3 de magos según puntuación. */
	private void topMagos() {
		ArrayList<Mago> magos = new ArrayList<>(gestor.getMagos());
		for(int i = 0; i< magos.size() - 1; i++ ) {
			for(int j= 0; j < magos.size()- i -1; j++) {
				if(magos.get(j).calcularPuntuacionTotal()< magos.get(j+1).calcularPuntuacionTotal()) {
					Mago temp = magos.get(j);
					magos.set(j, magos.get(j+1));
					magos.set(j + 1, temp);
				}
			}
		}
		int limite = 3;
        if (magos.size() < limite) {
            limite = magos.size();
        }
        for (int i = 0; i < limite; i++) {
            Mago m = magos.get(i);
            System.out.println((i+1) + ". " + m.getNombreMago() + " | Puntuación: " + m.calcularPuntuacionTotal());
        }
	}
    /** Muestra el Top 10 de hechizos según puntuación. */
	private void topHechizos() {
		ArrayList<Hechizo> hechizos = new ArrayList<>(gestorHechizos.getHechizos());
		for(int i = 0; i< hechizos.size()- 1; i++) {
			for(int j = 0; j< hechizos.size() - i- 1; j++) {
				if(hechizos.get(j).calcularPuntuacion() < hechizos.get(j+1).calcularPuntuacion()) {
					Hechizo temp = hechizos.get(j);
					hechizos.set(j, hechizos.get(j+1));
					hechizos.set(j+1, temp);
				}
			}
		}
		int limite = 10;
		if(hechizos.size() < limite) {
			limite = hechizos.size();
		}
		for(int i = 0; i < limite; i++) {
			Hechizo h = hechizos.get(i);
			System.out.println((i +1) + ". " + h.getNombreHechizo() + " | Puntuacion " + h.calcularPuntuacion());
		}
	}
	
}
