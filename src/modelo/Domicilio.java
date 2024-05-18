package modelo;

public class Domicilio {
	private String calle;
	private int numero;
	private String localidad;
	private String provincia;
	private int id_domicilio;

	public Domicilio(String calle, int numero, String localidad, String provincia, int id_domicilio) {
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.provincia = provincia;
		this.id_domicilio = id_domicilio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getId_domicilio() {
		return id_domicilio;
	}
	

}
