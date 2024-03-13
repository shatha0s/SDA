package tests.junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Assignment5 {
    @Test
    public void cookie(){

    WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/login/?next=https%3A%2F%2Fwww.facebook.com%2F");

    // Get all the cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("All Cookies:");
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " : " + cookie.getValue());
    }
    // Add a new cookie
    Cookie newCookie = new Cookie("exampleCookie", "exampleValue");
        driver.manage().addCookie(newCookie);

    // Delete a specific cookie by name
        driver.manage().deleteCookieNamed("exampleCookie");
    // Delete all cookies
        driver.manage().deleteAllCookies();

        driver.quit();
}
}

