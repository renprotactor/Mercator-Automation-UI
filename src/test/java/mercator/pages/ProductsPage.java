package mercator.pages;

import mercator.driver.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(css = "#shopping_cart_container")
    WebElement cart;

    public void addCostlyItemToCart() {
        boolean addToCart = false;
        String maxPrice = getMaxPrice();
        List<WebElement> items = driver.findElements(By.className("pricebar"));
        for (WebElement item : items) {
            if (item.getText().contains(maxPrice)) {
                item.findElement(By.tagName("button")).click();
                addToCart = true;
            }
        }
        if (!addToCart) {
            Assert.fail("Failed to click on Add to cart button: Add to cart button not found for the maximum price");
        }
    }

    public String getMaxPrice() {
        List<WebElement> itemPrices = driver.findElements(By.className("inventory_item_price"));
        double maxPrice = 0.0;

        for (WebElement item : itemPrices) {
            String priceText = item.getText().replace("$", "");
            double price = Double.parseDouble(priceText);
            if (price > maxPrice) {
                maxPrice = price;
            }
        }

        return String.valueOf(maxPrice);
    }

    public void clickOnCart() {
        assertElement(cart);
        clickElement(cart);
    }
}
