package ar.edu.unq.polemiccode;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class Polemico1 {
    /**
     * Evalua si el usuario esta editando algun camino o punto de la grilla, y
     * decide cambiar de registro con el boton de anterior o proximo.
     */
    public void evaluatePreviosNext() {
        Integer pnButtonValueCaminos = this.getEditCaminoEnSolicitud().getPrevNextButton();
        Integer pnButtonValuePtoEnt = this.getDetalleEntrega().getPrevNextButton();
        Integer pnButtonValuePtoRec = this.getDetalleRecepcion().getPrevNextButton();

        if (pnButtonValueCaminos != null) {
            // Cuando esta variable tiene un valor seteado, significa que
            // proviene de presionar
            // el boton de Anterior o Proximo camino. Por lo tanto debo mover el
            // cursor de seleccion
            // de la tabla hacia el valor siguiente o anterior segun
            // corresponda.
            int lenCam = this.getSolicitud().getCaminos().size();

            boolean foundIt = false;
            CaminoEnSolicitudDTO[] arrayCaminos = new CaminoEnSolicitudDTO[lenCam];

            // Asi se obtienen los valores ya ordenados por el usuario
            // que utiliza el componente tabla.
            Iterator listaCam = this.getComponent("tablaCaminos").getTableModel().getCurrentPageRows();
            int pos = 0;
            int foundAtPos = -1;
            // Los guardo a todos en un array que uso para indiciar posterior o
            // anterior
            while (listaCam.hasNext()) {
                CaminoEnSolicitudDTO cam = (CaminoEnSolicitudDTO) listaCam.next();
                arrayCaminos[pos] = cam;
                // Busco cual es el camino que estaba seleccionado en la lista
                if (cam.getReference().equals(this.getEditCaminoEnSolicitud().getPrevNextCamino().getReference())) {
                    foundIt = true;
                    foundAtPos = pos;
                }
                pos++;
            }

            // Si lo encontre
            if (foundIt) {
                int moveAt = 0;
                if (pnButtonValueCaminos.equals(Integer.valueOf(1))) {
                    // Previous
                    moveAt = lenCam - 1;
                    if (foundAtPos > 0) {
                        moveAt = foundAtPos - 1;
                    }
                } else if (pnButtonValueCaminos.equals(new Integer(2))) {
                    // next
                    moveAt = 0;
                    if (foundAtPos < lenCam - 1) {
                        moveAt = foundAtPos + 1;
                    }
                }
                if (moveAt != foundAtPos) {
                    // Seteo el foco editor en donde corresponde.
                    this.getEditCaminoEnSolicitud().openCamino(arrayCaminos[moveAt]);
                }
            }
            this.getEditCaminoEnSolicitud().setPrevNextButton(null);
        }

        if (pnButtonValuePtoEnt != null || pnButtonValuePtoRec != null) {
            // Cuando esta variable tiene un valor seteado, significa que
            // proviene de presionar
            // el boton de Anterior o Proximo Punto de Entrega. Por lo tanto
            // debo mover el cursor de seleccion
            // de la tabla hacia el valor siguiente o anterior segun
            // corresponda.

            int lenPtos;
            int pos = 0;
            int foundAtPos = -1;
            DetalleSolicitudPuntos dps;
            boolean foundIt = false;
            boolean isNext;

            if (pnButtonValuePtoEnt != null) {
                dps = this.getDetalleEntrega_();
                // Entrega
                lenPtos = this.getSolicitud().getPuntosPorRolYZona(RolPunto.ENTREGA, dps.getZonaSelected()).size();
                isNext = pnButtonValuePtoEnt.equals(new Integer(2));
            } else {
                dps = this.getDetalleRecepcion_();
                // Recepcion
                lenPtos = this.getSolicitud().getPuntosPorRolYZona(RolPunto.RECEPCION, dps.getZonaSelected()).size();
                isNext = pnButtonValuePtoRec.equals(new Integer(2));
            }

            Iterator itPtos = dps.getComponent("tablaPuntos").getTableModel().getCurrentPageRows();
            PuntoEnSolicitudDTO[] arrayCaminos = new PuntoEnSolicitudDTO[lenPtos];

            // Asi se obtienen los valores ya ordenados por el usuario
            // que utiliza el componente tabla.

            // Los guardo a todos en un array que uso para indiciar posterior o
            // anterior
            while (itPtos.hasNext()) {
                PuntoEnSolicitudDTO pto = (PuntoEnSolicitudDTO) itPtos.next();
                arrayCaminos[pos] = pto;
                // Busco cual es el camino que estaba seleccionado en la lista
                if (pto.getReference().equals(dps.getPrevNextPunto().getReference())) {
                    foundIt = true;
                    foundAtPos = pos;
                }
                pos++;
            }

            // Si lo encontre
            if (foundIt) {
                int moveAt = 0;
                if (isNext) {
                    // next
                    moveAt = 0;
                    if (foundAtPos < lenPtos - 1) {
                        moveAt = foundAtPos + 1;
                    }
                } else {
                    // Previous
                    moveAt = lenPtos - 1;
                    if (foundAtPos > 0) {
                        moveAt = foundAtPos - 1;
                    }
                }
                if (moveAt != foundAtPos) {
                    // Seteo el foco editor en donde corresponde.
                    dps.openPunto(arrayCaminos[moveAt]);
                }
            }
            dps.setPrevNextButton(null);
        }

    }

    // lo que sigue es codigo para que compile lo previo

    private DetalleSolicitudPuntos getDetalleRecepcion_() {
        throw new UnsupportedOperationException();
    }

    private DetalleSolicitudPuntos getDetalleEntrega_() {
        throw new UnsupportedOperationException();
    }

    private AjaxTable getComponent(final String string) {
        throw new UnsupportedOperationException();
    }

    private Bla getSolicitud() {
        throw new UnsupportedOperationException();
    }

    private Bla getDetalleRecepcion() {
        throw new UnsupportedOperationException();
    }

    private Bla getDetalleEntrega() {
        throw new UnsupportedOperationException();
    }

    private Bla getEditCaminoEnSolicitud() {
        throw new UnsupportedOperationException();
    }

    class Bla {

        public Integer getPrevNextButton() {
            throw new UnsupportedOperationException();
        }

        public Bla getPuntosPorRolYZona(final RolPunto entrega, final Object zonaSelected) {
            throw new UnsupportedOperationException();
        }

        public void setPrevNextButton(final Object object) {
            throw new UnsupportedOperationException();
        }

        public void openCamino(final CaminoEnSolicitudDTO caminoEnSolicitudDTO) {
            throw new UnsupportedOperationException();
        }

        public CaminoEnSolicitudDTO getPrevNextCamino() {
            throw new UnsupportedOperationException();
        }

        public Iterator getCurrentPageRows() {
            throw new UnsupportedOperationException();
        }

        public int size() {
            throw new UnsupportedOperationException();
        }

        public Bla getCaminos() {
            throw new UnsupportedOperationException();
        }

    }

    class CaminoEnSolicitudDTO {

        public Bla getReference() {
            throw new UnsupportedOperationException();
        }

    }

    class AjaxTable {

        public Bla getTableModel() {
            throw new UnsupportedOperationException();
        }

    }

    class DetalleSolicitudPuntos {

        public AjaxTable getComponent(final String string) {
            throw new UnsupportedOperationException();
        }

        public void setPrevNextButton(final Object object) {
            throw new UnsupportedOperationException();
        }

        public void openPunto(final PuntoEnSolicitudDTO puntoEnSolicitudDTO) {
            throw new UnsupportedOperationException();
        }

        public CaminoEnSolicitudDTO getPrevNextPunto() {
            throw new UnsupportedOperationException();
        }

        public Object getZonaSelected() {
            throw new UnsupportedOperationException();
        }

    }

    class PuntoEnSolicitudDTO {

        public Object getReference() {
            throw new UnsupportedOperationException();
        }

    }

    enum RolPunto {
        ENTREGA, RECEPCION

    }
}
