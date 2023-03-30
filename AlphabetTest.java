package enigma;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

import java.util.HashMap;

import static enigma.TestUtils.*;

/** The suite of all JUnit tests for the Alphabet class.
 * @author Megan Mehta
 */

public class AlphabetTest {
    /* ***** TESTS ***** */

    @Test
    public void basicBulkTest() {
        String testStr = "ABCD";
        Alphabet testVar = new Alphabet(testStr);
        char curr;

        for (int i = 0; i < testStr.length(); i++) {
            curr = testStr.charAt(i);

            assertEquals(curr, testVar.toChar(i));
            assertEquals(i, testVar.toInt(curr));
            assertTrue(testVar.contains(curr));
        }
        assertFalse(testVar.contains('a'));
        assertEquals(testVar.size(), testStr.length());
    }

    @Test
    public void complexBulkTest(){
        String testStr = "abcdefzxyw1092";
        Alphabet testVar = new Alphabet(testStr);

        for(int i = 0; i < testStr.length(); i++){
            char curr = testStr.charAt(i);
            assertEquals(curr, testVar.toChar(i));
            assertEquals(i, testVar.toInt(curr));
            assertTrue(testVar.contains(curr));
        }
        assertFalse(testVar.contains('A'));
        assertEquals(testVar.size(), testStr.length());
    }

    @Test
    public void emptyTest(){
        Alphabet testVar = new Alphabet("");

        assertEquals(26, testVar.size());
        assertFalse(testVar.contains(' '));
    }
}
