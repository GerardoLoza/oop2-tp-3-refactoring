package tp3.ejercicio1;

public class LibroNuevoLanzamiento extends Libro {
    private final double PRECIO_BASE = 3.0;
    public LibroNuevoLanzamiento(String nombre, int priceCode) {
        super(nombre, priceCode);
    }

    @Override
    public double calcularMonto(int diasAlquilados) {
        return diasAlquilados * PRECIO_BASE;
    }

    @Override
    public int calcularPuntosBonus(int diasAlquilados) {
        if (diasAlquilados > 1) {
            return 1;
        } else {
            return 0;
        }
    }
}
