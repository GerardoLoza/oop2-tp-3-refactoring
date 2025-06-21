package tp3.ejercicio3;

public abstract class Gasto {
    protected int monto;

    public Gasto(int monto) {
        this.monto = monto;
    }

    public abstract String obtenerNombre();

    public abstract boolean esComida();

    public abstract boolean tieneExceso();

    public int obtenerMonto() {
        return monto;
    }

    public String generarLineaReporte() {
        String marcaExceso = tieneExceso() ? "X" : " ";
        return obtenerNombre() + "\t" + monto + "\t" + marcaExceso;
    }
}
