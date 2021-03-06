package imdb.pages.lists;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov.
 */
public class ListEditor {


  SelenideElement editorContainer = $("div.list_edit"),
          addField = editorContainer.$("div.add input"),
          searchBtn = editorContainer.$(".search"),
          doneBtn = editorContainer.$(".save");

  ElementsCollection results = $$("div.results li");

  public ElementsCollection namesInTheList = $$("ul.list div.info");

  public ListEditor() {
    editorContainer.shouldBe(visible);
  }

  public void addToList(String movieOrTvShow) {
    addField.setValue(movieOrTvShow);
    searchBtn.click();
    results.find(text(movieOrTvShow)).click();
  }

  public void save() {
    doneBtn.click();
  }

  public void deleteByTitle(String title) {
    SelenideElement filmLine = namesInTheList.findBy(text(title)).closest("li");
    filmLine.$(".delete").click();
  }
}
