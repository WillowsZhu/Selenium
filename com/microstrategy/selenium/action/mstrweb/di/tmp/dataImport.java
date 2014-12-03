package com.microstrategy.selenium.action.mstrweb.DI;

import java.io.UnsupportedEncodingException;

import com.microstrategy.selenium.Locator;
import com.microstrategy.selenium.WebTest;
import com.microstrategy.selenium.Configuration.Keys;
import com.microstrategy.selenium.action.Action;
import com.microstrategy.selenium.action.mstrweb.MSTRWeb;
import com.microstrategy.selenium.utils.ParameterUtils;
import com.microstrategy.utils.WebURLEncoder;
import com.thoughtworks.selenium.DefaultSelenium;


public class dataImport extends MSTRWeb{
	
	public dataImport(WebTest webTest) {
		super(webTest);
	}
	
	/** 
	 * Open web page
	 * @param IServer
	 * @param Port
	 * @param Projectname
	 * @param username
	 * @param pwd
	 * @throws UnsupportedEncodingException 
	 */
	@Action
	public void login(String IServer, String Port, String Project, String userName, String passWord) throws UnsupportedEncodingException {
		String url = MSTRBaseURL
				+"?evt=3010&src=mstrWeb.3010"
				+ "&ServerAlias=" + WebURLEncoder.encode(IServer, "UTF-8")
				+ "&Project="+ WebURLEncoder.encode(Project, "UTF-8")
				+ "&Port="+ WebURLEncoder.encode(String.valueOf(Port), "UTF-8")
				+ "&Server=" + WebURLEncoder.encode(IServer, "UTF-8")
				+ "&loginReq=true";
		selenium.open(url);

		waitForPageLoadComplete(DefaultSelenium.default_timeout);
		
		if (selenium.getTitle().startsWith("Login")) {
			selenium.type(Locator.id("Uid"), userName);
			selenium.type(Locator.id("Pwd"), passWord);
			selenium.click("css=input#3054.mstrButton");
			waitForPageLoadComplete(10000);
			getLogger().console_info("Done login project!");
		}

	}
	
	private void openDI() {
		selenium.click("//div[text()='Access Data']");
		waitForPageLoadComplete(2000);
		getLogger().console_info("Done open DI page!");
	}
	
	private void saveCube(String name) throws InterruptedException {
		selenium.type("css=.mstrmojo-SaveAsEditor-nameInput", name);
		Thread.sleep(3000);
		selenium.click("//div[@class='mstrmojo-Editor-buttons']//div[text()='Save']");
		if (selenium.isElementPresent("//div[contains(text(),'Do you want to replace the existing one?')]")){
			selenium.click("css=.mstrmojo-di-errorBox .mstrmojo-Editor-buttons > div:nth-of-type(2)");
		} 
		Thread.sleep(10000);
	}
	
	
	/**
	 * import a file
	 *  @param filePath
	 * @throws InterruptedException 
	 */
	
	@Action
	public void importFile(String filePath) throws InterruptedException {
		openDI();
		selenium.click("//div[text()='File From Disk']");
		selenium.type("css=.mstrmojo-FileDragDropBox-buttonDiv .mstrmojo-FileUploadBox-file", filePath);
		selenium.click("//div[text()='Edit Data']");
		Thread.sleep(5000);
		selenium.click("//div[text()='Finish']");		
		saveCube("test");
	}
	

	
}
