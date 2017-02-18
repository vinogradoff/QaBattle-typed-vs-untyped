package imdb;

import imdb.domain.*;
import imdb.pages.common.*;
import imdb.pages.lists.*;
import imdb.steps.*;
import org.junit.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

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
    ListViewer listViewer = new ListViewer();
    listViewer.showCompactView();
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
    Film filmNarcos = view.getFilmInfoByTitle("Narcos");
    assertThat(filmNarcos.title, is("Narcos"));
    assertThat(filmNarcos.year, is("2015"));
    assertThat(filmNarcos.type, is("TV Series"));
    GenresFilter genresFilter = new GenresFilter();
    genresFilter.genres.shouldHave(texts("Biography (1)", "Comedy (1)", "Crime (1)",
            "Drama (2)", "Horror (1)", "Romance (1)", "Thriller (1)"));
    genresFilter.selectGenre("Drama");
    view.titles.shouldHaveSize(2);
    view.titles.shouldHave(exactTexts(
            "The Walking Dead",
            "Narcos"));
    listViewer.editList();
    listEditor = new ListEditor();
    listEditor.namesInTheList.shouldHaveSize(3);
    listEditor.deleteByTitle("The Big Bang Theory");
    listEditor.namesInTheList.shouldHaveSize(2);
    listEditor.save();
    new ListViewer().showCompactView();
    /*genresFilter.clearAll();
    view.titles.shouldHaveSize(3);*/
  }

  @AfterClass
  public static void deleteTitles() {
    CompactView view = new CompactView();
    view.removeAllFromList();
    view.titles.shouldHaveSize(0);
  }
}
