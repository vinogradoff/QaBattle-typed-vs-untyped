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
    open("/");
    new UserNavigation().openSignInOptions();
    new SignInAndRegistration().signInWithIMDb();
    new IMDbSignIn().login();

  }

  @Test
  public void listWorkflow(){
    new UserNavigation().openYourLists();
    sleep(5000);
  }
}
