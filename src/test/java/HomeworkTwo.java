import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.List;

public class HomeworkTwo {
    //.//main//article[contains(@class, 'headline')]//h1[contains(@class, 'headline__title')]
    private final By ARTICLE_SECOND_TITLE = By.xpath(".//main//article//h1[contains(@class, 'text-size-19')]");//2nd Title link on Homepage
    private final By SECOND_ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");//2nd Article page link
    private final By ARTICLE_COMMENT_PAGE = By.xpath(".//a[contains(@class,'btn-comments')]"); //  comment page link from Article
    private final By ARTICLE_COMMENT_PAGE_TITLE = By.xpath(".//div[contains(@id,'comments-listing')]//a"); //  Article comment page link

    private final By COMMENTS = By.xpath(".//main//article//span//a[contains(@class,'comment-count')]"); //comments from Homepage
    private final By COMMENTS_ON_ARTICLE_PAGE = By.xpath(".//a[contains(@class, 'd-print-none')]"); //comments from Article page
    private final By COMMENT_PAGE_REG_COMMENTS = By.xpath(".//li[contains(@class, 'show-reg')]//span[contains(@class,'type-cnt')]");
    private final By COMMENT_PAGE_ANO_COMMENTS = By.xpath(".//li[contains(@class, 'show-anon')]//span[contains(@class,'type-cnt')]");
    private final By COMMENT_ICON_IFNOCOMMENT_ON_ARTICLE_PAGE = By.xpath(".//i[contains(@class, 'icon-ui-comments')]");

    private WebDriver driver;
    private final Logger LOGGER = LogManager.getLogger(HomeworkTwo.class);

    @Test
    public void delfiTest2ndTitleOpening() {

        LOGGER.info("Setting up driver path");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        LOGGER.info("Open Chrome browser");
        driver = new ChromeDriver();

        LOGGER.info("Maximize window");
        driver.manage().window().maximize();

        LOGGER.info("Open Delfi.lv");
        driver.get("http://delfi.lv");

        LOGGER.info("Find the 2nd title on the Homepage");
        List<WebElement> articles = driver.findElements(ARTICLE_SECOND_TITLE);
        WebElement secondTitle = articles.get(1);

        LOGGER.info("Get and save the 2nd article's title text (expected result)");
        String secondTitleText = secondTitle.getText();
        secondTitleText = secondTitleText.substring(0, secondTitleText.length() - 1);
        System.out.println("RESULT: The 2nd article title on HOMEPAGE is - " + secondTitleText);

        LOGGER.info("Click on the title");
        secondTitle.click();

        LOGGER.info("Find the article's title on the article page");
        WebElement articleTitle = driver.findElement(SECOND_ARTICLE_PAGE_TITLE);

        LOGGER.info("Get and save the 2nd article's title text on Article Page (actual result)");
        String secondArticleTitleText = articleTitle.getText();
        secondArticleTitleText = secondArticleTitleText.substring(0, secondArticleTitleText.length() - 1);
        System.out.println("RESULT: Article title on ARTICLE PAGE is - " + secondArticleTitleText);

        LOGGER.info("Open Article comments page");
        WebElement articleComments = driver.findElement(ARTICLE_COMMENT_PAGE);
        articleComments.click();
        WebElement articleCommentsTitle = driver.findElement(ARTICLE_COMMENT_PAGE_TITLE);

        LOGGER.info("Get and save the article's comments page title text (actual result)");
        String articleCommentsTitleText = articleCommentsTitle.getText();
        System.out.println("RESULT: Article Title on COMMENTS PAGE is - " + articleCommentsTitleText);

        LOGGER.info("Compare title texts");

        Assertions.assertEquals(secondTitleText, secondArticleTitleText, "Wrong Article Title!");
        Assertions.assertEquals(secondTitleText, articleCommentsTitleText, "Wrong Article Title!");
    }

    @Test
    public void delfiTestCompareCountOfComments() {

        LOGGER.info("Open Chrome browser");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Open Delfi.lv");
        driver.get("http://delfi.lv");

        List<WebElement> comments = driver.findElements(COMMENTS);

        LOGGER.info("Find the 2nd title on Homepage.");
        WebElement countOfCommentsOnHomepage = comments.get(1);

        Boolean isPresent = driver.findElements(COMMENTS).size()>0;

        if (isPresent == false) {

            System.out.println("NO COMMENTS FOR THE 2ND TITLE IN HOMEPAGE! Compare count of comments on Article page and Comments Page!");

            LOGGER.info("Click on the 2nd title in Homepage");

            List<WebElement> articles = driver.findElements(ARTICLE_SECOND_TITLE);
            WebElement secondTitle = articles.get(1);
            secondTitle.click();

                    Boolean isCountOfCommentsOnThePage = driver.findElements(COMMENTS_ON_ARTICLE_PAGE).size()>0;

                         if(isCountOfCommentsOnThePage == true) {

                             LOGGER.info("Find count of comments on the Article page");
                             WebElement countOfCommentsArticlePage = driver.findElement(COMMENTS_ON_ARTICLE_PAGE);

                             LOGGER.info("Get and save count of comments for the 2nd article (actual result)");
                             String secondArticlePageComments = countOfCommentsArticlePage.getText();
                             secondArticlePageComments = secondArticlePageComments.substring(1, secondArticlePageComments.length() - 1);
                             Integer countOfArticleComments = Integer.valueOf(secondArticlePageComments);
                             System.out.println("RESULT: Count of comments on the ARTICLE PAGE is  " + countOfArticleComments);
                         }

                         else{
                             LOGGER.info("Find comments ICON on the article page");

                             driver.findElement(COMMENT_ICON_IFNOCOMMENT_ON_ARTICLE_PAGE);
                             Integer countOfCommentsOnArticlePage = 0;
                             System.out.println("RESULT: Comments on Article Page is " + countOfCommentsOnArticlePage);
                         }

            LOGGER.info("Open Article comments page");
            WebElement articleComments = driver.findElement(COMMENT_ICON_IFNOCOMMENT_ON_ARTICLE_PAGE);
            articleComments.click();

            LOGGER.info("Sum comments on comments page");
            WebElement articleCommentsPageCommentsReg = driver.findElement(COMMENT_PAGE_REG_COMMENTS);
            WebElement articleCommentsPageCommentsAno = driver.findElement(COMMENT_PAGE_ANO_COMMENTS);

            LOGGER.info("Get and save count of comments on Comments page (actual result)");
            String regArticleCommentsOnCommentsPage = articleCommentsPageCommentsReg.getText();
            regArticleCommentsOnCommentsPage = regArticleCommentsOnCommentsPage.substring(1, regArticleCommentsOnCommentsPage.length() - 1);
            Integer countReg = Integer.valueOf(regArticleCommentsOnCommentsPage);

            String anoArticleCommentsOnCommentsPage = articleCommentsPageCommentsAno.getText();
            anoArticleCommentsOnCommentsPage = anoArticleCommentsOnCommentsPage.substring(1, anoArticleCommentsOnCommentsPage.length() - 1);
            Integer countAno = Integer.valueOf(anoArticleCommentsOnCommentsPage);

            Integer totalComments = (countAno + countReg);
            System.out.println("RESULT: Count of comments on the COMMENTS PAGE is  " + totalComments);

            LOGGER.info("Compare count of comments on both pages.");
            Assertions.assertEquals(0, totalComments, "Count of comments does not match!");

        }
            else {

            LOGGER.info("Get and save count of comments for the 2nd article on homepage (expected result)");

            String secondArticleHomepageComments = countOfCommentsOnHomepage.getText();
            secondArticleHomepageComments = secondArticleHomepageComments.substring(1, secondArticleHomepageComments.length() - 1);
            Integer countOfArticleHomepageComments = Integer.valueOf(secondArticleHomepageComments);
            System.out.println("RESULT: Count of comments on the HOMEPAGE is  " + countOfArticleHomepageComments);

            LOGGER.info("Click on the title");
            List<WebElement> articles = driver.findElements(ARTICLE_SECOND_TITLE);
            WebElement secondTitle = articles.get(1);
            secondTitle.click();

            LOGGER.info("Find count of comments on the Article page");
            WebElement countOfCommentsArticlePage = driver.findElement(COMMENTS_ON_ARTICLE_PAGE);

            LOGGER.info("Get and save count of comments for the 2nd article (actual result)");
            String secondArticlePageComments = countOfCommentsArticlePage.getText();
            secondArticlePageComments = secondArticlePageComments.substring(1, secondArticlePageComments.length() - 1);
            Integer countOfArticleComments = Integer.valueOf(secondArticlePageComments);
            System.out.println("RESULT: Count of comments on the ARTICLE PAGE is  " + countOfArticleComments);

            LOGGER.info("Open Article comments page");
            WebElement articleComments = driver.findElement(ARTICLE_COMMENT_PAGE);
            articleComments.click();

            LOGGER.info("Sum comments on comments page");
            WebElement articleCommentsPageCommentsReg = driver.findElement(COMMENT_PAGE_REG_COMMENTS);
            WebElement articleCommentsPageCommentsAno = driver.findElement(COMMENT_PAGE_ANO_COMMENTS);

            LOGGER.info("Get and save the article's comments page count of comments (actual result)");
            String regArticleCommentsOnCommentsPage = articleCommentsPageCommentsReg.getText();
            regArticleCommentsOnCommentsPage = regArticleCommentsOnCommentsPage.substring(1, regArticleCommentsOnCommentsPage.length() - 1);
            Integer countReg = Integer.valueOf(regArticleCommentsOnCommentsPage);

            String anoArticleCommentsOnCommentsPage = articleCommentsPageCommentsAno.getText();
            anoArticleCommentsOnCommentsPage = anoArticleCommentsOnCommentsPage.substring(1, anoArticleCommentsOnCommentsPage.length() - 1);
            Integer countAno = Integer.valueOf(anoArticleCommentsOnCommentsPage);

            Integer totalComments = (countAno + countReg);
            System.out.println("RESULT: Count of comments on the COMMENTS PAGE is  " + totalComments);

            LOGGER.info("Compare count of comments on all pages.");

            Assertions.assertEquals(countOfArticleHomepageComments, countOfArticleComments, "Count of comments does not match!");
            Assertions.assertEquals(countOfArticleHomepageComments, totalComments, "Count of comments does not match!");
        }
    }
    @AfterEach
    public void closeBrowser(){
        driver.close();

    }
}



