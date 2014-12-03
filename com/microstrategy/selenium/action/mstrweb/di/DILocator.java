package com.microstrategy.selenium.action.mstrweb.di;

public class DILocator {

    public static String retXpathByText(final String tagType, final String text) {
	final String[] textNoSpace = text.split(" ");
	System.out.println(textNoSpace.length);
	final StringBuilder sb = new StringBuilder();
	sb.append("//");
	sb.append(tagType);
	sb.append("[");
	for (int i = 0; i < textNoSpace.length; ++i) {
	    if (i != 0) {
		sb.append(" and ");
	    }
	    sb.append("contains(text(),\"" + textNoSpace[i] + "\")");
	    if (i == textNoSpace.length - 1) {
		sb.append("]");
	    }
	}
	return sb.toString();
    }

    public static void main(final String[] args) {
	System.out.println(retXpathByText("div", "User:"));
    }

}
