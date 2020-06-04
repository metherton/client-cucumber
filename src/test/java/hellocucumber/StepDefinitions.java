package hellocucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import io.github.sukgu.*;

public class StepDefinitions {

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/User/martin/software/bin/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver","/User/martin/software/bin/chromedriver.exe");
    }

    private final WebDriver driver = new ChromeDriver();

    @Given("I am on the Google search page")
    public void I_visit_google() {
        driver.get("https:\\www.google.com");
    }

    @When("I search for {string}")
    public void search_for(String query) {
        WebElement element = driver.findElement(By.name("q"));
        // Enter something to search for
        element.sendKeys(query);
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
    }

    @Then("the page title should start with {string}")
    public void checkTitle(String titleStartsWith) {
        // Google's search is rendered dynamically with JavaScript
        // Wait for the page to load timeout after ten seconds
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(titleStartsWith);
            }
        });
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

    @Given("I am on the ONS home page")
    public void i_am_on_the_ONS_home_page() {
        driver.get("http:\\localhost:8000");
    }

    @Then("A photo of tulips is shown")
    public void a_photo_of_tulips_is_shown() {
        // Write code here that turns the phrase above into concrete actions
        // ONS home page is rendered dynamically with JavaScript
        // Wait for the page to load timeout after ten seconds
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                Shadow shadow = new Shadow(d);
                WebElement element = shadow.findElement("#tulips");
                return element.isDisplayed();
            }
        });
    }

    @Then("A link to Search Etherton family trees is shown")
    public void a_link_to_Search_Etherton_family_trees_is_shown() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                Shadow shadow = new Shadow(d);
                WebElement element = shadow.findElement("#search-family-trees");
                return element.isDisplayed();
            }
        });
    }


}
