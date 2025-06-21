package tp3.ejercicio2;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorCsv {
    private String rutaArchivo;

    public LectorCsv(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public List<String[]> loadData() throws IOException {
        List<String[]> csvData = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader(rutaArchivo));
        String[] row;

        while ((row = reader.readNext()) != null) {
            csvData.add(row);
        }
        reader.close();

        if (!csvData.isEmpty()) {
            csvData.remove(0);
        }

        return csvData;
    }
}
