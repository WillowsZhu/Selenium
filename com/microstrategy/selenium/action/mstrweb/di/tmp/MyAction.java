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

public class MyAction extends MSTRWeb {

	public MyAction(WebTest webTest) {
		super(webTest);
	}
	
	/** Create object by type and object name
	 * @param objectType  the type of the object
	 * @param template    the name of the template you want to use
	 */
	@Action
	public void createObject2(String objectType, String template) {
		String createObject_Locator = "New "+parseStringToInitialUpperCase(objectType);

		createObject_Locator = Locator.link(createObject_Locator);
		selenium.click(createObject_Locator);

		if (template.length() > 0) {
			if (objectType.equalsIgnoreCase("report") || objectType.equalsIgnoreCase("prompt")){
				selenium.click(Locator.link(template));
			}
			else if (objectType.equalsIgnoreCase("document")){
				//selenium.click(Locator.text("div", template));
				selenium.click(Locator.xpath("//div[text()='"+template+"']"));
			}
			else if (objectType.equalsIgnoreCase("filter")){
				// do nothing
			}
		}
	}
	
	
	/** Add data set in document
	 * @param dataSetPath  the path of the data set
	 *
	 */
	@Action
	public void addDataSet2(String dataSetPath) {
		String newDataSet = "tbDatasetNew";
		String [] path = dataSetPath.split("\\\\");
		String ok = Locator.xpath("//table[@id='SelectDataSetPopup1']//input[@value='OK']");
		if (path.length >= 2) {
			selenium.click(newDataSet);
			for (int i=0; i<path.length-1; i++) {
				String pathLocator = Locator.xpath("//a[text()='"+path[i]+"']");
				selenium.click(pathLocator);
			}
			selenium.click(Locator.xpath("//div[text()='"+path[path.length-1]+"']"));
			selenium.click(ok);
		}
	}
	

	
	

}
