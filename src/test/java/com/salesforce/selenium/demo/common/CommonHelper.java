package com.salesforce.selenium.demo.common;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.salesforce.selenium.demo.toolkit.MasterHelper;

/**
 * @description If the code of tests is reusable then it should probably become
 *              a helper. This class contain helper for common functionality in
 *              Salesforce Website.
 * @author amrit kumar
 */

public abstract class CommonHelper extends MasterHelper {

	public void moveToToolbarTab(String tab) throws Exception {
		String index = "";
		if (tab.equalsIgnoreCase("products")) {
			index = "1";
		} else if (tab.equalsIgnoreCase("solutions")) {
			index = "2";
		} else if (tab.equalsIgnoreCase("services")) {
			index = "3";
		} else if (tab.equalsIgnoreCase("support")) {
			index = "4";
		} else if (tab.equalsIgnoreCase("events")) {
			index = "5";
		} else if (tab.equalsIgnoreCase("customers")) {
			index = "6";
		} else if (tab.equalsIgnoreCase("aboutus")) {
			index = "7";
		}
		WebElement tabLocator = this.getTabWebElement(index);
		Actions action = new Actions(MasterHelper.getWebdriver());
		action.moveToElement(tabLocator).release().perform();
	}

	private WebElement getTabWebElement(String tabIndex) {
		WebElement tabId = MasterHelper.getWebdriver().findElement(
				(By.cssSelector("div.globalnav-menu-container.col > div > ul > li:nth-child(" + tabIndex +")")));
		return tabId;
	}
	
	public void naviagteToProductPage(String product) throws Exception {
		String index = "";
		if (product.equalsIgnoreCase("sales")) {
			index = "#sales_products";
		} else if (product.equalsIgnoreCase("commerce")) {
			index = "commerce_products";
		} else if (product.equalsIgnoreCase("communities")) {
			index = "communities_products";
		} else if (product.equalsIgnoreCase("service")) {
			index = "service_products ";
		} else if (product.equalsIgnoreCase("marketing")) {
			index = "marketing_products";
		} else if (product.equalsIgnoreCase("platform")) {
			index = "platform_products";
		}
		
		clickLinkByDataTarget("data-target",index);
	}

	private void clickLinkByDataTarget(String attributeName, String attributeValue) {
        List<WebElement> anchors = MasterHelper.getWebdriver().findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();
        while(i.hasNext()) {
            WebElement anchor = i.next();
            if(anchor.getAttribute(attributeName) !=null && anchor.getAttribute("data-target").contains(attributeValue)) {
                anchor.click();
                break;
            }
        }
    }

}
