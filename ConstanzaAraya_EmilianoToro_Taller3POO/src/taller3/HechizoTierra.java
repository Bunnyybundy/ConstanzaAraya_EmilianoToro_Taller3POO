package taller3;

public class HechizoTierra extends Hechizo implements Calcular{
	private int presionDelAgua;

	public HechizoTierra(String nombreHechizo, String tipo, int daño, int presionDelAgua) {
		super(nombreHechizo, tipo, daño);
		this.presionDelAgua = presionDelAgua;
	}

	public int getPresionDelAgua() {
		return presionDelAgua;
	}

	@Override
	public void calcularPuntuacionHechizos() {
		// TODO Auto-generated method stub
		
	}
	
	
}
