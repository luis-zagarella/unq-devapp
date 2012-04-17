package example.aop;

public class Persona {

    private String dialogo = "Necesitaria un desodorante";

    public Persona() {
    }

    public void setDialogo(final String dialogo) {
        this.dialogo = dialogo;
    }

    public void comprar() {
        System.out.println(dialogo);
    }

}