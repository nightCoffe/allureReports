package tests.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import tests.TestBase;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class AnnotationStepGithabEroshenko extends TestBase {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        openUrl();
    }

    @Step("Ищем репозиторий {repository}")
    public void searchRepository(String repository) {
        $("[name=q]").setValue(repository).pressEnter();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(byLinkText(repository)).click();
    }

    @Step("Открываем таб Issues")
    public void openTabIssues() {
        $("[data-content = Issues]").click();
    }

    @Step("Проверяем, что Issues {issueNumber} существует")
    public void assertIssues(int issueNumber) {
        $(withText("#" + issueNumber)).shouldBe(Condition.visible);
    }
}
