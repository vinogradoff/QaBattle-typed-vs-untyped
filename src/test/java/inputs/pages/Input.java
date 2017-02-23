package inputs.pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov.
 */
public class Input {
  public static SelenideElement input = $("#input"),
          textarea = $("#textarea");
}
