import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.IMDbSignIn;
import pages.SignInAndRegistration;
import pages.UserNavigation;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by vinogradov on 12.02.17.
 */
public class IMDBListsTest {

  @BeforeClass
  public static void setup(){
    Configuration.pageLoadStrategy="eager";
    Configuration.fastSetValue=true;
    open("http://imdb.com");
    new UserNavigation().openSignInOptions();
    new SignInAndRegistration().signInWithIMDb();
    new IMDbSignIn().login("alexei@vinogradoff.de","QABattle2017");

  }

  @Test
  public void test(){
    assertTrue(true);
  }
}
