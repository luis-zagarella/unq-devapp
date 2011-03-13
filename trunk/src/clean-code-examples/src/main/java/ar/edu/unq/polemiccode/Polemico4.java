package ar.edu.unq.polemiccode;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Polemico4 {

    public ServiceExecution generarReporteRecepcionYEntrega(final Date fecha, final String codigoContrato,
            final ReportType reportType) {
        ResultSet resultSet = asignacionDao.executeApSpaRecepEntregaCtrtoSse(fecha, codigoContrato);
        ServiceExecution se = null;

        ResultSetCollectionWrapper rscw = new ResultSetCollectionWrapper(resultSet);
        if (rscw.size() > 0) {
            Map parameters = new HashMap();
            parameters.put("fecha", fecha);
            parameters.put("contrato", codigoContrato);
            ReportFile rf = null;
            if (ReportType.PDF.equals(reportType)) {
                rf = reportFileBuilder.getPdfReportFile("recepcionYEntrega", parameters, rscw);
            } else if (ReportType.EXCEL.equals(reportType)) {
                rf = reportFileBuilder.getXlsReportFile("recepcionYEntrega", parameters, rscw,
                        AsignacionServiceImpl.REPORT_COLUMNS_RECEPCION_Y_ENTREGA);
            } else
                throw new IllegalArgumentException("");
            se = new ServiceExecution(rf, ServiceExecutionStatus.OK);
        } else {
            se = new ServiceExecution(null, ServiceExecutionStatus.FAILED);
        }
        return se;
    }

    public ServiceExecution generarReporteAsignacionContratoDeOperador(final Date fechaDesde, final Date fechaHasta,
            final String codigoContrato, final ReportType reportType) {
        ResultSet resultSet = asignacionDao.executeApSpaRepAsignCtrtoOper(fechaDesde, fechaHasta, codigoContrato);
        ServiceExecution se = null;

        ResultSetCollectionWrapper rscw = new ResultSetCollectionWrapper(resultSet);

        if (rscw.size() > 0) {
            Map parameters = new HashMap();
            parameters.put("fechaDesde", fechaDesde);
            parameters.put("fechaHasta", fechaHasta);
            parameters.put("codigoContrato", codigoContrato);
            ReportFile rf = null;
            if (ReportType.PDF.equals(reportType)) {
                rf = reportFileBuilder.getPdfReportFile("asignacionPorContratoDeOperador", parameters, rscw);
            } else if (ReportType.EXCEL.equals(reportType)) {
                rf = reportFileBuilder.getXlsReportFile("asignacionPorContratoDeOperador", parameters, rscw,
                        AsignacionServiceImpl.REPORT_COLUMNS_ASIG_CTRTO_OPER);
            } else
                throw new IllegalArgumentException("bla bla");
            se = new ServiceExecution(rf, ServiceExecutionStatus.OK);
        } else {
            se = new ServiceExecution(null, ServiceExecutionStatus.FAILED);
        }
        return se;
    }

    public ServiceExecution generarReportePuntosDeRTP(final Date fechaDesde, final Date fechaHasta,
            final ReportType reportType) {
        ResultSet resultSet = asignacionDao.executeApSpaConsPtosRTP(fechaDesde, fechaHasta);
        ServiceExecution se = null;

        ResultSetCollectionWrapper rscw = new ResultSetCollectionWrapper(resultSet);
        if (rscw.size() > 0) {
            Map parameters = new HashMap();
            parameters.put("fechaDesde", fechaDesde);
            parameters.put("fechaHasta", fechaHasta);
            ReportFile rf = null;
            if (ReportType.PDF.equals(reportType)) {
                rf = reportFileBuilder.getPdfReportFile("puntosDeRTP", parameters, rscw);
            } else if (ReportType.EXCEL.equals(reportType)) {
                rf = reportFileBuilder.getXlsReportFile("puntosDeRTP", parameters, rscw,
                        this.columnasPuntosRTP(fechaDesde, fechaHasta));
            } else
                throw new IllegalArgumentException("");
            se = new ServiceExecution(rf, ServiceExecutionStatus.OK);
        } else {
            se = new ServiceExecution(null, ServiceExecutionStatus.FAILED);
        }
        return se;
    }

    public ReportFile generarReporteDistribuidorasEntregas(final Date fechaDesde, final Date fechaHasta,
            final Reference entidadLegalRef, final ReportType reportType) {
        try {
            Integer numeroEntidadLegal = entidadLegalRef != null ? (Integer) entidadLegalRef.getId() : null;
            TGSResultSetWrapper resultSet = new TGSResultSetWrapper(asignacionDao.executeApSpaRepStandRecEnt(
                    fechaDesde, fechaHasta, numeroEntidadLegal, "E"));

            ReportFile ret = null;
            if (!resultSet.isEmpty()) {
                Map parameters = new HashMap();
                parameters.put("FECHA_DESDE", fechaDesde);
                parameters.put("FECHA_HASTA", fechaHasta);

                if (ReportType.PDF.equals(reportType)) {
                    ret = reportFileBuilder.getPdfReportFile("distribuidorasEntregas", parameters, resultSet);
                } else if (ReportType.EXCEL.equals(reportType)) {
                    ret = reportFileBuilder.getXlsReportFile("distribuidorasEntregas", parameters, resultSet,
                            AsignacionServiceImpl.REPORT_COLUMNS_DISTRIBUIDORAS_ENTREGAS);
                } else
                    throw new IllegalArgumentException(
                            "No se puede generar el reporte DistribuidorasEntregas de tipo '" + reportType + "'.");
            }

            return ret;
        } catch (SQLException ex) {
            throw new UnexpectedException(
                    "Ocurrio un error inesperado generando el reporte de Distribuidoras-Entregas.", ex);
        }

    }

    // Nota: Habia 3 metodos mas parecidos a estos en la misma clase... o sea
    // que en total era 7 metodos con mucho duplicado (seguro fue un
    // "copy&paste + mod")

    //@formatter:off
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public class ServiceExecution {

		public ServiceExecution(final ReportFile rf, final ServiceExecutionStatus ok) {
			throw new UnsupportedOperationException();
		}

	}

	public class ReportFileBuilder {

		public ReportFile getPdfReportFile(final String string, final Map parameters, final ResultSetCollectionWrapper rscw) {
			throw new UnsupportedOperationException();
		}

		public ReportFile getXlsReportFile(final String string, final Map parameters, final TGSResultSetWrapper resultSet,
				final String reportColumnsDistribuidorasEntregas) {
			throw new UnsupportedOperationException();
		}

		public ReportFile getPdfReportFile(final String string, final Map parameters, final TGSResultSetWrapper resultSet) {
			throw new UnsupportedOperationException();
		}

		public ReportFile getXlsReportFile(final String string, final Map parameters, final ResultSetCollectionWrapper rscw,
				final String reportColumnsAsigCtrtoOper) {
			throw new UnsupportedOperationException();
		}

	}

	public class ReportFile {

	}

	public class ResultSetCollectionWrapper {

		public ResultSetCollectionWrapper(final ResultSet resultSet) {
			throw new UnsupportedOperationException();
		}

		public int size() {
			throw new UnsupportedOperationException();
		}

	}

	public class AsignacionDao {

		public ResultSet executeApSpaRepAsignCtrtoOper(final Date fechaDesde, final Date fechaHasta, final String codigoContrato) {
			throw new UnsupportedOperationException();
		}

		public Object executeApSpaRepStandRecEnt(final Date fechaDesde, final Date fechaHasta, final Integer numeroEntidadLegal,
				final String string) {
			throw new UnsupportedOperationException();
		}

		public ResultSet executeApSpaConsPtosRTP(final Date fechaDesde, final Date fechaHasta) {
			throw new UnsupportedOperationException();
		}

		public ResultSet executeApSpaRecepEntregaCtrtoSse(final Date fecha, final String codigoContrato) {
			throw new UnsupportedOperationException();
		}

	}

	public enum ReportType {
		PDF, EXCEL

	}

	private AsignacionDao asignacionDao;
	private ReportFileBuilder reportFileBuilder;

	private String columnasPuntosRTP(final Date fechaDesde, final Date fechaHasta) {
		throw new UnsupportedOperationException();
	}

	public class AsignacionServiceImpl {
	
		public static final String REPORT_COLUMNS_DISTRIBUIDORAS_ENTREGAS = "";
		public static final String REPORT_COLUMNS_ASIG_CTRTO_OPER = "bla";
		public static final String REPORT_COLUMNS_RECEPCION_Y_ENTREGA = "";
	
	}

	public enum ServiceExecutionStatus {
		OK, FAILED

	}
	
	public class UnexpectedException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public UnexpectedException(final String string, final SQLException ex) {
			throw new UnsupportedOperationException();
		}

	}

	public class Reference {

		public Integer getId() {
			throw new UnsupportedOperationException();
		}

	}

	public class TGSResultSetWrapper {

		public TGSResultSetWrapper(final Object executeApSpaRepStandRecEnt) throws SQLException {
			throw new SQLException("");
		}

		public boolean isEmpty() {
			throw new UnsupportedOperationException();
		}

	}

}
