package excepions;
public class ValorAcessoInvalidoException extends Exception {

    private float nulo;

    public ValorAcessoInvalidoException (float nulo) {
        super();
        this.nulo = nulo;
    }

    public String toString() {
        return "Entrada invalida!";
    }
}