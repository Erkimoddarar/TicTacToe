package ttt;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.WebDriver;

public class IndexPageBaseTest {

	static WebDriver driver;
    static String baseUrl;
    static String port;

    /*
    @BeforeClass
    public static void before() {
        // Will be run before all tests in class are run
        driver = new FirefoxDriver();
        baseUrl = "http://erkimoddarar-staging.herokuapp.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void after() {
        // Will be run after all tests in class have run
        driver.close();
    }
    */

    @Test
    public void assertTitle() {
        driver = new FirefoxDriver();
        baseUrl = "http://erkimoddarar.herokuapp.com";
        driver.get(baseUrl + "/");
        assertEquals("The title was not Erkimoddarar", "Erkimoddarar", driver.getTitle());
        driver.close();
    }
    
    @Test
    public void assertTitleGame() {
        driver = new FirefoxDriver();
        baseUrl = "http://erkimoddarar.herokuapp.com";
        driver.get(baseUrl + "/");
        driver.findElement(By.id("play")).click();
        assertEquals("The title was not Erkimoddarar - Game", "Erkimoddarar - Game", driver.getTitle());
        driver.close();
    }
    
    @Test
    public void assertPlayersMarks() {
        driver = new FirefoxDriver();
        baseUrl = "http://erkimoddarar.herokuapp.com";
        driver.get(baseUrl + "/");
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.findElement(By.id("play")).click();
        driver.findElement(By.id("0")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("0")), "X"));
        assertEquals("The mark for player1 was not X", "X", driver.findElement(By.id("0")).getText());
        driver.close();
    }

    @Test
    public void assertPlayersMarks2() {
        driver = new FirefoxDriver();
        baseUrl = "http://erkimoddarar.herokuapp.com";
        driver.get(baseUrl + "/");
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.findElement(By.id("play")).click();
        driver.findElement(By.id("2")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("2")), "X"));
        driver.findElement(By.id("4")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("4")), "O"));
        assertEquals("The mark for player1 was not X", "X", driver.findElement(By.id("2")).getText());
        assertEquals("The mark for player2 was not O", "O", driver.findElement(By.id("4")).getText());
        driver.close();
    }

    @Test
    public void assertPlayerWins() {
        driver = new FirefoxDriver();
        baseUrl = "http://erkimoddarar.herokuapp.com";
        driver.get(baseUrl + "/");
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.findElement(By.id("play")).click();

        driver.findElement(By.id("0")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("0")), "X"));
        driver.findElement(By.id("3")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("3")), "O"));
        driver.findElement(By.id("1")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("1")), "X"));
        driver.findElement(By.id("4")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("4")), "O"));
        driver.findElement(By.id("2")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("score")), "Player 1: 1 | Player 2: 0 | Ties: 0"));
        
        assertEquals("Score text for not right", "Player 1: 1 | Player 2: 0 | Ties: 0", driver.findElement(By.id("score")).getText());
        driver.close();
    }

    @Test
    public void assertPlayer1WinsAndThenPlayer2() {
        driver = new FirefoxDriver();
        baseUrl = "http://erkimoddarar.herokuapp.com";
        driver.get(baseUrl + "/");
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.findElement(By.id("play")).click();
        
        driver.findElement(By.id("0")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("0")), "X"));
        driver.findElement(By.id("3")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("3")), "O"));
        driver.findElement(By.id("1")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("1")), "X"));
        driver.findElement(By.id("4")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("4")), "O"));
        driver.findElement(By.id("2")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("score")), "Player 1: 1 | Player 2: 0 | Ties: 0"));
        
        driver.findElement(By.id("0")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("0")), "O"));
        driver.findElement(By.id("3")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("3")), "X"));
        driver.findElement(By.id("1")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("1")), "O"));
        driver.findElement(By.id("4")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("4")), "X"));
        driver.findElement(By.id("2")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("score")), "Player 1: 1 | Player 2: 1 | Ties: 0"));

        assertEquals("Score text for not right", "Player 1: 1 | Player 2: 1 | Ties: 0", driver.findElement(By.id("score")).getText());
        driver.close();
    }

    @Test
    public void assertPlayersPlayAndGameEndWithTie() {
        driver = new FirefoxDriver();
        baseUrl = "http://erkimoddarar.herokuapp.com";
        driver.get(baseUrl + "/");
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.findElement(By.id("play")).click();

        driver.findElement(By.id("0")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("0")), "X"));
        driver.findElement(By.id("1")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("1")), "O"));
        driver.findElement(By.id("3")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("3")), "X"));
        driver.findElement(By.id("6")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("6")), "O"));
        driver.findElement(By.id("7")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("7")), "X"));
        driver.findElement(By.id("4")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("4")), "O"));
        driver.findElement(By.id("2")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("2")), "X"));
        driver.findElement(By.id("5")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("5")), "O"));
        driver.findElement(By.id("8")).click();

        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("score")), "Player 1: 0 | Player 2: 0 | Ties: 1"));
        
        assertEquals("Score text for not right", "Player 1: 0 | Player 2: 0 | Ties: 1", driver.findElement(By.id("score")).getText());
        driver.close();
    }



}
