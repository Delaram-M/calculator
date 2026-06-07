import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class MemoryTest {

    private Memory memory;

    @Before
    public void setUp() {
        memory = new Memory();
    }

    @After
    public void tearDown() {
        memory = null;
    }

    @Test
    public void intNumberSetAndGetTest() {
        memory.setNumberInMemory(10);
        assertEquals(10, memory.getNumberInMemory(), 0.00001);
    }

    @Test
    public void doubleNumberSetAndGetTest() {
        memory.setNumberInMemory(3.14159);
        assertEquals(3.14159, memory.getNumberInMemory(), 0.00001);
    }

    @Test
    public void noNumberGetTest() {
        assertEquals(Double.NaN, memory.getNumberInMemory(), 0.00001);
    }

    @Test
    public void plusOperatorSetAndGetTest() {
        memory.setPreviousOperator("+");
        assertEquals("+", memory.getPreviousOperator());
    }

    @Test
    public void minusOperatorSetAndGetTest() {
        memory.setPreviousOperator("-");
        assertEquals("-", memory.getPreviousOperator());
    }

    @Test
    public void multiplyOperatorSetAndGetTest() {
        memory.setPreviousOperator("*");
        assertEquals("*", memory.getPreviousOperator());
    }

    @Test
    public void divideOperatorSetAndGetTest() {
        memory.setPreviousOperator("/");
        assertEquals("/", memory.getPreviousOperator());
    }

    @Test
    public void noOperatorGetTest() {
        assertEquals("", memory.getPreviousOperator());
    }

}
