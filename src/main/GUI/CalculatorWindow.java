package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CalculatorWindow extends JFrame {

    private JPanel panel;
    private TextField textField;
    private HashMap<String, OperatorButton>  operatorButtons = new HashMap<>();
    private HashMap<String, NumberButton> numberButtons = new HashMap<>();
    private DotButton dotButton;
    private EqualsButton equalsButton;
    private SignButton signButton;
    private ClearButton clearButton;
    private DeleteButton deleteButton;


    public CalculatorWindow(){

        super("Calculator");
        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
        this.setIconImage(icon);
        this.setVisible(true);
        this.setSize(400,500);
        GridLayout gridLayout = new GridLayout();
        this.setLayout(gridLayout);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //panel
        panel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);
        panel.setBackground(Color.DARK_GRAY);
        this.add(panel);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipady = 40;

        //text field
            //row 0
        textField = new TextField();
        textField.setEditable(false);
        textField.setBackground(Color.LIGHT_GRAY);
        gbc.insets = new Insets(5,10,5,10);
        gbc.gridx = 0;
        gbc.gridy= 0;
        gbc.gridwidth = 4;
        panel.add(textField,gbc);

        //buttons
            //row 1
        deleteButton = new DeleteButton();
        deleteButton.setBackground(Color.RED);
        gbc.insets = new Insets(5,10,5,5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(deleteButton,gbc);

        clearButton = new ClearButton(textField);
        clearButton.setBackground(Color.RED);
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(clearButton,gbc);

        operatorButtons.put("\\", new OperatorButton("\\"));
        operatorButtons.get("\\").setBackground(Color.BLACK);
        operatorButtons.get("\\").setForeground(Color.RED);
        gbc.insets = new Insets(5,5,5,10);
        gbc.gridx = 3;
        gbc.gridwidth = 1;
        panel.add(operatorButtons.get("\\"),gbc);

            //row 2
        numberButtons.put("7", new NumberButton("7", textField));
        gbc.insets = new Insets(5,10,5,5);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 35;
        panel.add(numberButtons.get("7"),gbc);


        numberButtons.put("8", new NumberButton("8", textField));
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 1;
        panel.add(numberButtons.get("8"),gbc);

        numberButtons.put("9", new NumberButton("9", textField));
        gbc.gridx = 2;
        panel.add(numberButtons.get("9"),gbc);

        operatorButtons.put("*", new OperatorButton("*"));
        operatorButtons.get("*").setBackground(Color.BLACK);
        operatorButtons.get("*").setForeground(Color.RED);
        gbc.insets = new Insets(5,5,5,10);
        gbc.gridx = 3;
        panel.add(operatorButtons.get("*"),gbc);

            //row 3
        numberButtons.put("4", new NumberButton("4", textField));
        gbc.insets = new Insets(5,10,5,5);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(numberButtons.get("4"),gbc);

        numberButtons.put("5", new NumberButton("5", textField));
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 1;
        panel.add(numberButtons.get("5"),gbc);

        numberButtons.put("6", new NumberButton("6", textField));
        gbc.gridx = 2;
        panel.add(numberButtons.get("6"),gbc);

        operatorButtons.put("-", new OperatorButton("-"));
        operatorButtons.get("-").setBackground(Color.BLACK);
        operatorButtons.get("-").setForeground(Color.RED);
        gbc.insets = new Insets(5,5,5,10);
        gbc.gridx = 3;
        panel.add(operatorButtons.get("-"),gbc);

            //row 4
        numberButtons.put("1", new NumberButton("1", textField));
        gbc.insets = new Insets(5,10,5,5);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(numberButtons.get("1"),gbc);

        numberButtons.put("2", new NumberButton("2", textField));
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 1;
        panel.add(numberButtons.get("2"),gbc);

        numberButtons.put("3", new NumberButton("3", textField));
        gbc.gridx = 2;
        panel.add(numberButtons.get("3"),gbc);

        operatorButtons.put("+", new OperatorButton("+"));
        operatorButtons.get("+").setBackground(Color.BLACK);
        operatorButtons.get("+").setForeground(Color.RED);
        gbc.insets = new Insets(5,5,5,10);
        gbc.gridx = 3;
        panel.add(operatorButtons.get("+"),gbc);

            //row 5
        signButton = new SignButton(textField);
        gbc.insets = new Insets(5,10,5,5);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(signButton,gbc);

        numberButtons.put("0", new NumberButton("0", textField));
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 1;
        panel.add(numberButtons.get("0"),gbc);

        dotButton = new DotButton(textField);
        gbc.gridx = 2;
        panel.add(dotButton,gbc);

        equalsButton = new EqualsButton();
        equalsButton.setBackground(Color.WHITE);
        equalsButton.setForeground(Color.RED);
        gbc.insets = new Insets(5,5,5,10);
        gbc.gridx = 3;
        panel.add(equalsButton,gbc);

        this.revalidate();

    }


    public TextField getTextField() {
        return textField;
    }

    public HashMap<String, OperatorButton> getOperatorButtons() {
        return operatorButtons;
    }

    public EqualsButton getEqualsButton() {
        return equalsButton;
    }

    public DeleteButton getDeleteButton() {
        return deleteButton;
    }


}
