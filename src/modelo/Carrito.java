package modelo;

public class Carrito {
	private Producto producto;
	private int cantidad;
	private double subtotal;

	public Carrito(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.subtotal = producto.getPrecio()*cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "Carrito [producto=" + producto + ", cantidad=" + cantidad + ", subtotal=" + subtotal + "]";
	}
	
	

}
