package delfiPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DelfiArticlePage {
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By DELFI_ARTICLE_COMMENTS_PAGE = By.xpath(".//i[contains(@class,'icon-ui-comments')]");
    private final By DELFI_ARTICLE_PAGE_COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'd-print-none')]");
    private DelfiFunctions delfiFunctions;

//Constructor
    public DelfiArticlePage(DelfiFunctions delfiFunctions) {
        this.delfiFunctions = delfiFunctions;
    }

//Return title from the 2nd Delfi Article page
     public String getArticlePageTitle(){
        return delfiFunctions.findElement(ARTICLE_PAGE_TITLE).getText();
     }

    //Count comments for the Article on Article Page
    public String getCountOfCommentsArticlePage(int id) {
        List<WebElement> commentsArticle = delfiFunctions.findElements(DELFI_ARTICLE_PAGE_COMMENTS_COUNT);
        return commentsArticle.get(id - 1).getText();
    }

//Click on the Comments
    public void goToCommentsPage(int id) {
        List<WebElement> comments = delfiFunctions.findElements(DELFI_ARTICLE_COMMENTS_PAGE);
        delfiFunctions.click(comments.get(id - 1));
}
}
