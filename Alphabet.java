package enigma;

/** An alphabet of encodable characters.  Provides a mapping from characters
 *  to and from indices into the alphabet.
 *  @author Megan Mehta
 */
class Alphabet {

    /** A new alphabet containing CHARS. The K-th character has index
     *  K (numbering from 0). No character may be duplicated. */
    Alphabet(String chars) {
        if(chars.isBlank() || chars.isEmpty()){
            System.out.println("ERROR: Alphabet cannot be an empty string. " +
                    "Overriding with default Alphabet");
            _alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            // what should we do if the given alphabet is too short yet not null?
        }
        else{
            _alphabet = chars;
        }
    }

    /** A default alphabet of all upper-case characters. */
    Alphabet() {
        this("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    /** Returns the size of the alphabet. */
    int size() {
        return _alphabet.length();
    }

    /** Returns true if CH is in this alphabet. */
    boolean contains(char ch) {
        return (_alphabet.contains(Character.toString(ch)));
    }

    /** Returns character number INDEX in the alphabet, where
     *  0 <= INDEX < size(). */
    char toChar(int index) {
        try{
            return _alphabet.charAt(index);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ERROR: Invalid index");
            return ' ';
        }
    }

    /** Returns the index of character CH which must be in
     *  the alphabet. This is the inverse of toChar(). */
    int toInt(char ch) {
        return _alphabet.indexOf(ch);
    }

    String _alphabet;
}
