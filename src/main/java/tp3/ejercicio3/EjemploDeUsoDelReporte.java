package tp3.ejercicio3;

import java.util.List;

public class EjemploDeUsoDelReporte {
    public static void main(String[] args) {
        var desayuno = new Desayuno(1000);
        var cena = new Cena(6000);
        var alquiler = new AlquilerAuto(15000);

        var reporte = new ReporteDeGastos();
        reporte.imprimir(List.of(desayuno, cena, alquiler));
    }
}
