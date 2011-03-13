package ar.edu.unq.examples;

import java.util.List;

public class FlagArguments {

    void withFlag() {
        File file = new File("pref.txt", true);

        file.lines();
    }

    void withoutFlag() {
        File file = File.newReadOnly("pref.txt");

        file.lines();
    }

    // ---------------------------------------------
    static private class File {

        public File(final String string, final boolean readOnly) {
            // TODO Auto-generated constructor stub
        }

        public static File newReadOnly(final String string) {
            return new File(string, true);
        }

        public List<String> lines() {
            return null;

        }

    }
}
