package pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov.
 */
public class ListViewer {

  public ListViewer(){
    container.shouldBe(visible);
  }
  SelenideElement container=$(".list_titles"),
      compactViewBtn=container.$(".views .compact");

  public void showCompactView(){
    compactViewBtn.click();
  }
}
