package com.qa.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

    public TestBase()
	  {
		
		try {
			 prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\QA\\CucumberWorkSpace\\BDDCucumberPOM\\src\\main\\java\\com\\qa\\config\\config.properties");
			
			prop.load(ip);
		} catch(FileNotFoundException e) {
			   e.printStackTrace();
		        }
		catch (IOException e) 
		{
			e.printStackTrace();
			
		}
	  }
		
		public static void initialization() {
	    	  
	    	 String browsername=  prop.getProperty("browser");
	    	 
	    	  if(browsername.equals("chrome")) {
	    		  
	    		  System.setProperty("webdriver.chrome.driver", "C:\\QA\\SeleniumJars\\chromedriver.exe");
  			     driver = new ChromeDriver();	
	    		  
	    	  }
	    	  else if(browsername.equals("FF")) {
	    		  
	    		  driver=new FirefoxDriver();
	    	  }
	           else if(browsername.equals("EG")) {
	    		  
	    		  driver=new EdgeDriver();
	    	  }
	    	  
	    	  
	    	  
	    	  driver.manage().window().maximize();
	    	  driver.manage().deleteAllCookies();
	    	  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	    	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	    

	    	  driver.get(prop.getProperty("url"));
	    	  
	    	  
	      }
		public static void switchframe()
		{
			driver.switchTo().frame("mainpanel");
			
		}
	
	
	
}
