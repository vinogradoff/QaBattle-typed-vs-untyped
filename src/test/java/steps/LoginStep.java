package steps;

import pages.common.*;
import pages.login.*;

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
