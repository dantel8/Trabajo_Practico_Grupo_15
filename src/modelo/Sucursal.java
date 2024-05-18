package modelo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sucursal {
	private List<Empleado> empleados;
	private int domicilio_id;
	private int encargado_empleado_id;
	private List<Venta> ventas;
	private String nro_sucursal;

	public Sucursal(int domicilio_id, int encargado_empleado_id, String nro_sucursal) {
		this.empleados = new ArrayList<Empleado>();
		this.domicilio_id = domicilio_id;
		this.encargado_empleado_id = encargado_empleado_id;
		this.ventas = new ArrayList<Venta>();
		this.nro_sucursal = nro_sucursal;
	}

	public int cargarVenta(String metodoPago, Empleado emplea_atencion, Empleado emplea_cobro,
			List<Producto> productos) {
		// SE CALCULAN ESTOS DATOS POR FINES PRACTICOS PARA AGILIZAR LA CARGA DE VENTAS,
		// NO VIENE AL CASO CON EL TRABAJO
		// =====================================================================================================================================

		Random rand = new Random();

		int cantidadCarritos = rand.nextInt(10) + 1;//carrito que contienen productos y sus cantidades
		int i = 0;
		List<Carrito> carr = new ArrayList<Carrito>();

		while (i != cantidadCarritos) {
			// genera la posicion aleatoria del producto entre 0 y 19
			int productoIndex = rand.nextInt(20);
			// genera la cantidad aleatoria de productos que van a ir en el
			int cantidadProductos = rand.nextInt(5) + 1;
			
			Carrito aux = new Carrito(productos.get(productoIndex), cantidadProductos);
			// agrego al carrito, el auxiliar que contiene el producto con su cantidad
			carr.add(aux);
			i++;
		}

		int numero_incremental = 1;
		if (!this.ventas.isEmpty()) {
			String ultimo_num_ticket = this.ventas.get(this.ventas.size() - 1).getNum_ticket().split("-")[1];
			numero_incremental = Integer.parseInt(ultimo_num_ticket) + 1;
		}
		// generamos el numero de ticket con el formato 0001-00001234
		String num_ticket = String.format("%04d-%08d", Integer.parseInt(this.nro_sucursal), numero_incremental);

		double total = 0;

		for (int j = 0; j < carr.size(); j++) {
			total = total + carr.get(j).getSubtotal();// se calcula el total, sumando cada sub total de cada carrito con su producto y cantidad
		}
		// =====================================================================================================================================

		// se crea la venta con (fecha aletoria, numero de ticket ya calculado
		// automaticamente y total calculado)
		int dia = rand.nextInt(30) + 1;
		int mes = rand.nextInt(12) + 1;
		int anio = 2024;

		Venta venta = new Venta(LocalDate.of(anio, mes, dia), num_ticket, total, metodoPago, emplea_atencion,
				emplea_cobro);
		venta.agregarCarrito(carr);// agregamos el carrito a la venta

		// se agrega a las ventas de la sucursal la venta anterior
		this.ventas.add(venta);

		return 1;
	}

	public int agregarEmpleado(Empleado e) {

		if (e == null) {
			return 0;
		}

		this.empleados.add(e);

		return 1;
	}

	public void mostrarVentas() {
		if (ventas.isEmpty()) {
			System.out.println("No hay ventas registradas.");
		} else {
			for (Venta venta : ventas) {
				System.out.println(venta);
			}
		}
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public int getDomicilio_id() {
		return domicilio_id;
	}

	public int getEncargado_id() {
		return encargado_empleado_id;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public String getNro_sucursal() {
		return nro_sucursal;
	}

}
