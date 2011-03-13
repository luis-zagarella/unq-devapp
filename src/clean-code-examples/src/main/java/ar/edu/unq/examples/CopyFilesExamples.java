package ar.edu.unq.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

@SuppressWarnings("unused")
public class CopyFilesExamples {

    private void copyFileContents(final File fileOrigen, final File fileDestino) throws FileManagerException {
        try {
            FileReader in = new FileReader(fileOrigen);
            FileWriter out = new FileWriter(fileDestino);
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }

            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            throw new FileManagerException(e);
        } catch (IOException e) {
            throw new FileManagerException(e);
        }
    }

    private void copyFileContents2(final File fileOrigen, final File fileDestino) throws Exception {
        FileInputStream input = new FileInputStream(fileOrigen);
        try {
            FileOutputStream output = new FileOutputStream(fileDestino);
            try {
                IOUtils.copy(input, output);
            } finally {
                IOUtils.closeQuietly(output);
            }
        } finally {
            IOUtils.closeQuietly(input);
        }

    }

    class FileManagerException extends Exception {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        FileManagerException(final Throwable e) {
        }

    }
}
