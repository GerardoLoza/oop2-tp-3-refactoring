package tp3.ejercicio1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @Test
    public void calcularPago() {
        Libro elTunel = new LibroRegular("El Túnel", Libro.REGULARES);
        Libro antesDelFin = new LibroRegular("Antes del Fin", Libro.REGULARES);
        CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
        CopiaLibro antesDelFinCopia = new CopiaLibro(antesDelFin);
        Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);
        Alquiler alquilerAntesDelFin = new Alquiler(antesDelFinCopia, 3);
        Cliente yo = new Cliente("Javier");
        yo.alquilar(alquilerElTunel);
        yo.alquilar(alquilerAntesDelFin);
        Object[] resultado = yo.calcularDeudaYPuntosObtenidos();
        assertEquals(10.0, resultado[0]);
        assertEquals(2, resultado[1]);
    }

    @Test
    public void calcularPagoInfantiles() {
        Libro elPrincipito = new LibroInfantil("El Principito", Libro.INFANTILES);
        CopiaLibro elPrincipitoCopia = new CopiaLibro(elPrincipito);
        Alquiler alquilerElPrincipito = new Alquiler(elPrincipitoCopia, 5);
        Cliente yo = new Cliente("Benjamin");
        yo.alquilar(alquilerElPrincipito);
        Object[] resultado = yo.calcularDeudaYPuntosObtenidos();
        assertEquals(4.5, resultado[0]);
        assertEquals(1, resultado[1]);
    }

    @Test
    public void calcularPagoRegulares() {
        Libro rebelionEnLaGranja = new LibroRegular("Rebelion en la granja", Libro.REGULARES);
        CopiaLibro rebelionEnLaGranjaCopia = new CopiaLibro(rebelionEnLaGranja);
        Alquiler alquilerRebelionEnLaGranja = new Alquiler(rebelionEnLaGranjaCopia, 10);
        Cliente yo = new Cliente("Hernesto");
        yo.alquilar(alquilerRebelionEnLaGranja);
        Object[] resultado = yo.calcularDeudaYPuntosObtenidos();
        assertEquals(14.0, resultado[0]);
        assertEquals(1, resultado[1]);
    }

    @Test
    public void calcularPagoNuevoLanzamiento() {
        Libro elReino = new LibroNuevoLanzamiento("El Reino", Libro.NUEVO_LANZAMIENTO);
        CopiaLibro elReinoCopia = new CopiaLibro(elReino);
        Alquiler alquilerElReino = new Alquiler(elReinoCopia, 7);
        Cliente yo = new Cliente("Marcelo");
        yo.alquilar(alquilerElReino);
        Object[] resultado = yo.calcularDeudaYPuntosObtenidos();
        assertEquals(21.0, resultado[0]);
        assertEquals(2, resultado[1]);
    }

}
