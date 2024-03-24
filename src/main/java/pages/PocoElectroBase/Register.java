package pages.PocoElectroBase;

import engine.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register extends Pages{


    private final String url = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    private final By firstName = By.id("input-firstname");
    private final By lastName = By.id("input-lastname");
    private final By emailAddress = By.id("input-email");
    private final By Telephone = By.id("input-telephone");
    private final   By password = By.id("input-password");
    private final By passwordConfirmation = By.id("input-confirm");
    private final  By agree = By.id("input-agree");
    private final By ContinueButton = By.cssSelector("input[value='Continue']");

    public Register(WebDriver driver, ActionsBot bot) {
        super(driver, bot );
    }
    @Step
    public Register goTo() {
        bot.navigate(url);
        return this;
    }

    @Step("Fill the required ")
    public Register register (CharSequence FirstName , CharSequence LastName , CharSequence Email, CharSequence telephone ,CharSequence Password){
        bot.type(firstName , FirstName);
        bot.type(lastName , LastName);
        bot.type(emailAddress ,Email );
        bot.type(Telephone ,telephone );
        bot.type(password ,Password );
        bot.type(passwordConfirmation ,Password );
        bot.click(agree);
        bot.click(ContinueButton);
        return this;
    }


}
