package taller3;
/**
 * Representa un hechizo de tipo Tierra.
 * Fórmula de puntuación: (Daño * MejoraDefensa) / 2.
 */
public class HechizoTierra extends Hechizo {
	private int mejoraDefensa;

	/**
     * Constructor de HechizoFuego.
     * @param nombre Nombre del hechizo.
     * @param daño Daño base del hechizo.
     * @param mejoraDefensa Mejora de la Defensa del hechizo.
     */
	public HechizoTierra(String nombreHechizo, int daño, int mejoraDefensa) {
		super(nombreHechizo, "Tierra" , daño);
		this.mejoraDefensa = mejoraDefensa;
	}
    /** @return mejora de la defensa.*/


	public int getMejoraDefensa() {
		return mejoraDefensa;
	}

	/**
     * Calcula la puntuación del hechizo de fuego.
     * @return Daño multiplicado por la duración de la quemadura.
     */

	@Override
	public double calcularPuntuacion() {

		return (getDaño() * mejoraDefensa) / 2.0;

	}
}
