

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestVenta {
	Prenda pantalonNuevo = new Prenda(new Nueva(), 100, TipoPrenda.PANTALON);
	Prenda camisaEnLiquidacion = new Prenda(new Liquidacion(), 200, TipoPrenda.CAMISA);
	Prenda sacoEnPromocion = new Prenda(new Promocion(5), 105, TipoPrenda.SACO);
	
	List<Item> items = Arrays.asList(new Item(pantalonNuevo, 1), new Item(camisaEnLiquidacion, 1), new Item(sacoEnPromocion, 1));
	LocalDate fechaDeHoy = LocalDate.now();
	Venta ventaDeHoy = new Venta(items, fechaDeHoy);
	
	Registro registro = new Registro();
	
	@Test
	public void laVentaDeHoSale300() {
		Assert.assertEquals(300, ventaDeHoy.importe(), 0);
	}
	
	@Test
	public void laGananciaDeHoyEs300() {
		registro.nuevaVenta(ventaDeHoy);
		Assert.assertEquals(300, registro.gananciasDelDia(fechaDeHoy), 0);
	}

}
