package pages.lists;

import com.codeborne.selenide.*;
import domain.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov.
 */
public class CompactView {

  SelenideElement container = $(".list.compact");

  public SelenideElement ratingHeader = container.$("[data-field=num_votes]"),
          selectAllChkbox = container.$("[data-field=check]");

  public ElementsCollection titles = container.$$("td.title");

  public CompactView() {
    container.shouldBe(visible);
  }

  public void sortByRatings() {
    ratingHeader.click();
  }

  public void removeAllFromList() {
    selectAllChkbox.click();
    new ListViewer().removeSelected();
  }

  public Film getFilmInfoByTitle(String title) {
    Film film = new Film();
    SelenideElement filmRow = titles.findBy(text(title)).parent();
    filmRow.shouldBe(visible);
    film.title = filmRow.find(".title").getText();
    film.year = filmRow.find(".year").getText();
    film.type = filmRow.find(".title_type").getText();
    return film;
  }

}
