package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;

import com.MapsObjet.MapObjetCerrarSesion;
import com.MapsObjet.MapObjetLogin;

public class PagObjetCerrarSesion extends MapObjetCerrarSesion
{
	String url;
	
	public void setUrl(String url) {
		this.url = url;
	}

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagObjetCerrarSesion(WebDriver driver)
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
	public PagObjetCerrarSesion Cerrarsesion (File rutaCarpeta, String generarEvidencia) throws Exception
	{
		try
		{

			click(btnMenu, rutaCarpeta, generarEvidencia);
			click(btnLogout, rutaCarpeta, generarEvidencia);
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return this;
	}
}
