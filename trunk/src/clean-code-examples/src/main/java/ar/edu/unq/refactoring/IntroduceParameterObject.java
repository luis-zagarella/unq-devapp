package ar.edu.unq.refactoring;

import java.util.Date;
import java.util.List;

import ar.edu.unq.refactoring.support.Range;

/**
 * Un grupo de parametros van siempre juntos en distintos metodos. Pide a gritos
 * la creacion de un nuevo objeto y tal vez la mudanza de esos metodos a ese
 * objeto nuevo.
 */
public class IntroduceParameterObject {

    static interface ClaimsRepository_v1 {

        List<Claim> claimsReceivedIn(Date start, Date end);

        List<Claim> claimsApprovedIn(Date start, Date end);

        List<Claim> claimsRejectedIn(Date satrt, Date end);

    }

    static interface ClaimsRepository_v2 {

        List<Claim> claimsReceivedIn(Range<Date> range);

        List<Claim> claimsApprovedIn(Range<Date> range);

        List<Claim> claimsRejectedIn(Range<Date> range);

    }

    static class RepositorioDeClientes_v1 {

        public void agregar(final long id, final String doc, final String cuit, final String nombre,
                final String apellido, final String telefono, final String mail, final String direccion,
                final String localidad, final String piso, final String provincia) {
            // Agrega un nuevo cliente a la DB
        }

        public void modificar(final long id, final String doc, final String cuit, final String nombre,
                final String apellido, final String telefono, final String mail, final String direccion,
                final String localidad, final String piso, final String provincia) {
            // modifica un cliente de la DB
        }

    }

    static class RepositorioDeClientes_v2 {

        public void agregar(final Cliente cliente) {
            // Agrega un nuevo cliente a la DB
        }

        public void modificar(final Cliente cliente) {
            // Agrega un nuevo cliente a la DB
        }

    }

    static class Claim {

    }

    static class Cliente {
        long id;

        String doc;

        String cuit;

        String nombre;

        String apellido;

        String telefono;

        String mail;

        String direccion;

        String localidad;

        String piso;

        String provincia;
    }

}
