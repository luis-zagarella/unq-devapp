package ar.edu.unq.aop;

public class Persona {

    private String dialogo = "Necesitaría un desodorante";

    public Persona() {
        System.out.println("constructor");
    }

    public void setDialogo(final String dialogo) {
        this.dialogo = dialogo;
    }

    public void comprar() {
        System.out.println(dialogo);
    }

}