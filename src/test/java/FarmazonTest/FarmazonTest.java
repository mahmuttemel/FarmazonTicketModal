package FarmazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class FarmazonTest {
    //Elements
    static WebDriver cdriver;
    static WebElement girisyapbutton;
    static WebElement girisyaploginbutton;
    static WebElement usernamelabel;
    static WebElement passwordlabel;
    static WebElement urunbutton;
    static WebElement elementbuttonwait;
    static JavascriptExecutor js;
    static ExpectedCondition elementbuttonisdisplayed;
    static int milis=1000;
    static String usernamelogin="farmazonecz";
    static String passwordlogin="Kyg*DvCQjs8Uw";
    static WebElement Sorunbildirbutton;
    static WebElement eksikurun;
    static WebElement dropdownelement;
    static WebElement selectedOption;
    static WebElement sorunbildirticketbutton;
    static String actualeksikurunmessage;
    static WebElement farkliurunbutton;
    public String uploadfilepath;
    static WebElement uploadfile;
    static String actualfarkliuruntick;
    static String mainWindowHandle;
    static WebElement hasarliurun;
    static WebElement Hasarliurunnot;
    static WebElement Miadiyanlis;
    static WebElement Miadiyanlisnot;
    static WebElement Fazlaurun;
    static WebElement Fazlaurunnot;
    static WebElement kusurluurun;
    static WebElement Kusurluurunnot;
    static WebElement UTSBildirimi;
    static WebElement UTSBildiriminot;




    //Windows
    static Set<String> windows;
    static Iterator<String> window;
    static String parentid;
    static String Childone;



    @BeforeClass
    public void setUp() {
        cdriver = new ChromeDriver();
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        cdriver.get("https://staging.react.farmazon.com.tr/myprofile/orderdetail/buy/62011");


    }
    @AfterClass
    public void tearDown() {
        // cdriver.quit();

    }
    @Test
    public void test01() throws InterruptedException {  // homepage

        usernamelabel = cdriver.findElement(By.name("loginUsername"));
        usernamelabel.sendKeys(usernamelogin);
        Thread.sleep(milis);
        passwordlabel = cdriver.findElement(By.name("loginPassword"));
        passwordlabel.sendKeys(passwordlogin);
        Thread.sleep(milis);
        girisyaploginbutton = cdriver.findElement(By.xpath("//span[contains(text(),'Giriş Yap')]"));
        girisyaploginbutton.click();

    }
    @Test
    public void test02() throws InterruptedException {    // Sorun bildir butonu

        Sorunbildirbutton = cdriver.findElement(By.xpath("//button[normalize-space()='Sorun Bildir']"));
        Sorunbildirbutton.click();
        Thread.sleep(milis);

    }
    @Test
    public void test03() throws InterruptedException { //  Eksikürün
        urunbutton = cdriver.findElement(By.xpath("//button[normalize-space()='Ürün']"));
        urunbutton.click();
        Thread.sleep(milis);
        eksikurun = cdriver.findElement(By.xpath("//button[normalize-space()='Eksik Ürün']"));
        eksikurun.click();
        Thread.sleep(milis);

        dropdownelement = cdriver.findElement(By.xpath("//select[@name='155218']"));
        Select dropdown = new Select(dropdownelement);
        dropdown.selectByValue("1");
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[normalize-space()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();



    }
    @Test
    public void test04() throws InterruptedException { // Farklı Ürün


        Sorunbildirbutton = cdriver.findElement(By.xpath("//button[normalize-space()='Sorun Bildir']"));
        Sorunbildirbutton.click();
        Thread.sleep(milis);

        urunbutton = cdriver.findElement(By.xpath("//button[normalize-space()='Ürün']"));
        urunbutton.click();
        Thread.sleep(milis);

        mainWindowHandle = cdriver.getWindowHandle(); // window handle için


        farkliurunbutton = cdriver.findElement(By.xpath("//button[contains(text(),'Farklı Ürün')]"));
        farkliurunbutton.click();
        Thread.sleep(milis);

        dropdownelement = cdriver.findElement(By.xpath("//select[@name='155218']"));
        Select dropdown = new Select(dropdownelement);
        dropdown.selectByValue("1");
        Thread.sleep(milis);



        uploadfile = cdriver.findElement(By.id("upload-button"));
        uploadfile.sendKeys("C:\\Users\\mhmt_\\Desktop\\images\\images\\download(1).jpg");
        Thread.sleep(milis);


        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[normalize-space()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();

    }
    @Test
    public void test05() throws InterruptedException { // Hasarlı Ürün

        Sorunbildirbutton = cdriver.findElement(By.xpath("//button[normalize-space()='Sorun Bildir']"));
        Sorunbildirbutton.click();
        Thread.sleep(milis);

        urunbutton = cdriver.findElement(By.xpath("//button[normalize-space()='Ürün']"));
        urunbutton.click();
        Thread.sleep(milis);

        mainWindowHandle = cdriver.getWindowHandle();

        hasarliurun = cdriver.findElement(By.xpath("//button[contains(text(),'Hasarlı Ürün')]"));
        hasarliurun.click();
        Thread.sleep(milis);

        dropdownelement = cdriver.findElement(By.xpath("//select[@name='155218']"));
        Select dropdown = new Select(dropdownelement);
        dropdown.selectByValue("1");
        Thread.sleep(milis);


        uploadfile = cdriver.findElement(By.id("upload-button"));
        uploadfile.sendKeys("C:\\Users\\mhmt_\\Desktop\\images\\images\\download(1).jpg");
        Thread.sleep(milis);

        uploadfile = cdriver.findElement(By.id("upload-button"));
        uploadfile.sendKeys("C:\\Users\\mhmt_\\Desktop\\images\\images\\download(1).jpg");
        Thread.sleep(milis);


        Hasarliurunnot = cdriver.findElement(By.name("problemDetails"));
        Hasarliurunnot.sendKeys("Testnot");
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[normalize-space()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();

    }
    @Test
    public void test06() throws InterruptedException { // Miadı Yanlış Ürün

        Sorunbildirbutton = cdriver.findElement(By.xpath("//button[normalize-space()='Sorun Bildir']"));
        Sorunbildirbutton.click();
        Thread.sleep(milis);

        urunbutton = cdriver.findElement(By.xpath("//button[normalize-space()='Ürün']"));
        urunbutton.click();
        Thread.sleep(milis);

        mainWindowHandle = cdriver.getWindowHandle();

        Miadiyanlis = cdriver.findElement(By.xpath("//button[contains(text(),'Miadı Yanlış Ürün')]"));
        Miadiyanlis.click();
        Thread.sleep(milis);

        dropdownelement = cdriver.findElement(By.xpath("//select[@name='155218']"));
        Select dropdown = new Select(dropdownelement);
        dropdown.selectByValue("1");
        Thread.sleep(milis);


        Miadiyanlisnot = cdriver.findElement(By.name("problemDetails"));
        Miadiyanlisnot.sendKeys("Testnot");
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[normalize-space()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();
    }
    @Test
    public void test07() throws InterruptedException { // Fazla Ürün

        Sorunbildirbutton = cdriver.findElement(By.xpath("//button[normalize-space()='Sorun Bildir']"));
        Sorunbildirbutton.click();
        Thread.sleep(milis);

        urunbutton = cdriver.findElement(By.xpath("//button[normalize-space()='Ürün']"));
        urunbutton.click();
        Thread.sleep(milis);

        mainWindowHandle = cdriver.getWindowHandle();

        Fazlaurun = cdriver.findElement(By.xpath("//button[normalize-space()='Fazla Ürün']"));
        Fazlaurun.click();
        Thread.sleep(milis);

        Fazlaurunnot = cdriver.findElement(By.name("problemDetails"));
        Fazlaurunnot.sendKeys("Testnot");
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[normalize-space()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();
    }
    @Test
    public void test08() throws InterruptedException { // Kusurlu Ürün

        Sorunbildirbutton = cdriver.findElement(By.xpath("//button[normalize-space()='Sorun Bildir']"));
        Sorunbildirbutton.click();
        Thread.sleep(milis);

        urunbutton = cdriver.findElement(By.xpath("//button[normalize-space()='Ürün']"));
        urunbutton.click();
        Thread.sleep(milis);

        mainWindowHandle = cdriver.getWindowHandle();

        kusurluurun = cdriver.findElement(By.xpath("//button[normalize-space()='Kusurlu Ürün']"));
        kusurluurun.click();
        Thread.sleep(milis);

        dropdownelement = cdriver.findElement(By.xpath("//select[@name='155218']"));
        Select dropdown = new Select(dropdownelement);
        dropdown.selectByValue("1");
        Thread.sleep(milis);


        uploadfile = cdriver.findElement(By.id("upload-button"));
        uploadfile.sendKeys("C:\\Users\\mhmt_\\Desktop\\images\\images\\download(1).jpg");
        Thread.sleep(milis);


        Kusurluurunnot = cdriver.findElement(By.name("problemDetails"));
        Kusurluurunnot.sendKeys("Testnot");
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[normalize-space()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();
    }
    @Test
    public void test09() throws InterruptedException { // ÜTS Bildirimi

        Sorunbildirbutton = cdriver.findElement(By.xpath("//button[normalize-space()='Sorun Bildir']"));
        Sorunbildirbutton.click();
        Thread.sleep(milis);

        urunbutton = cdriver.findElement(By.xpath("//button[normalize-space()='Ürün']"));
        urunbutton.click();
        Thread.sleep(milis);

        mainWindowHandle = cdriver.getWindowHandle();

        UTSBildirimi = cdriver.findElement(By.xpath("//button[normalize-space()='ÜTS Problemi']"));
        UTSBildirimi.click();
        Thread.sleep(milis);

        dropdownelement = cdriver.findElement(By.xpath("//select[@name='155218']"));
        Select dropdown = new Select(dropdownelement);
        dropdown.selectByValue("1");
        Thread.sleep(milis);

        UTSBildiriminot = cdriver.findElement(By.name("problemDetails"));
        UTSBildiriminot.sendKeys("Testnot");
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[normalize-space()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();
    }


}