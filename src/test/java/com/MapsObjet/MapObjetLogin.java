package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testNG.ClaseBase;


public class MapObjetLogin extends ClaseBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapObjetLogin(WebDriver driver) 
	{
		super(driver);
	}
		
		
	//ELEMENTOS PAGINA INICIAL 	
		protected By txtUsername =By.xpath("//input[@id='user-name']");
		protected By txtPassword =By.xpath("//input[@id='password']");
		protected By btnLogin =By.xpath("//input[@id='login-button']");
		

}
	