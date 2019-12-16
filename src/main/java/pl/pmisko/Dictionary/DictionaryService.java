package pl.pmisko.Dictionary;

import java.util.Map;

public class DictionaryService {
    private DictionaryRepository dictionaryRepository = new DictionaryRepository();

     Map<Character, String> getDictionary (DictionaryType type) {
        return dictionaryRepository.initDictionary(type);
    }
}
