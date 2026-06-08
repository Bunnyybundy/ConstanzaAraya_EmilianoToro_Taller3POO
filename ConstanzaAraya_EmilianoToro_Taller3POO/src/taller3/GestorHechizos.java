package taller3;
 
import java.util.ArrayList;
/**
 * Clase que administra la colección global de hechizos.
 * Permite realizar operaciones CRUD sobre los hechizos y buscarlos por nombre.
 */
public class GestorHechizos {
	private ArrayList<Hechizo> hechizos;
 
    /** Constructor que inicializa la lista de hechizos. */ 
	public GestorHechizos() {
		this.hechizos = new ArrayList<>();
	}
	/**
     * Agrega un nuevo hechizo a la lista.
     * @param h Hechizo a agregar.
     */
	public void agregarHechizo(Hechizo h) {
		hechizos.add(h);
	}
	 /**
     * Modifica un hechizo existente.
     * @param nombre Nombre del hechizo a modificar.
     * @param nuevo Nuevo objeto Hechizo con los datos actualizados.
     */
	public void modificarHechizo(String nombre, Hechizo nuevo) {
		for(int i = 0; i < hechizos.size(); i++) {
			if(hechizos.get(i).getNombreHechizo().equals(nombre)) {
				hechizos.set(i, nuevo);
				return;
			}
		}
	}
	/**
     * Elimina un hechizo por su nombre.
     * @param nombre Nombre del hechizo a eliminar.
     */
	public void eliminarHechizo(String nombre) {
		hechizos.removeIf(h -> h.getNombreHechizo().equals(nombre));
	}
	/**
     * @return Lista completa de hechizos.
     */
	public ArrayList<Hechizo> getHechizos() {
		return hechizos;
	}
	/**
     * Busca un hechizo por su nombre.
     * @param nombre Nombre del hechizo a buscar.
     * @return El objeto Hechizo encontrado o null si no existe.
     */
	public Hechizo buscarPorNombre(String nombre) {
		for(Hechizo h : hechizos) {
			if(h.getNombreHechizo().equals(nombre)) {
				return h;
			}
		}
		return null;
	}
	/**
     * Muestra todos los hechizos almacenados en el sistema.
     */
	public void mostrarHechizos() {
		for(Hechizo h : hechizos) {
			System.out.println("Hechizo: " + h.getNombreHechizo() + " | Tipo: " + h.getTipo() + " | Puntuacion: " + h.calcularPuntuacion());
		}
	}
}
