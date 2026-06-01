package taller3;

public class HechizoAgua extends Hechizo {
	private int cantidadHeal;
	private int presionAgua;

	public HechizoAgua(String nombreHechizo, int daño, int cantidadHeal, int presionAgua) {
		super(nombreHechizo, "Agua", daño);
		this.cantidadHeal = cantidadHeal;
		this.presionAgua = presionAgua;
	}


	public int getCantidadHeal() {
		return cantidadHeal;
	}


	public int getPresionAgua() {
		return presionAgua;
	}



	@Override
	public double calcularPuntuacion() {

		return (getDaño() + cantidadHeal + presionAgua) * 2;
	}

}
