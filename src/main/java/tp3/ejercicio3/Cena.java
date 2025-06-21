package tp3.ejercicio3;

public class Cena extends Gasto {
    private static final int LIMITE_EXCESO = 5000;

    public Cena(int monto) {
        super(monto);
    }

    @Override
    public String obtenerNombre() {
        return "Cena";
    }

    @Override
    public boolean esComida() {
        return true;
    }

    @Override
    public boolean tieneExceso() {
        return monto > LIMITE_EXCESO;
    }
}
