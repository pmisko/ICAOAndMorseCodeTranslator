package pl.pmisko.Translator;

import pl.pmisko.Dictionary.DictionaryType;

class TranslatorFactory {
    private DictionaryType type;

    DictionaryType produce(String codeType) {
        if (codeType.toLowerCase().equals("morse")) {
            type = DictionaryType.MORSE;
        } else if (codeType.toLowerCase().equals("icao")) {
            type = DictionaryType.ICAO;
        }
        return type;
    }
}
