package taller3;
/**
 * Representa un hechizo de tipo Fuego.
 * La puntuación se calcula como Daño * DuraciónQuemadura.
 */
public class HechizoFuego extends Hechizo {
	private int duracionQuemadura;

	 /**
     * Constructor de HechizoFuego.
     * @param nombre Nombre del hechizo.
     * @param daño Daño base del hechizo.
     * @param duracionQuemadura Duración del efecto de quemadura.
     */
	public HechizoFuego(String nombreHechizo, int daño, int duracionQuemadura) {
		super(nombreHechizo,"Fuego", daño);
		this.duracionQuemadura = duracionQuemadura;
	}
    /** @return duracion de la quemadura. */

	public int getDuracionQuemadura() {
		return duracionQuemadura;
	}

	/**
     * Calcula la puntuación del hechizo de fuego.
     * @return Daño multiplicado por la duración de la quemadura.
     */
	@Override
	public double calcularPuntuacion() {

		return getDaño() * duracionQuemadura ;
	}
	
	
}
