package taller3;

public class HechizoFuego extends Hechizo implements Calcular{
	private int mejoraDefensa;

	public HechizoFuego(String nombreHechizo, String tipo, int daño, int mejoraDefensa) {
		super(nombreHechizo, tipo, daño);
		this.mejoraDefensa = mejoraDefensa;
	}

	public int getMejoraDefensa() {
		return mejoraDefensa;
	}

	@Override
	public void calcularPuntuacionHechizos() {
		// TODO Auto-generated method stub
		
	}
	
	
}
