package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.SubmarinoPage;

import static org.junit.Assert.assertEquals;

public class SubmarinoSteps {
    private SubmarinoPage page;
    private WebDriver driver;

    @Given("O usuário acessa o site do submarino")
    public void accessSubmarinoPage() {
        page = new SubmarinoPage();
        driver = page.initWebDriver();
        driver.get("https://www.submarino.com.br/");
    }

    @When("Pesquisar por um produto")
    public void searchForProduct() {
        page.searchForProduct("Teclado Corsair K95 Platinum");
    }

    @Then("O produto deve aparecer na tela")
    public void isProductDisplayedOnScreen() {
        assertEquals("Teclado Gamer Corsair Ch-9127014-br K95 Platinum Retroiluminacao Rgb Teclas Cherry Mx", page.getProductInList().getText());
    }

    @And("Adicionar o produto no carrinho")
    public void addProductToCart() {
        page.addProductToCart();
    }

    @Then("O produto deve ser adicionado no carrinho")
    public void productWasAddedToCart() {
        assertEquals("Teclado Gamer Corsair Ch-9127014-br K95 Platinum Retroiluminacao Rgb Teclas Cherry Mx", page.getProductInCart().getText());
        driver.close();
    }
}
