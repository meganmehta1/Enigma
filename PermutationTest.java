package enigma;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import static enigma.TestUtils.*;

/** The suite of all JUnit tests for the Permutation class.
 *  @author Megan Mehta
 */
public class PermutationTest {

    /** Testing time limit. */
    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    /* ***** TESTING UTILITIES ***** */

    private Permutation perm;
    private String alpha = UPPER_STRING;

    /** Check that perm has an alphabet whose size is that of
     *  FROMALPHA and TOALPHA and that maps each character of
     *  FROMALPHA to the corresponding character of FROMALPHA, and
     *  vice-versa. TESTID is used in error messages. */
    private void checkPerm(String testId,
                           String fromAlpha, String toAlpha) {
        int N = fromAlpha.length();
        assertEquals(testId + " (wrong length)", N, perm.size());
        for (int i = 0; i < N; i += 1) {
            char c = fromAlpha.charAt(i), e = toAlpha.charAt(i);
            assertEquals(msg(testId, "wrong translation of '%c'", c),
                         e, perm.permute(c));
            assertEquals(msg(testId, "wrong inverse of '%c'", e),
                         c, perm.invert(e));
            int ci = alpha.indexOf(c), ei = alpha.indexOf(e);
            assertEquals(msg(testId, "wrong translation of %d", ci),
                         ei, perm.permute(ci));
            assertEquals(msg(testId, "wrong inverse of %d", ei),
                         ci, perm.invert(ei));
        }
    }

    /* ***** TESTS ***** */

    @Test
    public void checkIdTransform() {
        perm = new Permutation("", UPPER);
        checkPerm("identity", UPPER_STRING, UPPER_STRING);
    }

    /** Tests if Permutation constructor works properly */
    @Test
    public void checkPermutation(){
        Alphabet alphabet = new Alphabet("ABCDefGHIJKLMNopQrSTuVW");
        Permutation cycles = new Permutation("(ABCD) (ef) (GHI)", alphabet);

        List<String> cyclesArrLst = new ArrayList<>();
        cyclesArrLst.add("ABCD");
        cyclesArrLst.add("ef");
        cyclesArrLst.add("GHI");
        assertEquals(cycles._cycles.get(cycles._cycles.size() - 1), cyclesArrLst.get(2));
        assertEquals(cycles._cycles.size(), cyclesArrLst.size());

    }

    /** Tests if characters are performing inverted permutations properly */
    @Test
    public void testInvertChar(){
        Alphabet alphabet = new Alphabet("ABCD");
        Permutation p = new Permutation("(BACD)", alphabet);
        assertEquals('B', p.invert('A'));
        assertEquals('D', p.invert('B'));
        assertEquals('A', p.invert('C'));

        Alphabet alphabet1 = new Alphabet("HILFNGR");
        Permutation p2 = new Permutation("(HIG) (NF) (L)", alphabet1);
        assertEquals('H', p2.invert('I'));
        assertEquals('F', p2.invert('N'));
        assertEquals('L', p2.invert('L'));
        assertEquals('G', p2.invert('H'));
    }

    /** Tests if Permutation of characters not in alphabet fails */
    @Test(expected = EnigmaException.class)
    public void testNotInAlphabet(){
        Alphabet alphabet = new Alphabet("ABCD");
        Permutation p = new Permutation("(BACD)", alphabet);
        p.invert('F');
    }

    @Test(expected = EnigmaException.class)
    public void testPermutations()
    {
        Alphabet alphabet = new Alphabet("AB");
        Permutation p = new Permutation("(AB)", alphabet);
        assertEquals('B', p.permute('A'));
        assertEquals('B', p.permute('A'));

        Alphabet alphabet1 = new Alphabet("ABC");
        Permutation p2 = new Permutation("(JKL)", alphabet1);

        Alphabet alphabet2 = new Alphabet("JKL");
        Permutation p3 = new Permutation("(JK)", alphabet2);

        Alphabet alphabet3 = new Alphabet("BCAD");
        Permutation p4 = new Permutation("(ABCD)", alphabet3);
        assertEquals('D', p4.permute('C'));
        assertEquals('A', p4.permute('D'));
        assertEquals('D', p4.permute('A'));

        Alphabet alphabet4 = new Alphabet("HILFNGR");
        Permutation p5 = new Permutation("(HIG)(NF)(L)", alphabet4);
        assertEquals('I', p5.permute('H'));
        assertEquals('N', p5.permute('F'));
        assertEquals('L', p5.permute('L'));
        assertEquals('H', p5.permute('G'));
    }

}
