package com.microstrategy.selenium.action.mstrweb.di;

import com.microstrategy.selenium.WebTest;
import com.microstrategy.selenium.action.Action;
import com.microstrategy.selenium.action.mstrweb.MSTRWeb;

public class DBconnection extends MSTRWeb {
    public DBconnection(final WebTest webTest) {
	super(webTest);
    }

    static String DBRoleEditorOKButton = "css=.mstrmojo-wh-DBRoleEditor .mstrmojo-Editor-buttons .rightfloat";
    static String DBRoleAdd = "css=.mstrmojo-wh-addDB";
    static String DBMSpullDown = "css=.mstrmojo-ui-Pulldown";
    static String NamespacePullDown = "css=.mstrmojo-ui-SearchablePulldown";
    static String TableSearch = "css=.mstrmojo-wh-sb-input";
    static String DBroleDel = "css=.del.mstrmojo-ui-Menu-item";

    /**
     * Create DB Instance
     *
     * @param databaseType
     * @param logInInfo
     * @throws InterruptedException
     */
    @Action
    public void dataImportCreateDBInstance(final String databaseType,
	    final String logInInfo) {
	selenium.click(DBRoleAdd);
	selenium.click(DBMSpullDown);
	selenium.click(DILocator.retXpathByText("div", databaseType));

	final String[] info = logInInfo.split(",");
	// SQL Server
	selenium.type(DILocator.retXpathByText("div", "Host Name")
		+ "/../input", info[0]);
	selenium.type(DILocator.retXpathByText("div", "Port Number")
		+ "/../input", info[1]);
	selenium.type(DILocator.retXpathByText("div", "Database Name")
		+ "/../input", info[2]);
	selenium.type(DILocator.retXpathByText("div", "User:") + "/../input",
		info[3]);
	selenium.type(DILocator.retXpathByText("div", "Password:")
		+ "/../input", info[4]);
	selenium.type(DILocator.retXpathByText("div", "Data Source Name:")
		+ "/../input", info[5]);
	selenium.click(DBRoleEditorOKButton);
    }

    /**
     * Delete DBrole
     *
     * @param DBroleName
     * @throws InterruptedException
     */
    @Action
    public void deleteDBrole(final String DBroleName) {
	selenium.click(DILocator.retXpathByText("span", DBroleName)
		+ "/../span[@class='item-mn']");
	selenium.click(DBroleDel);
	selenium.click("css=.mstrmojo-Editor-button-Yes");
	while (selenium.isTextPresent(DBroleName)) {

	}
    }

    /**
     * Click Finish to publish cube
     *
     * @param cubename
     * @throws InterruptedException
     */
    @Action
    public void finishPublish(final String cubename)
	    throws InterruptedException {
	// Finish
	selenium.click("//div[@id='DIContainer']"
		+ DILocator.retXpathByText("div", "Finish"));
	selenium.click(DILocator.retXpathByText("div",
		"Import as an In-memory Dataset"));
	selenium.type("css=.mstrmojo-SaveAsEditor-nameInput", cubename);
	selenium.click("css=.mstrmojo-SaveAsEditor .okButton");
	if (selenium.isTextPresent("Saving cube with the same name")) {
	    selenium.click(DILocator.retXpathByText("div", "Yes"));
	}

	// wait final success page show up
	selenium.click(DILocator.retXpathByText("div",
		"Success! Your data was imported as"));
	Thread.sleep(CommonXPath.timeout);
    }

    /**
     * Click on DBRole, fetch data from single table
     *
     * @param DBroleName
     * @param Namespace
     * @param tables
     * @throws InterruptedException
     */
    @Action
    public void dataImportFromDBSingleTable(final String DBroleName,
	    final String Namespace, final String tables)
	    throws InterruptedException {
	selenium.click(DILocator.retXpathByText("span", DBroleName));
	selenium.click(NamespacePullDown);
	selenium.click("//div[contains(@class,'mstrmojo-scrollNode')]"
		+ DILocator.retXpathByText("div", Namespace));
	Thread.sleep(CommonXPath.timeout);

	// one table first
	// Todo Multiple tables

	// table search
	selenium.type(TableSearch, tables.substring(0, 1).toLowerCase());
	// this is to take onblur effect.
	selenium.click(DILocator.retXpathByText("div", "Import from Tables"));
	selenium.doubleClick(DILocator.retXpathByText("span", tables));

    }

}