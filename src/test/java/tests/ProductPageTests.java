package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static business.steps.OrdersSteps.navigateToProductViaCategoryMenu;
import static business.steps.OrdersSteps.navigateToProductViaSearch;

@Epic("Use cases for Product page")
@Feature("Open product page and make some actions")
public class ProductPageTests extends BaseTest {

    @BeforeEach
    public void navigateToPage() {
        mainPage.openMainPage();
    }

    @Story("A")
    @Description("test")
    @Test
    public void navigateViaCatalogAndPutProductIntoCart() {
        navigateToProductViaCategoryMenu(driver, "Навушники і акустика", "Акустика", 2);
        productPage.clickBuyButton();
        cartModal.verifyCartModal();
        cartModal.closeCartModal();
        headerMenu.verifyShoppingCartCount("1");
    }

    @Story("B")
    @Description("test")
    @Test
    public void navigateViaSearchAndPutProductIntoCart() {
        navigateToProductViaSearch(driver, "мультиварка", 2);
        productPage.clickBuyButton();
        cartModal.verifyCartModal();
        cartModal.closeCartModal();
        headerMenu.verifyShoppingCartCount("1");
    }

    @Story("C")
    @Description("test")
    @Test
    public void putProductIntoCartAndIncreaseAmount() {
        navigateToProductViaSearch(driver, "електросамокат", 0);
        productPage.clickBuyButton();
        cartModal.verifyCartModal();
        cartModal.increaseProductsAmountByOne(0);
        cartModal.verifyCartModal();
        cartModal.closeCartModal();
        headerMenu.verifyShoppingCartCount("2");
    }

    @Story("D")
    @Description("test")
    @Test
    public void putProductIntoCartAndThanRemove() {
        navigateToProductViaSearch(driver, "Кавомашина", 5);
        productPage.clickBuyButton();
        cartModal.verifyCartModal();
        cartModal.removeItemFromCartByIndex(0);
        cartModal.verifyCartIsEmpty();
    }

    @Story("E")
    @Description("test")
    @Test
    public void putProductIntoCartAndGoToOrderPage() {
        navigateToProductViaSearch(driver, "Планшет", 3);
        productPage.clickBuyButton();
        cartModal.verifyCartModal();
        cartModal.openOrderPage();
    }
}
