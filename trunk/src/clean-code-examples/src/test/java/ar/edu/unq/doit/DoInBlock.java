package ar.edu.unq.doit;

public abstract class DoInBlock {

    public void execute() {
        this.start();
        this.doOperation();
        this.close();

    }

    public abstract void close();

    public abstract void start();

    protected abstract void doOperation();
}
