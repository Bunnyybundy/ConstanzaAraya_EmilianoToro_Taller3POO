package taller3;

import java.util.Scanner;

public class MenuAdmin {
	static Scanner s = new Scanner(System.in);
	private GestorMagos gestor;
	private gestorHechizos gestorHechizos;

	public MenuAdmin(GestorMagos gestor, gestorHechizos gestorHechizos) {
		this.gestor = gestor;
		this.gestorHechizos = gestorHechizos;
	}
	
	public void mostrarMenu() {
		int opcion;
		do {
			System.out.println(" === Panel Administrador === ");
			System.out.println("1. Agregar Mago");
			System.out.println("2. Modificar Mago");
			System.out.println("3. Eliminar Mago");
			System.out.println("4. Agregar Hechizo");
			System.out.println("5. Modificar Hechizo");
			System.out.println("6. Eliminar Hechizo");
			System.out.println("0. Salir");
			opcion = s.nextInt();
			s.nextLine();
			
			switch(opcion) {
			case 1: 
				System.out.println(" Nombre del nuevo mago: ");
				String nombre = s.nextLine();
				gestor.agregarMago(new Mago(nombre));
				break;
			case 2: 
				System.out.println("Nombre del mago a modificar");
				String viejo = s.nextLine();
				System.out.println("Nuevo nombre: ");
				String nuevo = s.nextLine();
				gestor.modificarMago(viejo, new Mago(nuevo));
				break;
			case 3:
				System.out.println("Nombre del mago a eliminar: ");
				String eliminar = s.nextLine();
				gestor.eliminarMago(eliminar);
				break;
			case 4:
				System.out.println("Nombre del hechizo: ");
				String nombreH = s.nextLine();
				System.out.println("Tipo (Fuego/Agua/Planta/Tierra): ");
				String tipo = s.nextLine();
				System.out.println("Daño: ");
				int daño = Integer.parseInt(s.nextLine());
				Hechizo nuevoH = crearHechizo(nombreH, tipo, daño);
				if(nuevoH != null) {
					gestorHechizos.agregarHechizo(nuevoH);
				}
				break;
			case 5:
				System.out.println("Nombre del hechizo a modificar: ");
				String nombreMod = s.nextLine();
				System.out.println("Nuevo tipo (Fuego/Agua/Planta/Tierra): ");
				String tipoMod = s.nextLine();
				System.out.println("Nuevo daño: ");
				int dañoMod = Integer.parseInt(s.nextLine());
				Hechizo modificado = crearHechizo(nombreMod, tipoMod, dañoMod);
				if(modificado != null) {
					gestorHechizos.modificarHechizo(nombreMod, modificado);
				}
				break;
			case 6:
				System.out.println("Nombre del hechizo a eliminar: ");
				String nombreElim = s.nextLine();
				gestorHechizos.eliminarHechizo(nombreElim);
				break;
			case 0: 
				System.out.println("Saliendo del menu administrador...");
				break;
			default:
				System.out.println("Opcion incorrecta. Intenta nuevamente");
			}
		}while(opcion != 0);
	}

	private Hechizo crearHechizo(String nombre, String tipo, int daño) {
		switch(tipo) {
		case "Fuego":
			System.out.println("Duracion Quemadura: ");
			return new HechizoFuego(nombre, daño, Integer.parseInt(s.nextLine()));
		case "Tierra":
			System.out.println("Mejora Defensa: ");
			return new HechizoTierra(nombre, daño, Integer.parseInt(s.nextLine()));
		case "Planta":
			System.out.println("Duracion Stun: ");
			int durS = Integer.parseInt(s.nextLine());
			System.out.println("Cantidad Plantas: ");
			int cantP = Integer.parseInt(s.nextLine());
			return new HechizoPlanta(nombre, daño, durS, cantP);
		case "Agua":
			System.out.println("Cantidad Heal: ");
			int heal = Integer.parseInt(s.nextLine());
			System.out.println("Presion Agua: ");
			int presion = Integer.parseInt(s.nextLine());
			return new HechizoAgua(nombre, daño, heal, presion);
		default:
			System.out.println("Tipo invalido.");
			return null;
		}
	}
}