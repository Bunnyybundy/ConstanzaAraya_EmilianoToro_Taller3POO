package taller3;

import java.util.ArrayList;
import java.util.List;

public class Mago {
	private String nombreMago;
	private List<Hechizo> hechizos;
	
	public Mago(String nombreMago, List<Hechizo> hechizos) {
		this.nombreMago = nombreMago;
		this.hechizos = new ArrayList<>();
	}

	public String getNombreMago() {
		return nombreMago;
	}

	public List<Hechizo> getHechizos() {
		return hechizos;
	}
	
	
}
