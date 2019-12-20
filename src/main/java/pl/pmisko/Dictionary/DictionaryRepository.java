package pl.pmisko.Dictionary;

import org.eclipse.jetty.io.WriterOutputStream;

import javax.persistence.Entity;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

class DictionaryRepository {

    DictionaryRepository() {
    }

    Map<Character, String> initDictionary(DictionaryType type) {
        Map<Character, String> dictionary = new HashMap<>();
        if (type.equals(DictionaryType.ICAO)) {
            dictionary = icaoLetterMap;
        } else if (type.equals(DictionaryType.MORSE)) {
            dictionary = morseLetterMap;
        }
        return dictionary;
    }

    private final static Map<Character, String> icaoLetterMap = new HashMap<>() {
        {
            put('A', "Alfa");
            put('B', "Bravo");
            put('C', "Charlie");
            put('D', "Delta");
            put('E', "Echo");
            put('F', "Foxtrot");
            put('G', "Golf");
            put('H', "Hotel");
            put('I', "India");
            put('J', "Juliett");
            put('K', "Kilo");
            put('L', "Lima");
            put('M', "Mike");
            put('N', "November");
            put('O', "Oscar");
            put('Q', "Quebec");
            put('P', "Papa");
            put('R', "Romeo");
            put('S', "Sierra");
            put('U', "Uniform");
            put('T', "Tango");
            put('V', "Victor");
            put('W', "Whiskey");
            put('X', "X-ray");
            put('Y', "Yankee");
            put('Z', "Zulu");
            put('1', "One");
            put('2', "Two");
            put('3', "Three");
            put('4', "Four");
            put('5', "Five");
            put('6', "Six");
            put('7', "Seven");
            put('8', "Eight");
            put('9', "Nine");
            put('0', "Zero");

        }
    };

    private final static Map<Character, String> morseLetterMap = new HashMap<>() {
        {
            put('A', ".-");
            put('B', "-...");
            put('C', "-.-.");
            put('D', "-..");
            put('E', ".");
            put('F', "..-.");
            put('G', "--.");
            put('H', "....");
            put('I', "..");
            put('J', ".---");
            put('K', "-.");
            put('L', ".-..");
            put('M', "--");
            put('N', "-.");
            put('O', "---");
            put('P', ".--.");
            put('Q', "--.-");
            put('R', ".-.");
            put('S', "...");
            put('T', "-");
            put('U', "..-");
            put('V', "...-");
            put('W', ".--");
            put('X', "-..-");
            put('Y', "-.--");
            put('Z', "--..");
            put('1', ".----");
            put('2', "..---");
            put('3', "...--");
            put('4', "....-");
            put('5', ".....");
            put('6', "-....");
            put('7', "--...");
            put('8', "---..");
            put('9', "----.");
            put('0', "-----");
        }
    };
}