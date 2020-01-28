package page.fieldsOfCalculator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

public class CommittedUsage extends AbstractPage {
    private By datacenterLocationOsakaBy = By.xpath("//*[@id='select_option_185']/child::div[contains(text(),'Osaka')]");

    @FindBy(xpath = "//label[contains(text(),'Committed usage')]/following-sibling::md-select")
    private WebElement committedUsageContainer;

    public CommittedUsage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public CommittedUsage selectCommittedUsage(String value) {
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.invisibilityOfElementLocated(datacenterLocationOsakaBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", committedUsageContainer);
        By committedUsageBy = By.xpath(String.format("//*[@id='select_option_85']/div[contains(text(),'%s')]", value));
        WebElement committedUsage = new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOfElementLocated(committedUsageBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", committedUsage);
        return this;
    }
}
