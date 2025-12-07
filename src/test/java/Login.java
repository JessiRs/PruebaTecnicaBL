import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.cdimascio.dotenv.Dotenv;



public class Login {
    Dotenv dotenv = Dotenv.configure().load();
    String user = dotenv.get("USER_TEST");
    String pass = dotenv.get("PASS_TEST");

    @Test
    public void LoginTrue() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://quotes.toscrape.com");
        System.out.println("Usuario: " + user);
        System.out.println("Password: " + pass);
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[value=Login]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[href='/logout']")).click();
        Thread.sleep(4000);
        driver.quit();

    }
}

