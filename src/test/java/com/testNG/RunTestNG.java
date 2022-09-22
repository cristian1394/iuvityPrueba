package com.testNG;

import org.testng.annotations.Test;

import com.PagsObjet.PagObjetCerrarSesion;
import com.PagsObjet.PagObjetProducts;
import com.PagsObjet.PagObjetLogin;
import com.Utilidades.ExcelUtilidades;
import com.Utilidades.GenerarReportePdf;
import com.Utilidades.MyScreenRecorder;

import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RunTestNG 
{
	private WebDriver driver;
	PagObjetLogin pagObjetLogin;
	PagObjetProducts pagObjetProducts;
	PagObjetCerrarSesion pagObjetCerrarSesion;
	ClaseBase claseBase;
	File rutaCarpeta = null;
	GenerarReportePdf generarReportePdf;
	String valor;
	
  @BeforeClass
  @Parameters({"url","rutaImagenReporte","rutaOutut"})
  public void beforeClass(@Optional("default") String url,
		  				  @Optional("default") String rutaImagenReporte,
		  				  @Optional("default") String rutaOutut) 
  {	  
	  //ASIGNAR PROPIEDADES A DRIVER 
	  driver =ClaseBase.chomeDriverConnetion();
	  //INSTANCIAR LA CLASE 
	  pagObjetLogin = new PagObjetLogin(driver);
	  pagObjetProducts = new PagObjetProducts(driver);
	  pagObjetCerrarSesion = new PagObjetCerrarSesion(driver);
	  
	  claseBase = new ClaseBase(driver);
	  generarReportePdf = new GenerarReportePdf();
	  
	  //SETTIAR LAS CLASES
	  pagObjetLogin.setUrl(url);
	  generarReportePdf.setRutaImagen(rutaImagenReporte);
	  claseBase.setRutaOutut(rutaOutut);
  }
  
  @DataProvider(name="busqueda")
  public Object[][] datos() throws Exception
  {
	  Object[][] arreglo=ExcelUtilidades.getTableArray("./Data/prueba.xlsx", "registro");
	  return arreglo;	  
  }

  @Test(dataProvider = "busqueda",description="acceso a Swag Labs")
  
  public void pruebaInicialTestNG(String ejecutarCaso, String generarEvidencia,String userName,String password) throws Exception 
  {
	  if (ejecutarCaso.equals("Si"))
	  {
		  // OBTENER EL NOMBRE DEL METODO A EJECUTAR
		  String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		 		 
		  //ACCEDER A LA URL
		  pagObjetLogin.urlAcceso();
		  
		  //VALIDAFR SI SE GENERA EVIDENCIA
		  if (generarEvidencia.contains("Si"))
		  {
			  // CREAR CARPETA PARA ALMACENAMIENTO DE EVIDENCIAS
			  rutaCarpeta = claseBase.crearCarpeta(nomTest);
			  
			  //INICIA GRABACION DE VIDEO
			  MyScreenRecorder.startRecording(nomTest,rutaCarpeta);
			  
			  //INICIA CREACION DE REPORTE PDF
			  generarReportePdf.crearPlantilla(nomTest,rutaCarpeta);
			  
			  //ACCEDER AL METODO DE PRUEBA INCIAL (EJECUCUION DE CASO DE PRUEBA)
			  pagObjetLogin.Login(userName,password, rutaCarpeta,generarEvidencia);
			  pagObjetProducts.Products(rutaCarpeta,generarEvidencia);
			  pagObjetCerrarSesion.Cerrarsesion(rutaCarpeta, generarEvidencia);
			  
			  //FINALIZA GRABACION DE VIDEO
			  MyScreenRecorder.stopRecording();
			  
			  //FINALIZA CREACION DE REPORTE PDF
			  generarReportePdf.cerrarPlantilla();
		  }
		  else
		  {
			  //ACCEDER AL METODO DE PRUEBA INCIAL (EJECUCUION DE CASO DE PRUEBA)
			  pagObjetLogin.Login(userName,password, rutaCarpeta,generarEvidencia);
			  pagObjetProducts.Products(rutaCarpeta,generarEvidencia);
			  pagObjetCerrarSesion.Cerrarsesion(rutaCarpeta, generarEvidencia);
		  }
		  
	  }
  }
 
  
    
  @AfterClass
  public void afterClass()
  {	  
	  driver.close();
  }
}
