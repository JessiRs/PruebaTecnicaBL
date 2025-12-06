import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public String NameUser = "admin";
    public String Paassword="admin";


    @Test
    public void Login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://quotes.toscrape.com");
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        driver.findElement(By.id("username")).sendKeys(NameUser);
        driver.findElement(By.id("password")).sendKeys(Paassword);
        driver.findElement(By.cssSelector("input[value=Login]")).click();
        driver.quit();

    }
}
