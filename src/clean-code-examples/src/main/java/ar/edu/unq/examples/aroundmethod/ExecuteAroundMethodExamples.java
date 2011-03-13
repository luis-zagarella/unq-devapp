package ar.edu.unq.examples.aroundmethod;

public class ExecuteAroundMethodExamples {

    public void execute(final String param) {
        this.start();
        Repository.operate(param);
        this.close();
    }

    public void execute2(final String param, final String param2, final int param3) {
        this.start();
        Repository.operate(param, param2, param3);
        this.close();
    }

    public void execute3(final String param, final String param2, final String param3) {
        this.start();
        Repository.operate(param, param2, param3);
        this.close();
    }

    // /////////////////////////////////////
    // /////////////////////////////////////
    // /////////////////////////////////////
    // /////////////////////////////////////

    static class Repository {

        public static void operate(final String param, final String param2, final String param3) {
            // TODO Auto-generated method stub

        }

        public static void operate(final String param) {
            // TODO Auto-generated method stub

        }

        public static void operate(final String param, final String param2, final int param3) {
            // TODO Auto-generated method stub

        }

    }

    private void close() {

    }

    private void start() {

    }

}
