import org.junit.Assert;
import org.junit.Test;

public class TestPrenda {
	
	Prenda pantalonNuevo = new Prenda(new Nueva(), 100, TipoPrenda.PANTALON);
	Prenda camisaEnLiquidacion = new Prenda(new Liquidacion(), 200, TipoPrenda.CAMISA);
	Prenda sacoEnPromocion = new Prenda(new Promocion(5), 105, TipoPrenda.SACO);
	
	@Test
	public void unPantalonNuevoNoVariaSuPrecio() {
		Assert.assertEquals(100, pantalonNuevo.precio(), 0);
	}
	
	@Test
	public void unaRemeraEnPromocionSaleMenos() {
		Assert.assertEquals(100, camisaEnLiquidacion.precio(), 0);
	}
	
	@Test
	public void unSacoEnLiquidacionSaleMenos() {
		Assert.assertEquals(100, sacoEnPromocion.precio(), 0);
	}
}