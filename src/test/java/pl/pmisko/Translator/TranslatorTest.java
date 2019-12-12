package pl.pmisko.Translator;

import org.junit.Assert;
import org.junit.Test;
import pl.pmisko.Dictionary.DictionaryType;

import java.util.Map;

import static org.junit.Assert.*;

public class TranslatorTest {
    private Translator translator=new Translator();
    private String FALL_BACK_SENTENCE = "Please enter the sentence";

    @Test
    public void translateShouldReturnTranslatedSentence() {
        final String codeTypeMorse="morse";
        final String codeTypeIcao="icao";
        final String givenSentence="abc abc";
        final String expectedSentenceMorse= ".- -... -.-.   .- -... -.-.";
        final String expectedSentenceIcao= "Alfa Bravo Charlie   Alfa Bravo Charlie";

        final String resultSentenceMorse = translator.translate(givenSentence, codeTypeMorse);
        final String resultSentenceIcao = translator.translate(givenSentence, codeTypeIcao);

       assertEquals(expectedSentenceMorse,resultSentenceMorse);
       assertEquals(expectedSentenceIcao,resultSentenceIcao);
    }

    @Test
    public void translateShouldReturnFallBackMsgWhenSentenceHasNotBeenEntered() {
        final String codeTypeMorse="morse";
        final String codeTypeIcao="icao";
        final String givenSentence="";

        final String resultSentenceMorse = translator.translate(givenSentence, codeTypeMorse);
        final String resultSentenceIcao = translator.translate(givenSentence, codeTypeIcao);

        assertEquals(FALL_BACK_SENTENCE,resultSentenceMorse);
        assertEquals(FALL_BACK_SENTENCE,resultSentenceIcao);
    }

    @Test
    public void translateShouldReturnAppropriateSymbolWhenDictionaryMapDoesntContainChar() {
        final String codeTypeMorse="morse";
        final String codeTypeIcao="icao";
        final String givenSentence="ąóćłż";
        final String FALL_BACK="* * * * *";

        final String resultSentenceMorse = translator.translate(givenSentence, codeTypeMorse);
        final String resultSentenceIcao = translator.translate(givenSentence, codeTypeIcao);

        assertEquals(FALL_BACK,resultSentenceMorse);
        assertEquals(FALL_BACK,resultSentenceIcao);
    }

    @Test
    public void getDictionaryTypeShouldReturnDictionaryOfGivenType() {
        final String codeTypeMorse="morse";
        final String codeTypeIcao="icao";

        final DictionaryType dictionaryTypeIcao = translator.getDictionaryType(codeTypeIcao);
        final DictionaryType dictionaryTypeMorse = translator.getDictionaryType(codeTypeMorse);

        assertEquals(dictionaryTypeMorse, DictionaryType.MORSE);
        assertEquals(dictionaryTypeIcao, DictionaryType.ICAO);
    }

    @Test
    public void getAppropriateDictionaryMap() {
        final String aMorse = ".-";
        final String aIcao = "Alfa";

        final Map<Character, String> morseDictionaryMap= translator.getAppropriateDictionaryMap(DictionaryType.MORSE);
        final Map<Character, String> icaoDictionaryMap = translator.getAppropriateDictionaryMap(DictionaryType.ICAO);

        Assert.assertEquals(aMorse, morseDictionaryMap.get('A'));
        Assert.assertEquals(aIcao, icaoDictionaryMap.get('A'));
    }
}