package modelo;

public class Producto {
	private String nombre;
	private int id_producto;
	private double precio;
	private String descripcion;
	private String laboratorio;
	private int codigo;
	private String tipo;

	public Producto(String nombre, int id_producto, double precio, String descripcion, String laboratorio, int codigo,
			String tipo) {
		this.nombre = nombre;
		this.id_producto = id_producto;
		this.precio = precio;
		this.descripcion = descripcion;
		this.laboratorio = laboratorio;
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_producto() {
		return id_producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", id_producto=" + id_producto + ", precio=" + precio + ", descripcion="
				+ descripcion + ", laboratorio=" + laboratorio + ", codigo=" + codigo + ", tipo=" + tipo + "]";
	}
	
	

}
