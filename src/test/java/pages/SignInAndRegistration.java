package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by vinogradov on 12.02.17.
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