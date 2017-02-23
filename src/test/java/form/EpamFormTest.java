package form;

import form.domain.*;
import form.pages.*;
import org.junit.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Alexei Vinogradov
 */
public class EpamFormTest {

  @BeforeClass
  public static void prepare() {
    open("https://www.epam.com/careers/job-listings?query=qa&department%5B%5D=all&city=St-Petersburg&country=Russia");
    $(byText("Senior QA Automation Engineer")).click();
  }

  @Test
  public void fillEpamForm() {
    Application application = new Application();
    application.name = "Alexei";
    application.lastname = "Vinogradov";
    application.email = "qa@vinogradov-it.de";
    application.land = "Germany";
    application.city = "Dormagen";
    application.message = "Hire me, I am the best!";

    ApplicationForm form = new ApplicationForm();
    form.fillInForm(application);
    form.name.shouldHave(value(application.name));
    form.lastname.shouldHave(value("Vinogradov"));
    form.email.shouldHave(value(application.email));
    form.land.shouldHave(value(application.land));
    form.city.shouldHave(value(application.city));
    form.message.shouldHave(value(application.message));


  }
}
