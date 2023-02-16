package Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import kong.unirest.Unirest;

import com.fasterxml.jackson.databind.JsonNode;
import io.netty.handler.codec.http.HttpResponse;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {

	public static WebDriver driver;
	Properties pro;

	public String ApiLinkPath = "./src/main/resources/Datas/RetailerID.xls";


	@Test
	@Parameters({"firstsheetname"})
	public void Startbrowser1(String sheetname) throws IOException {

		FileInputStream File = new FileInputStream(ApiLinkPath);
		HSSFWorkbook workbook = new HSSFWorkbook(File);
		HSSFSheet sheet = workbook.getSheet(sheetname);
		int noforows = sheet.getLastRowNum();
		for (int irow = 1; irow <= noforows; irow++) {
			HSSFRow currentrow = sheet.getRow(irow);
			String RetailerID = currentrow.getCell(0).getStringCellValue();
			URL url = new URL("http://redipae.in/Retailer/GetPrintRetailerPDF/?Retailerid="+RetailerID+"&ClientID=15");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			System.out.println(connection.getResponseMessage());
		}

	}

	@Test
	@Parameters({"Secondsheetname"})
	public void startbrowser2(String sheetname) throws IOException {

		FileInputStream File = new FileInputStream(ApiLinkPath);
		HSSFWorkbook workbook = new HSSFWorkbook(File);
		HSSFSheet secondsheet = workbook.getSheet(sheetname);
		int noforows = secondsheet.getLastRowNum();
		for (int jrow = 1; jrow <= noforows; jrow++) {
			HSSFRow currentrow = secondsheet.getRow(jrow);
			String RetailerID = currentrow.getCell(0).getStringCellValue();
			URL url = new URL("http://redipae.in/Retailer/GetPrintRetailerPDF/?Retailerid="+RetailerID+"&ClientID=15");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			System.out.println(connection.getResponseMessage());
		}

	}


	@Test
	@Parameters({"Thirdsheetname"})
	public void startbrowser3(String sheetname) throws IOException {

		FileInputStream File = new FileInputStream(ApiLinkPath);
		HSSFWorkbook workbook = new HSSFWorkbook(File);
		HSSFSheet Thirdsheet = workbook.getSheet(sheetname);
		int noforows = Thirdsheet.getLastRowNum();
		for (int krow = 1; krow <= noforows; krow++) {
			HSSFRow currentrow = Thirdsheet.getRow(krow);
			String RetailerID = currentrow.getCell(0).getStringCellValue();
			URL url = new URL("http://redipae.in/Retailer/GetPrintRetailerPDF/?Retailerid="+RetailerID+"&ClientID=15");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			System.out.println(connection.getResponseMessage());
		}


	}

	@Test
	@Parameters({"Fourthsheetname"})
	public void startbrowser4(String sheetname) throws IOException {

		FileInputStream File = new FileInputStream(ApiLinkPath);
		HSSFWorkbook workbook = new HSSFWorkbook(File);
		HSSFSheet Fourthsheet = workbook.getSheet(sheetname);
		int noforows = Fourthsheet.getLastRowNum();
		for (int Lrow = 1; Lrow <= noforows; Lrow++) {
			HSSFRow currentrow = Fourthsheet.getRow(Lrow);
			String RetailerID = currentrow.getCell(0).getStringCellValue();
			URL url = new URL("http://redipae.in/Retailer/GetPrintRetailerPDF/?Retailerid="+RetailerID+"&ClientID=15");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			System.out.println(connection.getResponseMessage());
		}


	}

	@Test
	@Parameters({"Fifthsheetname"})
	public void startbrowser5(String sheetname) throws IOException {

		FileInputStream File = new FileInputStream(ApiLinkPath);
		HSSFWorkbook workbook = new HSSFWorkbook(File);
		HSSFSheet fifithsheet = workbook.getSheet(sheetname);
		int noforows = fifithsheet.getLastRowNum();
		for (int mrow = 1; mrow <= noforows; mrow++) {
			HSSFRow currentrow = fifithsheet.getRow(mrow);
			String RetailerID = currentrow.getCell(0).getStringCellValue();
			URL url = new URL("http://redipae.in/Retailer/GetPrintRetailerPDF/?Retailerid="+RetailerID+"&ClientID=15");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			System.out.println(connection.getResponseMessage());
		}


	}

	@Test
	@Parameters({"Sixthsheetname"})
	public void startbrowser6(String sheetname) throws IOException {

		FileInputStream File = new FileInputStream(ApiLinkPath);
		HSSFWorkbook workbook = new HSSFWorkbook(File);
		HSSFSheet sixthsheet = workbook.getSheet(sheetname);
		int noforows = sixthsheet.getLastRowNum();
		for (int Nrow = 1; Nrow <= noforows; Nrow++) {
			HSSFRow currentrow = sixthsheet.getRow(Nrow);
			String RetailerID = currentrow.getCell(0).getStringCellValue();
			URL url = new URL("http://redipae.in/Retailer/GetPrintRetailerPDF/?Retailerid="+RetailerID+"&ClientID=15");
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			System.out.println(connection.getResponseMessage());
		}


	}

}
