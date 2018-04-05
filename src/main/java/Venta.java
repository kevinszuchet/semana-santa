

import java.time.LocalDate;
import java.util.List;

public class Venta {
	List<Item> items;
	
	LocalDate fecha;
	
	Venta(List<Item> items, LocalDate fecha){
		this.items = items;
		this.fecha = fecha;
	}
	
	double importe() {
		return items.stream().mapToDouble(item -> item.subtotal()).sum();
	}
	
	boolean esDelDia(LocalDate unaFecha) {
		return unaFecha.isEqual(unaFecha);
	}
	
}

class VentaTarjeta extends Venta{
	int cantidadCuotas;
	double coeficiente;
	
	VentaTarjeta(List<Item> items, LocalDate fecha, int cantidadCuotas, double coeficiente) {
		super(items, fecha);
		this.cantidadCuotas = cantidadCuotas;
		this.coeficiente = coeficiente;
	}
	
	double importe() {
		return super.importe() + recargo();
	}
	
	double recargo() {
		return super.importe() * 0.01  + cantidadCuotas * coeficiente;
	}
}

class Item{
	int cantidad;
	Prenda prenda;
	
	Item(Prenda prenda, int cantidad){
		this.cantidad = cantidad;
		this.prenda = prenda;
	}
	
	double subtotal() {
		return prenda.precio() * cantidad;
	}
}
