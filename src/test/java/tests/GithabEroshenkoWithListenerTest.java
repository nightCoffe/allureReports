package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class GithabEroshenkoWithListenerTest extends TestBase {

    @Test
    void GithabEroshenkoIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        openUrl();
        $("[name=q]").setValue("eroshenkoam/allure-example").pressEnter();
        $(byLinkText("eroshenkoam/allure-example")).click();
        $("[data-content = Issues]").click();
        $(withText("#68")).shouldBe(Condition.visible);
    }
}
