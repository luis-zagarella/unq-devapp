package ar.edu.unq.examples.statements;

import java.io.File;

import ar.edu.unq.examples.statements.support.ErrorCode;
import ar.edu.unq.examples.statements.support.FileData;
import ar.edu.unq.examples.statements.support.Status;

public class ErrorCodes {

    public ErrorCode casosDeExcepYNormalesIntercalados(final String inputFileName, final Status status) {
        ErrorCode errorCode = ErrorCode.NONE;

        File file = this.openFile(inputFileName, status);
        if (status == Status.ERROR) {
            errorCode = ErrorCode.FileOpenError;
        } else {
            FileData data = this.readFile(file, status);
            if (status == Status.SUCCESS) {
                FileData summary = this.summarizeFileData(data, status);
                if (status == Status.ERROR) {
                    errorCode = ErrorCode.DataSummaryError;
                } else {
                    this.printSummary(summary);
                    this.saveSummary(summary, status);
                    if (status == Status.ERROR) {
                        errorCode = ErrorCode.SummarySaveError;
                    } else {
                        this.updateAllAccounts();
                        this.eraseUndoFile();
                    }
                }
            } else {
                errorCode = ErrorCode.FileReadError;
            }
        }
        return errorCode;
    }

    public ErrorCode casosNormalesPrimero(final String inputFileName, final Status status) {
        ErrorCode errorCode = ErrorCode.NONE;

        File file = this.openFile(inputFileName, status);
        if (status == Status.SUCCESS) {
            FileData data = this.readFile(file, status);
            if (status == Status.SUCCESS) {
                FileData summary = this.summarizeFileData(data, status);
                if (status == Status.SUCCESS) {
                    this.printSummary(summary);
                    this.saveSummary(summary, status);
                    if (status == Status.SUCCESS) {
                        this.updateAllAccounts();
                        this.eraseUndoFile();
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

    public ErrorCode conGuardas(final String inputFileName, final Status status) {
        File file = this.openFile(inputFileName, status);
        if (status == Status.ERROR) {
            return ErrorCode.NONE;
        }

        FileData data = this.readFile(file, status);
        if (status == Status.ERROR) {
            return ErrorCode.FileReadError;
        }

        FileData summary = this.summarizeFileData(data, status);
        if (status == Status.ERROR) {
            return ErrorCode.DataSummaryError;
        }

        this.printSummary(summary);
        this.saveSummary(summary, status);
        if (status == Status.ERROR) {
            return ErrorCode.SummarySaveError;
        }

        this.updateAllAccounts();
        this.eraseUndoFile();

        return ErrorCode.NONE;
    }

    void usandoExcpetions(final String inputFileName) {
        File file = this.openFile(inputFileName);
        FileData data = this.readFile(file);
        FileData summary = this.summarizeFileData(data);
        this.printSummary(summary);
        this.saveSummary(summary);
        this.updateAllAccounts();
        this.eraseUndoFile();
    }

    private void printSummary(final FileData summary) {
        throw new UnsupportedOperationException();
    }

    private void saveSummary(final FileData summary) {
        throw new UnsupportedOperationException();
    }

    private FileData summarizeFileData(final FileData data) {
        throw new UnsupportedOperationException();
    }

    private FileData readFile(final File file) {
        throw new UnsupportedOperationException();
    }

    private File openFile(final String inputFileName) {
        throw new UnsupportedOperationException();
    }

    private void eraseUndoFile() {
        throw new UnsupportedOperationException();
    }

    private void updateAllAccounts() {
        throw new UnsupportedOperationException();
    }

    private void saveSummary(final FileData summary, final Status status) {
        throw new UnsupportedOperationException();
    }

    private FileData summarizeFileData(final FileData data, final Status status) {
        throw new UnsupportedOperationException();
    }

    private File openFile(final String inputFileName, final Status status) {
        throw new UnsupportedOperationException();
    }

    private FileData readFile(final File inputFile, final Status status) {
        throw new UnsupportedOperationException();
    }
}
