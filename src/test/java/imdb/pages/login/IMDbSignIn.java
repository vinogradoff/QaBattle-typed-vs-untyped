package imdb.pages.login;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov
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

  public void login() {
    login(System.getProperty("imdb.user"), System.getProperty("imdb.password"));
  }

}
