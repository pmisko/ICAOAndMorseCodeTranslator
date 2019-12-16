package pl.pmisko.Dictionary;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DictionaryRepositoryTest {
    private DictionaryRepository repository= new DictionaryRepository();

    @Test
    public void initDictionaryShouldReturnAppropriateDictionaryMap() {
        final String aMorse= ".-";
        final String aIcao= "Alfa";

        Map<Character, String> morseDictionary;
        Map<Character, String> icaoDictionary;

        DictionaryType morseType=DictionaryType.MORSE;
        DictionaryType icaoType=DictionaryType.ICAO;

        morseDictionary = repository.initDictionary(morseType);
        icaoDictionary = repository.initDictionary(icaoType);

        Assert.assertEquals(aMorse, morseDictionary.get('A'));
        Assert.assertEquals(aIcao, icaoDictionary.get('A'));
        }
    }
