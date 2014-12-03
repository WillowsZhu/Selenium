package com.microstrategy.selenium.action.mstrweb.di;

import com.microstrategy.selenium.WebTest;
import com.microstrategy.selenium.action.Action;
import com.microstrategy.selenium.action.mstrweb.MSTRWeb;

public class ConnectorAction extends MSTRWeb {
    public ConnectorAction(final WebTest webTest) {
	super(webTest);
    }

    private void launchDI() {
	// selenium.click(CommonXPath.launchDIinVI);
	selenium.click(DILocator.retXpathByText("div", "Access External Data"));
	getLogger().console_info("Done launch DI page!");
    }

    /**
     * Input URL in URL connectors
     *
     * @param URLPath
     * @throws InterruptedException
     */
    @Action
    public void URLFile(final String URLPath) throws InterruptedException {
	launchDI();
	waitForPageLoadComplete(CommonXPath.timeout);
	selenium.click(CommonXPath.fileFromURL);
	Thread.sleep(CommonXPath.timeout);
	/* input URL */
	selenium.type("//input[contains(@class,'upload-url')]", URLPath);
    }

    /**
     * Upload local file in connectors
     *
     * @param localFile
     * @throws InterruptedException
     */
    @Action
    public void localFile(final String filePath) throws InterruptedException {
	launchDI();
	waitForPageLoadComplete(CommonXPath.timeout);
	selenium.click(CommonXPath.fileFromDisk);
	Thread.sleep(CommonXPath.timeout);
	/* input URL */
	selenium.type(CommonXPath.uploadFile, filePath);
    }

    /**
     * go to pick tables page
     *
     * @throws InterruptedException
     */
    @Action
    public void pickTables() throws InterruptedException {
	launchDI();
	waitForPageLoadComplete(CommonXPath.timeout);
	selenium.click(CommonXPath.database);
	Thread.sleep(CommonXPath.timeout);
	// selenium.click("//span[contains(text(),\"Pick Tables\")]");
	selenium.click(DILocator.retXpathByText("span", "Pick Tables"));
	selenium.click("//div[contains(text(),\"Next\")]");
	Thread.sleep(CommonXPath.timeout);
    }

    /**
     * go to WQB page
     *
     * @throws InterruptedException
     */
    @Action
    public void WQBPage() throws InterruptedException {
	launchDI();
	waitForPageLoadComplete(CommonXPath.timeout);
	selenium.click(CommonXPath.database);
	Thread.sleep(CommonXPath.timeout);
	selenium.click("//span[contains(text(),\"Build\")]");
	selenium.click("//div[contains(text(),\"Next\")]");
	Thread.sleep(CommonXPath.timeout);
    }

    /**
     * go to FFSQL page
     *
     * @throws InterruptedException
     */
    @Action
    public void FFSQLPage() throws InterruptedException {
	launchDI();
	waitForPageLoadComplete(CommonXPath.timeout);
	selenium.click(CommonXPath.database);
	Thread.sleep(CommonXPath.timeout);
	selenium.click("//span[contains(text(),\"Type\")]");
	selenium.click("//div[contains(text(),\"Next\")]");
	Thread.sleep(CommonXPath.timeout);
    }

    /**
     * go to FFSQL page
     *
     * @throws InterruptedException
     */
    @Action
    public void BISource() throws InterruptedException {
	launchDI();
	waitForPageLoadComplete(CommonXPath.timeout);
	selenium.click(CommonXPath.BITools);
	Thread.sleep(CommonXPath.timeout);
    }
}
