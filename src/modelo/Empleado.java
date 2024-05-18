package modelo;

public class Empleado extends Persona {
	private String cuil;
	private int empleado_id;

	public Empleado(String nombre, int dni, int domicilio_id, int obraSocial_id, int nro_afiliado, String cuil,
			int empleado_id) {
		super(nombre, dni, domicilio_id, obraSocial_id, nro_afiliado);
		this.cuil = cuil;
		this.empleado_id = empleado_id;
	}

	public String getCuil() {
		return cuil;
	}

	public int getEmpleado_id() {
		return empleado_id;
	}

}
