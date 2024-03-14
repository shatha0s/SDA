package tests.junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import java.util.Set;

/*   Go to URL: http://facebook.com
     getCookies,
     addCookie,
     deleteCookieNamed,
     deleteAllCookies
*/
public class Assignment5 extends TestBase {
    @Test
    public void cookie(){
        driver.get("http://facebook.com");

    // Get all the cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        cookies.forEach(System.out::println);

    // Add a new cookie
      Cookie newCookie = new Cookie("Shatha", "Aziz");
        driver.manage().addCookie(newCookie);

        driver.manage().deleteCookieNamed("sugar"); // Delete a specific cookie by name
        driver.manage().deleteAllCookies(); // Delete all cookies

        driver.quit();
}
}

