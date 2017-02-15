import com.codeborne.selenide.CollectionCondition;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.*;

import java.util.List;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov
 */
public class IMDBListsTest {

  @BeforeClass
  public static void setup(){
    open("/");
    new UserNavigation().openSignInOptions();
    new SignInAndRegistration().signInWithIMDb();
    new IMDbSignIn().login();

  }

  @Test
  public void listWorkflow(){
    new UserNavigation().openYourLists();
    Lists lists=new Lists();
    lists.titlesCountTextForList("My best TV shows").shouldHave(text("0 Titles"));
    lists.editList("My best TV shows");
    ListEditor listEditor=new ListEditor();
    listEditor.addToList("The Walking Dead");
    listEditor.addToList("Narcos");
    listEditor.addToList("The Big Bang Theory");
    listEditor.namesInTheList.shouldHaveSize(3);
    listEditor.namesInTheList.shouldHave(CollectionCondition.exactTexts(
            "The Walking Dead (2010 TV Series)",
            "Narcos (2015 TV Series)",
            "The Big Bang Theory (2007 TV Series)"));
    listEditor.save();
    sleep(5000);
  }
}
