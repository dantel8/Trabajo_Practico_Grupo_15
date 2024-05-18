package modelo;

public class ObraSocial {
	private String nombre;
	private int id_obra_social;

	public ObraSocial(String nombre, int id_obra_social) {
		this.nombre = nombre;
		this.id_obra_social = id_obra_social;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_obra_social() {
		return id_obra_social;
	}

}
