package tp3.ejercicio1;

public class LibroInfantil extends Libro {
    private final double PRECIO_BASE = 1.5;
    public LibroInfantil(String nombre, int priceCode) {
        super(nombre, priceCode);
    }

    @Override
    public double calcularMonto(int diasAlquilados) {
        double monto = PRECIO_BASE;
        if (diasAlquilados > 3) {
            monto += (diasAlquilados - 3) * 1.5;
        }
        return monto;
    }

    @Override
    public int calcularPuntosBonus(int diasAlquilados) {
        return 0;
    }
}
