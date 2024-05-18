package modelo;

public class Cliente extends Persona {
	private int id_cliente;

	public Cliente(String nombre, int dni, int domicilio_id, int obraSocial_id, int nro_afiliado, int id_cliente) {
		super(nombre, dni, domicilio_id, obraSocial_id, nro_afiliado);
		this.id_cliente = id_cliente;
	}

	public int getId_cliente() {
		return id_cliente;
	}

}
