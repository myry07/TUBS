package array;

import org.junit.Test;
import static org.junit.Assert.*;


public class EvenArrayTest {
    public boolean testArray(int[][] expected, int[][] actual){
        //Prüfe, ob Anzahl Zeilen identisch ist.
        if (expected.length != actual.length){
            return false;
        }
        
        for (int i = 0; i < expected.length; ++i){
            //Prüfe, ob Zeilen identische Länge besitzen.
            if (expected[i].length != actual[i].length){
                return false;
            }
            
            for (int j = 0; j < expected[i].length; ++j){
                //Prüfe, ob Werte in Zellen identisch sind.
                if (expected[i][j] != actual[i][j]){
                    return false;
                }
            }
        }
        
        return true;
    }

    @Test
    public void c0TestEvenArray() {
        //C0-Test für EvenArray. 
        int[][] expected = {{0,0},{0,0},{0,2}};
        assertTrue(testArray(expected, EvenArray.buildEvenArray(2,3)));
    }
    
    @Test
    public void c1TestEvenArray() {
        //C1-Test für EvenArray. 
        int[][] expected = {{0,0},{0,0},{0,2}};
        assertTrue(testArray(expected, EvenArray.buildEvenArray(2,3)));
    }
    
    @Test
    public void c1_2TestEvenArray() {
        //C1-Test für EvenArray. 
        int[][] expected = {{0,0},{0,0},{0,2}};
        assertTrue(testArray(new int[0][0], EvenArray.buildEvenArray(0,0)));
    }
}