package pl.pmisko.Translator;

public class TranslatorService {
    private Translator translator = new Translator();

    public String doTranslation(String sentence, String code) {
        return translator.translate(sentence, code);
    }
}
