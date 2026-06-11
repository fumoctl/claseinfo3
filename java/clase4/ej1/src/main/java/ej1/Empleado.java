package ej1;

public class Empleado extends Persona implements Trabajador {
	private String puesto;

	public Empleado(String nombre, int edad, String puesto) {
		super(nombre, edad);
		this.puesto = puesto;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public void mostrarPuesto() {
		System.out.println("Puesto: " + puesto);
	}

	@Override
	public void trabajar() {
		System.out.println(getNombre() + " esta trabajando como " + puesto + ".");
	}
}
