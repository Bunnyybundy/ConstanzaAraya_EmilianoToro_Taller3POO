package taller3;

import java.util.Scanner;

public class MenuAdmin {
	static Scanner s = new Scanner(System.in);
	private GestorMagos gestor;

	public MenuAdmin(GestorMagos gestor) {
		this.gestor = gestor;
	}
	
	public void mostrarMenu() {
		int opcion;
		do {
			System.out.println(" === Panel Administrador === ");
			System.out.println("1. Agregar Mago");
			System.out.println("2. Modificar Mago");
			System.out.println("3. Eliminar Mago");
			System.out.println("4. Mostrar Magos");
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
				gestor.mostrarMagos();
				break;
			case 0: 
				System.out.println("Saliendo del menu administrador...");
				break;
			default:
				System.out.println("Opcion incorrecta. Intenta nuevamente");
			}
		}while(opcion != 0);
	}
	
}
