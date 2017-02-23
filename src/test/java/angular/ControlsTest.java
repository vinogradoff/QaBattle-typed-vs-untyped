package angular;

import com.codeborne.selenide.*;
import org.junit.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov
 */
public class ControlsTest {

  @BeforeClass
  public static void openSite() {
    open("http://localhost:8080/demo/input");
  }

  @Test
  public void checkboxTest() {
    SelenideElement acceptTerms = $("md-checkbox");
    acceptTerms.click();
    acceptTerms.shouldHave(attribute("aria-checked", "true"));
  }

  @Test
  public void switchTest() {
    SelenideElement enableSpecialOptions = $("md-switch");
    enableSpecialOptions.click();
    enableSpecialOptions.shouldHave(attribute("aria-checked", "true"));
  }
}
