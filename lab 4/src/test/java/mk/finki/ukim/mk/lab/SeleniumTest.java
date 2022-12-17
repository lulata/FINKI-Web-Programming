package mk.finki.ukim.mk.lab;

import mk.finki.ukim.mk.lab.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("h2")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumTest {

    private WebDriver driver;

    @BeforeEach
    private void setup() {
        this.driver = new HtmlUnitDriver(true);
    }

    @AfterEach
    public void destroy() {
        if (this.driver != null) {
            this.driver.close();
        }
    }

    @Test
    public void testScenario() {

        this.driver = new HtmlUnitDriver(true);
        BalloonsPage balloonsPage = BalloonsPage.to(this.driver);
        balloonsPage.assertElements(0, 0, 0);

        LoginPage loginPage = LoginPage.openLogin(this.driver);
        balloonsPage = LoginPage.doLogin(this.driver, loginPage, "admin", "admin");
        balloonsPage.assertElements(6, 6, 1);
    }


}
