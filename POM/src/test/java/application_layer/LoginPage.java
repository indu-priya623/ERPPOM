package application_layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage
{
@FindBy(xpath = "//button[@id='btnreset']")
WebElement reset;
@FindBy(xpath = "//input[@id='username']")
WebElement user;
@FindBy(xpath = "//input[@id='password']")
WebElement pass;
@FindBy(xpath ="//button[@id='btnsubmit']")
WebElement login;

public void login(String username,String password)
{
	reset.click();
	user.sendKeys(username);
	pass.sendKeys(password);
	login.click();
}

}

