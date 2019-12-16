package pl.pmisko.Dictionary;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class DictionaryServiceTest {
    private DictionaryRepository repository = new DictionaryRepository();
    private DictionaryService service = new DictionaryService();

    @Test
    public void getDictionaryShouldReturnAppropriateDictionary() {
        final String aMorse = ".-";
        final String aIcao = "Alfa";

        Map<Character, String> morseDictionary;
        Map<Character, String> icaoDictionary;

        DictionaryType morseType = DictionaryType.MORSE;
        DictionaryType icaoType = DictionaryType.ICAO;

        morseDictionary = service.getDictionary(morseType);
        icaoDictionary = service.getDictionary(icaoType);

        Assert.assertEquals(aMorse, morseDictionary.get('A'));
        Assert.assertEquals(aIcao, icaoDictionary.get('A'));
    }
}