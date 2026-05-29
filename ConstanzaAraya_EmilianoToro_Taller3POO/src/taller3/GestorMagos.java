package taller3;

import java.util.ArrayList;

public class GestorMagos {
	private ArrayList<Mago> magos;

	public GestorMagos() {
		this.magos = new ArrayList<>();
	}
	public void agregarMago(Mago m) {
		magos.add(m);
	}
	
	public void modificarMago(String nombre, Mago nuevo) {
		for(int i = 0; i< magos.size(); i++) {
			if(magos.get(i).getNombreMago().equals(nombre)) {
				magos.set(i, nuevo);
				return;
			}
		}
	}
	
	public void eliminarMago(String nombre) {
		magos.removeIf(m -> m.getNombreMago().equals(nombre));
	}
	public ArrayList<Mago> getMagos() {
		return magos;
	}
	public void mostrarMagos() {
		for(Mago m: magos) {
			System.out.println("Mago: " + m.getNombreMago() + " | Puntuacion: " + m.calcularPuntuacionTotal());
		}
	}
}
