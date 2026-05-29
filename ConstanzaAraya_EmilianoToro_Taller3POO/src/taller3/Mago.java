package taller3;

import java.util.ArrayList;
import java.util.List;
/**
 * Representa un Mago dentro del sistema.
 * Cada mago posee un conjunto de hechizos y una puntuación total
 * que se calcula sumando las puntuaciones de sus hechizos.
 */
public class Mago {
	private String nombreMago;
	private List<Hechizo> hechizos;
	/**
     * Constructor de Mago.
     * @param nombre Nombre del mago.
     */
	public Mago(String nombreMago) {
		this.nombreMago = nombreMago;
		this.hechizos = new ArrayList<>();
	}
    /** @return Nombre del mago. */
	public String getNombreMago() {
		return nombreMago;
	}
    /** @return Lista de hechizos del mago. */
	public List<Hechizo> getHechizos() {
		return hechizos;
	}
	/**
     * Agrega un nuevo hechizo al repertorio del mago.
     * @param h Hechizo a agregar.
     */
	public void agregarHechizo(Hechizo h) {
		hechizos.add(h);
	}
	/**
     * Calcula la puntuación total del mago.
     * @return Suma de las puntuaciones de todos sus hechizos.
     */
	public double calcularPuntuacionTotal() {
		double total = 0;
		for(Hechizo h : hechizos) {
			total += h.calcularPuntuacion();
		}
		return total;
	}
}
