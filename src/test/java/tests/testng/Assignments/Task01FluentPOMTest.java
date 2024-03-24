package tests.testng.Assignments;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.PocoElectroBase.Register;
import tests.testng.Tests;

 /*        go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
            register account test with fluent page object approach
         */

public class Task01FluentPOMTest extends Tests {
    private final String emailAddress = "shatha"+System.currentTimeMillis()+"@out.sa";
    private final String password = "ccc"+System.currentTimeMillis();
    private final String firstName = "shatha";
    private final String lastName = "Aziz";
    private final String Telephone = "0592345678";

    @Test
    public void register(){
        Register register = new Register(driver,bot).goTo()
                .register(firstName,lastName,emailAddress,Telephone,password );
    }
}
