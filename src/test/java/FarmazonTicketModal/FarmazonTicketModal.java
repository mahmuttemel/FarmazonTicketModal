package FarmazonTicketModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class FarmazonTicketModal {
    static WebDriver cdriver;
    static SoftAssert softAssert;
    static File file;

    //ELEMENTS
    static WebElement usernamelabel;
    static WebElement passwordlabel;
    static WebElement girisyapbutton;
    static WebElement sorunbildirbutton;
    static WebElement Urunbutton;
    static WebElement Eksikurunbutton;
    static WebElement sorunbildirticketbutton;
    static WebElement Farkliurunbutton;
    static WebElement uploadButton;
    static WebElement Hasarliurunbutton;
    static WebElement hasarlinotlabel;
    static WebElement miadiyanlisurunbutton;
    static WebElement miadiyanlisnot;
    static WebElement fazlaurunbutton;
    static WebElement fazlaurunnot;
    static WebElement ayipliurunbutton;
    static WebElement ayipliurunnot;
    static WebElement UTSBildirimibutton;
    static WebElement UTSBildirinot;
    static String originalWindow;





    //OTHER
    static int milis = 1000;
    public String downloadFilePath;
    static String expectedFilePath = "C:\\Users\\mhmt_\\OneDrive\\Desktop\\images\\images\\images\\ticketgorsel.jpg";
    static String actualFilePath;
    static String username="farmazonecz";
    static String password="Kyg*DvCQjs8Uw";
    static String testnot = "Testnot";

    @BeforeClass
    public static void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");

        cdriver = new ChromeDriver(options);
        softAssert = new SoftAssert();
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        cdriver.get("https://staging.react.farmazon.com.tr/myprofile/orderdetail/buy/62011");

        // WebElement'in yüklenmesini bekle
        WebDriverWait wait = new WebDriverWait(cdriver, Duration.ofSeconds(10));
        usernamelabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginUsername")));

        usernamelabel.sendKeys(username);
        Thread.sleep(milis);

        passwordlabel = cdriver.findElement(By.name("loginPassword"));
        passwordlabel.sendKeys(password);
        Thread.sleep(milis);

        girisyapbutton = cdriver.findElement(By.xpath("//span[contains(text(),'Giriş Yap')]"));
        girisyapbutton.click();
        Thread.sleep(milis);

        sorunbildirbutton = cdriver.findElement(By.xpath("//button[text()='Sorun Bildir']"));
        sorunbildirbutton.click();
        Thread.sleep(milis);

    }
    @AfterClass
    public static void tearDown(){ cdriver.quit();
    }

    @Test
    public void test01() throws InterruptedException {  // Eksik Ürün

        Urunbutton = cdriver.findElement(By.xpath("//button[text()='Ürün']"));
        Urunbutton.click();
        Thread.sleep(milis);

        originalWindow = cdriver.getWindowHandle();

// Açılan tüm pencereleri al
        for (String windowHandle : cdriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                cdriver.switchTo().window(windowHandle);
                cdriver.close();
            }
        }

// İlk pencereye geri dön
        cdriver.switchTo().window(originalWindow);

        Eksikurunbutton = cdriver.findElement(By.xpath("//button[text()='Eksik Ürün']"));
        Eksikurunbutton.click();
        Thread.sleep(milis);

        Select dropdown = new Select(cdriver.findElement(By.xpath("//select[@name='155218']")));
        dropdown.selectByVisibleText("1");
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[text()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();

    }
    @Test
    public void test02() throws InterruptedException { // Farklı Ürün

        sorunbildirbutton = cdriver.findElement(By.xpath("//button[text()='Sorun Bildir']"));
        sorunbildirbutton.click();
        Thread.sleep(milis);

        Urunbutton = cdriver.findElement(By.xpath("//button[text()='Ürün']"));
        Urunbutton.click();
        Thread.sleep(milis);

        originalWindow = cdriver.getWindowHandle();

// Açılan tüm pencereleri al
        for (String windowHandle : cdriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                cdriver.switchTo().window(windowHandle);
                cdriver.close();
            }
        }

// İlk pencereye geri dön
        cdriver.switchTo().window(originalWindow);
        Farkliurunbutton = cdriver.findElement(By.xpath("//button[contains(text(),'Farklı Ürün')]"));
        Farkliurunbutton.click();
        Thread.sleep(milis);


        Select dropdown = new Select(cdriver.findElement(By.xpath("//select[@name='155218']")));
        dropdown.selectByVisibleText("1");
        Thread.sleep(milis);

        uploadButton = cdriver.findElement(By.id("upload-button"));
        uploadButton.sendKeys(expectedFilePath);
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[text()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();

    }
    @Test
    public void test03() throws InterruptedException {  // Hasarlı Urun

        sorunbildirbutton = cdriver.findElement(By.xpath("//button[text()='Sorun Bildir']"));
        sorunbildirbutton.click();
        Thread.sleep(milis);

        Urunbutton = cdriver.findElement(By.xpath("//button[text()='Ürün']"));
        Urunbutton.click();
        Thread.sleep(milis);

        originalWindow = cdriver.getWindowHandle();

// Açılan tüm pencereleri al
        for (String windowHandle : cdriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                cdriver.switchTo().window(windowHandle);
                cdriver.close();
            }
        }

// İlk pencereye geri dön
        cdriver.switchTo().window(originalWindow);

        Hasarliurunbutton = cdriver.findElement(By.xpath("//button[contains(text(),'Hasarlı Ürün')]"));
        Hasarliurunbutton.click();
        Thread.sleep(milis);

        Select dropdown = new Select(cdriver.findElement(By.xpath("//select[@name='155218']")));
        dropdown.selectByVisibleText("1");
        Thread.sleep(milis);

        uploadButton = cdriver.findElement(By.id("upload-button"));
        uploadButton.sendKeys(expectedFilePath);
        Thread.sleep(milis);

        uploadButton = cdriver.findElement(By.id("upload-button"));
        uploadButton.sendKeys(expectedFilePath);
        Thread.sleep(milis);

        hasarlinotlabel = cdriver.findElement(By.xpath("//input[@placeholder='Not yazınız']"));
        hasarlinotlabel.sendKeys(testnot);
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[text()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();


    }
    @Test
    public void test04() throws InterruptedException {  // Miadı Yanlıs

        sorunbildirbutton = cdriver.findElement(By.xpath("//button[text()='Sorun Bildir']"));
        sorunbildirbutton.click();
        Thread.sleep(milis);

        Urunbutton = cdriver.findElement(By.xpath("//button[text()='Ürün']"));
        Urunbutton.click();
        Thread.sleep(milis);

        originalWindow = cdriver.getWindowHandle();

        for (String windowHandle : cdriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                cdriver.switchTo().window(windowHandle);
                cdriver.close();
            }
        }

        cdriver.switchTo().window(originalWindow);

        miadiyanlisurunbutton = cdriver.findElement(By.xpath("//button[contains(text(),'Miadı Yanlış Ürün')]"));
        miadiyanlisurunbutton.click();
        Thread.sleep(milis);

        originalWindow = cdriver.getWindowHandle();

        for (String windowHandle : cdriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                cdriver.switchTo().window(windowHandle);
                cdriver.close();
            }
        }

        cdriver.switchTo().window(originalWindow);


        Select dropdown = new Select(cdriver.findElement(By.xpath("//select[@name='155218']")));
        dropdown.selectByVisibleText("1");
        Thread.sleep(milis);

        uploadButton = cdriver.findElement(By.id("upload-button"));
        uploadButton.sendKeys(expectedFilePath);
        Thread.sleep(milis);

        miadiyanlisnot = cdriver.findElement(By.xpath("//input[@placeholder='Not yazınız']"));
        miadiyanlisnot.sendKeys(testnot);
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[text()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();


    }
    @Test
    public void test05() throws InterruptedException { // Fazla Ürün

        sorunbildirbutton = cdriver.findElement(By.xpath("//button[text()='Sorun Bildir']"));
        sorunbildirbutton.click();
        Thread.sleep(milis);

        Urunbutton = cdriver.findElement(By.xpath("//button[text()='Ürün']"));
        Urunbutton.click();
        Thread.sleep(milis);

        originalWindow = cdriver.getWindowHandle();

        for (String windowHandle : cdriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                cdriver.switchTo().window(windowHandle);
                cdriver.close();
            }
        }

        cdriver.switchTo().window(originalWindow);

        fazlaurunbutton = cdriver.findElement(By.xpath("//button[normalize-space()='Fazla Ürün']"));
        fazlaurunbutton.click();
        Thread.sleep(milis);


        fazlaurunnot = cdriver.findElement(By.xpath("//input[@placeholder='Not yazınız']"));
        fazlaurunnot.sendKeys(testnot);
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[text()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();




    }
    @Test
    public void test06() throws InterruptedException { // Ayıplı Ürün


        sorunbildirbutton = cdriver.findElement(By.xpath("//button[text()='Sorun Bildir']"));
        sorunbildirbutton.click();
        Thread.sleep(milis);

        Urunbutton = cdriver.findElement(By.xpath("//button[text()='Ürün']"));
        Urunbutton.click();
        Thread.sleep(milis);

        originalWindow = cdriver.getWindowHandle();

        for (String windowHandle : cdriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                cdriver.switchTo().window(windowHandle);
                cdriver.close();
            }
        }

        cdriver.switchTo().window(originalWindow);

        ayipliurunbutton = cdriver.findElement(By.xpath("//button[contains(text(),'Ayıplı Ürün')]"));
        ayipliurunbutton.click();
        Thread.sleep(milis);


        Select dropdown = new Select(cdriver.findElement(By.xpath("//select[@name='155218']")));
        dropdown.selectByVisibleText("1");
        Thread.sleep(milis);

        uploadButton = cdriver.findElement(By.id("upload-button"));
        uploadButton.sendKeys(expectedFilePath);
        Thread.sleep(milis);

        ayipliurunnot = cdriver.findElement(By.xpath("//input[@placeholder='Not yazınız']"));
        ayipliurunnot.sendKeys(testnot);
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[text()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();


    }
    @Test
    public void test07() throws InterruptedException { // UTS Bildirimi

        sorunbildirbutton = cdriver.findElement(By.xpath("//button[text()='Sorun Bildir']"));
        sorunbildirbutton.click();
        Thread.sleep(milis);

        Urunbutton = cdriver.findElement(By.xpath("//button[text()='Ürün']"));
        Urunbutton.click();
        Thread.sleep(milis);

        originalWindow = cdriver.getWindowHandle();

        for (String windowHandle : cdriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                cdriver.switchTo().window(windowHandle);
                cdriver.close();
            }
        }

        cdriver.switchTo().window(originalWindow);

        UTSBildirimibutton = cdriver.findElement(By.xpath("//button[normalize-space()='ÜTS Problemi']"));
        UTSBildirimibutton.click();
        Thread.sleep(milis);

        Select dropdown = new Select(cdriver.findElement(By.xpath("//select[@name='155218']")));
        dropdown.selectByVisibleText("1");
        Thread.sleep(milis);


        UTSBildirinot = cdriver.findElement(By.xpath("//input[@placeholder='Not yazınız']"));
        UTSBildirinot.sendKeys(testnot);
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[text()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();

    }
}
