package delfiPageObject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DelfiTitleTests {
    private DelfiFunctions delfiFunctions = new DelfiFunctions();

    @Test

    public void delfiSecondTitleCheck() {

//Open Delfi Homepage
        delfiFunctions.openDelfiHomePage();

//Open the 2nd title from Delfi Homepage
        DelfiHomePage delfiHomePage = new DelfiHomePage(delfiFunctions);
        String delfiHomePageTitle = delfiHomePage.getDelfiSecondTitleById(3);
        delfiHomePageTitle = delfiHomePageTitle.substring(0, delfiHomePageTitle.length() - 1);
        System.out.println("The 2nd Article title on the HOMEPAGE is: " + delfiHomePageTitle);

        //Count comments for the 2nd Article on the Homepage
        DelfiHomePage delfiHomePageComments = new DelfiHomePage(delfiFunctions);
        String comments = delfiHomePageComments.getCountOfCommentsHomepage(3);
        int countHomepage = Integer.parseInt(comments.substring(1, comments.length() - 1));
        System.out.println("COUNT of comments on the HOMEPAGE is: " + countHomepage);

        //Move to the next page (Article Page)
        delfiHomePage.goToArticleById(3);

        //Open Article Page
        DelfiArticlePage delfiArticlePage = new DelfiArticlePage(delfiFunctions);
        String delfiArticlePageTitle = delfiArticlePage.getArticlePageTitle();
        delfiArticlePageTitle = delfiArticlePageTitle.substring(0, delfiArticlePageTitle.length() - 1);
        System.out.println("Title on the Article Page is: " + delfiArticlePageTitle);

        //Count comments for the Article on the Article Page
        DelfiArticlePage delfiArticlePageComments = new DelfiArticlePage(delfiFunctions);
        String articlePageComments = delfiArticlePageComments.getCountOfCommentsArticlePage(1);
        int countCommentsArticlePage = Integer.parseInt(comments.substring(1, articlePageComments.length() - 1));
        System.out.println("COUNT of comments on the ARTICLE_PAGE is: " + countCommentsArticlePage);

        //Move to the Comments Page
        delfiArticlePage.goToCommentsPage(1);


        //Open Comments Page
        DelfiCommentsPage delfiCommentsPage = new DelfiCommentsPage(delfiFunctions);
        String delfiCommentsPageTitle = delfiCommentsPage.getCommentsPageTitle();
        //  delfiCommentsPageTitle = delfiCommentsPageTitle.substring(0, delfiCommentsPageTitle.length() - 1);
        System.out.println("Title on the Comments Page is: " + delfiCommentsPageTitle);

        //Count comments on the Comments Page
        DelfiCommentsPage delfiCommentsPageCommentsAnonim = new DelfiCommentsPage(delfiFunctions);
        String commentsPageCommentsAnonim = delfiCommentsPageCommentsAnonim.getCountOfCommentsCommentsPageAnonim(1);
        int countCommentsPageAnonim = Integer.parseInt(commentsPageCommentsAnonim.substring(1, commentsPageCommentsAnonim.length() - 1));

        DelfiCommentsPage delfiCommentsPageCommentsReg = new DelfiCommentsPage(delfiFunctions);
        String commentsPageCommentsReg = delfiCommentsPageCommentsReg.getCountOfCommentsCommentsPageRegister(1);
        int countCommentsPageReg = Integer.parseInt(commentsPageCommentsReg.substring(1, commentsPageCommentsReg.length() - 1));

        int totalCountOfComments = countCommentsPageAnonim + countCommentsPageReg;

        System.out.println("COUNT of comments on the COMMENTS_PAGE is: " + totalCountOfComments);

        //Assertions - check - titles are the same, count of comments is the same over all 3 pages
        Assertions.assertEquals(delfiHomePageTitle, delfiArticlePageTitle, "Titles are not the same on Homepage and Article Page!!!");
        Assertions.assertEquals(delfiHomePageTitle, delfiCommentsPageTitle, "Titles are not the same on Homepage and Comments Page!!!!");

        Assertions.assertEquals(countHomepage, countCommentsArticlePage, "Count of Comments are not the same on Homepage and Article Page!!!");
        Assertions.assertEquals(countHomepage, totalCountOfComments, "Count of Comments are not the same on Homepage and Comments Page!!!");

        //Close Browser
        delfiFunctions.closeBrowser();
    }
}
