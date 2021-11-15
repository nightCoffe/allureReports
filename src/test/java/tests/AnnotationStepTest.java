package tests;

import org.junit.jupiter.api.Test;
import tests.steps.AnnotationStepGithabEroshenko;

public class AnnotationStepTest {

    private static final String repository = "eroshenkoam/allure-example";
    private static final Integer issueNumber = 68;

    private AnnotationStepGithabEroshenko steps = new AnnotationStepGithabEroshenko();

    @Test
    public void testGitHubIssue() {
        steps.openUrl();
        steps.openMainPage();
        steps.searchRepository(repository);
        steps.goToRepository(repository);
        steps.openTabIssues();
        steps.assertIssues(issueNumber);
    }
}
