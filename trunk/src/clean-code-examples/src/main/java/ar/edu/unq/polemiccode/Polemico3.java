package ar.edu.unq.polemiccode;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
public class Polemico3 {

    private List completarDiasFaltantesyBorra(final List datos, final DatoAsignacion example, final Date fechaInicial,
            final Date fechaFinal, final Map referentes) {

        Iterator iter = datos.iterator();
        while (iter.hasNext()) {
            DatoAsignacionPorPunto element = (DatoAsignacionPorPunto) iter.next();
            if (!referentes.containsKey(element.getReferente_AA_AA())) {
                iter.remove();
            }
        }

        Iterator iter2 = datos.iterator();
        boolean bPrimeraVez = true;
        String refAnterior = null;
        ArrayList tempList = new ArrayList();
        ArrayList tempFinal = new ArrayList();

        while (iter2.hasNext()) {
            DatoAsignacionPorPunto element = (DatoAsignacionPorPunto) iter2.next();
            if (bPrimeraVez) {
                refAnterior = element.getReferente_AA_AA();
                tempList.add(element);
                bPrimeraVez = false;
            } else {
                if (!refAnterior.equals(element.getReferente_AA_AA())) {
                    // Cambio de refente

                    this.completarDiasFaltantes(tempList, example, fechaInicial, fechaFinal, refAnterior);
                    tempFinal.addAll(tempList);
                    refAnterior = element.getReferente_AA_AA();
                    tempList.clear();
                }
                tempList.add(element);
            }
        }
        if (tempList.size() > 0) {
            this.completarDiasFaltantes(tempList, example, fechaInicial, fechaFinal, refAnterior);
            tempFinal.addAll(tempList);
        }

        // Devuelvo la lista completa
        return tempFinal;

    }

    //@formatter:off
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public class DatoAsignacionPorPunto {

		public String getReferente_AA_AA() {
			throw new UnsupportedOperationException();
		}

	}

	public class DatoAsignacion {

	}

	private void completarDiasFaltantes(final ArrayList tempList, final DatoAsignacion example, final Date fechaInicial, final Date fechaFinal,
			final String refAnterior) {
		throw new UnsupportedOperationException();
	}

}
