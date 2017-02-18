package imdb.pages.lists;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov.
 */
public class ListViewer {

  public ListViewer() {
    container.shouldBe(visible);
  }

  SelenideElement container = $(".list_titles"),
          compactViewBtn = container.$(".views .compact"),
          removeBtn = container.$(".bulk .delete"),
          editListBtn = container.$(byLinkText("Edit list"));

  public void showCompactView() {
    compactViewBtn.click();
  }

  public void editList() {
    editListBtn.click();
  }

  public void removeSelected() {
    removeBtn.click();
  }
}
