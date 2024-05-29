package web.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RoutingSeverTest {
	 private WebDriver driver;
	    private final String login_url = "http://localhost:8080/login";
	    private final String q1_url = "http://localhost:8080/q1";
	    private final String q2_url = "http://localhost:8080/q2";
	    private final String q3_url = "http://localhost:8080/q3";
	
	
	    @Before
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
	        driver = new ChromeDriver();
	    }
	    
	    private void sleep(int seconds) {
	        try {
	            Thread.sleep(seconds * 1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	   
	    @Test
	    public void testLogin() {
	        driver.get(login_url);
	       

	        WebElement usernameInput = driver.findElement(By.id("username"));
	        WebElement passwordInput = driver.findElement(By.id("passwd"));
	        WebElement dobInput = driver.findElement(By.id("dob"));
	        WebElement submitButton = driver.findElement(By.id("loginbutton"));

	        

	        usernameInput.sendKeys("Ishini");
	        passwordInput.sendKeys("Ishini_pass");
	        dobInput.sendKeys("01/01/2000");
	        submitButton.click();

	        

	        String currentUrl = driver.getCurrentUrl();
	        assertEquals(q1_url, currentUrl);
	    }
	    
	    @Test
	    public void testQ1PageValidInput() {
	      
	        driver.get(q1_url);
	        sleep(5);
	        WebElement number1Input = driver.findElement(By.id("number1"));
	        WebElement number2Input = driver.findElement(By.id("number2"));
	        WebElement resultInput = driver.findElement(By.id("result"));
	        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
	        number1Input.sendKeys("1");
	        number2Input.sendKeys("2");
	        resultInput.sendKeys("3");
	        submitButton.click();
	        sleep(5);
	        
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.urlContains("/q2"));
	        sleep(5);
	    }
	    
	    @Test
	    public void testQ1PageEmptyInput() {
	      
	        driver.get(q1_url);
	        sleep(5);
	        
	        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
	       
	        submitButton.click();
	        sleep(5);
	        
	        assertEquals("Please enter valid numbers.", driver.findElement(By.tagName("div")).getText());
	        sleep(5);
	    }
	    
	    @Test
	    public void testQ1PageNonNumInput() {
	      
	        driver.get(q1_url);
	        
	        WebElement number1Input = driver.findElement(By.id("number1"));
	        WebElement number2Input = driver.findElement(By.id("number2"));
	        WebElement resultInput = driver.findElement(By.id("result"));
	        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
	        number1Input.sendKeys("a");
	        number2Input.sendKeys("b");
	        resultInput.sendKeys("c");
	        submitButton.click();
	        
	        
	        assertEquals("Please enter valid numbers.", driver.findElement(By.tagName("div")).getText());
	       
	    }
	    
	    @Test
	    public void testQ2PageValidInput() {
	      
	        driver.get(q2_url);
	        
	        WebElement number1Input = driver.findElement(By.id("number1"));
	        WebElement number2Input = driver.findElement(By.id("number2"));
	        WebElement resultInput = driver.findElement(By.id("result"));
	        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
	        number1Input.sendKeys("4");
	        number2Input.sendKeys("2");
	        resultInput.sendKeys("2");
	        submitButton.click();
	        
	        
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.urlContains("/q3"));
	      
	    }
	    
	    @Test
	    public void testQ2PageEmptyInput() {
	      
	        driver.get(q2_url);
	        
	        
	        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
	       
	        submitButton.click();
	        
	        
	        assertEquals("Invalid input. Please enter valid numbers.", driver.findElement(By.tagName("div")).getText());
	        
	    }
	    
	    @Test
	    public void testQ2PageNonNumInput() {
	      
	        driver.get(q2_url);
	        
	        WebElement number1Input = driver.findElement(By.id("number1"));
	        WebElement number2Input = driver.findElement(By.id("number2"));
	        WebElement resultInput = driver.findElement(By.id("result"));
	        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
	        number1Input.sendKeys("a");
	        number2Input.sendKeys("b");
	        resultInput.sendKeys("c");
	        submitButton.click();
	        
	        
	        assertEquals("Invalid input. Please enter valid numbers.", driver.findElement(By.tagName("div")).getText());
	       
	    }
	    
	    @Test
	    public void testQ3PageValidInput() {
	      
	        driver.get(q3_url);
	        
	        WebElement number1Input = driver.findElement(By.id("number1"));
	        WebElement number2Input = driver.findElement(By.id("number2"));
	        WebElement resultInput = driver.findElement(By.id("result"));
	        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
	        number1Input.sendKeys("4");
	        number2Input.sendKeys("2");
	        resultInput.sendKeys("8");
	        submitButton.click();
	        
	        
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.urlContains("/success"));
	      
	    }
	    
	    @Test
	    public void testQ3PageEmptyInput() {
	      
	        driver.get(q3_url);
	        
	        
	        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
	       
	        submitButton.click();
	        
	        
	        assertEquals("Please enter valid numbers.", driver.findElement(By.tagName("div")).getText());
	        
	    }
	    
	    @Test
	    public void testQ3PageNonNumInput() {
	      
	        driver.get(q3_url);
	        
	        WebElement number1Input = driver.findElement(By.id("number1"));
	        WebElement number2Input = driver.findElement(By.id("number2"));
	        WebElement resultInput = driver.findElement(By.id("result"));
	        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
	        number1Input.sendKeys("a");
	        number2Input.sendKeys("b");
	        resultInput.sendKeys("c");
	        submitButton.click();
	        
	        
	        assertEquals("Please enter valid numbers.", driver.findElement(By.tagName("div")).getText());
	       
	    }
	    
	    
	    
	    
	    
	
	
}