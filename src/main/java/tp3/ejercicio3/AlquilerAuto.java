package tp3.ejercicio3;

public class AlquilerAuto extends Gasto {

    public AlquilerAuto(int monto) {
        super(monto);
    }

    @Override
    public String obtenerNombre() {
        return "Alquiler de Autos";
    }

    @Override
    public boolean esComida() {
        return false;
    }

    @Override
    public boolean tieneExceso() {
        return false;
    }
}
