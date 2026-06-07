package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButton extends JButton {

    ClearButton(TextField textField){
        super("Clear");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.clear();
            }
        });
    }

}
