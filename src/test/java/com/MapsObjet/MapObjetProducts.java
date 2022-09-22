package com.MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testNG.ClaseBase;


public class MapObjetProducts extends ClaseBase
{
	//CONSTRUCTOR DE LA CLASE
	public MapObjetProducts(WebDriver driver) 
	{
		super(driver);
	}
		
	//ELEMENTOS PAGINA INICIAL 	
	 	
		
		protected By btnAddCart =By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
		protected By btnTrolley =By.xpath("//a[@class='shopping_cart_link']");
		protected By btnRemove =By.xpath("//button[@id='remove-sauce-labs-backpack']");	

}	
