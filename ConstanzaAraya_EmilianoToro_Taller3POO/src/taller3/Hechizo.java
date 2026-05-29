package taller3;
/**
 * Clase abstracta que representa un Hechizo genérico.
 * Contiene atributos comunes como nombre, tipo y daño.
 * Cada subclase debe implementar el cálculo de puntuación
 * según las reglas específicas de su tipo.
 */
public abstract class Hechizo {
	private String nombreHechizo;
	private String tipo;
	private int daño;
	/**
     * Constructor de la clase Hechizo.
     * @param nombre Nombre del hechizo.
     * @param tipo Tipo de elemento (Fuego, Agua, Planta, Tierra).
     * @param daño Valor de daño base del hechizo.
     */
	public Hechizo(String nombreHechizo, String tipo, int daño) {
		this.nombreHechizo = nombreHechizo;
		this.tipo = tipo;
		this.daño = daño;
	}
    /** @return Nombre del hechizo. */
	public String getNombreHechizo() {
		return nombreHechizo;
	}
    /** @return Tipo del hechizo. */
	public String getTipo() {
		return tipo;
	}
    /** @return Daño base del hechizo. */
	public int getDaño() {
		return daño;
	}
	/**
     * Método abstracto para calcular la puntuación del hechizo.
     * Cada subclase debe implementar su propia fórmula.
     * @return Puntuación calculada del hechizo.
     */
	public abstract double calcularPuntuacion();
}
