import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestesSelenium {




    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("https://www.catho.com.br");
        browser.findElement(By.name("q")).sendKeys("programador");
        browser.findElement(By.name("submit")).submit();

        Assert.assertEquals("https://www.catho.com.br/vagas/?pais_id=31&q=programador", browser.getCurrentUrl());

        browser.close();
    }

    @Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("https://www.catho.com.br");

        browser.findElement(By.name("q")).sendKeys("programador");
        browser.navigate().refresh();

        browser.findElement(By.name("q")).sendKeys("programador");
//        Assert.assertEquals("programador", browser.);
        browser.close();
    }

    @Test
    public void test3() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("https://seguro.catho.com.br/signin/?_ga=2.230405148.1615813565.1632688812-387181253.1632688812");

        browser.findElement(By.id("input-4431277"));
        browser.findElement(By.id("input-4431278"));

//        browser.navigate().;
    }
}
