package ar.edu.unq.examples.aroundmethod;

import ar.edu.unq.doit.DoInBlock;
import ar.edu.unq.examples.aroundmethod.ExecuteAroundMethodExamples.Repository;

public class ExecuteAroundMethod2Examples {

    public void execute(final String param) {
        DoInBlock doInBlock = new DoInBlock() {
            @Override
            protected void doOperation() {
                Repository.operate(param);
            }

            @Override
            public void close() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void start() {
                throw new UnsupportedOperationException();
            }
        };
        doInBlock.execute();
    }

    public void execute2(final String param, final String param2, final int param3) {
        DoInBlock doInBlock = new DoInBlock() {
            @Override
            protected void doOperation() {
                Repository.operate(param, param2, param3);
            }

            @Override
            public void close() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void start() {
                throw new UnsupportedOperationException();
            }
        };
        doInBlock.execute();
    }

    public void execute3(final String param, final String param2, final String param3) {
        DoInBlock doInBlock = new DoInBlock() {
            @Override
            protected void doOperation() {
                Repository.operate(param, param2, param3);
            }

            @Override
            public void close() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void start() {
                throw new UnsupportedOperationException();
            }
        };
        doInBlock.execute();
    }

}
