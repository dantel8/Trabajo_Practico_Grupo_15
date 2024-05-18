package modelo;

public class Persona {
	private String nombre;
	private int dni;
	private int domicilio_id;
	private int obraSocial_id;
	private int nro_afiliado;

	public Persona(String nombre, int dni, int domicilio_id, int obraSocial_id, int nro_afilido) {
		this.nombre = nombre;
		this.dni = dni;
		this.domicilio_id = domicilio_id;
		this.obraSocial_id = obraSocial_id;
		this.nro_afiliado = obraSocial_id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDni() {
		return dni;
	}

	public int getDomicilio() {
		return domicilio_id;
	}

	public void setDomicilio(int domicilio_id) {
		this.domicilio_id = domicilio_id;
	}

	public int getObraSocial() {
		return obraSocial_id;
	}

	public void setObraSocial(int obraSocial_id) {
		this.obraSocial_id = obraSocial_id;
	}

	public int getNro_afiliado() {
		return nro_afiliado;
	}

	public void setNro_afiliado(int nro_afiliado) {
		this.nro_afiliado = nro_afiliado;
	}

}
