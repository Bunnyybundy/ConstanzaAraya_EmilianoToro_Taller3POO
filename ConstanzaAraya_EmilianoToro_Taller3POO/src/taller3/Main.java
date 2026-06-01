package taller3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Hechizo> hechizos = new ArrayList<>();
	public static void main(String[] args) {
		GestorMagos gestor = new GestorMagos();
		gestorHechizos gestorH = new gestorHechizos();
		leerHechizos("Hechizos.txt",gestorH);
		leerMagos("Magos.txt", gestor);
		MenuAdmin menuAdmin = new MenuAdmin(gestor, gestorH);
		menuAdmin.mostrarMenu();


	}

	private static void leerHechizos(String archivo, gestorHechizos gestorHechizos) {
		try {
			Scanner sc = new Scanner(new File(archivo));
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] partes = linea.split(";");
				String nombre = partes[0];
				String tipo = partes[1];
				int daño = Integer.parseInt(partes[2]);
				
				switch(tipo) {
				
				case "Fuego":
					int duracionQuemadura = Integer.parseInt(partes[3]);
					gestorHechizos.agregarHechizo(new HechizoFuego(nombre, daño, duracionQuemadura));
					break;

				case "Planta":
					String[] extra = partes[3].split(",");
					int duracionStun = Integer.parseInt(extra[0]);
					int cantPlantas = Integer.parseInt(extra[1]);
					gestorHechizos.agregarHechizo(new HechizoPlanta(nombre, daño, duracionStun, cantPlantas));
					break;

				case "Agua":
					String[] extras = partes[3].split(",");
					int cantidadHeal = Integer.parseInt(extras[0]);
					int presionAgua = Integer.parseInt(extras[1]);
					gestorHechizos.agregarHechizo(new HechizoAgua(nombre, daño, cantidadHeal, presionAgua));
					break;

				case "Tierra":
					int mejoraDefensa = Integer.parseInt(partes[3]);
					gestorHechizos.agregarHechizo(new HechizoTierra(nombre, daño, mejoraDefensa));
					break;
				}
			}
			sc.close();
		}catch(FileNotFoundException e) {
			System.out.println("Error al leer el archivo de hechizos: " + e.getMessage());
		}
	}

	private static void leerMagos(String archivo, GestorMagos gestor) {
		try {
			Scanner sc = new Scanner(new File(archivo));
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] partes = linea.split(";");
				String nombreMago = partes[0];
				Mago mago = new Mago(nombreMago);
				
				if(partes.length > 1) {
					String[] nombresHechizos = partes[1].split("\\|");
					for(String nombreH : nombresHechizos) {
						for(Hechizo h : hechizos) {
							if(h.getNombreHechizo().equals(nombreH)) {
								mago.agregarHechizo(h);
								break;
							}
						}
					}
				}
				gestor.agregarMago(mago);
			}
			sc.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("Error al leer el archivo de magos: " + e.getMessage());
		}
	}
}