package taller3;
 
import java.util.ArrayList;
 
public class gestorHechizos {
	private ArrayList<Hechizo> hechizos;
 
	public gestorHechizos() {
		this.hechizos = new ArrayList<>();
	}
 
	public void agregarHechizo(Hechizo h) {
		hechizos.add(h);
	}
 
	public void modificarHechizo(String nombre, Hechizo nuevo) {
		for(int i = 0; i < hechizos.size(); i++) {
			if(hechizos.get(i).getNombreHechizo().equals(nombre)) {
				hechizos.set(i, nuevo);
				return;
			}
		}
	}
 
	public void eliminarHechizo(String nombre) {
		hechizos.removeIf(h -> h.getNombreHechizo().equals(nombre));
	}
 
	public ArrayList<Hechizo> getHechizos() {
		return hechizos;
	}
 
	public Hechizo buscarPorNombre(String nombre) {
		for(Hechizo h : hechizos) {
			if(h.getNombreHechizo().equals(nombre)) {
				return h;
			}
		}
		return null;
	}
 
	public void mostrarHechizos() {
		for(Hechizo h : hechizos) {
			System.out.println("Hechizo: " + h.getNombreHechizo() + " | Tipo: " + h.getTipo() + " | Puntuacion: " + h.calcularPuntuacion());
		}
	}
}
