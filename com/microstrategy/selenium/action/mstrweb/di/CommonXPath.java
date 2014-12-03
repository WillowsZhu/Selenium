package com.microstrategy.selenium.action.mstrweb.di;

public class CommonXPath {
	public static int timeout = 3000;	/* parameters: general parameter */
	public static String loginButton = "css=input#3054.mstrButton";	/* login: login button */
	public static String createDash = "css=a.mscld-create-lnk";	/* workflow: Open VI page */
	public static String launchDI = "css=div#mstr72.mstrmojo-Label";	/* workflow: launch DI page */
	public static String launchDIinVI = "//div[contains(text(),'Add') and contains(text(),'Data')]";	/* workflow: launch DI in VI page */
	public static String fileFromURL = "//span[contains(text(),\"URL\")]";	/* connector: xpath for file from URL */
	public static String fileFromDisk = "//span[contains(text(),\"Disk\")]";	/* connector: xpath for file from Disk */
	public static String database = "//span[contains(text(),\"Database\")]";	/* connector: xpath for database */
	public static String pickTables = "//span[contains(text(),\"Pick Tables\")]";	/* connector: xpath for pick tables */
	public static String BITools = "//span[contains(text(),\"BI Tools\")]";	/* connector: xpath for file from Disk */
	public static String uploadFile = "//input[@class='mstrmojo-FileUploadBox-file']";	/* connector: xpath for uploading file */
	public static String prepareData = "//div[text()='Prepare Data']";	/* Connector: Prepare data button */
	public static String finishButton = "//div[text()='Finish']";	/* Connector: Prepare data button */
	public static String closePreview = "//div[@class='mstrmojo-di-header']//div[@class='mstrmojo-Button-text ']";	/* workflow: close preview page */
	public static String closeDI = "";	/* worflow: close DI page */
}
