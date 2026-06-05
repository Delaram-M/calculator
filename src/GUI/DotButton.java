package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DotButton extends JButton {

    DotButton(TextField textField){
        super(".");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().equals("") && !textField.getText().contains("."))
                    textField.addDigit(".");
            }
        });
    }

}
