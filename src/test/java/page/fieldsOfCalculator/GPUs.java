package page.fieldsOfCalculator;

import model.TestModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

public class GPUs extends AbstractPage {
    private By instanceTypeBy = By.xpath("//md-option/div[contains(text(),'standard-8')]");
    private TestModel testModel;

    @FindBy(xpath = "//div[@class='md-container md-ink-ripple']")
    private WebElement checkBoxAddGPUs;

    @FindBy(xpath = "//label[contains(text(),'Number of GPUs')]//following-sibling::md-select")
    private WebElement numberOfGPUsContainer;

    @FindBy(xpath = "//div[contains(text(),'1') and @class='md-text ng-binding']/parent::md-option[@value='1' and contains(@ng-repeat,'supportedGpuNumbers')]")
    private WebElement numberOfGPUs;

    @FindBy(xpath = "//label[contains(text(),'GPU type')]/following-sibling::md-select")
    private WebElement GPUTypeContainer;

    @FindBy(xpath = "//label[contains(text(),'Local SSD')]/following-sibling::md-select")
    private WebElement localSSDContainer;

    public GPUs(TestModel testModel) {
        super();
        this.testModel = testModel;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckBoxAddGPUs() {
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.invisibilityOfElementLocated(instanceTypeBy));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkBoxAddGPUs);
    }

    public void selectNumberOfGPUs() {
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOf(numberOfGPUsContainer));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", numberOfGPUsContainer);
        WebElement numberOfGPUs = new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOfElementLocated(By.
                        xpath(String.format("//div[contains(text(),'%s') and @class='md-text ng-binding']/parent::md-option[@value='1' and contains(@ng-repeat,'supportedGpuNumbers')]", testModel.getNumberGPU()))));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", numberOfGPUs);
    }

    public void selectGPUType() {
        new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOf(GPUTypeContainer));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", GPUTypeContainer);
        WebElement GPUType = new WebDriverWait(driver, 5).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//div[contains(text(),'%s')]", testModel.getGPUType()))));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", GPUType);
    }
}
