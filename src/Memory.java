import java.util.Objects;

public class Memory {

    private String previousOperator;
    private Double numberInMemory;


    Memory(){
        previousOperator = "";
        numberInMemory = null;
    }


    public String getPreviousOperator() {
        return previousOperator;
    }

    public void setPreviousOperator(String previousOperator) {
        this.previousOperator = previousOperator;
    }

    public double getNumberInMemory() {
        if(Objects.isNull(numberInMemory))
            return Double.NaN;
        else
            return numberInMemory;
    }

    public void setNumberInMemory(double numberInMemory) {
        this.numberInMemory = numberInMemory;
    }

}
