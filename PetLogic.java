package petdiseasealerts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PetLogic {
	public static WebDriver driver;
	public static String AreaOnMap;
	public static Actions ac;
	public static JavascriptExecutor js;
	
	public static void getStates() {
		
		ac=new Actions(driver);
		
		driver.switchTo().frame(0);
		
		String allState="//*[name()='svg']//*[local-name()='g' and contains(@id, 'regions')]//*[local-name()='g' and contains(@class, 'region')]//*[local-name()='path']";
		
		List<WebElement> elementList=driver.findElements(By.xpath(allState));
		
		System.out.println("Total State Count "+elementList.size());
		
		
		for(int count=1;count<=elementList.size();count++) {
		for(WebElement e:elementList) {
		
			
			ac.moveToElement(e).perform();
			String xpath="//*[name()='svg']//*[local-name()='g' and contains(@id, 'regions')]//*[local-name()='g' and contains(@class, 'region')]["+count+"]//*[local-name()='path']";
			
			String stateName=driver.findElement(By.xpath(xpath)).getAttribute("name");
			System.out.println("State Name : "+stateName);
			if (stateName.equalsIgnoreCase("Minnesota")) {
				 driver.switchTo(). defaultContent();
				js.executeScript("window.scrollBy(0,450)", "");
				driver.switchTo().frame(0);
			}
			count++;
		}}
	}
	
	public static void click4State(String state) throws InterruptedException {
		
		if (state.equalsIgnoreCase("California")) {
			driver.switchTo().frame(0);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String xpath="//*[name()='svg']//*[local-name()='g' and contains(@class, 'rpath')]//*[local-name()='path' and contains(@name,'"+state+"')]";
			driver.findElement(By.xpath(xpath)).click();	
		}
		if (state.equalsIgnoreCase("Florida")) { //getting Exception in thread "main" org.openqa.selenium.ElementClickInterceptedException:
			
			driver.switchTo().frame(0);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			String xpath="//*[name()='svg']//*[local-name()='g' and contains(@class, 'rpath')]//*[local-name()='path' and contains(@name,'"+state+"')]";
			
			WebElement element=driver.findElement(By.xpath(xpath));
			Thread.sleep(5000);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			//ac.moveToElement(element).click().build().perform();
			//js.executeScript("arguments[0].scrollIntoView(true);", element);
			//ac.moveToElement(element).perform();
			//element.click();
			ac.moveByOffset(950, 210).click().build().perform();
			
			Thread.sleep(10000);
		}
		if (state.equalsIgnoreCase("New York")) {
			driver.switchTo().frame(0);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String xpath="//*[name()='svg']//*[local-name()='g' and contains(@class, 'rpath')]//*[local-name()='path' and contains(@name,'"+state+"')]";
			driver.findElement(By.xpath(xpath)).click();	
		}
		if (state.equalsIgnoreCase("Maryland")) {
			driver.switchTo().frame(0);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String xpath="//*[name()='svg']//*[local-name()='g' and contains(@class, 'rpath')]//*[local-name()='path' and contains(@name,'"+state+"')]";
			driver.findElement(By.xpath(xpath)).click();	
		}
		
	}
	public static void main(String args[]) throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		js= (JavascriptExecutor) driver;
		ac=new Actions(driver);

		driver.get("https://petdiseasealerts.org/forecast-map/#/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		//js.executeScript("window.scrollBy(0,450)", "");
		//PetLogic.getStates();
		
		//js.executeScript("window.scrollBy(0,450)", "");
		//PetLogic.click4State("California");
		
		js.executeScript("window.scrollBy(0,700)", "");
		PetLogic.click4State("Florida");
		
		//js.executeScript("window.scrollBy(0,450)", "");
		//PetLogic.click4State("New York");
		
		//js.executeScript("window.scrollBy(0,450)", "");
		//PetLogic.click4State("Maryland");
		
		
	}
}
