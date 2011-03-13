package ar.edu.unq.polemiccode;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Polemico4 {

	public ServiceExecution generarReporteRecepcionYEntrega(Date fecha, String codigoContrato, ReportType reportType) {
		ResultSet resultSet = this.asignacionDao.executeApSpaRecepEntregaCtrtoSse(fecha, codigoContrato);
		ServiceExecution se = null;

		ResultSetCollectionWrapper rscw = new ResultSetCollectionWrapper(resultSet);
		if (rscw.size() > 0) {
			Map parameters = new HashMap();
			parameters.put("fecha", fecha);
			parameters.put("contrato", codigoContrato);
			ReportFile rf = null;
			if (ReportType.PDF.equals(reportType)) {
				rf = this.reportFileBuilder.getPdfReportFile("recepcionYEntrega", parameters, rscw);
			} else if (ReportType.EXCEL.equals(reportType)) {
				rf = this.reportFileBuilder.getXlsReportFile("recepcionYEntrega", parameters, rscw,
						AsignacionServiceImpl.REPORT_COLUMNS_RECEPCION_Y_ENTREGA);
			} else {
				throw new IllegalArgumentException("");
			}
			se = new ServiceExecution(rf, ServiceExecutionStatus.OK);
		} else {
			se = new ServiceExecution(null, ServiceExecutionStatus.FAILED);
		}
		return se;
	}

	public ServiceExecution generarReporteAsignacionContratoDeOperador(Date fechaDesde, Date fechaHasta,
			String codigoContrato, ReportType reportType) {
		ResultSet resultSet = this.asignacionDao.executeApSpaRepAsignCtrtoOper(fechaDesde, fechaHasta, codigoContrato);
		ServiceExecution se = null;

		ResultSetCollectionWrapper rscw = new ResultSetCollectionWrapper(resultSet);
		if (rscw.size() > 0) {
			Map parameters = new HashMap();
			parameters.put("fechaDesde", fechaDesde);
			parameters.put("fechaHasta", fechaHasta);
			parameters.put("codigoContrato", codigoContrato);
			ReportFile rf = null;
			if (ReportType.PDF.equals(reportType)) {
				rf = this.reportFileBuilder.getPdfReportFile("asignacionPorContratoDeOperador", parameters, rscw);
			} else if (ReportType.EXCEL.equals(reportType)) {
				rf = this.reportFileBuilder.getXlsReportFile("asignacionPorContratoDeOperador", parameters, rscw,
						AsignacionServiceImpl.REPORT_COLUMNS_ASIG_CTRTO_OPER);
			} else {
				throw new IllegalArgumentException("bla bla");
			}
			se = new ServiceExecution(rf, ServiceExecutionStatus.OK);
		} else {
			se = new ServiceExecution(null, ServiceExecutionStatus.FAILED);
		}
		return se;
	}

	public ServiceExecution generarReportePuntosDeRTP(Date fechaDesde, Date fechaHasta, ReportType reportType) {
		ResultSet resultSet = this.asignacionDao.executeApSpaConsPtosRTP(fechaDesde, fechaHasta);
		ServiceExecution se = null;

		ResultSetCollectionWrapper rscw = new ResultSetCollectionWrapper(resultSet);
		if (rscw.size() > 0) {
			Map parameters = new HashMap();
			parameters.put("fechaDesde", fechaDesde);
			parameters.put("fechaHasta", fechaHasta);
			ReportFile rf = null;
			if (ReportType.PDF.equals(reportType)) {
				rf = this.reportFileBuilder.getPdfReportFile("puntosDeRTP", parameters, rscw);
			} else if (ReportType.EXCEL.equals(reportType)) {
				rf = this.reportFileBuilder.getXlsReportFile("puntosDeRTP", parameters, rscw,
						this.columnasPuntosRTP(fechaDesde, fechaHasta));
			} else {
				throw new IllegalArgumentException("");
			}
			se = new ServiceExecution(rf, ServiceExecutionStatus.OK);
		} else {
			se = new ServiceExecution(null, ServiceExecutionStatus.FAILED);
		}
		return se;
	}

	public ReportFile generarReporteDistribuidorasEntregas(Date fechaDesde, Date fechaHasta, Reference entidadLegalRef,
			ReportType reportType) {
		try {
			Integer numeroEntidadLegal = entidadLegalRef != null ? (Integer) entidadLegalRef.getId() : null;
			TGSResultSetWrapper resultSet = new TGSResultSetWrapper(this.asignacionDao.executeApSpaRepStandRecEnt(
					fechaDesde, fechaHasta, numeroEntidadLegal, "E"));

			ReportFile ret = null;
			if (!resultSet.isEmpty()) {
				Map parameters = new HashMap();
				parameters.put("FECHA_DESDE", fechaDesde);
				parameters.put("FECHA_HASTA", fechaHasta);

				if (ReportType.PDF.equals(reportType)) {
					ret = this.reportFileBuilder.getPdfReportFile("distribuidorasEntregas", parameters, resultSet);
				} else if (ReportType.EXCEL.equals(reportType)) {
					ret = this.reportFileBuilder.getXlsReportFile("distribuidorasEntregas", parameters, resultSet,
							AsignacionServiceImpl.REPORT_COLUMNS_DISTRIBUIDORAS_ENTREGAS);
				} else {
					throw new IllegalArgumentException(
							"No se puede generar el reporte DistribuidorasEntregas de tipo '" + reportType + "'.");
				}
			}

			return ret;
		} catch (SQLException ex) {
			throw new UnexpectedException(
					"Ocurrió un error inesperado generando el reporte de Distribuidoras-Entregas.", ex);
		}

	}

	// Nota: Habia 3 metodos mas parecidos a estos en la misma clase... o sea
	// que en total era 7 metodos con mucho duplicado (seguro fue un
	// "copy&paste + mod")

	//@formatter:off
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public class ServiceExecution {

		public ServiceExecution(ReportFile rf, ServiceExecutionStatus ok) {
			throw new UnsupportedOperationException();
		}

	}

	public class ReportFileBuilder {

		public ReportFile getPdfReportFile(String string, Map parameters, ResultSetCollectionWrapper rscw) {
			throw new UnsupportedOperationException();
		}

		public ReportFile getXlsReportFile(String string, Map parameters, TGSResultSetWrapper resultSet,
				String reportColumnsDistribuidorasEntregas) {
			throw new UnsupportedOperationException();
		}

		public ReportFile getPdfReportFile(String string, Map parameters, TGSResultSetWrapper resultSet) {
			throw new UnsupportedOperationException();
		}

		public ReportFile getXlsReportFile(String string, Map parameters, ResultSetCollectionWrapper rscw,
				String reportColumnsAsigCtrtoOper) {
			throw new UnsupportedOperationException();
		}

	}

	public class ReportFile {

	}

	public class ResultSetCollectionWrapper {

		public ResultSetCollectionWrapper(ResultSet resultSet) {
			throw new UnsupportedOperationException();
		}

		public int size() {
			throw new UnsupportedOperationException();
		}

	}

	public class AsignacionDao {

		public ResultSet executeApSpaRepAsignCtrtoOper(Date fechaDesde, Date fechaHasta, String codigoContrato) {
			throw new UnsupportedOperationException();
		}

		public Object executeApSpaRepStandRecEnt(Date fechaDesde, Date fechaHasta, Integer numeroEntidadLegal,
				String string) {
			throw new UnsupportedOperationException();
		}

		public ResultSet executeApSpaConsPtosRTP(Date fechaDesde, Date fechaHasta) {
			throw new UnsupportedOperationException();
		}

		public ResultSet executeApSpaRecepEntregaCtrtoSse(Date fecha, String codigoContrato) {
			throw new UnsupportedOperationException();
		}

	}

	public enum ReportType {
		PDF, EXCEL

	}

	private AsignacionDao asignacionDao;
	private ReportFileBuilder reportFileBuilder;

	private String columnasPuntosRTP(Date fechaDesde, Date fechaHasta) {
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

		public UnexpectedException(String string, SQLException ex) {
			throw new UnsupportedOperationException();
		}

	}

	public class Reference {

		public Integer getId() {
			throw new UnsupportedOperationException();
		}

	}

	public class TGSResultSetWrapper {

		public TGSResultSetWrapper(Object executeApSpaRepStandRecEnt) throws SQLException {
			throw new SQLException("");
		}

		public boolean isEmpty() {
			throw new UnsupportedOperationException();
		}

	}

}
