package imdb.steps;

import imdb.pages.common.*;
import imdb.pages.login.*;

/**
 * @author Alexei Vinogradov.
 */
public class LoginStep {

  public static void login() {
    new UserNavigation().openSignInOptions();
    new SignInAndRegistration().signInWithIMDb();
    new IMDbSignIn().login();
  }
}
