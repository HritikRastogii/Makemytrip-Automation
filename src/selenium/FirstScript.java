
package selenium;

import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
        //Using ChromeDriver as WebDriver
		System.setProperty("webdriver.chrome.driver", "/Users/hritik/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//To maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//To open the desired WebPage
		driver.get("https://www.makemytrip.com/railways");
		Thread.sleep(5000);
		
		//Printing Title and URL of the page
		System.out.println("Title is : "+driver.getTitle());
		System.out.println("URL is : "+driver.getCurrentUrl());
		
		//Clicking on From Button and giving input as DELHI
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[1]/label")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[1]/div[1]/div/div/div/input")).sendKeys("DELHI");
		Thread.sleep(3000);
		
		//To get the most appropriate option from the DropDown List
		List<WebElement>list=driver.findElements(By.cssSelector("p[class='searchedResult font14 darkText']"));
		
		for(int i=0;i<list.size();i++) {
			String text=list.get(i).getText();
			if(text.contains("Delhi"))
			{
				list.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
		
		//Clicking on To Button and giving input as LUCKNOW
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/input")).sendKeys("LUCKNOW");
		Thread.sleep(3000);
		
		//Again to get the most appropriate option from the DropDown List
        List<WebElement>list2=driver.findElements(By.cssSelector("p[class='searchedResult font14 darkText']"));
		
		for(int i=0;i<list2.size();i++) {
			String text=list2.get(i).getText();
			if(text.contains("Lucknow"))
			{
				list2.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
		
		//Selecting date as 20th,May by its xPath 
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div[6]")).click();
		Thread.sleep(2000);
		
		//Selecting class as 3rd AC by its xPath
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[4]/ul/li[3]")).click();
		
		//Clicking on Search Button to get the details of all available trains
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/p/a")).click();
		Thread.sleep(7000);
        
		driver.close();

	}

}
