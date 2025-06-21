package tp3.ejercicio2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recaudacion {
    private static final String COMPANY_NAME = "company_name";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String ROUND = "round";
    private static final String PERMALINK = "permalink";
    private static final String NUMBER_EMPLOYEES = "number_employees";
    private static final String CATEGORY = "category";
    private static final String FUNDED_DATE = "funded_date";
    private static final String RAISED_AMOUNT = "raised_amount";
    private static final String RAISED_CURRENCY = "raised_currency";

    private static final int PERMALINK_INDEX = 0;
    private static final int COMPANY_NAME_INDEX = 1;
    private static final int NUMBER_EMPLOYEES_INDEX = 2;
    private static final int CATEGORY_INDEX = 3;
    private static final int CITY_INDEX = 4;
    private static final int STATE_INDEX = 5;
    private static final int FUNDED_DATE_INDEX = 6;
    private static final int RAISED_AMOUNT_INDEX = 7;
    private static final int RAISED_CURRENCY_INDEX = 8;
    private static final int ROUND_INDEX = 9;

    private List<String[]> csvData;
    private LectorCsv dataLoader;

    public Recaudacion(String rutaArchivo) throws IOException {
        this.dataLoader = new LectorCsv(rutaArchivo);
        this.csvData = dataLoader.loadData();
    }

    public List<Map<String, String>> where(Map<String, String> options) {
        List<String[]> filteredData = new ArrayList<>(csvData);

        Map<String, Integer> fieldIndexMap = Map.of(
                COMPANY_NAME, COMPANY_NAME_INDEX,
                CITY, CITY_INDEX,
                STATE, STATE_INDEX,
                ROUND, ROUND_INDEX
        );

        for (Map.Entry<String, String> entry : options.entrySet()) {
            String field = entry.getKey();
            String value = entry.getValue();

            if (fieldIndexMap.containsKey(field)) {
                int index = fieldIndexMap.get(field);
                filteredData = filterByColumn(filteredData, index, value);
            }
        }

        return convertToMapList(filteredData);
    }

    private List<String[]> filterByColumn(List<String[]> data, int columnIndex, String value) {
        List<String[]> results = new ArrayList<>();

        for (String[] row : data) {
            if (row[columnIndex].equals(value)) {
                results.add(row);
            }
        }
        return results;
    }

    private List<Map<String, String>> convertToMapList(List<String[]> data) {
        List<Map<String, String>> output = new ArrayList<>();

        for (String[] row : data) {
            Map<String, String> mapped = createRowMap(row);
            output.add(mapped);
        }
        return output;
    }

    private Map<String, String> createRowMap(String[] row) {
        Map<String, String> mapped = new HashMap<>();
        mapped.put(PERMALINK, row[PERMALINK_INDEX]);
        mapped.put(COMPANY_NAME, row[COMPANY_NAME_INDEX]);
        mapped.put(NUMBER_EMPLOYEES, row[NUMBER_EMPLOYEES_INDEX]);
        mapped.put(CATEGORY, row[CATEGORY_INDEX]);
        mapped.put(CITY, row[CITY_INDEX]);
        mapped.put(STATE, row[STATE_INDEX]);
        mapped.put(FUNDED_DATE, row[FUNDED_DATE_INDEX]);
        mapped.put(RAISED_AMOUNT, row[RAISED_AMOUNT_INDEX]);
        mapped.put(RAISED_CURRENCY, row[RAISED_CURRENCY_INDEX]);
        mapped.put(ROUND, row[ROUND_INDEX]);
        return mapped;
    }
}

