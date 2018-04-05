

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Registro {
	List<Venta> ventas = new ArrayList<>();
	
	double gananciasDelDia(LocalDate unaFecha) {
		return ventas.stream().
			filter(venta -> venta.esDelDia(unaFecha)).
			mapToDouble(venta -> venta.importe()).
			sum();
	}
	
	void nuevaVenta(Venta venta) {
		ventas.add(venta);
	}
}