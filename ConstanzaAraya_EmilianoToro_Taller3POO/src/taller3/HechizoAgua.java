package taller3;
/**
 * Representa un hechizo de tipo Agua.
 * Fórmula de puntuación: (Daño + CantidadHeal + PresionAgua) * 2.
 */
public class HechizoAgua extends Hechizo {
	private int cantidadHeal;
	private int presionAgua;

	/**
     * Constructor de HechizoAgua.
     * @param nombre Nombre del hechizo.
     * @param daño Daño base del hechizo.
     * @param cantidadHeal Cantidad de heal del hechizo.
     * @param presionAgua Presion de agua del hechizo.
     */
	public HechizoAgua(String nombreHechizo, int daño, int cantidadHeal, int presionAgua) {
		super(nombreHechizo, "Agua", daño);
		this.cantidadHeal = cantidadHeal;
		this.presionAgua = presionAgua;
	}

	 /** @return cantidad de Heal. */

	public int getCantidadHeal() {
		return cantidadHeal;
	}

	 /** @return presion del agua. */

	public int getPresionAgua() {
		return presionAgua;
	}

	/**
     * Calcula la puntuación del hechizo de fuego.
     * @return Daño multiplicado por la duración de la quemadura.
     */

	@Override
	public double calcularPuntuacion() {

		return (getDaño() + cantidadHeal + presionAgua) * 2;
	}

}
