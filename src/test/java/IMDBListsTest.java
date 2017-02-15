import org.junit.*;
import pages.*;
import steps.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov
 */
public class IMDBListsTest {

  @BeforeClass
  public static void setup() {
    open("/");
    LoginStep.login();
  }

  @Test
  public void listWorkflow() {
    new UserNavigation().openYourLists();
    Lists lists = new Lists();
    lists.titlesCountTextForList("My best TV shows").shouldHave(text("0 Titles"));
    lists.editList("My best TV shows");
    ListEditor listEditor = new ListEditor();
    listEditor.addToList("The Walking Dead");
    listEditor.addToList("Narcos");
    listEditor.addToList("The Big Bang Theory");
    listEditor.namesInTheList.shouldHaveSize(3);
    listEditor.namesInTheList.shouldHave(exactTexts(
            "The Walking Dead (2010 TV Series)",
            "Narcos (2015 TV Series)",
            "The Big Bang Theory (2007 TV Series)"));
    listEditor.save();
    new ListViewer().showCompactView();
    CompactView view = new CompactView();
    view.titles.shouldHaveSize(3);
    view.titles.shouldHave(exactTexts(
            "The Walking Dead",
            "Narcos",
            "The Big Bang Theory"));
    view.sortByRatings();
    view.ratingHeader.shouldHave(cssClass("active_desc"));
    view.titles.shouldHave(exactTexts(
            "The Walking Dead",
            "The Big Bang Theory",
            "Narcos"));
    sleep(5000);
  }
}
