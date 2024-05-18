package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {
	private LocalDate fecha;
	private String num_ticket;
	private double total;
	private String metodo_pago;
	private List<Carrito> carrito;
	private Empleado empleado_atencion;
	private Empleado empleado_cobro;

	public Venta(LocalDate fecha, String num_ticket, double total, String metodo_pago, Empleado empleado_atencion,
			Empleado empleado_cobro) {
		this.fecha = fecha;
		this.num_ticket = num_ticket;
		this.total = 0;
		this.metodo_pago = metodo_pago;
		this.carrito = new ArrayList<Carrito>();
		this.empleado_atencion = empleado_atencion;
		this.empleado_cobro = empleado_cobro;
	}

	public int agregarCarrito(List<Carrito> listCarrito) {

		for (int i = 0; i < listCarrito.size(); i++) {
			carrito.add(listCarrito.get(i));
		}

		return 1;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getNum_ticket() {
		return num_ticket;
	}

	public double getTotal() {
		return total;
	}

	public String getMetodo_pago() {
		return metodo_pago;
	}

	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}

	public List<Carrito> getCarrito() {
		return carrito;
	}

	public Empleado getEmpleado_atencion() {
		return empleado_atencion;
	}

	public void setEmpleado_atencion(Empleado empleado_atencion) {
		this.empleado_atencion = empleado_atencion;
	}

	public Empleado getEmpleado_cobro() {
		return empleado_cobro;
	}

	public void setEmpleado_cobro(Empleado empleado_cobro) {
		this.empleado_cobro = empleado_cobro;
	}

	@Override
	public String toString() {
		return "Venta [fecha=" + fecha + ", num_ticket=" + num_ticket + ", total=" + total + ", metodo_pago="
				+ metodo_pago + ", carrito=" + carrito + ", empleado_atencion=" + empleado_atencion
				+ ", empleado_cobro=" + empleado_cobro + "]";
	}

}
