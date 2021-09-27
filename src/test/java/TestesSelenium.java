import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

        browser.findElement(By.name("email")).sendKeys("clebercaio12345@gmail.com");
        browser.findElement(By.name("password")).sendKeys("Cleber194t%");

        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.findElement(By.xpath("//*[@id=\"__next\"]/div/div/main/div/div/div/div/article/div/form/button")).submit();


        browser.findElement(By.xpath("text-size-adjust: 100%;\n" +
                "    margin: 0;\n" +
                "    border: 0;\n" +
                "    font: inherit;\n" +
                "    vertical-align: baseline;\n" +
                "    text-decoration: none;\n" +
                "    outline: 0 none;\n" +
                "    appearance: none;\n" +
                "    transition: all .1s ease-out;\n" +
                "    border-radius: 5px;\n" +
                "    box-shadow: none;\n" +
                "    border-width: 0 0 3px;\n" +
                "    border-style: solid;\n" +
                "    text-align: center;\n" +
                "    text-shadow: none;\n" +
                "    background-color: #005da4;\n" +
                "    border-color: #00468C;\n" +
                "    color: #fff;\n" +
                "    font-size: 1.1666666666666667em;\n" +
                "    display: inline-block;\n" +
                "    font-weight: 700;\n" +
                "    padding: 8px 27px 7px;\n" +
                "    text-transform: lowercase;")).submit();


//        browser.close();
    }
}
