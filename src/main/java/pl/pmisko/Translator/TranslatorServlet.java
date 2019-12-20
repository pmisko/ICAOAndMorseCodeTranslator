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
    private final static String FALL_BACK_MSG = "Please enter the sentence";
    private final static String REQ_WCODE_PARAM_MSG = "Incorrect request!";
    private final Logger logger = Logger.getLogger(Main.class);
    private TranslatorService service = new TranslatorService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("Got request with parameters" + req.getParameterMap());
        var sentence = req.getParameter(SENTENCE_PARAM);
        var code = req.getParameter(CODE_PARAM);

        if (code.isEmpty()) {
            resp.getWriter().write(REQ_WCODE_PARAM_MSG);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            getAnswer(resp, sentence, code);
        }
    }

    private void getAnswer(HttpServletResponse resp, String sentence, String code) throws IOException {
        if (!sentence.isEmpty()) {
            resp.getWriter().write(service.doTranslation(sentence, code));
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.getWriter().write(FALL_BACK_MSG);
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}