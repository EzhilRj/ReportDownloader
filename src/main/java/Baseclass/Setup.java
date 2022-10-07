package Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {

    public static WebDriver driver;
    Properties pro;

    @BeforeTest
    public void Startbrowser() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt =  new ChromeOptions();
        opt.setHeadless(false);
        driver = new ChromeDriver(opt);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void Chromedownload() throws IOException, InterruptedException {

        Logger log = Logger.getLogger("RedipaeReportLogs");
        DOMConfigurator.configure("Log4J.xml");

        String ApiLinkPath = "C:\\Redipae RetailerMaster Reports\\RedipaePDF.xlsx";

        FileInputStream File = new FileInputStream(ApiLinkPath);

        XSSFWorkbook workbook = new XSSFWorkbook(File);

        XSSFSheet sheet = workbook.getSheet("Datas");

        int noforows = sheet.getLastRowNum();

        for (int row = 1; row <= noforows; row++) {

            XSSFRow currentrow = sheet.getRow(row);

            String RetailerID = currentrow.getCell(0).getStringCellValue();

            String ClientID = currentrow.getCell(1).getStringCellValue();
            String ClientID1 = ClientID + " ";

            driver.get("http://redipae.in/Retailer/GetPrintRetailerPDF/?Retailerid=" + RetailerID  + "&ClientID=" + ClientID1 + ""); //LIVE
            //driver.get("http://testing.ppms.co.in/Redipae/Retailer/GetPrintRetailerPDF/?Retailerid=" + RetailerID  + "&ClientID=" + ClientID1 + "");  //TEST

            String URLofPage = driver.getCurrentUrl();
            log.info("Chrome" + RetailerID + "  " + URLofPage);
            System.out.println(RetailerID + "  " + URLofPage);


        }

    }

    @Test(enabled = true)
    void Foldercreation() {

        File Reportdir = new File("C:\\Redipae RetailerMaster Reports");

        if (Reportdir.exists()) {

        } else {
            Reportdir.mkdir();
        }

    }

    public void captureScreen(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
            File target = new File(System.getProperty("user.dir") + "/ScreenShots/" + result.getName() + ".png");

            FileUtils.copyFile(source, target);
            System.out.println("Screenshot captured");
        }

    }


}
