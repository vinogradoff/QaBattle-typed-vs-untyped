package htmls;

import org.junit.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static htmls.pages.Input.*;

/**
 * @author Alexei Vinogradov.
 */
public class InputFieldTest {
  @Test
  public void inputTest() {
    open("file:///Users/vinogradov/Dropbox/Vorträge/Selenide101/inputField.html");
    input.setValue("abc");
    input.shouldHave(value("abc"));
    textarea.setValue("xyz");
    textarea.shouldHave(value("xyz"));
  }

  @Test
  public void divTest() {
    open("file:///Users/vinogradov/Dropbox/Vorträge/Selenide101/divInputField.html");
    input.setValue("abc");
    input.shouldHave(text("abc"));
    textarea.setValue("xyz");
    textarea.shouldHave(text("xyz"));
  }
}
