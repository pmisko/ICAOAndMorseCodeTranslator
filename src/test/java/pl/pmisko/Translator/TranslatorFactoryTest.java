package pl.pmisko.Translator;

import org.junit.Assert;
import org.junit.Test;
import pl.pmisko.Dictionary.DictionaryType;

import static org.junit.Assert.*;

public class TranslatorFactoryTest {
    private TranslatorFactory factory = new TranslatorFactory();

    @Test
    public void produceShouldReturnAppropriateDictionaryType() {
        final String codeTypeMorse = "MorSE";
        final String codeTypeIcao = "IcaO";

        final DictionaryType resultFromFactoryWithTypeIcao = factory.produce(codeTypeIcao);
        final DictionaryType resultFromFromFactoryWithTypeMorse = factory.produce(codeTypeMorse);

        Assert.assertEquals(DictionaryType.MORSE, resultFromFromFactoryWithTypeMorse);
        Assert.assertEquals(DictionaryType.ICAO, resultFromFactoryWithTypeIcao);
    }
}