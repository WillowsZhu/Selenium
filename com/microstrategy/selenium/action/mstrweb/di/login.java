package com.microstrategy.selenium.action.mstrweb.di;

import java.io.UnsupportedEncodingException;

import com.microstrategy.selenium.Locator;
import com.microstrategy.selenium.WebTest;
import com.microstrategy.selenium.action.Action;
import com.microstrategy.selenium.action.mstrweb.MSTRWeb;
import com.microstrategy.utils.WebURLEncoder;
import com.thoughtworks.selenium.DefaultSelenium;

public class login extends MSTRWeb {
    public login(final WebTest webTest) {
	super(webTest);
    }

    /**
     * Open web page
     *
     * @param IServer
     * @param Port
     * @param Projectname
     * @param username
     * @param pwd
     * @throws UnsupportedEncodingException
     */
    @Action
    public void commonLogin(final String IServer, final String Port,
	    final String Project, final String userName, final String passWord)
		    throws UnsupportedEncodingException {
	final String url = MSTRBaseURL + "?evt=3010&src=mstrWeb.3010"
		+ "&ServerAlias=" + WebURLEncoder.encode(IServer, "UTF-8")
		+ "&Project=" + WebURLEncoder.encode(Project, "UTF-8")
		+ "&Port="
		+ WebURLEncoder.encode(String.valueOf(Port), "UTF-8")
		+ "&Server=" + WebURLEncoder.encode(IServer, "UTF-8")
		+ "&loginReq=true";
	selenium.open(url);

	waitForPageLoadComplete(DefaultSelenium.default_timeout);

	if (selenium.getTitle().startsWith("Login")) {
	    selenium.type(Locator.id("Uid"), userName);
	    selenium.type(Locator.id("Pwd"), passWord);
	    selenium.click(CommonXPath.loginButton);
	    waitForPageLoadComplete(CommonXPath.timeout);
	    getLogger().console_info("Done login project!");
	    // selenium.click(CommonXPath.createDash);
	    // waitForPageLoadComplete(CommonXPath.timeout);
	    // selenium.click("//div[6]/div/div/div/div[3]/div/div/div/div");
	}
    }
}
