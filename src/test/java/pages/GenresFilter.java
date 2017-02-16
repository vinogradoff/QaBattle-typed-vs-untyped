package pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov.
 */
public class GenresFilter {


  SelenideElement container = $(".genres");

  public ElementsCollection genres = container.$$("li");

  public GenresFilter() {
    container.shouldBe(visible);
  }

  public void selectGenre(String genre) {
    genres.findBy(text(genre)).$("input").click();
  }
}