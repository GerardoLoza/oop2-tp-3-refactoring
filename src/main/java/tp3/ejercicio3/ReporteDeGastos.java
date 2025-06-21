package tp3.ejercicio3;

import java.time.LocalDate;
import java.util.List;

public class ReporteDeGastos {
    private LocalDate fecha;

    public ReporteDeGastos(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ReporteDeGastos() {
        this.fecha = LocalDate.now();
    }

    public String generar(List<Gasto> gastos) {
        StringBuilder reporte = new StringBuilder();
        int total = 0;
        int gastosDeComida = 0;

        reporte.append("Expenses ").append(fecha).append("\n");

        for (Gasto gasto : gastos) {
            if (gasto.esComida()) {
                gastosDeComida += gasto.obtenerMonto();
            }
            reporte.append(gasto.generarLineaReporte()).append("\n");
            total += gasto.obtenerMonto();
        }

        reporte.append("Gastos de comida: ").append(gastosDeComida).append("\n");
        reporte.append("Total de gastos: ").append(total).append("\n");

        return reporte.toString();
    }

    public void imprimir(List<Gasto> gastos) {
        System.out.print(generar(gastos));
    }
}
