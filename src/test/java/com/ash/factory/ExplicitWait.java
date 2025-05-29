package com.ash.factory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ash.utility.BasePage;
import com.ash.utils.waitStrategy;

public class ExplicitWait extends BasePage {
	
	
	public static WebElement performExplicitWait(waitStrategy Wait,By by) {
		WebElement element=null;
		try {
			if(Wait==waitStrategy.CLICKABLE) {
				element =new WebDriverWait(driver,Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(by));
				}
			else if(Wait==waitStrategy.PRESENCE) {
				element = new WebDriverWait(driver,Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated(by));
			}
			else if(Wait== waitStrategy.VISIBLE) {
				element=new WebDriverWait(driver,Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOfElementLocated(by));
			}
		}
		catch(ElementClickInterceptedException e) {
			element=driver.findElement(by);
		}
		return element;
		
		
		
	}
	public static void loadingWait(WebDriver driver, By loader) {
		WebDriverWait waits=new WebDriverWait(driver,Duration.ofSeconds(60));
		waits.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		
		
	}
	
	

}
