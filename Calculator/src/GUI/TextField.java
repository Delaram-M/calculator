package GUI;

import javax.swing.*;

public class TextField extends JTextField {

    TextField(){
        super("");
    }


    public double getDecimal(){
        return Double.parseDouble(getText());
    }

    public void clear(){
        setText("");
    }

    public void addDigit(String digit){
        String numberString = getText() + digit;
        this.setText(numberString);
    }

    public void changeSign(){
        if(getText().startsWith("-"))
            setText(getText().substring(1));
        else
            setText("-" + getText());
    }


}
