public class ExceptionHandling extends Exception{
    String errorMessage;

    public ExceptionHandling(String message){
        errorMessage = message;
    }  
    public String getMessage(){
        return errorMessage;
    }
}

