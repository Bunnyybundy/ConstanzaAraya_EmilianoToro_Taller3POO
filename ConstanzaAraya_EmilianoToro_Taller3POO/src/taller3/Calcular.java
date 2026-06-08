package taller3;
/**
 * Interfaz funcional que define el contrato para calcular puntuaciones.
 * Debe ser implementada por las clases que necesiten calcular la puntuación
 * total de sus elementos (por ejemplo, un Mago con sus hechizos).
 */
public interface Calcular {
	/**
     * Calcula la puntuación total de los elementos asociados.
     * En el caso de la clase Mago, suma la puntuación de todos sus hechizos.
     */
	void calcularPuntuacionHechizos();
}
