package com.microstrategy.selenium.action.mstrweb.di;

import java.io.UnsupportedEncodingException;

import com.microstrategy.selenium.Locator;
import com.microstrategy.selenium.WebTest;
import com.microstrategy.selenium.action.Action;
import com.microstrategy.selenium.action.mstrweb.MSTRWeb;
import com.microstrategy.utils.WebURLEncoder;
import com.thoughtworks.selenium.DefaultSelenium;

public class WorkflowAction extends MSTRWeb{
	public WorkflowAction(WebTest webTest) {
		super(webTest);
	}
	
	/** 
	 * Launch DI page
	 * @throws InterruptedException 
	 */
	@Action
	public void launchDI() throws InterruptedException {
		selenium.click(CommonXPath.launchDIinVI);
		Thread.sleep(CommonXPath.timeout);
		getLogger().console_info("Done launch DI page!");
	}
	/** 
	 * Close DI page
	 * @throws InterruptedException 
	 */
	@Action
	public void closeDI() throws InterruptedException {
		
		Thread.sleep(CommonXPath.timeout);
	}
	
	/** 
	 * Close DI page
	 * @throws InterruptedException 
	 */
	@Action
	public void closePreview() throws InterruptedException {
		selenium.click(CommonXPath.closePreview);
		Thread.sleep(CommonXPath.timeout);
	}
	
	/** 
	 * Prepare data
	 * @throws InterruptedException 
	 */
	@Action
	public void prepareData() throws InterruptedException {
		selenium.click(CommonXPath.prepareData);
		Thread.sleep(CommonXPath.timeout);
	}
	
	/** 
	 * Finish to publish
	 * @throws InterruptedException 
	 */
	@Action
	public void finish() throws InterruptedException {
		selenium.click(CommonXPath.finishButton);
		Thread.sleep(CommonXPath.timeout);
	}
}
