package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculadoraTest {
    private static final String URL = "https://igorsmasc.github.io/calculadora_atividade_selenium/";
    private static WebDriver driver;
    @BeforeAll
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @BeforeEach
    void beforeEach() {
        driver.get(URL);
    }
    @AfterAll
    public static void afterAll(){
        driver.quit();
    }

    @Test
    void somaTest(){
        WebElement num1  = driver.findElement(By.id("seven"));
        num1.click();
        WebElement op = driver.findElement(By.xpath("//*[@id=\"add\"]"));
        op.click();
        WebElement num2 = driver.findElement(By.cssSelector("#four"));
        num2.click();
        WebElement buttonEquals = driver.findElement(By.id("equals"));
        buttonEquals.click();
        WebElement display = driver.findElement(By.id("display"));

        Assertions.assertEquals("11",display.getAttribute("value"));
    }

    @Test
    void subtracaoTest(){
        WebElement num1  = driver.findElement(By.id("nine"));
        num1.click();
        WebElement op = driver.findElement(By.xpath("//*[@id=\"subtract\"]"));
        op.click();
        WebElement num2 = driver.findElement(By.cssSelector("#three"));
        num2.click();
        WebElement buttonEquals = driver.findElement(By.id("equals"));
        buttonEquals.click();
        WebElement display = driver.findElement(By.id("display"));

        Assertions.assertEquals("6",display.getAttribute("value"));
    }

    @Test
    void multiplicacaoTest(){
        WebElement num1  = driver.findElement(By.id("five"));
        num1.click();
        WebElement op = driver.findElement(By.xpath("//*[@id=\"multiply\"]"));
        op.click();
        WebElement num2 = driver.findElement(By.cssSelector("#one"));
        num2.click();
        WebElement buttonEquals = driver.findElement(By.id("equals"));
        buttonEquals.click();
        WebElement display = driver.findElement(By.id("display"));

        Assertions.assertEquals("5",display.getAttribute("value"));
    }

    @Test
    void divisaoInteiraTest(){
        WebElement num1  = driver.findElement(By.id("six"));
        num1.click();
        WebElement op = driver.findElement(By.xpath("//*[@id=\"divide\"]"));
        op.click();
        WebElement num2 = driver.findElement(By.cssSelector("#two"));
        num2.click();
        WebElement buttonEquals = driver.findElement(By.id("equals"));
        buttonEquals.click();
        WebElement display = driver.findElement(By.id("display"));

        Assertions.assertEquals("3",display.getAttribute("value"));
    }

    @Test
    void divisaoResultadoDecimalTest(){
        WebElement num1  = driver.findElement(By.id("nine"));
        num1.click();
        WebElement op = driver.findElement(By.xpath("//*[@id=\"divide\"]"));
        op.click();
        WebElement num2 = driver.findElement(By.cssSelector("#four"));
        num2.click();
        WebElement buttonEquals = driver.findElement(By.id("equals"));
        buttonEquals.click();
        WebElement display = driver.findElement(By.id("display"));

        Assertions.assertEquals("2.25",display.getAttribute("value"));
    }

    @Test
    void divisaoPorZeroTest(){
        WebElement num1  = driver.findElement(By.id("nine"));
        num1.click();
        WebElement op = driver.findElement(By.xpath("//*[@id=\"divide\"]"));
        op.click();
        WebElement num2 = driver.findElement(By.cssSelector("#zero"));
        num2.click();
        WebElement buttonEquals = driver.findElement(By.id("equals"));
        buttonEquals.click();
        WebElement display = driver.findElement(By.id("display"));

        Assertions.assertEquals("Infinity",display.getAttribute("value"));
    }
}
