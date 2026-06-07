package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignButton extends JButton {

    SignButton(TextField textField){
        super("+/-");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.changeSign();
            }
        });
    }

}
