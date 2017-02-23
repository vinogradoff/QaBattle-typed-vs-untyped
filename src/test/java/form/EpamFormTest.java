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
    $(byLinkText("Senior QA Automation Engineer")).closest("li").$(byLinkText("Apply")).click();
    //open("https://www.epam.com/careers/job-listings/job.10190#apply");
  }

  @Test
  public void fillEpamForm() {
    Application application = new Application();
    application.firstname = "Alexei";
    application.lastname = "Vinogradov";
    application.email = "qa@vinogradov-it.de";
    application.country = "Germany";
    application.city = "Dusseldorf";
    application.message = "Hire me, I am the best!";

    ApplicationForm form = new ApplicationForm();
    form.fillInForm(application);
    form.firstname.shouldHave(value(application.firstname));
    form.lastname.shouldHave(value("Vinogradov"));
    form.email.shouldHave(value(application.email));
    form.country.shouldHave(text(application.country));
    form.city.shouldHave(text(application.city));
    form.message.shouldHave(value(application.message));


  }
}
