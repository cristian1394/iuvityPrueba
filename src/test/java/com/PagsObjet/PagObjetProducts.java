package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;

import com.MapsObjet.MapObjetProducts;
import com.MapsObjet.MapObjetLogin;

public class PagObjetProducts extends MapObjetProducts
{
	String url;
	
	public void setUrl(String url) {
		this.url = url;
	}

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagObjetProducts(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}

	// METODO INICIAL
	public void urlAcceso()
	{
		driver.get(url);
	}

	// METODO PRIMERA PRUEBA
	public PagObjetProducts Products (File rutaCarpeta, String generarEvidencia) throws Exception
	{
		try
		{
            tiempoEspera(1);
			click(btnAddCart, rutaCarpeta, generarEvidencia);
			click(btnTrolley, rutaCarpeta, generarEvidencia);
			click(btnRemove, rutaCarpeta, generarEvidencia);
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return this;
	}
}
