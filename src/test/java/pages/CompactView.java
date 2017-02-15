package pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov.
 */
public class CompactView {

  SelenideElement container=$(".list.compact");

  public SelenideElement ratingHeader=container.$("[data-field=num_votes]");

  public ElementsCollection titles=container.$$("td.title");

  public CompactView(){
    container.shouldBe(visible);
  }

  public void sortByRatings(){
    ratingHeader.click();
  }

}
