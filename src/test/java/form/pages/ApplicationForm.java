package form.pages;

import com.codeborne.selenide.*;
import form.domain.*;

import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov
 */
public class ApplicationForm {

  public SelenideElement name = $(""),
          lastname = $(""),
          email = $(""),
          land = $(""),
          city = $(""),
          message = $("");

  public void fillInForm(Application application) {
    name.setValue(application.name);
    lastname.setValue(application.lastname);
    email.setValue(application.email);
    land.click();
    land.selectOption(application.land);
    city.click();
    city.selectOption(application.city);
    message.setValue(application.message);
  }


}
