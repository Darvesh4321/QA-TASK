package qatask.testing_qa;



import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testing_qa {
	
	@Test

	public static void main(String[] args) throws Exception {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://cdn.adpushup.com/qaTakeHomeTask/");
		
		driver.manage().window().maximize();
		
	WebElement box1=	driver.findElement(By.cssSelector("div[data-ad-size='728x90']"));
	WebElement box2=    driver.findElement(By.cssSelector(".ad-box[data-ad-size='300x600']"));
	int count=0;
//  TO VALIDATE BOX 1 AND BOX2 ARE VISIBLE-------------------------------------------------------------->>>
	WebElement Box_TOP=    driver.findElement(By.xpath("//span[normalize-space()='Box-1']"));
	WebElement Box_RIGHT_SIDEBAR=    driver.findElement(By.xpath("//span[normalize-space()='Box-2']"));
	
	String BOX1_TEXT= Box_TOP.getText();
	System.out.println("BOX1_TEXT value is"+":"+ BOX1_TEXT);
	Assert.assertEquals("Box-1",BOX1_TEXT);
	
	String BOX2_RIGHT_SIDEBAR= Box_RIGHT_SIDEBAR.getText();
	System.out.println("BOX2_TEXT value is"+":"+ BOX2_RIGHT_SIDEBAR);
	Assert.assertEquals("Box-2",BOX2_RIGHT_SIDEBAR);
	
	
	Thread.sleep(5000);

	
// TO VALIDATE BOX 1 ADS ARE CHANGING AND BOX2 ARE VISIBLE------------------------------------------->>>	
for (int i=1;i<=5;i++) {
	 
		  
	String s=box1.getAttribute("style");
	
	System.out.println(s);
	count++;
	
	Thread.sleep(30000);
				   
}
if(count==5) 

{
	System.out.println("ads of box1 are changing");
}
else {
	System.out.println("ads of box1 are changing");
}
	Thread.sleep(5000);
//TO VALIDATE BOX 1 ADS ARE CHANGING on 50% visibility------------------------------------------->>>	
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollTo(0,80)");
		for (int i=1;i<=5;i++) {
			 
			  
			String s=box1.getAttribute("style");
			
			System.out.println(s);
			count++;
			
			Thread.sleep(30000);
						   
		}
		if(count==5) 

		{
			System.out.println("ads of box1 with 50% visibility are changing");
		}
		else {
			System.out.println("ads of box1 with 50% visibility  not are changing");
		}
		
		Thread.sleep(5000);
//TO VALIDATE if  BOX 1 ADS ARE not  CHANGING on the bottom of the page -------------------------------------------------->>>	
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		for (int i=1;i<=5;i++) {
			 
			  
			String s=box1.getAttribute("style");
			
			System.out.println(s);
			count++;
			
			Thread.sleep(30000);
						   
		}
		if(count==5) 

		{
			System.out.println("ads of box1 with no visibility are changing");
		}
		else {
			System.out.println("ads of box1 with no visibility are  not  changing");
		}
		
		Thread.sleep(5000);
		
//TO VALIDATE if  BOX 2 ADS ARE  CHANGING on the bottom of the page -------------------------------------------------->>>			
		js.executeScript("arguments[0].scrollIntoView(true)",box2);
		for (int i=1;i<=5;i++) {
			 
			  
			String s=box2.getAttribute("style");
			
			System.out.println(s);
			count++;
			
			Thread.sleep(30000);
						   
		}
		if(count==5) 

		{
			System.out.println("ads of box2 with  visibility are changing");
		}
		else {
			System.out.println("ads of box2 with no visibility are  not  changing");
		}
		
//TO VALIDATE if  BOX is present in bottom -------------------------------------------------->>>	
		Thread.sleep(5000);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//String BOX2_RIGHT_SIDEBAR= Box_RIGHT_SIDEBAR.getText();
		System.out.println("BOX2_TEXT value is present in bottom of the right sidebar"+":"+ BOX2_RIGHT_SIDEBAR);
		Assert.assertEquals("Box-2",BOX2_RIGHT_SIDEBAR);
		
//TO VALIDATE if  BOX1 is AGAIN VISIBLE AND ADS CHANGING FROM bottom -TO TOP------------------------------------------------->>>		
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView(true)",box1);
		for (int i=1;i<=5;i++) {
			 
			  
			String s=box1.getAttribute("style");
			
			System.out.println(s);
			count++;
			
			Thread.sleep(30000);
						   
		}
		if(count==5) 

		{
			System.out.println("ads of box1 with  visibility are changing");
		}
		else {
			System.out.println("ads of box1 with no visibility are  not  changing");
		}

		driver.quit();
	}


	
	}



