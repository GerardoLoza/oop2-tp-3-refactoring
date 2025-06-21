package tp3.ejercicio3;

public class Desayuno extends Gasto {
    private static final int LIMITE_EXCESO = 1000;

    public Desayuno(int monto) {
        super(monto);
    }

    @Override
    public String obtenerNombre() {
        return "Desayuno";
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
