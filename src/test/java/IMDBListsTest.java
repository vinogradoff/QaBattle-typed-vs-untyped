import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.IMDbSignIn;
import pages.Lists;
import pages.SignInAndRegistration;
import pages.UserNavigation;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;

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
    sleep(5000);
  }
}
