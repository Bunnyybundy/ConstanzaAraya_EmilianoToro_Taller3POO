package taller3;
/**
 * Representa un hechizo de tipo Planta.
 * La puntuación se calcula como Daño + (DuraciónStun * CantidadPlantas).
 */
public class HechizoPlanta extends Hechizo {
	private int duracionStun;
	private int cantPlantas;
	/**
     * Constructor de HechizoPlanta.
     * @param nombre Nombre del hechizo.
     * @param daño Daño base del hechizo.
     * @param duracionStun Duración del efecto de aturdimiento.
     * @param cantPlantas Cantidad de plantas invocadas.
     */
	public HechizoPlanta(String nombreHechizo, int daño, int duracionStun ,int cantPlantas) {
		super(nombreHechizo, "Planta", daño);
		this.cantPlantas = cantPlantas;
		this.duracionStun = duracionStun;
	}
    /** @return cantidad de plantas. */

	public int getCantPlantas() {
		return cantPlantas;
	}

	/**
     * Calcula la puntuación del hechizo de planta.
     * @return Daño más el producto de duración del stun y cantidad de plantas.
     */
	@Override
	public double calcularPuntuacion() {

		return getDaño() + (duracionStun * cantPlantas);
	}
	
	
}
