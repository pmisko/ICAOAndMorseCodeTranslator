package pl.pmisko.Translator;

import pl.pmisko.Dictionary.DictionaryService;
import pl.pmisko.Dictionary.DictionaryType;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Translator implements TranslatorInterface {

    private DictionaryService dictionaryService = new DictionaryService();
    private TranslatorFactory factory = new TranslatorFactory();

    private String FALL_BACK_CHAR = "*";

    @Override
    public String translate(String sentence, String codeType) {
        final DictionaryType dictionaryType = getDictionaryType(codeType);
        final Map<Character, String> appropriateDictionaryMap = getAppropriateDictionaryMap(dictionaryType);
        return doTranslation(sentence, appropriateDictionaryMap);
    }

    DictionaryType getDictionaryType(String type) {
        return factory.produce(type);
    }

    Map<Character, String> getAppropriateDictionaryMap(DictionaryType type) {
        return dictionaryService.getDictionary(type);
    }

    private String doTranslation(String sentence, Map<Character, String> dictionary) {
        String translationInProgress = sentence.toUpperCase().chars()
                .mapToObj(c -> (char) c)
                .map(c -> {
                    if (c.toString().equals(" ")) {
                        return " ";
                    } else if (c.toString().matches("\\s|[A-Z0-9]")) {
                        return dictionary.get(c);
                    } else return FALL_BACK_CHAR;
                })
                .collect(Collectors.toList())
                .toString();
        return translationInProgress.replaceAll("[,\\[\\]]", "");
    }
}