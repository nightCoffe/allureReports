package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class StepLambdaGithabEroshenkoTest extends TestBase {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;

    @Test
    void GithabEroshenkoIssue() {
        step("Открываем главную страницу", () -> {
            openUrl();
        });
        step("Ищем репозиторий", () -> {
            $("[name=q]").setValue(REPOSITORY).pressEnter();
        });
        step("Переходим в репозиторий", () -> {
            $(byLinkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues", () -> {
            $("[data-content = Issues]").click();
        });
        step("Проверяем, что Issues " + ISSUE_NUMBER + " существует", () -> {
            $(withText("#" + ISSUE_NUMBER)).shouldBe(Condition.visible);
        });
    }
}
