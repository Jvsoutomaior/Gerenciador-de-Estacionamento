package exceptions;

public class DescricaoEmBrancoException extends Exception{
    public DescricaoEmBrancoException (String message){
        super(message);
        message = "Entrada invalida!";
    }
}