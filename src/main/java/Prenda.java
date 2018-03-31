
enum TipoPrenda {
	CAMISA, PANTALON, SACO
}


public class Prenda {
	Estado estado;
	double precioBase;
	TipoPrenda tipo;
	
	Prenda(Estado estado, double precioBase, TipoPrenda tipo){
		this.estado = estado;
		this.precioBase = precioBase;
		this.tipo = tipo;
	}
	
	double precio() {
		return estado.precioFinal(precioBase);
	}
}

interface Estado{
	double precioFinal(double precioBase);
}

class Nueva implements Estado{
	public double precioFinal(double precioBase) {
		return precioBase;
	}
}

class Promocion implements Estado {
	double valorFijo;
	
	Promocion(double valorFijo){
		this.valorFijo = valorFijo;
	}
	
	public double precioFinal(double precioBase) {
		return precioBase - valorFijo;
	}
}

class Liquidacion implements Estado{
	public double precioFinal(double precioBase) {
		return precioBase * 0.5;
	}
}
