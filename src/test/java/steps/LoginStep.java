package steps;

import pages.*;

/**
 * @author Alexei Vinogradov.
 */
public class LoginStep {

  public static void login(){
    new UserNavigation().openSignInOptions();
    new SignInAndRegistration().signInWithIMDb();
    new IMDbSignIn().login();
  }
}
