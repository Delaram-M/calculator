import GUI.TextField;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class TextFieldTest {

    private TextField textField;

    @Before
    public void setUp() {
        textField = new TextField();
    }

    @After
    public void tearDown() {
        textField = null;
    }

    @Test
    public void noTextGetTest(){
        assertEquals("", textField.getText());
    }

    @Test
    public void oneDigitTextGetTest(){
        textField.addDigit("1");
        assertEquals("1", textField.getText());
    }

    @Test
    public void multiDigitTextGetTest(){
        textField.addDigit("1");
        textField.addDigit("2");
        textField.addDigit("3");
        assertEquals("123", textField.getText());
    }

    @Test
    public void floatTextGetTest(){
        textField.addDigit("1");
        textField.addDigit("2");
        textField.addDigit(".");
        textField.addDigit("3");
        assertEquals("12.3", textField.getText());
    }

    @Test
    public void positiveToNegativeChangeSignTest(){
        textField.addDigit("1");
        textField.addDigit("2");
        textField.changeSign();
        assertEquals("-12", textField.getText());
    }

    @Test
    public void doubleChangeSignTest(){
        textField.addDigit("1");
        textField.addDigit("2");
        textField.changeSign();
        assertEquals("-12", textField.getText());
        textField.changeSign();
        assertEquals("12", textField.getText());
    }

    @Test
    public void floatChangeSignTest(){
        textField.addDigit("1");
        textField.addDigit("2");
        textField.addDigit(".");
        textField.addDigit("3");
        textField.changeSign();
        assertEquals("-12.3", textField.getText());
        textField.changeSign();
        assertEquals("12.3", textField.getText());
    }

    @Test
    public void clearPositiveTest(){
        textField.addDigit("1");
        textField.addDigit("2");
        textField.clear();
        assertEquals("", textField.getText());
    }

    @Test
    public void clearNegativeTest(){
        textField.addDigit("1");
        textField.addDigit("2");
        textField.changeSign();
        textField.clear();
        assertEquals("", textField.getText());
    }

    @Test
    public void clearPositiveFloatTest(){
        textField.addDigit("1");
        textField.addDigit("2");
        textField.addDigit(".");
        textField.addDigit("3");
        textField.clear();
    }

    @Test
    public void clearNegativeFloatTest(){
        textField.addDigit("1");
        textField.addDigit("2");
        textField.addDigit(".");
        textField.addDigit("3");
        textField.changeSign();
        textField.clear();
    }

}
