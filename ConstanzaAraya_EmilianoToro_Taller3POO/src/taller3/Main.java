package taller3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Hechizo> hechizos = new ArrayList<>();
	public static void main(String[] args) {
		GestorMagos gestor = new GestorMagos();
		leerMagos("Magos.txt", gestor);
		leerHechizos("Hechizos.txt");
	}

	private static void leerHechizos(String archivo) {
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
					hechizos.add(new HechizoFuego(nombre, daño, duracionQuemadura));
					break;
				case "Planta":
					String[] extra = partes[3].split(",");
					int duracionStun = Integer.parseInt(extra[0]);
					int cantPlantas = Integer.parseInt(extra[1]);
					hechizos.add(new HechizoPlanta( nombre, daño, duracionStun, cantPlantas));
					break;
				case "Agua":
					String[] extras = partes[3].split(",");
					int cantidadHeal = Integer.parseInt(extras[0]);
					int presionAgua = Integer.parseInt(extras[1]);
					hechizos.add(new HechizoAgua(nombre, daño, cantidadHeal, presionAgua));
					break;
				case "Tierra":
					int mejoraDefensa = Integer.parseInt(partes[3]);
					hechizos.add(new HechizoTierra(nombre, daño, mejoraDefensa));
					break;
				}
			}
			sc.close();
		}catch(FileNotFoundException e) {
			System.out.println("Error al leer el archivo de magos: " + e.getMessage());
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
					String[] hechizos = partes[1].split("\\|");
					for(String h : hechizos) {
						System.out.println("Hechizo leido: " + h);
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
