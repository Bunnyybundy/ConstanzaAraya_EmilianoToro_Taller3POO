package taller3;

public class HechizoPlanta extends Hechizo implements Calcular{
	private int cantPlantas;

	public HechizoPlanta(String nombreHechizo, String tipo, int daño, int cantPlantas) {
		super(nombreHechizo, tipo, daño);
		this.cantPlantas = cantPlantas;
	}

	public int getCantPlantas() {
		return cantPlantas;
	}

	@Override
	public void calcularPuntuacionHechizos() {
		// TODO Auto-generated method stub
		
	}
	
	
}
