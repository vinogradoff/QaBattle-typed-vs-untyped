package imdb.pages.lists;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov.
 */
public class Lists {

  public Lists() {
    listsWidget.shouldBe(visible);
  }

  SelenideElement listsWidget = $(".lists");

  ElementsCollection lists = listsWidget.$$("tr");

  public SelenideElement titlesCountTextForList(String name) {
    return lists.find(text(name)).$("td.name span");
  }

  public void editList(String name) {
    lists.find(text(name)).$("td .edit").click();
  }


}
