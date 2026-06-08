package taller3;

import java.util.ArrayList;
/**
 * Clase que administra la colección de magos.
 * Permite realizar operaciones CRUD sobre los magos.
 */
public class GestorMagos {
	private ArrayList<Mago> magos;

    /** Constructor que inicializa la lista de magos. */
	public GestorMagos() {
		this.magos = new ArrayList<>();
	}
    /** Agrega un nuevo mago a la lista. */
	public void agregarMago(Mago m) {
		magos.add(m);
	}
    /** Modifica un mago existente. */
	public void modificarMago(String nombre, Mago nuevo) {
		for(int i = 0; i< magos.size(); i++) {
			if(magos.get(i).getNombreMago().equals(nombre)) {
				magos.set(i, nuevo);
				return;
			}
		}
	}
    /** Elimina un mago por nombre. */
	public void eliminarMago(String nombre) {
		magos.removeIf(m -> m.getNombreMago().equals(nombre));
	}
    /** @return Lista de magos. */
	public ArrayList<Mago> getMagos() {
		return magos;
	}
    /** Muestra todos los magos con su puntuacion. */
	public void mostrarMagos() {
		for(Mago m: magos) {
			System.out.println("Mago: " + m.getNombreMago() + " | Puntuacion: " + m.calcularPuntuacionTotal());
		}
	}
}
