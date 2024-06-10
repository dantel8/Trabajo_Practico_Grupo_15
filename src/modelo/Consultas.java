package modelo;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Field;

import org.bson.Document;
import org.bson.conversions.Bson;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Accumulators.*;

public class Consultas {

	@SuppressWarnings("unused")
	private MongoCollection<Document> ventasCollection;

	public Consultas(MongoCollection<Document> ventasCollection) {
		this.ventasCollection = ventasCollection;
	}

	public void total_ventas_sucursales_entre_fechas(LocalDate desde, LocalDate hasta,
			MongoCollection<Document> collection) {
		Date startDate = Date.from(desde.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// Agregamos 1 día al final paraincluir todo el último día
		Date endDate = Date.from(hasta.atStartOfDay(ZoneId.systemDefault()).plusDays(1).toInstant());

		List<Bson> pipeline = Arrays.asList(
				// convertimos la fecha de String a Date
				addFields(new Field<>("fecha_date",
						new Document("$dateFromString", new Document("dateString", "$fecha")))),

				// filtramos dentro del rango de fechas
				match(and(gte("fecha_date", startDate), lt("fecha_date", endDate))),

				// identifico la sucursal mediante el ticket
				addFields(new Field<>("sucursal",
						new Document("$arrayElemAt",
								Arrays.asList(new Document("$split", Arrays.asList("$num_ticket", "-")), 0)))),

				// agrupo por sucursal y calculo ventas totales por sucursal
				group("$sucursal", sum("total_ventas_por_sucursal", "$total")),
				group(null, sum("total_ventas", "$total_ventas_por_sucursal"),
						push("ventas_por_sucursal",
								new Document("sucursal", "$_id").append("cantidad", "$total_ventas_por_sucursal"))),

				// Resultado final
				project(fields(excludeId(), include("total_ventas", "ventas_por_sucursal"))));

		// hacemos la consulta
		AggregateIterable<Document> result = collection.aggregate(pipeline);
		Document report = result.first();

		// mostramos los resultados
		if (report != null) {
			double totalVentas = report.getDouble("total_ventas");
			System.out.println("=================(Consulta 1)==================");
			System.out.println("Total ventas: $" + totalVentas);

			List<Document> ventasPorSucursal = report.getList("ventas_por_sucursal", Document.class);
			for (Document doc : ventasPorSucursal) {
				String sucursal = doc.getString("sucursal");
				double cantidad = doc.getDouble("cantidad");
				System.out.println("Sucursal " + sucursal + ": Cantidad: $" + cantidad);
			}
		} else {
			System.out.println("No se encontraron ventas en el rango de fechas especificado.");
		}
	}

	public void total_ventas_por_tipo_producto_entre_fechas(LocalDate desde, LocalDate hasta,
			MongoCollection<Document> collection) {
		Date startDate = Date.from(desde.atStartOfDay(ZoneId.systemDefault()).toInstant());
		// Agregamos 1 día al final para incluir todo el último día
		Date endDate = Date.from(hasta.atStartOfDay(ZoneId.systemDefault()).plusDays(1).toInstant()); 

		List<Bson> pipeline = Arrays.asList(
				// convertimos la fecha de String a Date
				addFields(new Field<>("fecha_date",
						new Document("$dateFromString", new Document("dateString", "$fecha")))),

				// filtarmos dentro del rango de fechas
				match(and(gte("fecha_date", startDate), lt("fecha_date", endDate))),

				// agrupa por tipo de producto (farmacia / perfumería) y calcula ventas totales
				// por tipo de producto
				unwind("$carrito"),
				group("$carrito.producto.tipo", sum("total_ventas_por_tipo_producto", "$carrito.cantidad")),

				// resultado final
				project(fields(excludeId(), computed("tipo_producto", "$_id"),
						include("total_ventas_por_tipo_producto"))));

		// hacemos la consulta
		AggregateIterable<Document> result = collection.aggregate(pipeline);
		System.out.println("=================(Consulta 4)==================");
		for (Document doc : result) {
			String tipoProducto = doc.getString("tipo_producto");
			int totalVentas = doc.getInteger("total_ventas_por_tipo_producto");
			System.out.println(tipoProducto + ": " + totalVentas);
		}
	}

}
