package delfiPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DelfiCommentsPage {
     private final By DELFI_COMMENTS_PAGE_TITLE = By.xpath(".//div[contains(@id,'comments-listing')]//h1");
     private final By COMMENT_PAGE_REG_COMMENTS = By.xpath(".//li[contains(@class, 'show-reg')]//span[contains(@class,'type-cnt')]");
     private final By COMMENT_PAGE_ANO_COMMENTS = By.xpath(".//li[contains(@class, 'show-anon')]//span[contains(@class,'type-cnt')]");
     private DelfiFunctions delfiFunctions;

//Constructor
     public DelfiCommentsPage(DelfiFunctions delfiFunctions) {
          this.delfiFunctions = delfiFunctions;
     }

//Return Title of the Article Comments Page
     public String getCommentsPageTitle(){
        return delfiFunctions.findElement(DELFI_COMMENTS_PAGE_TITLE).getText();
     }

     //Count comments for the Article on Comments Page

     public String getCountOfCommentsCommentsPageAnonim(int id) {
          List<WebElement> commentsCommentsPageAno = delfiFunctions.findElements(COMMENT_PAGE_ANO_COMMENTS);
          return commentsCommentsPageAno.get(id - 1).getText();
     }
     public String getCountOfCommentsCommentsPageRegister(int id) {
               List<WebElement> commentsCommentsPageReg = delfiFunctions.findElements(COMMENT_PAGE_REG_COMMENTS);
           return commentsCommentsPageReg.get(id - 1).getText();
     }

}
