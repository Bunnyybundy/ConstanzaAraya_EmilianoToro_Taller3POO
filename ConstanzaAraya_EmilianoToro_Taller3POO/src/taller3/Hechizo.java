package taller3;

public abstract class Hechizo {
	private String nombreHechizo;
	private String tipo;
	private int daño;
	
	public Hechizo(String nombreHechizo, String tipo, int daño) {
		this.nombreHechizo = nombreHechizo;
		this.tipo = tipo;
		this.daño = daño;
	}

	public String getNombreHechizo() {
		return nombreHechizo;
	}

	public String getTipo() {
		return tipo;
	}

	public int getDaño() {
		return daño;
	}
	
	
}
