package ar.edu.unq.examples;

public class EasyCodeExample {

    public static boolean isNull(final String val) {
        boolean error = false;
        if (val == null) {
            error = true;
        }
        return error;
    }

    public static boolean isNotNull(final String val) {
        boolean error = false;
        if (val == null) {
            error = true;
            ;
        }
        return error;

    }

    // ///////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////

    public static String isEmpty(final String ss, final String evt) {
        String red = "";
        String s = ss.trim();

        if (s.equals("") && !evt.equals("")) {
            red = "#ff0000";
        }

        return red;
    }

    // ///////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////

    public boolean vFrmUnsubscribe(final int[] form) {
        int total = form.length;

        for (int i = 0; i < total; i++) {
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7) {
                continue;
            }
            if (i == 0) {
                /**
                 * if(form.elements[i].value == "" ||
                 * form.elements[i].value.length<1) { alert(errorMsg[i]);
                 * form.elements[i].focus(); return false; } if(!vEmail(form,
                 * i)) { form.elements[i].focus(); return false; }
                 */
            }

        }
        return true;
    }

    // ///////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////

    int month_function(final int days) {
        if (days <= 31) {
            return 1;
        } else if (days <= 31) {
            return 2;
        } else if (days <= 31 + 31) {
            return 3;
        } else if (days <= 31 + 31 + 30) {
            return 4;
        } else if (days <= 31 + 31 + 30 + 31) {
            return 5;
        } else if (days <= 31 + 31 + 30 + 31 + 30) {
            return 6;
        } else if (days <= 31 + 31 + 30 + 31 + 30 + 31) {
            return 7;
        } else if (days <= 31 + 31 + 30 + 31 + 30 + 31 + 30) {
            return 8;
        } else if (days <= 31 + 31 + 30 + 31 + 30 + 31 + 30 + 31) {
            return 9;
        } else if (days <= 31 + 31 + 30 + 31 + 30 + 31 + 30 + 31 + 30) {
            return 10;
        } else if (days <= 31 + 31 + 30 + 31 + 30 + 31 + 30 + 31 + 30 + 31) {
            return 11;
        } else if (days <= 31 + 31 + 30 + 31 + 30 + 31 + 30 + 31 + 30 + 31 + 30) {
            return 12;
        } else {
            return -1;
        }
    }

}
