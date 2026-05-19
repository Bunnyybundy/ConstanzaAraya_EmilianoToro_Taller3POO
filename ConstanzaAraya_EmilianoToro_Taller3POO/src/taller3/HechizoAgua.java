package taller3;

public class HechizoAgua extends Hechizo implements Calcular{
	private int duracionQuemadura;

	public HechizoAgua(String nombreHechizo, String tipo, int daño, int duracionQuemadura) {
		super(nombreHechizo, tipo, daño);
		this.duracionQuemadura = duracionQuemadura;
	}

	public int getDuracionQuemadura() {
		return duracionQuemadura;
	}

	@Override
	public void calcularPuntuacionHechizos() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
