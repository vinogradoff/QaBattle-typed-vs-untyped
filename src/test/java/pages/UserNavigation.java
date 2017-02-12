package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by vinogradov on 12.02.17.
 */
public class UserNavigation {

  public UserNavigation() {
    navigationContainer.shouldBe(visible);
  }

  SelenideElement linkToSignIn = $(byLinkText("Other Sign in options")),
          navigationContainer = $("#consumer_user_nav"),
          userLink=navigationContainer.$("#navUserMenu"),
          yourListsLink=navigationContainer.$(".sub_nav").$(byLinkText("Your Lists"));

  public void openSignInOptions() {
    linkToSignIn.click();
  }

  public void openYourLists() {
    userLink.hover();
    yourListsLink.click();
  }
}
