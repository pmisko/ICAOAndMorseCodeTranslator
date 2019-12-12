package pl.pmisko.Translator;

import org.apache.log4j.Logger;
import pl.pmisko.Main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "Code", urlPatterns = {"/api"})
public class TranslatorServlet extends HttpServlet {
    private final static String SENTENCE_PARAM = "sentence";
    private final static String CODE_PARAM = "code";
    private final Logger logger = Logger.getLogger(Main.class);
    private TranslatorService service = new TranslatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Got request with parameters" + req.getParameterMap());
        var sentence = req.getParameter(SENTENCE_PARAM);
        var codeType = req.getParameter(CODE_PARAM);
        Optional.of(sentence)
                .filter(s -> !s.isEmpty())
                .ifPresentOrElse(s -> translate(resp, sentence, codeType), () -> {
                    badRequest(resp);
                });
    }

    private void badRequest(HttpServletResponse resp) {
        try {
            resp.getWriter().write("Incorrect request parameters");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void translate(HttpServletResponse resp, String sentence, String codeType) {
        try {
            resp.getWriter().write(service.doTranslation(sentence, codeType));
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

