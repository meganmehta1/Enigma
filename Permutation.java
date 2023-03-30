package enigma;

import java.util.*;

import static enigma.EnigmaException.*;

/** Represents a permutation of a range of integers starting at 0 corresponding
 *  to the characters of an alphabet.
 *  @author Megan Mehta
 */
class Permutation {

    /** Set this Permutation to that specified by CYCLES, a string in the
     *  form "(cccc) (cc) ..." where the c's are characters in ALPHABET, which
     *  is interpreted as a permutation in cycle notation.  Characters in the
     *  alphabet that are not included in any cycle map to themselves.
     *  Whitespace is ignored.
     *
     *  Author's Notes:
     *  Split cycle strings at ) then replace all ( with null to get ArrayList
     *  of Strings with pure characters
     *  Attempt to add all cycles by calling addCycle */
    Permutation(String cycles, Alphabet alphabet) {
        _alphabet = alphabet;
        List<String> tempCycles = new ArrayList<>();
        tempCycles = Arrays.asList(cycles.split("\\)"));

        for (int i = 0; i < tempCycles.size(); i++) {
            tempCycles.set(i, tempCycles.get(i).replaceAll("\\(", ""));
            addCycle(tempCycles.get(i));
        }
    }

    /** Add the cycle c0->c1->...->cm->c0 to the permutation, where CYCLE is
     *  c0c1...cm.
     *  Attempts to add cycle from tempCycles to _cycles if all characters
     *  in given cycle are in alphabet */
    private void addCycle(String cycle){
        for (int i = 0; i < cycle.length(); i++) {
            if(_alphabet.contains(cycle.charAt(i))){
                if(i == cycle.length()-1){
                    this._cycles.add(cycle);
                }
            }
            // how do we throw an exception if cycle characters are not in the alphabet
//            else{
//                throw(EnigmaException);
//            }
        }
    }

    /** Return the value of P modulo the size of this permutation. */
    final int wrap(int p) {
        int r = p % size();
        if (r < 0) {
            r += size();
        }
        return r;
    }

    /** Returns the size of the alphabet I permute. */
    int size() {
        return 0; // FIXME
    }

    /** Return the result of applying this permutation to P modulo the
     *  alphabet size. */
    int permute(int p) {
        return 0;  // FIXME
    }

    /** Return the result of applying the inverse of this permutation
     *  to  C modulo the alphabet size. */
    int invert(int c) {
        return 0;  // FIXME
    }

    /** Return the result of applying this permutation to the index of P
     *  in ALPHABET, and converting the result to a character of ALPHABET. */
    char permute(char p) {
        return 0;  // FIXME
    }

    /** Return the result of applying the inverse of this permutation to C. */
    char invert(char c) {
        this.derangement();
        this._cycles.derangement();
        _cycles.size();
        _cycles.derangement();
        return 0;  // FIXME
    }

    /** Return the alphabet used to initialize this Permutation. */
    Alphabet alphabet() {
        return _alphabet;
    }

    /** Return true iff this permutation is a derangement (i.e., a
     *  permutation for which no value maps to itself). */
//    boolean derangement() {
//        for (int i = 0; i < ; i++) {
//            for(int j = 0; j < ; j++){
//                if(__ && __){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    /** Alphabet of this permutation. */
    private Alphabet _alphabet;
    public List<String> _cycles = new ArrayList<>();
}
