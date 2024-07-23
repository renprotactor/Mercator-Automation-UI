package mercator.steps;

import mercator.driver.BasePage;
import mercator.pages.LoginPage;
import mercator.pages.ProductsPage;
import mercator.pages.CartPage;
import io.cucumber.java8.En;
import org.junit.Assert;

public class AutomationTestSteps implements En {

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();

    String maxPrice = "";


    public AutomationTestSteps() {


        Given("I open the Sauce Demo site", () -> {
            loginPage.openUrl(BasePage.getProperty("baseUrl"));

        });

        And("I log in with valid credentials", () -> {
            loginPage.login();
        });

        Then("I should see the page title {string}", (String title) -> {
            Assert.assertEquals("The expected page title 'Products' does not match the actual title", title, productsPage.getPageTitle());
        });

        Then("I add the most expensive dress to the cart", () -> {
            maxPrice = productsPage.getMaxPrice();
            System.out.println("The maximum item price found is" + maxPrice);
            productsPage.addCostlyItemToCart();
        });

        And("I click on the cart icon on the products page", () -> {
            productsPage.clickOnCart();
        });

        Then("validate that cart should contain the most expensive dress with the correct price", () -> {
            Assert.assertEquals("Fail: The item added to the cart does not match the expected item price", maxPrice, cartPage.getTheItemPrice());
        });

    }

}
