package ar.edu.unq.aop;

public class Persona {

    private String dialogo = "Necesitaría un desodorante";

    public void setDialogo(final String dialogo) {
        this.dialogo = dialogo;
    }

    public void comprar() {
        System.out.println(dialogo);
    }

}