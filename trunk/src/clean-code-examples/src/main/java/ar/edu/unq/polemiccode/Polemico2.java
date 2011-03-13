package ar.edu.unq.polemiccode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import ar.edu.unq.polemiccode.Polemico4.ReportFile;
import ar.edu.unq.polemiccode.Polemico4.ServiceExecutionStatus;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Polemico2 {

    public ServiceExecution saveContratoOperador(final ContratoOperadorDTO contratoDTO) {

        List messages = new ArrayList();

        if (contratoDTO.getFechaInicialContrato().after(contratoDTO.getFechaFinalContrato()))
            throw new ServiceException(messageSource.getMessage("periodoInvalido"));

        if (contratoDTO.getReference().isTransient()) {

            ParameterizedQuery query = new ParameterizedQuery(ContratoOperador.class);
            query.addExpression("codigo", contratoDTO.getCodigoContrato());

            if (this.getRepository().exist(query)) {

                messages.add(messageSource.getMessage("numero_contrato_existente"));
                throw new ServiceException(messages);
            }

            List contratos = this.selectContratosAsBO(TipoContrato.OP, EstadoContrato.ACTIVO, contratoDTO
                    .getEntidadLegal().getReference());
            if (contratos != null && !contratos.isEmpty())
                throw new ServiceException(messageSource.getMessage("entidad-legal-con-contrato",
                        new Object[] { ((Contrato) contratos.get(0)).getCodigo() }));
        }

        if (contratoDTO.getPuntos().size() == 0)
            throw new ServiceException(messageSource.getMessage("contrato_sin_puntos"));

        // Se validan todos los puntos del contrato

        boolean isValid = true;
        for (Iterator puntos = contratoDTO.getPuntos().iterator(); puntos.hasNext();) {

            PuntoEnContratoSummaryDTO ptoCtrto = (PuntoEnContratoSummaryDTO) puntos.next();

            if (!ptoCtrto.getReference().isTransient() && !contratoDTO.getReference().isTransient()
                    && contratoDTO.isDirty()) {
                PuntoEnContrato puntoViejo = this.getRepository().retrieve(ptoCtrto.getReference());

                // Cambio la fecha de finalizacion de los puntos si es que hay
                // un cambio de fecha Final en el contrato.
                if (DateUtils
                        .mayorOIgual(contratoDTO.getFechaFinalContrato(), puntoViejo.getContrato().getFechaFinal())) {
                    // Es una expansion, es decir la fecha final del contrato se
                    // corre hacia el futuro.

                    if (DateUtils.equals(puntoViejo.getFechaFinalOperador(), puntoViejo.getContrato().getFechaFinal())) {
                        // Si la fecha fin del punto coincide con la fecha fin
                        // del contrato viejo,
                        // la estiro a la fecha fin nueva del ctro.
                        ptoCtrto.setFechaFinalOperador(contratoDTO.getFechaFinalContrato());
                    }
                }

                if (contratoDTO.getFechaFinalContrato().before(puntoViejo.getContrato().getFechaFinal())) {
                    // Es una contraccion, es decir la fecha final del contrato
                    // se corre hacia el pasado

                    if (contratoDTO.getFechaFinalContrato().before(puntoViejo.getFechaFinalOperador())) {
                        // Si la fecha del punto final nueva del contratato es
                        // menor a la del punto viejo, retrotraigo tambien
                        // la fecha del punto = a la del contrato
                        ptoCtrto.setFechaFinalOperador(contratoDTO.getFechaFinalContrato());
                    }

                }

            }

            this.validarPuntosEnContratoOperadorActualSolapados(ptoCtrto, contratoDTO, messages);

            ServiceExecution srv = this.validarPuntoEnContratoOperador(ptoCtrto, contratoDTO.getFechaInicialContrato(),
                    contratoDTO.getFechaFinalContrato());
            if (!srv.getReturnValue().booleanValue()) {

                messages.add("Punto Nro " + ptoCtrto.getPunto().getNumeroPunto().toString());
                messages.addAll(srv.getMessages());
                isValid = false;
            }
        }
        if (!isValid)
            throw new ServiceException(messages);

        Contrato contrato = this.getDtoService().disassemble(contratoDTO);

        this.getRepository().save(contrato);

        return new ServiceExecution(Boolean.TRUE);
    }

    //@formatter:off
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public class PuntoEnContratoSummaryDTO {

		public BolsaDeGatos getReference() {
			throw new UnsupportedOperationException();
		}

		public void setFechaFinalOperador(final Date fechaFinalContrato) {
			throw new UnsupportedOperationException();
		}

		public BolsaDeGatos getPunto() {
			throw new UnsupportedOperationException();
		}

	}

	private ServiceExecution validarPuntoEnContratoOperador(final PuntoEnContratoSummaryDTO ptoCtrto,
			final Date fechaInicialContrato, final Date fechaFinalContrato) {
		throw new UnsupportedOperationException();
	}

	private void validarPuntosEnContratoOperadorActualSolapados(final PuntoEnContratoSummaryDTO ptoCtrto,
			final ContratoOperadorDTO contratoDTO, final List messages) {
		throw new UnsupportedOperationException();
	}

	private List selectContratosAsBO(final TipoContrato op, final EstadoContrato activo, final BolsaDeGatos reference) {
		throw new UnsupportedOperationException();
		
		
	}

	public enum EstadoContrato {
		ACTIVO

	}

	public enum TipoContrato {
		OP

	}

	public class ContratoOperador {

	}

	public class ParameterizedQuery {

		public ParameterizedQuery(final Class<ContratoOperador> class1) {
			throw new UnsupportedOperationException();
		}

		public void addExpression(final String string, final Object codigoContrato) {
			throw new UnsupportedOperationException();
		}

	}

	public class PuntoEnContrato {

		public BolsaDeGatos getContrato() {
			throw new UnsupportedOperationException();
		}

		public Date getFechaFinalOperador() {
			throw new UnsupportedOperationException();
		}

	}

	static public class DateUtils {

		public static boolean mayorOIgual(final Date fechaFinalContrato, final Date fechaFinal) {
			throw new UnsupportedOperationException();
		}

		public static boolean equals(final Date fechaFinalOperador, final Date fechaFinal) {
			throw new UnsupportedOperationException();
		}

	}

	public class Contrato {

		public Object getCodigo() {
			throw new UnsupportedOperationException();
		}

	}

	private BolsaDeGatos messageSource;

	private BolsaDeGatos getDtoService() {
		throw new UnsupportedOperationException();
	}

	private BolsaDeGatos getRepository() {
		throw new UnsupportedOperationException();
	}

	public class ContratoOperadorDTO {

		public Date getFechaInicialContrato() {
			throw new UnsupportedOperationException();
		}

		public boolean isDirty() {
			throw new UnsupportedOperationException();
		}

		public List getPuntos() {
			throw new UnsupportedOperationException();
		}

		public ContratoOperadorDTO getEntidadLegal() {
			throw new UnsupportedOperationException();
		}

		public Object getCodigoContrato() {
			throw new UnsupportedOperationException();
		}

		public BolsaDeGatos getReference() {
			throw new UnsupportedOperationException();
		}

		public Date getFechaFinalContrato() {
			throw new UnsupportedOperationException();
		}

	}

	public class ServiceExecution {

		public ServiceExecution(final Boolean boolean1) {
			throw new UnsupportedOperationException();
		}

		public ServiceExecution(final ReportFile rf, final ServiceExecutionStatus ok) {
			throw new UnsupportedOperationException();
		}

		public Boolean getReturnValue() {
			throw new UnsupportedOperationException();
		}

		public Collection getMessages() {
			throw new UnsupportedOperationException();
		}

	}

	public class ServiceException extends RuntimeException {

		public ServiceException(final List messages) {
			throw new UnsupportedOperationException();
		}

		private static final long serialVersionUID = -1L;

	}

	public class BolsaDeGatos {

		public void save(final Contrato contrato) {
			throw new UnsupportedOperationException();
		}

		public Object getNumeroPunto() {
			throw new UnsupportedOperationException();
		}

		public Date getFechaFinal() {
			throw new UnsupportedOperationException();
		}

		public PuntoEnContrato retrieve(final BolsaDeGatos reference) {
			throw new UnsupportedOperationException();
		}

		public List getMessage(final String string, final Object[] objects) {
			throw new UnsupportedOperationException();
		}

		public boolean exist(final ParameterizedQuery query) {
			throw new UnsupportedOperationException();
		}

		public boolean isTransient() {
			throw new UnsupportedOperationException();
		}

		public List getMessage(final String string) {
			throw new UnsupportedOperationException();
		}

		public Contrato disassemble(final ContratoOperadorDTO contratoDTO) {
			throw new UnsupportedOperationException();
		}

	}
}
