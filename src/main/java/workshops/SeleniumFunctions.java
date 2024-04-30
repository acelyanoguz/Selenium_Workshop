package workshops;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumFunctions {
    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver= new ChromeDriver();
        //1-)Selenium WebDriver: tarayıcıların kontrolünü sağlar.
        //Tarayıcılar arası uyumluluk için farklı sürücüler sağlar (ChromeDriver, FirefoxDriver, vb.).
        webDriver.navigate().to("https://www.saucedemo.com/v1/");

        //2-)getTitle() fonksiyonu: WebDriver aracılığıyla açık olan tarayıcının başlık(title) metnini döndürür.
        //Bu fonksiyon herhangi bir parametre almaz çünkü sadece mevcut tarayıcının başlığını döndürür.
        String title= webDriver.getTitle();
        System.out.println(title);

        //3-)WebElement: Web sayfasındaki HTML elementlerini temsil eder.
        //Bu elementlere tıklama, metin yazma, değer alma gibi işlemleri gerçekleştirmek için kullanılır.
        //4-)findElement: Belirli bir HTML elementini bulmak için kullanılır.
        // Bu metod, bir CSS selektörü veya XPath ifadesi kullanarak elementleri bulabilir.
        WebElement usernameInput=webDriver.findElement(By.id("user-name"));

        //5-)sendKeys(): Bir WebElement'e metin göndermek için kullanılır.
        //Özellikle form alanlarına metin yazmak için kullanılır.
        usernameInput.sendKeys("acelya_deneme");
        System.out.println(usernameInput);
        Thread.sleep(1000);

        //6-)click fonksiyonu, bir WebElement'e tıklamak için kullanılır ve herhangi bir parametre almaz.
        //Bu fonksiyon, sadece belirtilen WebElement'e tıklar ve herhangi bir dönüş değeri yoktur.
        WebElement loginBtn=webDriver.findElement(By.id("login-button"));
        loginBtn.click();

        //7-) findElements() fonksiyonu, WebDriver aracılığıyla bir web sayfasındaki belirli
        //HTML elementlerini bulmak için kullanılır. Parametreleri "by" ve "locator" dir.
        List<WebElement> inputs=webDriver.findElements(By.cssSelector("input"));
        System.out.println("Toplam input sayısı:"+inputs.size());

        //8-)getAttribute() fonksiyonu, bir WebElement'in belirli bir HTML özniteliğinin değerini almak için kullanılır.
        //Bir parametresi vardır: attributeName: Bu parametre, alınmak istenen HTML özniteliğinin adını belirtir.
        //Örneğin, bir elementin id, class, href, value gibi özniteliklerinin değerlerini almak için getAttribute() fonksiyonunu kullanabilirsiniz.
        //Bu örnekte,tüm <input> elementlerinin value özniteliğinin değerini almak için kullanılmıştır.
        for(WebElement input:inputs){
            System.out.println("input text i: "+ input.getAttribute("value"));
        }


        //9-)getText: getText() fonksiyonu, bir WebElement'in metin içeriğini almak için kullanılır.
        //Parametresi yoktur. Sadece çalıştırıldığı WebElement'in metin içeriğini döndürür.

        WebElement errorText=webDriver.findElement(By.tagName("h3"));
        String errorText1=errorText.getText();
        System.out.println("Hata metni: "+errorText1);

        //10-)isEnabled(): Bir WebElement'in etkin olup olmadığını kontrol etmek için kullanılır.
        //Bu fonksiyonun herhangi bir parametresi yoktur. True veya false değeri döndürür.
        Boolean isEnabled=usernameInput.isEnabled();
        System.out.println("Username alanı etkin mi: "+isEnabled);

        //11-) isDisplayed(): Bir WebElement'in görüntülenip görüntülenmediğini kontrol etmek için kullanılır.
        //Bu fonksiyonun herhangi bir parametresi yoktur. True veya false değeri döndürür.

        WebElement logo=webDriver.findElement(By.className("login_logo"));
        Boolean isDisplayed=logo.isDisplayed();
        System.out.println("Logo gözüküyor mu: "+isDisplayed);

        //Web driver i kapatma
        webDriver.quit();
    }
}
