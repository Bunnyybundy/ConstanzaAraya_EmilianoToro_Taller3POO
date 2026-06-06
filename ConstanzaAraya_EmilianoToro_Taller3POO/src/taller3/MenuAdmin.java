package taller3;

import java.io.*;
import java.util.*;

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
				guardarMagos();
				break;
			case 2:
				System.out.println("Nombre del mago a modificar");
				String viejo = s.nextLine();
				System.out.println("Nuevo nombre: ");
				String nuevo = s.nextLine();
				gestor.modificarMago(viejo, new Mago(nuevo));
				guardarMagos();
				break;
			case 3:
				System.out.println("Nombre del mago a eliminar: ");
				String eliminar = s.nextLine();
				gestor.eliminarMago(eliminar);
				guardarMagos();
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
					guardarHechizos();
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
					guardarHechizos();
				}
				break;
			case 6:
				System.out.println("Nombre del hechizo a eliminar: ");
				String nombreElim = s.nextLine();
				gestorHechizos.eliminarHechizo(nombreElim);
				guardarHechizos();
				break;
			case 0:
				System.out.println("Saliendo del menu administrador...");
				break;
			default:
				System.out.println("Opcion incorrecta. Intenta nuevamente");
			}
		} while(opcion != 0);
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

	private void guardarMagos() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Magos.txt"));
			for(Mago m : gestor.getMagos()) {
				StringBuilder sb = new StringBuilder(m.getNombreMago());
				if(!m.getHechizos().isEmpty()) {
					sb.append(";");
					for(int i = 0; i < m.getHechizos().size(); i++) {
						sb.append(m.getHechizos().get(i).getNombreHechizo());
						if(i < m.getHechizos().size() - 1) {
							sb.append("|");
						}
					}
				}
				bw.write(sb.toString());
				bw.newLine();
			}
			bw.close();
		} catch(IOException e) {
			System.out.println("Error al guardar magos: " + e.getMessage());
		}
	}

	private void guardarHechizos() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Hechizos.txt"));
			for(Hechizo h : gestorHechizos.getHechizos()) {
				StringBuilder sb = new StringBuilder();
				sb.append(h.getNombreHechizo()).append(";")
				  .append(h.getTipo()).append(";")
				  .append(h.getDaño()).append(";");
				if(h instanceof HechizoFuego) {
					sb.append(((HechizoFuego) h).getDuracionQuemadura());
				} else if(h instanceof HechizoTierra) {
					sb.append(((HechizoTierra) h).getMejoraDefensa());
				} else if(h instanceof HechizoPlanta) {
					HechizoPlanta hp = (HechizoPlanta) h;
					sb.append(hp.getDuracionStun()).append(",").append(hp.getCantPlantas());
				} else if(h instanceof HechizoAgua) {
					HechizoAgua ha = (HechizoAgua) h;
					sb.append(ha.getCantidadHeal()).append(",").append(ha.getPresionAgua());
				}
				bw.write(sb.toString());
				bw.newLine();
			}
			bw.close();
		} catch(IOException e) {
			System.out.println("Error al guardar hechizos: " + e.getMessage());
		}
	}
}