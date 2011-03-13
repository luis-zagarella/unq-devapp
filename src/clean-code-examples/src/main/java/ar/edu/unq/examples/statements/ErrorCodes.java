package ar.edu.unq.examples.statements;

import java.io.File;

import ar.edu.unq.examples.statements.support.ErrorCode;
import ar.edu.unq.examples.statements.support.FileData;
import ar.edu.unq.examples.statements.support.Status;

public class ErrorCodes {

	public ErrorCode casosDeExcepYNormalesIntercalados(String inputFileName, Status status) {
		ErrorCode errorCode = ErrorCode.NONE;

		File file = openFile(inputFileName, status);
		if (status == Status.ERROR) {
			errorCode = ErrorCode.FileOpenError;
		} else {
			FileData data = readFile(file, status);
			if (status == Status.SUCCESS) {
				FileData summary = summarizeFileData(data, status);
				if (status == Status.ERROR) {
					errorCode = ErrorCode.DataSummaryError;
				} else {
					printSummary(summary);
					saveSummary(summary, status);
					if (status == Status.ERROR) {
						errorCode = ErrorCode.SummarySaveError;
					} else {
						updateAllAccounts();
						eraseUndoFile();
					}
				}
			} else {
				errorCode = ErrorCode.FileReadError;
			}
		}
		return errorCode;
	}

	public ErrorCode casosNormalesPrimero(String inputFileName, Status status) {
		ErrorCode errorCode = ErrorCode.NONE;

		File file = openFile(inputFileName, status);
		if (status == Status.SUCCESS) {
			FileData data = readFile(file, status);
			if (status == Status.SUCCESS) {
				FileData summary = summarizeFileData(data, status);
				if (status == Status.SUCCESS) {
					printSummary(summary);
					saveSummary(summary, status);
					if (status == Status.SUCCESS) {
						updateAllAccounts();
						eraseUndoFile();
					} else {
						errorCode = ErrorCode.SummarySaveError;
					}
				} else {
					errorCode = ErrorCode.DataSummaryError;
				}
			} else {
				errorCode = ErrorCode.FileReadError;
			}
		} else {
			errorCode = ErrorCode.FileOpenError;
		}

		return errorCode;
	}

	public ErrorCode conGuardas(String inputFileName, Status status) {
		File file = openFile(inputFileName, status);
		if (status == Status.ERROR) {
			return ErrorCode.NONE;
		}

		FileData data = readFile(file, status);
		if (status == Status.ERROR) {
			return ErrorCode.FileReadError;
		}

		FileData summary = summarizeFileData(data, status);
		if (status == Status.ERROR) {
			return ErrorCode.DataSummaryError;
		}

		printSummary(summary);
		saveSummary(summary, status);
		if (status == Status.ERROR) {
			return ErrorCode.SummarySaveError;
		}

		updateAllAccounts();
		eraseUndoFile();

		return ErrorCode.NONE;
	}

	void usandoExcpetions(String inputFileName) {
		File file = openFile(inputFileName);
		FileData data = readFile(file);
		FileData summary = summarizeFileData(data);
		printSummary(summary);
		saveSummary(summary);
		updateAllAccounts();
		eraseUndoFile();
	}

	private void printSummary(FileData summary) {
		throw new UnsupportedOperationException();
	}

	private void saveSummary(FileData summary) {
		throw new UnsupportedOperationException();
	}

	private FileData summarizeFileData(FileData data) {
		throw new UnsupportedOperationException();
	}

	private FileData readFile(File file) {
		throw new UnsupportedOperationException();
	}

	private File openFile(String inputFileName) {
		throw new UnsupportedOperationException();
	}

	private void eraseUndoFile() {
		throw new UnsupportedOperationException();
	}

	private void updateAllAccounts() {
		throw new UnsupportedOperationException();
	}

	private void saveSummary(FileData summary, Status status) {
		throw new UnsupportedOperationException();
	}

	private FileData summarizeFileData(FileData data, Status status) {
		throw new UnsupportedOperationException();
	}

	private File openFile(String inputFileName, Status status) {
		throw new UnsupportedOperationException();
	}

	private FileData readFile(File inputFile, Status status) {
		throw new UnsupportedOperationException();
	}
}
