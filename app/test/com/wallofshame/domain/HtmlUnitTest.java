package com.wallofshame.domain;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: twer
 * Date: 3/15/12
 * Time: 2:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class HtmlUnitTest {
    
    @Test
    @Ignore
    public void canAccessHtmlUnitWelcomePage() throws IOException {
        WebClient client = new WebClient();
        HtmlPage welcomePage = client.getPage("http://htmlunit.sourceforge.net");
        assertEquals("Welcome to HtmlUnit",welcomePage.getTitleText());
    }
}
