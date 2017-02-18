package imdb.pages.login;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov
 */
public class SignInAndRegistration {

  SelenideElement signInWithImdbLink = $(byLinkText("Sign in with IMDb")),
          title = $("#signin-options h1");

  public SignInAndRegistration() {
    title.shouldHave(text("Sign in"));
  }

  public void signInWithIMDb() {
    signInWithImdbLink.click();
  }
}
