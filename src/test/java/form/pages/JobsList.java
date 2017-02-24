package form.pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov
 */
public class JobsList {

  ElementsCollection jobsList = $$(".search-result-item");

  public void applyFor(String description, String city) {
    jobsList.filterBy(text(description))
            .find(text(city)).
            $(byLinkText("Apply"))
            .click();
  }
}
