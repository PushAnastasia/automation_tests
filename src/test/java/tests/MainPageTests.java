package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static business.steps.OrdersSteps.navigateToProductViaSearch;

@Epic("Use cases for Main page")
@Feature("Open Main page and make some actions")
public class MainPageTests extends BaseTest {

    @BeforeEach
    public void navigateToPage() {
        mainPage.openMainPage();
    }

    @Story("1")
    @Description("test")
    @Test
    public void submitSearchQuery() {
        headerMenu.submitSearchQuery("earphones");
        Assertions.assertTrue(searchResultsPage.isBreadcrumbContainValue("earphones"));
    }

//    @Story("2")
//    @Description("test")
//    @Test
//    public void openGeolocationMenuAndVerifyElements() {
//        mainPage.waitAllElementsLoad();
//        headerMenu.verifyGeolocationMenuItems();
//    }

    @Story("3")
    @Description("test")
    @Test
    public void emailFieldValidationForInvalidInput() {
        mainPage.waitAllElementsLoad();
        mainPage.submitEmailFieldValue("test");
        mainPage.verifyEmailFieldValidationMessage("Будь ласка, вкажіть коректну адресу електронної пошти");
    }

    @Story("4")
    @Description("test")
    @Test
    public void emailFieldValidationForEmptyInput() {
        mainPage.waitAllElementsLoad();
        mainPage.submitEmailFieldValue("");
        mainPage.verifyEmailFieldValidationMessage("Це поле є обов'язковим для заповнення.");
    }

//    @Story("5")
//    @Description("test")
//    @Test
//    public void navigateToCatalogPageViaCategoryLink() {
//        String query = "Ноутбуки";
//        mainPage.selectSideBarMenuCategory(query);
//        mainPage.selectSubCategory(query);
//        cataloguePage.verifyCatalogueTitle(query);
//    }

//    @Story("6")
//    @Description("test")
//    @Test
//    public void verifyChangingGeolocation() {
//        mainPage.waitAllElementsLoad();
//        headerMenu.changeGeolocation("Лозова");
//    }

    @Story("7")
    @Description("test")
    @Test
    public void cartModalContainsItemAfterClickBuyButton() {
        mainPage.clickBuyButtonByIndex(0);
        cartModal.verifyCartModal();
    }

    @Story("8")
    @Description("test")
    @Test
    public void navigateToProductPageViaSearch() {
        navigateToProductViaSearch(driver, "smart TV", 0);
        productPage.verifyPageHeader("TV");
    }

//    @Story("9")
//    @Description("test")
//    @Test
//    public void putProductIntoCartVerifyCartCount() {
//        String query = "Навушники";
//        mainPage.selectSideBarMenuCategory(query);
//        mainPage.selectSubCategory(query);
//        mainPage.clickBuyButtonByIndex(1);
//        cartModal.verifyCartModal();
//        cartModal.closeCartModal();
//        headerMenu.verifyShoppingCartCount("1");
//    }
}
