package com.microstrategy.selenium.action.mstrweb.di;

import com.microstrategy.selenium.WebTest;
import com.microstrategy.selenium.action.Action;
import com.microstrategy.selenium.action.mstrweb.MSTRWeb;

public class WebQueryBuilder extends MSTRWeb {

    public static String QBFilter = "css=.mstrmojo-Label.condition";
    public static String AddCondition = "css=.mstrmojo-CGE-addCondition";
    public static String ExprPanel = "css=.mstrmojo-qb-ExpressionEditor .mstrmojo-TokenInputBox-edit";
    public static String ExprSave = "css=.mstrmojo-Editor-button[value=\"Save\"]";

    public WebQueryBuilder(final WebTest webTest) {
	super(webTest);
    }

    /**
     * Create a filter in WQB
     *
     * @param expr
     * @throws InterruptedException
     */
    @Action
    public void addFilter(final String expr) throws InterruptedException {
	selenium.click(QBFilter);
	selenium.click(AddCondition);
	selenium.typeKeys(ExprPanel, expr);
	Thread.sleep(CommonXPath.timeout);
	selenium.click(ExprSave);
    }

    /**
     * Fetch data from WQB
     *
     * @param DBroleName
     * @param Namespace
     * @param tables
     * @throws InterruptedException
     */
    @Action
    public void dataImportFromQB(final String DBroleName,
	    final String Namespace, final String tables)
	    throws InterruptedException {
	selenium.click(DILocator.retXpathByText("span", DBroleName));
	selenium.click(DBconnection.NamespacePullDown);
	selenium.click("//div[contains(@class,'mstrmojo-scrollNode')]"
		+ DILocator.retXpathByText("div", Namespace));
	Thread.sleep(CommonXPath.timeout);

	// one table first
	// Todo Multiple tables

	// table search
	selenium.type(DBconnection.TableSearch, tables.substring(0, 1)
		.toLowerCase());
	// this is to take onblur effect.
	selenium.click(DILocator.retXpathByText("div", "Import from Tables"));
	selenium.doubleClick(DILocator.retXpathByText("span", tables));
	Thread.sleep(CommonXPath.timeout);
    }

}
