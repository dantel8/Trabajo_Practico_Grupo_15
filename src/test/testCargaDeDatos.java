package test;

import modelo.Cliente;
import modelo.Consultas;
import modelo.Domicilio;
import modelo.Empleado;
import modelo.ObraSocial;
import modelo.Producto;
import modelo.Sucursal;
import modelo.Venta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class testCargaDeDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//======================================================= CARGA DE DOMICILIO ==============================================================================
		
		Domicilio d1 = new Domicilio("Avenida Corrientes", 1234, "Buenos Aires", "Buenos Aires", 1);
		Domicilio d2 = new Domicilio("Calle Florida", 567, "CABA", "Buenos Aires", 2);
		Domicilio d3 = new Domicilio("Avenida Belgrano", 789, "Rosario", "Santa Fe", 3);
		Domicilio d4 = new Domicilio("Calle San Martín", 1011, "Córdoba", "Córdoba", 4);
		Domicilio d5 = new Domicilio("Avenida Libertador", 1213, "Mendoza", "Mendoza", 5);
		Domicilio d6 = new Domicilio("Calle Mitre", 1415, "Mar del Plata", "Buenos Aires", 6);
		Domicilio d7 = new Domicilio("Avenida 9 de Julio", 1617, "Tucumán", "Tucumán", 7);
		Domicilio d8 = new Domicilio("Calle Maipú", 1819, "Salta", "Salta", 8);
		
		//======================================================= CARGA DE OBRA SOCIAL ==============================================================================

		ObraSocial os1 = new ObraSocial("OSDE", 1);
		ObraSocial os2 = new ObraSocial("Swiss Medical", 2);
		ObraSocial os3 = new ObraSocial("Galeno", 3);
		ObraSocial os4 = new ObraSocial("Medicus", 4);

		//======================================================= CARGA DE EMPLEADOS ==============================================================================
		
		Empleado e1 = new Empleado("Dante Lugo", 43994935, d1.getId_domicilio(), os1.getId_obra_social(), 1234, "20-43994935-0", 1);// nombre, dni, domicilio, obra social,nro afiliado, cuil
		Empleado e2 = new Empleado("Peter Griffin", 49684573, d2.getId_domicilio(), os3.getId_obra_social(), 2345, "20-49684573-4", 2);// nombre, dni, domicilio, obra social,nro afiliado, cuil
		Empleado e3 = new Empleado("Bart Simposon", 29384396, d4.getId_domicilio(), os4.getId_obra_social(), 3456, "20-29384396-6", 3);// nombre, dni, domicilio, obra social,nro afiliado, cuil
		Empleado e4 = new Empleado("Rick Sanchez", 24936047, d3.getId_domicilio(), os2.getId_obra_social(), 4567, "20-24936047-0", 4);// nombre, dni, domicilio, obra social,nro afiliado, cuil
		
		//======================================================= CARGA DE CLIENTES ==============================================================================

		Cliente c1 = new Cliente("Juan García", 12345678, d5.getId_domicilio(), os4.getId_obra_social(), 5678, 1);// nombre, dni, domicilio, obrasocial, cliente_id
		Cliente c2 = new Cliente("María Rodríguez", 23456789, d6.getId_domicilio(), os2.getId_obra_social(), 6789, 2);// nombre, dni, domicilio, obrasocial, cliente_id
		Cliente c3 = new Cliente("Juan García", 12345678, d7.getId_domicilio(), os3.getId_obra_social(), 7890, 3);// nombre, dni, domicilio, obrasocial, cliente_id
		Cliente c4 = new Cliente("Juan García", 12345678, d8.getId_domicilio(), os1.getId_obra_social(), 8901, 4);// nombre, dni, domicilio, obrasocial, cliente_id
		
		//======================================================= CARGA DE PRODUCTOS ==============================================================================

		Producto p1 = new Producto("Perfume Floral", 101, 50.99, "Fragancia floral suave y fresca", "Perfumes S.A.",
				123456, "Perfumería");
		Producto p2 = new Producto("Loción Corporal Coco", 102, 12.75, "Hidratación profunda con aroma a coco",
				"Cosméticos Elegance", 234567, "Perfumería");
		Producto p3 = new Producto("Agua de Colonia Citrus", 103, 18.50, "Aroma cítrico revitalizante",
				"Fragancias del Sol", 345678, "Perfumería");
		Producto p4 = new Producto("Eau de Toilette Vainilla", 104, 25.99, "Fragancia dulce y envolvente",
				"Belleza Aromática", 456789, "Perfumería");
		Producto p5 = new Producto("Perfume Floral Fresco", 105, 30.49, "Fragancia floral refrescante",
				"Aromas Naturales", 567890, "Perfumería");
		Producto p6 = new Producto("Crema Corporal Almendra", 106, 14.99, "Hidratación intensa con aroma a almendra",
				"Naturaleza y Belleza", 678901, "Perfumería");
		Producto p7 = new Producto("Colonía Infantil", 107, 8.25, "Fragancia suave y delicada para bebés",
				"Bebé Perfumado", 789012, "Perfumería");
		Producto p8 = new Producto("Perfume Floral Nocturno", 108, 35.75, "Fragancia floral sensual para la noche",
				"Noches Encantadas", 890123, "Perfumería");
		Producto p9 = new Producto("Aceite de Baño Lavanda", 109, 20.99, "Relajación total con aroma a lavanda",
				"Spa Sensaciones", 901234, "Perfumería");
		Producto p10 = new Producto("Agua de Rosas", 110, 15.49, "Tónico facial refrescante y tonificante",
				"Rosas del Valle", 123456, "Perfumería");

		Producto p11 = new Producto("Ibuprofeno 400mg", 201, 7.99, "Alivio rápido del dolor y la inflamación",
				"Farmacias Unidos", 123456, "Farmacia");
		Producto p12 = new Producto("Paracetamol 500mg", 202, 5.50, "Reducción de la fiebre y el dolor leve",
				"Salud Farmacéutica", 234567, "Farmacia");
		Producto p13 = new Producto("Vitamina C 1000mg", 203, 9.75, "Refuerzo del sistema inmunológico", "Vida Natural",
				345678, "Farmacia");
		Producto p14 = new Producto("Gel Antibacterial 70%", 204, 4.25, "Limpieza y desinfección de manos", "BioSalud",
				456789, "Farmacia");
		Producto p15 = new Producto("Loción Solar FPS 50", 205, 15.99, "Protección alta contra los rayos UV",
				"Protección Solar", 567890, "Farmacia");
		Producto p16 = new Producto("Jarabe para la Tos", 206, 8.49, "Alivio de la tos seca y productiva",
				"Farmacias Unidos", 678901, "Farmacia");
		Producto p17 = new Producto("Antibiótico Amoxicilina 500mg", 207, 12.99,
				"Tratamiento de infecciones bacterianas", "Salud Farmacéutica", 789012, "Farmacia");
		Producto p18 = new Producto("Parches Anticonceptivos", 208, 19.75, "Método anticonceptivo hormonal",
				"Farmacias Unidos", 890123, "Farmacia");
		Producto p19 = new Producto("Cepillo Dental Eléctrico", 209, 39.99, "Limpieza profunda y eficaz", "BioSalud",
				901234, "Farmacia");
		Producto p20 = new Producto("Pastillas para la Acidez Estomacal", 210, 6.25,
				"Alivio rápido de la acidez y el malestar estomacal", "Vida Natural", 123456, "Farmacia");

		//======================================================= CARGA DE SUCURSAL ==========================================================================

		// instanciamos una sucursal con domicilio y un encargado
		Sucursal s1 = new Sucursal(d1.getId_domicilio(), e3.getEmpleado_id(),"0001");//domicilio, encargado y numero de sucursal 000"n"
		Sucursal s2 = new Sucursal(d1.getId_domicilio(), e2.getEmpleado_id(),"0002");
		Sucursal s3 = new Sucursal(d1.getId_domicilio(), e3.getEmpleado_id(),"0003");

		//================================================= AGREGAMOS EMPLEADOS A LAS SUCURSALES ===========================================================
		
		// se cargan los empleados que trabajan en la sucursal
		s1.agregarEmpleado(e1);
		s1.agregarEmpleado(e2);
		
		s2.agregarEmpleado(e3);
		s2.agregarEmpleado(e4);
		
		s3.agregarEmpleado(e2);
		s3.agregarEmpleado(e4);
		
		//======================================================= CARGA DE VENTAS ==========================================================================
		
		//hacemos una lista de productos para fines mas practicos
		List<Producto> listProductos = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20);
		
		// se cargan 10 ventas a la surcursal 1
		s1.cargarVenta("Tarjeta de Credito", e1, e2, listProductos);
		s1.cargarVenta("Tarjeta de Debito", e1, e2, listProductos);
		s1.cargarVenta("Mercado Pago", e2, e1, listProductos);
		s1.cargarVenta("QR", e1, e2, listProductos);
		s1.cargarVenta("Efectivo", e1, e2, listProductos);
		s1.cargarVenta("Tarjeta de Credito", e2, e1, listProductos);
		s1.cargarVenta("Tarjeta de Debito", e2, e1, listProductos);
		s1.cargarVenta("Mercado Pago", e1, e2, listProductos);
		s1.cargarVenta("QR", e1, e2, listProductos);
		s1.cargarVenta("Efectivo", e1, e2, listProductos);
		
		// se cargan 10 ventas a la surcursal 2
		s2.cargarVenta("Tarjeta de Credito", e3, e4, listProductos);
		s2.cargarVenta("Tarjeta de Credito", e4, e3, listProductos);
		s2.cargarVenta("Mercado Pago", e3, e4, listProductos);
		s2.cargarVenta("Mercado Pago", e4, e3, listProductos);
		s2.cargarVenta("Efectivo", e4, e3, listProductos);
		s2.cargarVenta("Efectivo", e3, e4, listProductos);
		s2.cargarVenta("Tarjeta de Debito", e3, e4, listProductos);
		s2.cargarVenta("Tarjeta de Debito", e4, e3, listProductos);
		s2.cargarVenta("QR", e4, e3, listProductos);
		s2.cargarVenta("QR", e4, e3, listProductos);
		
		// se cargan 10 ventas a la surcursal 3
		s3.cargarVenta("Efectivo", e2, e4, listProductos);
		s3.cargarVenta("QR", e4, e2, listProductos);
		s3.cargarVenta("Mercado Pago", e2, e4, listProductos);
		s3.cargarVenta("Tarjeta de Debito", e4, e2, listProductos);
		s3.cargarVenta("Tarjeta de Credito", e4, e2, listProductos);
		s3.cargarVenta("Tarjeta de Credito", e2, e4, listProductos);
		s3.cargarVenta("Tarjeta de Debito", e2, e4, listProductos);
		s3.cargarVenta("Mercado Pago", e4, e2, listProductos);
		s3.cargarVenta("QR", e4, e2, listProductos);
		s3.cargarVenta("Efectivo", e4, e2, listProductos);
		
		//==================================== CREACION DEL JSON CON LAS VENTAS DE LAS 3 SUCURSALES ====================================================
		
		//guardo las ventas de las 3 sucursales en una lista
		ArrayList<Venta> ventas_sucursales = new ArrayList<Venta>();
		
		ventas_sucursales.addAll(s1.getVentas());
		ventas_sucursales.addAll(s2.getVentas());
		ventas_sucursales.addAll(s3.getVentas());
		

		//trasnformamos la ventas_sucursales.java ya cargada en un archivo json
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd")); //formato de fecha "año-mes-dia"

		try {
		    //Guarda la lista de ventas en un archivo JSON
		    mapper.writeValue(new File("ventas_de_sucursales.json"), ventas_sucursales);
		    System.out.println("JSON generado y guardado en ventas_de_sucursales.json");
		} catch (IOException e) {
		    e.printStackTrace();
		}

		//=============================================== CONEXION Y CARGA A LA BASE DE DATOS ==========================================================
		
		//conectamos con mongo (host y puerto default)
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        //conexión a la base de datos
        MongoDatabase database = mongoClient.getDatabase("grupo_15");
        MongoCollection<Document> collection = database.getCollection("ventas_grupo_15");
        
        //vamos a verificar que la base de datos este vacia/no exista para poder agregar datos/crearla
		if (collection.countDocuments() == 0) {
			// se insertamos cada venta en la coleccion
			for (Venta venta : ventas_sucursales) {
				try {
					// convertimos cada objeto venta a un documento de mongo
					String jsonString = mapper.writeValueAsString(venta);
					Document document = Document.parse(jsonString);

					// subimos el documento a mongo
					collection.insertOne(document);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("JSON insertado con éxito!");
			}
		} else {
			System.out.println("La colección ya contiene datos.");
		}
        
		//=============================================== CONSULTAS 1 Y 4 A LA BASE DE DATOS MONGO BD Y MOSTRADOS POR CONSOLA ==========================================================
		
        Consultas report = new Consultas(collection);
        
        report.total_ventas_sucursales_entre_fechas(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31), collection);
        report.total_ventas_por_tipo_producto_entre_fechas(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31), collection);

        //cerrando la conexión
        mongoClient.close();
        
	}
}
