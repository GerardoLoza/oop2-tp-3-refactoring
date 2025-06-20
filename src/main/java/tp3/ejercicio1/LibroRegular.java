package tp3.ejercicio1;

public class LibroRegular extends Libro {
    private final double PRECIO_BASE = 2.0;
    private final double RECARGO_EXTRA = 1.5;
    public LibroRegular(String nombre, int priceCode) {
        super(nombre, priceCode);
    }

    @Override
    public double calcularMonto(int diasAlquilados) {
        double monto = PRECIO_BASE;
        if (diasAlquilados > 2) {
            monto += (diasAlquilados - 2) * RECARGO_EXTRA;
        }
        return monto;
    }

    @Override
    public int calcularPuntosBonus(int diasAlquilados) {
        return 0;
    }
}
