package ar.edu.unq.examples;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class GetEmailArrayExample {

    // ///////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////

    public static String[] getEmailArray(final String emails) {
        // ArrayList list = new ArrayList (1);
        List<String> list = new ArrayList<String>(1);

        if (emails == null) {
            return new String[0];
        }

        int len = emails.length();
        StringBuilder curEmail = new StringBuilder();
        int i = 0;
        while (true) {
            boolean allDone = false;
            boolean doneCur = false;

            if (i >= len) {
                allDone = true;
                doneCur = true;
            } else {
                char ch = emails.charAt(i);

                if (ch == ' ' || ch == '\t' || ch == ',' || ch == ';' || ch == ':') {
                    if (curEmail.length() > 0) {
                        doneCur = true;
                    }
                } else {
                    curEmail.append(ch);
                }
            }

            if (doneCur) {
                String current = curEmail.toString().trim();
                if (current.length() > 0) {
                    list.add(current);
                    curEmail = new StringBuilder();
                }
            }

            if (allDone) {
                break;
            }

            i++;
        }

        for (i = 0; i < len; i++) {
            char ch = emails.charAt(i);
        }
        // list.Add (emails);
        int num = list.size();
        String[] arr = new String[num];
        for (i = 0; i < num; i++) {
            // arr[i] = (string) list[i];
            arr[i] = list.get(i);
        }

        return arr;
    }

    public static String[] getEmailArray2(final String emails) {

        String[] str = emails.split(" |\t|;|,|:");
        return str;
    }

}
