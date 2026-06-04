package taller3;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuAnalista {
	private GestorMagos gestor;
	private gestorHechizos gestorHechizos;
	static Scanner s = new Scanner(System.in);
	
	public MenuAnalista(GestorMagos gestor, taller3.gestorHechizos gestorHechizos) {
		super();
		this.gestor = gestor;
		this.gestorHechizos = gestorHechizos;
	}
	
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
			opcion = s.nextInt();
			
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

	private void mostrarMagosConPuntuacion() {
		for(Mago m: gestor.getMagos()) {
			System.out.println("Mago: " + m.getNombreMago() + " | Puntuacion: " + m.calcularPuntuacionTotal());
		}
	}

	private void mostrarHechizosConPuntuacion() {
		for(Hechizo h: gestorHechizos.getHechizos()) {
			System.out.println("Hechizo: " + h.getNombreHechizo() + " | Tipo: " + h.getTipo() + " | Puntuacion: " + h.calcularPuntuacion());
		}
	}

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
