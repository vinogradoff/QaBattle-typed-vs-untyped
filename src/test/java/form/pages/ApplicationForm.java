package form.pages;

import com.codeborne.selenide.*;
import form.domain.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov
 */
public class ApplicationForm {

  public SelenideElement firstname = $("[name=applicantFirstName]"),
          lastname = $("[name=applicantLastName]"),
          email = $("[name=applicantEmail]"),
          country = $(".country-wrapper [id$='-container']"),
          city = $(".city-wrapper [id$='-container']"),
          message = $("[name=applicantMessage]");

  SelenideElement countryOptions = $("[id$='-results']"),
          cityOptions = $("[id$='-results']");

  public void fillInForm(Application application) {
    firstname.setValue(application.firstname);
    lastname.setValue(application.lastname);
    email.setValue(application.email);
    country.click();
    countryOptions.$(byText(application.country)).click();
    city.click();
    cityOptions.$(byText(application.city)).click();
    message.setValue(application.message);
  }


}
