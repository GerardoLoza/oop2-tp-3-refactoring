package tp3.ejercicio4;

import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Objects;

public class PersonaRepository {

    private Jdbi jdbi;

    public PersonaRepository(Jdbi jdbi) {
        this.jdbi = Objects.requireNonNull(jdbi, "Jdbi no puede ser null");
    }

    /**
     * Busca por nombre a parte
     */
    public List<Persona> buscarPorNombre(String nombreOParte) {
        Objects.requireNonNull(nombreOParte, "El nombre no puede ser null");

        return jdbi.withHandle(handle -> {
            var rs = handle
                    .select("select nombre, apellido from persona where nombre like ?")
                    .bind(0, "%" + nombreOParte + "%").mapToMap(String.class).list();

            var personas = new ArrayList<Persona>();

            for (Map<String, String> map : rs) {
                personas.add(new Persona(map.get("nombre"), map.get("apellido")));
            }

            return personas;
        });
    }

    /**
     * Dado un id, retorna Optional con la persona encontrada
     */
    public Optional<Persona> buscarId(Long id) {
        Objects.requireNonNull(id, "El id no puede ser null");

        return jdbi.withHandle(handle -> {
            var rs = handle
                    .select("select nombre, apellido from persona where id_persona = ?")
                    .bind(0, id).mapToMap(String.class).list();

            if (rs.isEmpty()) {
                return Optional.empty();
            }

            return Optional.of(new Persona(rs.get(0).get("nombre"), rs.get(0).get("apellido")));
        });
    }
}
