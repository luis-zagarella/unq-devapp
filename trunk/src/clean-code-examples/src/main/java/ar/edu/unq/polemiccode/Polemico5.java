package ar.edu.unq.polemiccode;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@SuppressWarnings("rawtypes")
public class Polemico5 {

    public RecordKeeper selectAjustesMedicion(final Date fechaDesde, final Date fechaHasta, final boolean descartados) {
        String descartadosParam = descartados ? "D" : "N";

        List ajustes = this.getRepository().executeNamedQuery("ajustesMedicion",
                new Object[] { descartadosParam, fechaDesde, fechaHasta });

        Collections.sort(ajustes, new Comparator() {
            @Override
            public int compare(final Object o1, final Object o2) {
                int result;
                AjusteMedicion a1 = (AjusteMedicion) o1;
                AjusteMedicion a2 = (AjusteMedicion) o2;
                result = a1.getRolPunto().compareTo(a2.getRolPunto());
                if (result == 0) {
                    result = a1.getCodigoZona().compareTo(a2.getCodigoZona());
                }
                if (result == 0) {
                    result = a1.getFecha().compareTo(a2.getFecha());
                }
                if (result == 0) {
                    result = a1.getNumeroPunto().compareTo(a2.getNumeroPunto());
                }
                return result;
            }
        });

        return new RecordKeeper(ajustes);
    }

    //@formatter:off
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public class AjusteMedicion {

		public Date getRolPunto() {
			throw new UnsupportedOperationException();
		}

		public Date getCodigoZona() {
			throw new UnsupportedOperationException();
		}

		public Date getFecha() {
			throw new UnsupportedOperationException();
		}

		public Date getNumeroPunto() {
			throw new UnsupportedOperationException();
		}

	}

	public static class Collections {

		public static void sort(final List ajustes, final Comparator comparator) {
			throw new UnsupportedOperationException();
		}

	}

	public class RecordKeeper {

		public RecordKeeper(final List ajustes) {
			throw new UnsupportedOperationException();
		}

	}

	private Repository getRepository() {
		throw new UnsupportedOperationException();
	}

	class Repository {

		public List executeNamedQuery(final String string, final Object[] objects) {
			throw new UnsupportedOperationException();
		}

	}
}
