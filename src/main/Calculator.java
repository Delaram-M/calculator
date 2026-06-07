import GUI.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Calculator {

    private CalculatorWindow GUI;
    private Memory memory;


    Calculator(){
        GUI = new CalculatorWindow();
        setNonTextFieldActions();
        memory = new Memory();
    }

    private void setNonTextFieldActions(){

        ///operators
        for(String operator: GUI.getOperatorButtons().keySet()){
            GUI.getOperatorButtons().get(operator).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!((memory.getPreviousOperator().equals("\\") && GUI.getTextField().getDecimal() == 0) ||
                            GUI.getTextField().getText().equals(""))){
                        if(memory.getPreviousOperator().isEmpty())
                            memory.setNumberInMemory(GUI.getTextField().getDecimal());
                        else
                            memory.setNumberInMemory(calculate(GUI.getTextField().getDecimal()));
                        memory.setPreviousOperator(operator);
                        GUI.getTextField().clear();
                    }
                    System.out.printf("MEMORY:  number:%f \t operator:%s\n",memory.getNumberInMemory(),memory.getPreviousOperator());
                }
            });
        }

        //delete
        GUI.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memory.setNumberInMemory(Double.NaN);
                memory.setPreviousOperator("");
                System.out.printf("MEMORY:  number:%f \t operator:%s\n",memory.getNumberInMemory(),memory.getPreviousOperator());
            }
        });

        //equals
        GUI.getEqualsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(memory.getPreviousOperator().equals("\\") && GUI.getTextField().getDecimal() == 0)){
                    if(Double.isNaN(memory.getNumberInMemory()) && !(GUI.getTextField().getText().equals(""))){
                        memory.setNumberInMemory(GUI.getTextField().getDecimal());
                        GUI.getTextField().clear();
                    }
                    if(!(memory.getPreviousOperator().equals("") || GUI.getTextField().getText().equals("")))
                        memory.setNumberInMemory(calculate(GUI.getTextField().getDecimal()));
                    if(!Double.isNaN(memory.getNumberInMemory())) {
                        NumberFormat formatter = new DecimalFormat("#0.#############");
                        GUI.getTextField().setText(formatter.format(memory.getNumberInMemory()));
                    }
                    else
                        GUI.getTextField().clear();
                    memory.setPreviousOperator("");
                    memory.setNumberInMemory(Double.NaN);
                    System.out.printf("MEMORY:  number:%f \t operator:%s\n",memory.getNumberInMemory(),memory.getPreviousOperator());
                }
            }
        });


    }


    private double calculate(double secondNumber){
        double firstNumber = memory.getNumberInMemory();
        String operator = memory.getPreviousOperator();
        double result;
        if(operator.equals("+"))
            result = firstNumber + secondNumber;
        else if(operator.equals("-"))
            result = firstNumber - secondNumber;
        else if(operator.equals("*"))
            result = firstNumber * secondNumber;
        else
            result = firstNumber / secondNumber;
        return result;
    }

}