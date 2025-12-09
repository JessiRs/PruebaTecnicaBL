import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Login {
    Dotenv dotenv = Dotenv.configure().load();
    String user = dotenv.get("USER_TEST");
    String pass = dotenv.get("PASS_TEST");

    @Test
    public void LoginSuccesful() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://quotes.toscrape.com");
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.cssSelector("input[value=Login]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/']")));
        System.out.println("Login succesful");
        driver.quit();
    }
}

