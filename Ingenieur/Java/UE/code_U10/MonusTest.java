import org.junit.Test;
import static org.junit.Assert.*;


public class MonusTest {

    @Test
    public void c0TestMonus() {
        //C0-Test für Monus.
        assertEquals(5, Monus.monus(10,5));
    }
    
    @Test
    public void c1TestMonus() {
        //C1-Test für Monus.
        assertEquals(5, Monus.monus(10,5));
        assertEquals(0, Monus.monus(8,-1));
        assertEquals(0, Monus.monus(-2,-3));
        assertEquals(0, Monus.monus(3,4));
    }
    
    
}