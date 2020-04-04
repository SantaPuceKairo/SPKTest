package delfiPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DelfiHomePage {
    private final By DELFI_SECOND_TITLE = By.xpath(".//main//article//h1[contains(@class, 'text-size-19')]");
    private final By COMMENTS = By.xpath(".//main//article//span//a[contains(@class,'comment-count')]");
    private DelfiFunctions delfiFunctions;

    //constructor
    public DelfiHomePage(DelfiFunctions delfiFunctions) {
        this.delfiFunctions = delfiFunctions;
    }

    //Find the second article title in Delfi
    public String getDelfiSecondTitleById(int id) {
        List<WebElement> titles = delfiFunctions.findElements(DELFI_SECOND_TITLE);
        return titles.get(id - 2).getText();
    }
     //Count comments for the Article on Homepage
      public String getCountOfCommentsHomepage(int id) {
        List<WebElement> comments = delfiFunctions.findElements(COMMENTS);
          return comments.get(id - 2).getText();
      }
    //click on the Article
    public void goToArticleById (int id){
        List<WebElement> titles = delfiFunctions.findElements(DELFI_SECOND_TITLE);
        delfiFunctions.click(titles.get(id - 2));
    }
}
