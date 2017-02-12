package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by vinogradov on 12.02.17.
 */
public class IMDbSignIn {
  SelenideElement title = $("div.a-section h1"),
          emailField = $("#ap_email"),
          passwordField = $("#ap_password"),
          signInBtn = $("#signInSubmit");

  public IMDbSignIn() {
    title.shouldHave(text("Sign in"));
  }

  public void login(String user, String password) {
    emailField.setValue(user);
    passwordField.setValue(password);
    signInBtn.click();
  }
}