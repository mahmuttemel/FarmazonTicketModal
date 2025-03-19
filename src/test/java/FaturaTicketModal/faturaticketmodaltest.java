package FaturaTicketModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;

public class faturaticketmodaltest {
    static WebDriver cdriver;
    static SoftAssert softAssert;
    static File file;

    //ELEMENTS
    static WebElement usernamelabel;
    static WebElement passwordlabel;
    static WebElement girisyapbutton;
    static WebElement sorunbildirbutton;
    static WebElement faturabutton;
    static WebElement faturamgelmedibutton;
    static WebElement faturachecbox1;
    static WebElement faturachecbox2;
    static WebElement faturayisaticidantalepbutton;
    static WebElement uploadButton;
    static WebElement faturahatalibutton;
    static WebElement faturahatalinot;
    static WebElement gelenbanaaitdegilbutton;
    static WebElement gelenbanaaitdegilnot;
    static WebElement sorunbildirticketbutton;
    static WebElement kargobutton;
    static WebElement kargomgelmedibutton;
    static WebElement kargomgelmedinot;

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

        // UPDATE SupportTickets SET Status = 3 WHERE Id BETWEEN 139735 AND 139735;
        // UPDATE SupportTickets SET IsDeleted = 1  WHERE Id BETWEEN 139725 AND 139735;

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
    public void test01() throws InterruptedException { // Faturam Gelmedi

        faturabutton = cdriver.findElement(By.xpath("//button[text()='Fatura']"));
        faturabutton.click();
        Thread.sleep(milis);

        faturamgelmedibutton = cdriver.findElement(By.xpath("//button[text()='Faturam Gelmedi']"));
        faturamgelmedibutton.click();
        Thread.sleep(milis);

        originalWindow = cdriver.getWindowHandle();

        for (String windowHandle : cdriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                cdriver.switchTo().window(windowHandle);
                cdriver.close();
            }
        }

        cdriver.switchTo().window(originalWindow);

        faturachecbox1 = cdriver.findElement(By.xpath("//div[contains(@class,'invoice-field')]//div[2]"));

        boolean isSelectedfaturabutton = faturachecbox1.isSelected();

        if(isSelectedfaturabutton){
            System.out.println("CheckBox is already selected");
        }else{
            faturachecbox1.click();
            Thread.sleep(milis);

            faturachecbox2 = cdriver.findElement(By.xpath("//div[contains(@class,'invoice-field')]//div[3]"));

            boolean isSelectedfaturabutton2 = faturachecbox2.isSelected();

            if(isSelectedfaturabutton2){
                System.out.println("CheckBox is already selected");
            }else{
                faturachecbox2.click();
                Thread.sleep(milis);

                faturayisaticidantalepbutton = cdriver.findElement(By.xpath("//button[contains(text(),'Faturayı Satıcıdan Talep Et')]"));
                faturayisaticidantalepbutton.click();
                Thread.sleep(milis);

                cdriver.navigate().refresh();

    }
        }

    }
    @Test
    public void test02() throws InterruptedException { // Fatura Hatalı

        sorunbildirbutton = cdriver.findElement(By.xpath("//button[text()='Sorun Bildir']"));
        sorunbildirbutton.click();
        Thread.sleep(milis);

        faturabutton = cdriver.findElement(By.xpath("//button[text()='Fatura']"));
        faturabutton.click();
        Thread.sleep(milis);

        faturahatalibutton = cdriver.findElement(By.xpath("//button[contains(text(),'Fatura Hatalı')]"));
        faturahatalibutton.click();
        Thread.sleep(milis);

        originalWindow = cdriver.getWindowHandle();

        for (String windowHandle : cdriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                cdriver.switchTo().window(windowHandle);
                cdriver.close();
            }
        }

        cdriver.switchTo().window(originalWindow);

        faturahatalinot = cdriver.findElement(By.xpath("//input[@placeholder='Not yazınız']"));
        faturahatalinot.sendKeys(testnot);
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[text()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();

    }
    @Test
    public void test03() throws InterruptedException { // Kargom Gelmedi

        sorunbildirbutton = cdriver.findElement(By.xpath("//button[text()='Sorun Bildir']"));
        sorunbildirbutton.click();
        Thread.sleep(milis);

        kargobutton = cdriver.findElement(By.xpath("//button[normalize-space()='Kargo']"));
        kargobutton.click();
        Thread.sleep(milis);

        kargomgelmedibutton = cdriver.findElement(By.xpath("//button[normalize-space()='Kargom Gelmedi']"));
        kargomgelmedibutton.click();
        Thread.sleep(milis);

        originalWindow = cdriver.getWindowHandle();

        for (String windowHandle : cdriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                cdriver.switchTo().window(windowHandle);
                cdriver.close();
            }
        }

        cdriver.switchTo().window(originalWindow);

        kargomgelmedinot = cdriver.findElement(By.xpath("//input[@placeholder='Not yazınız']"));
        kargomgelmedinot.sendKeys(testnot);
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[text()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

        cdriver.navigate().refresh();


    }
    @Test
    public void test04() throws InterruptedException { // Gelen Kargo Bana Ait Değil

        sorunbildirbutton = cdriver.findElement(By.xpath("//button[text()='Sorun Bildir']"));
        sorunbildirbutton.click();
        Thread.sleep(milis);

        kargobutton = cdriver.findElement(By.xpath("//button[normalize-space()='Kargo']"));
        kargobutton.click();
        Thread.sleep(milis);

        gelenbanaaitdegilbutton = cdriver.findElement(By.xpath("//button[contains(text(),'Gelen Kargo Bana Ait Değil')]"));
        gelenbanaaitdegilbutton.click();
        Thread.sleep(milis);

        originalWindow = cdriver.getWindowHandle();

        for (String windowHandle : cdriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                cdriver.switchTo().window(windowHandle);
                cdriver.close();
            }
        }

        cdriver.switchTo().window(originalWindow);

        uploadButton = cdriver.findElement(By.id("upload-button"));
        uploadButton.sendKeys(expectedFilePath);
        Thread.sleep(milis);

        uploadButton = cdriver.findElement(By.id("upload-button"));
        uploadButton.sendKeys(expectedFilePath);
        Thread.sleep(milis);

        gelenbanaaitdegilnot = cdriver.findElement(By.xpath("//input[@placeholder='Not yazınız']"));
        gelenbanaaitdegilnot.sendKeys(testnot);
        Thread.sleep(milis);

        sorunbildirticketbutton = cdriver.findElement(By.xpath("//span[text()='Sorun Bildir']"));
        sorunbildirticketbutton.click();
        Thread.sleep(milis);

    }
}



