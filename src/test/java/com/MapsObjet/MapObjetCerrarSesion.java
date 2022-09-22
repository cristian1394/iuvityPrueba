package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testNG.ClaseBase;


public class MapObjetCerrarSesion extends ClaseBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapObjetCerrarSesion(WebDriver driver) 
	{
		super(driver);
	}
		
		
	//ELEMENTOS PAGINA FINAL
		protected By btnMenu =By.xpath("//button[@id='react-burger-menu-btn']");
		protected By btnLogout =By.xpath("//a[@id='logout_sidebar_link']");
		

}
