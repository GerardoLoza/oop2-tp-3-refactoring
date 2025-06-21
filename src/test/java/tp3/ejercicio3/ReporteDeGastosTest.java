package tp3.ejercicio3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ReporteDeGastosTest {

    private ReporteDeGastos reporte;
    private LocalDate fechaFija;

    @BeforeEach
    public void setUp() {
        fechaFija = LocalDate.of(2024, 1, 15);
        reporte = new ReporteDeGastos(fechaFija);
    }

    @Test
    public void testReporteVacio() {
        String resultado = reporte.generar(List.of());

        String esperado = "Expenses 2024-01-15\n" +
                "Gastos de comida: 0\n" +
                "Total de gastos: 0\n";

        assertEquals(esperado, resultado);
    }

    @Test
    public void testUnSoloDesayuno() {
        var desayuno = new Desayuno(500);
        String resultado = reporte.generar(List.of(desayuno));

        String esperado = "Expenses 2024-01-15\n" +
                "Desayuno\t500\t \n" +
                "Gastos de comida: 500\n" +
                "Total de gastos: 500\n";

        assertEquals(esperado, resultado);
    }

    @Test
    public void testDesayunoConExceso() {
        var desayuno = new Desayuno(1500);
        String resultado = reporte.generar(List.of(desayuno));

        String esperado = "Expenses 2024-01-15\n" +
                "Desayuno\t1500\tX\n" +
                "Gastos de comida: 1500\n" +
                "Total de gastos: 1500\n";

        assertEquals(esperado, resultado);
    }

    @Test
    public void testCenaConExceso() {
        var cena = new Cena(6000);
        String resultado = reporte.generar(List.of(cena));

        String esperado = "Expenses 2024-01-15\n" +
                "Cena\t6000\tX\n" +
                "Gastos de comida: 6000\n" +
                "Total de gastos: 6000\n";

        assertEquals(esperado, resultado);
    }

    @Test
    public void testAlquilerAuto() {
        var alquiler = new AlquilerAuto(15000);
        String resultado = reporte.generar(List.of(alquiler));

        String esperado = "Expenses 2024-01-15\n" +
                "Alquiler de Autos\t15000\t \n" +
                "Gastos de comida: 0\n" +
                "Total de gastos: 15000\n";

        assertEquals(esperado, resultado);
    }

    @Test
    public void testMultiplesGastosConExcesos() {
        List<Gasto> gastos = Arrays.asList(
                new Desayuno(1500), // Exceso
                new Cena(6000),     // Exceso
                new Desayuno(800),  // Sin exceso
                new AlquilerAuto(25000)
        );

        String resultado = reporte.generar(gastos);

        String esperado = "Expenses 2024-01-15\n" +
                "Desayuno\t1500\tX\n" +
                "Cena\t6000\tX\n" +
                "Desayuno\t800\t \n" +
                "Alquiler de Autos\t25000\t \n" +
                "Gastos de comida: 8300\n" +
                "Total de gastos: 33300\n";

        assertEquals(esperado, resultado);
    }
}
