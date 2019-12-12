package pl.pmisko.Translator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
@RunWith(MockitoJUnitRunner.class)
public class TranslatorServletTest {
    TranslatorServlet servlet;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() {
        servlet = new TranslatorServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }
    @Test
    public void doGetWithoutRequestParametersShouldReturnFallBackMsg() throws IOException, ServletException {
        final String expectedMsg="Incorrect request parameters";

        request.addParameter("sentence", "");
        request.addParameter("code", "");

        servlet.doGet(request, response);

        Assert.assertEquals(expectedMsg, response.getContentAsString());
    }

    @Test
    public void doGetWithoutSentenceParameter() throws IOException, ServletException {
        final String expectedMsg="Incorrect request parameters";

        request.addParameter("sentence", "");
        request.addParameter("code", "morse");

        servlet.doGet(request, response);

        Assert.assertEquals(expectedMsg, response.getContentAsString());
    }
    @Ignore
    @Test
    public void doGetWithoutCodeParameter() throws IOException, ServletException {
        final String expectedMsg="Incorrect request parameters";

        request.addParameter("sentence", "AbC");
        request.addParameter("code", "");

        servlet.doGet(request, response);

        Assert.assertEquals(expectedMsg, response.getContentAsString());
    }
}
