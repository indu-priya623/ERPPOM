package application_layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage 
{
@FindBy(xpath = "(//a[contains(@href,'logout.php')])[2]")
WebElement logout;
public void logout()
{
	logout.click();
}
}
