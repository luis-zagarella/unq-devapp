package ar.edu.unq.refactoring;

/**
 * Cuando una clase crece y comienza a tener muchas responsabilidades comienza a
 * ser dificil de entenderla.
 * 
 * Mejor distribuir esas responsabilidades "extra" en otras.
 */
@SuppressWarnings("unused")
public class ExtractClass {

    class Person_v1 {

        private String name;

        private String officeAreaCode;

        private String officeNumber;

        public String getName() {
            return name;
        }

        public String getTelephoneNumber() {
            return "(" + officeAreaCode + ") " + officeNumber;
        }

        String getOfficeAreaCode() {
            return officeAreaCode;
        }

        void setOfficeAreaCode(final String arg) {
            officeAreaCode = arg;
        }

        String getOfficeNumber() {
            return officeNumber;
        }

        void setOfficeNumber(final String arg) {
            officeNumber = arg;
        }

    }

    /**
     * La inversa ir del v2 al v1 es InlineClass.
     */
    class Person_v2 {

        private String name;

        private TelephoneNumber officeTelephone;

        public String getName() {
            return name;
        }

        public String getTelephoneNumber() {
            return officeTelephone.getTelephoneNumber();
        }

        TelephoneNumber getOfficeTelephone() {
            return officeTelephone;
        }

    }

    class TelephoneNumber {
        private String number;

        private String areaCode;

        public String getTelephoneNumber() {
            return "(" + areaCode + ") " + number;
        }

        String getAreaCode() {
            return areaCode;
        }

        void setAreaCode(final String arg) {
            areaCode = arg;
        }

        String getNumber() {
            return number;
        }

        void setNumber(final String arg) {
            number = arg;
        }

    }

    class Page_v1 {

        private String[] lines;

        private double widthNumber;

        private String widthUnits;

        private double heightNumber;

        private String heightUnits;

        /**
         * return the page area in inches.
         */
        public double area() {
            double widthInches;
            double heightInches;

            widthInches = widthNumber * (widthUnits.equals("mm") ? 25.4 : 1.0);
            heightInches = heightNumber * (heightUnits.equals("mm") ? 25.4 : 1.0);

            return widthInches * heightInches;
        }
    }

    class Page_v2 {

        private String[] lines;

        private Length width;

        private Length height;

        public Length area() {
            return width.multipliedBy(height);
        }

    }

    static class Length {

        private final double magnitude;

        private final Unit unit;

        public Length(final Unit unit, final double magnitude) {
            this.unit = unit;
            this.magnitude = magnitude;
        }

        public Length multipliedBy(final Length aLength) {
            return Length.newInInches(this.magnitudeInInches() + aLength.magnitudeInInches());
        }

        private static Length newInInches(final double magnitudeInInches) {
            return new Length(Unit.inches, magnitudeInInches);
        }

        private double magnitudeInInches() {
            return magnitude;
        }

        private double magnitudeInMM() {
            return magnitude * Unit.mmFactor();
        }
    }

    enum Unit {
        mm, inches;

        public static double mmFactor() {
            return 25.4;
        }
    }

}
