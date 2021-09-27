import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestesSelenium {



    //    busca por vaga
    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("https://www.catho.com.br");
        browser.findElement(By.name("q")).sendKeys("programador");
        browser.findElement(By.name("submit")).submit();

        Assert.assertFalse(browser.getCurrentUrl().equals("https://www.catho.com.br"));

        browser.close();
    }

    //    atualizar perfil com cep invalido
    @Test
    public void test2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("https://seguro.catho.com.br/signin/?_ga=2.230405148.1615813565.1632688812-387181253.1632688812");

        browser.findElement(By.name("email")).sendKeys("clebercaio12345@gmail.com");
        browser.findElement(By.name("password")).sendKeys("Cleber194t%");

        browser.findElement(By.xpath("//*[@id=\"__next\"]/div/div/main/div/div/div/div/article/div/form/button")).submit();

        TimeUnit.SECONDS.sleep(7);

        browser.navigate().to("https://www.catho.com.br/curriculo/?sugestaoVagas=1&editInativo=1&_ga=2.111187460.1071191939.1632741763-1569945203.1632741762");
        TimeUnit.SECONDS.sleep(3);
        browser.navigate().to("https://www.catho.com.br/curriculo/dados-pessoais/");
        TimeUnit.SECONDS.sleep(3);

        browser.findElement(By.id("zipCode")).sendKeys("445");
        browser.findElement(By.xpath("//*[@id=\"main\"]/section/form/div[10]/button")).submit();

        Assert.assertTrue(browser.getPageSource().contains("Ops! Este CEP é inválido"));

        browser.close();
    }

    //    Testa se o campo CEP fica vazio apos recarregar pagina
    @Test
    public void test3() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("https://seguro.catho.com.br/signin/?_ga=2.230405148.1615813565.1632688812-387181253.1632688812");

        browser.findElement(By.name("email")).sendKeys("clebercaio12345@gmail.com");
        browser.findElement(By.name("password")).sendKeys("Cleber194t%");

        browser.findElement(By.xpath("//*[@id=\"__next\"]/div/div/main/div/div/div/div/article/div/form/button")).submit();

        TimeUnit.SECONDS.sleep(7);

        browser.navigate().to("https://www.catho.com.br/curriculo/?sugestaoVagas=1&editInativo=1&_ga=2.111187460.1071191939.1632741763-1569945203.1632741762");
        TimeUnit.SECONDS.sleep(3);
        browser.navigate().to("https://www.catho.com.br/curriculo/dados-pessoais/");
        TimeUnit.SECONDS.sleep(3);

        browser.findElement(By.id("zipCode")).sendKeys("445");
        browser.navigate().refresh();

        Assert.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("zipCode")));

        browser.close();
    }

    //    Atualizar perfil com numero da casa invalido
    @Test
    public void test4() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("https://seguro.catho.com.br/signin/?_ga=2.230405148.1615813565.1632688812-387181253.1632688812");

        browser.findElement(By.name("email")).sendKeys("clebercaio12345@gmail.com");
        browser.findElement(By.name("password")).sendKeys("Cleber194t%");

        browser.findElement(By.xpath("//*[@id=\"__next\"]/div/div/main/div/div/div/div/article/div/form/button")).submit();

        TimeUnit.SECONDS.sleep(7);

        browser.navigate().to("https://www.catho.com.br/curriculo/?sugestaoVagas=1&editInativo=1&_ga=2.111187460.1071191939.1632741763-1569945203.1632741762");
        TimeUnit.SECONDS.sleep(3);
        browser.navigate().to("https://www.catho.com.br/curriculo/dados-pessoais/");
        TimeUnit.SECONDS.sleep(3);

        browser.findElement(By.id("addressNumber")).click();
        browser.findElement(By.xpath("//*[@id=\"main\"]/section/form/div[10]/button")).submit();

        Assert.assertTrue(browser.getPageSource().contains("Número inválido"));

        browser.close();
    }

    //    Atualizar perfil com logradouro invalido
    @Test
    public void test5() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("https://seguro.catho.com.br/signin/?_ga=2.230405148.1615813565.1632688812-387181253.1632688812");

        browser.findElement(By.name("email")).sendKeys("clebercaio12345@gmail.com");
        browser.findElement(By.name("password")).sendKeys("Cleber194t%");

        browser.findElement(By.xpath("//*[@id=\"__next\"]/div/div/main/div/div/div/div/article/div/form/button")).submit();

        TimeUnit.SECONDS.sleep(7);

        browser.navigate().to("https://www.catho.com.br/curriculo/?sugestaoVagas=1&editInativo=1&_ga=2.111187460.1071191939.1632741763-1569945203.1632741762");
        TimeUnit.SECONDS.sleep(3);
        browser.navigate().to("https://www.catho.com.br/curriculo/dados-pessoais/");
        TimeUnit.SECONDS.sleep(3);

        browser.findElement(By.id("address")).click();
        browser.findElement(By.xpath("//*[@id=\"main\"]/section/form/div[10]/button")).submit();

        Assert.assertTrue(browser.getPageSource().contains("Informe seu endereço"));

        browser.close();
    }

    //    Atualizar perfil sem um nome
    @Test
    public void test6() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("https://seguro.catho.com.br/signin/?_ga=2.230405148.1615813565.1632688812-387181253.1632688812");

        browser.findElement(By.name("email")).sendKeys("clebercaio12345@gmail.com");
        browser.findElement(By.name("password")).sendKeys("Cleber194t%");

        browser.findElement(By.xpath("//*[@id=\"__next\"]/div/div/main/div/div/div/div/article/div/form/button")).submit();

        TimeUnit.SECONDS.sleep(7);

        browser.navigate().to("https://www.catho.com.br/curriculo/?sugestaoVagas=1&editInativo=1&_ga=2.111187460.1071191939.1632741763-1569945203.1632741762");
        TimeUnit.SECONDS.sleep(3);
        browser.navigate().to("https://www.catho.com.br/curriculo/dados-pessoais/");
        TimeUnit.SECONDS.sleep(4);

        browser.findElement(By.id("name")).clear();

        Assert.assertTrue(browser.getPageSource().contains("O campo Nome completo é obrigatório"));

        browser.close();
    }

    //    Atualizar perfil sem um email
    @Test
    public void test7() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("https://seguro.catho.com.br/signin/?_ga=2.230405148.1615813565.1632688812-387181253.1632688812");

        browser.findElement(By.name("email")).sendKeys("clebercaio12345@gmail.com");
        browser.findElement(By.name("password")).sendKeys("Cleber194t%");

        browser.findElement(By.xpath("//*[@id=\"__next\"]/div/div/main/div/div/div/div/article/div/form/button")).submit();

        TimeUnit.SECONDS.sleep(7);

        browser.navigate().to("https://www.catho.com.br/curriculo/?sugestaoVagas=1&editInativo=1&_ga=2.111187460.1071191939.1632741763-1569945203.1632741762");
        TimeUnit.SECONDS.sleep(3);
        browser.navigate().to("https://www.catho.com.br/curriculo/dados-pessoais/");
        TimeUnit.SECONDS.sleep(4);

        browser.findElement(By.id("email")).clear();

        Assert.assertTrue(browser.getPageSource().contains("O campo E-mail é obrigatório"));

        browser.close();
    }

    //    Atualizar perfil sem um telefone
    @Test
    public void test8() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("https://seguro.catho.com.br/signin/?_ga=2.230405148.1615813565.1632688812-387181253.1632688812");

        browser.findElement(By.name("email")).sendKeys("clebercaio12345@gmail.com");
        browser.findElement(By.name("password")).sendKeys("Cleber194t%");

        browser.findElement(By.xpath("//*[@id=\"__next\"]/div/div/main/div/div/div/div/article/div/form/button")).submit();

        TimeUnit.SECONDS.sleep(7);

        browser.navigate().to("https://www.catho.com.br/curriculo/?sugestaoVagas=1&editInativo=1&_ga=2.111187460.1071191939.1632741763-1569945203.1632741762");
        TimeUnit.SECONDS.sleep(3);
        browser.navigate().to("https://www.catho.com.br/curriculo/dados-pessoais/");
        TimeUnit.SECONDS.sleep(4);

        browser.findElement(By.id("phoneCel")).clear();

        Assert.assertTrue(browser.getPageSource().contains("O campo Telefone principal é obrigatório"));

        browser.close();
    }

//    testando redirecionamento do botão voltar para area do candidato
    @Test
    public void test9() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("https://seguro.catho.com.br/signin/?_ga=2.230405148.1615813565.1632688812-387181253.1632688812");

        browser.findElement(By.name("email")).sendKeys("clebercaio12345@gmail.com");
        browser.findElement(By.name("password")).sendKeys("Cleber194t%");

        browser.findElement(By.xpath("//*[@id=\"__next\"]/div/div/main/div/div/div/div/article/div/form/button")).submit();

        TimeUnit.SECONDS.sleep(7);

        browser.navigate().to("https://www.catho.com.br/curriculo/?sugestaoVagas=1&editInativo=1&_ga=2.111187460.1071191939.1632741763-1569945203.1632741762");
        TimeUnit.SECONDS.sleep(3);
        browser.navigate().to("https://www.catho.com.br/curriculo/dados-pessoais/");
        TimeUnit.SECONDS.sleep(3);

        browser.findElement(By.xpath("/html/body/div[1]/main/section/form/div[11]/button")).click();
        TimeUnit.SECONDS.sleep(1);

        Assert.assertFalse(browser.getCurrentUrl().equals("https://www.catho.com.br/curriculo/dados-pessoais/"));

        browser.close();
    }

    @Test
    public void test10() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("https://seguro.catho.com.br/signin/?_ga=2.230405148.1615813565.1632688812-387181253.1632688812");

        browser.findElement(By.name("email")).sendKeys("clebercaio12345@gmail.com");
        browser.findElement(By.name("password")).sendKeys("Cleber194t%");

        browser.findElement(By.xpath("//*[@id=\"__next\"]/div/div/main/div/div/div/div/article/div/form/button")).submit();

        TimeUnit.SECONDS.sleep(7);

        String url = browser.getCurrentUrl();
//        browser.navigate().to("https://www.catho.com.br/curriculo/?sugestaoVagas=1&editInativo=1&_ga=2.111187460.1071191939.1632741763-1569945203.1632741762");
//        TimeUnit.SECONDS.sleep(3);

        browser.findElement(By.xpath("//*[@id=\"bcTestsContainer\"]/div[1]/article/div[4]/div/div/div/a")).click();

        Assert.assertFalse(browser.getCurrentUrl().equals(url));

        browser.close();
    }
}
