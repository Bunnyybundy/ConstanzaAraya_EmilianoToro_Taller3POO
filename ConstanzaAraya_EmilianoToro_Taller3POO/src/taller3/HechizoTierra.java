package taller3;

public class HechizoTierra extends Hechizo {
	private int mejoraDefensa;

	public HechizoTierra(String nombreHechizo, int daño, int mejoraDefensa) {
		super(nombreHechizo, "Tierra" , daño);
		this.mejoraDefensa = mejoraDefensa;
	}


	public int getMejoraDefensa() {
		return mejoraDefensa;
	}



	@Override
	public double calcularPuntuacion() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
