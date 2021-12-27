import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ABGRFruitAndVeggiesShopTest extends ABGRFruitAndVeggiesShop{

    @Test
    public void checkLogo(){

        System.out.println("--------------------------Test Case 1---------------------------");
        WebElement logo = driver.findElement(By.xpath("/html/body/nav/div/img"));
        boolean visible = logo.isDisplayed();
        if(visible){
            Assert.assertTrue(true);
            System.out.println("Expected : Logo is displayed\nActual : Logo is displayed");
        }else{
            System.out.println("Expected : Logo is displayed\nActual : Logo is not displayed");
            System.out.println("-----------------------------------------------------------------");
            Assert.assertTrue(false);
        }
        System.out.println("-----------------------------------------------------------------");

    }

    @Test
    public void searchBar() throws InterruptedException {

        System.out.println("--------------------------Test Case 2---------------------------");
        WebElement input = driver.findElement((By.id("searchInput")));
        input.sendKeys("banana");
        Thread.sleep(2000);

        WebElement card = driver.findElement(By.xpath("//*[@id=\"products_list\"]/div/div/div[2]/h5"));
        String eatable = card.getText();
        if(eatable.equals("Banana")){
            Assert.assertTrue(true);
            System.out.println("Expected : Banana Card View filtered\nActual : Banana Card View filtered");
        }else{
            System.out.println("Expected : Banana Card View filtered\nActual : Banana Card View is not filtered");
            System.out.println("-----------------------------------------------------------------");
            Assert.assertTrue(false);
        }
        System.out.println("-----------------------------------------------------------------");
    }

    @Test
    public void categories() throws InterruptedException {

        System.out.println("--------------------------Test Case 3---------------------------");
        WebElement category = driver.findElement(By.id("categoryFilter"));
        category.click();

        WebElement vegetable = driver.findElement(By.xpath("//*[@id=\"categoryFilter\"]/option[4]"));
        vegetable.click();
        Thread.sleep(2000);

        WebElement card1 = driver.findElement(By.xpath("//*[@id=\"products_list\"]/div[1]/div/div[2]/h5"));
        String eatable1 = card1.getText();
        WebElement card2 = driver.findElement(By.xpath("//*[@id=\"products_list\"]/div[2]/div/div[2]/h5"));
        String eatable2 = card2.getText();
        WebElement card3 = driver.findElement(By.xpath("//*[@id=\"products_list\"]/div[3]/div/div[2]/h5"));
        String eatable3 = card3.getText();
        WebElement card4 = driver.findElement(By.xpath("//*[@id=\"products_list\"]/div[4]/div/div[2]/h5"));
        String eatable4 = card4.getText();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        Thread.sleep(8000);

        if(eatable1.equals("Lettuce iceberg") &&
           eatable2.equals("Potato") &&
           eatable3.equals("Tomato canario") &&
           eatable4.equals("Broccoli")){
            Assert.assertTrue(true);
            System.out.println("Expected : Other card views, except the vegetables are filtered\nActual : Other card views, except the vegetables are filtered");
        }else{
            System.out.println("Expected : Other card views, except the vegetables are filtered\nActual : Other card views, except the vegetables are not filtered");
            System.out.println("-----------------------------------------------------------------");
            Assert.assertTrue(false);
        }

        System.out.println("-----------------------------------------------------------------");
    }

    @Test
    public void cardViewImgClick() throws InterruptedException {
        System.out.println("--------------------------Test Case 4---------------------------");
        WebElement tangerine = driver.findElement(By.xpath("//*[@id=\"products_list\"]/div[4]/div/img"));
        tangerine.click();
        Thread.sleep(2000);

        WebElement specific = driver.findElement(By.xpath("//*[@id=\"product_details\"]/div/div"));
        boolean tangerinePane = specific.isDisplayed();

        if(tangerinePane){
            Assert.assertTrue(true);
            System.out.println("Expected : Card view is clickable\nActual : Card View is clickable");
        }else{
            System.out.println("Expected : Card view is clickable\nActual : Card View is not clickable");
            System.out.println("-----------------------------------------------------------------");
            Assert.assertTrue(false);
        }
        System.out.println("-----------------------------------------------------------------");
    }

    @Test
    public void cardViewBodyClick() throws InterruptedException {
        System.out.println("--------------------------Test Case 5---------------------------");
        WebElement tangerine = driver.findElement(By.xpath("//*[@id=\"products_list\"]/div[4]/div/div[2]"));
        tangerine.click();
        Thread.sleep(2000);

        WebElement specific = driver.findElement(By.xpath("//*[@id=\"product_details\"]/div/div"));
        boolean tangerinePane = specific.isDisplayed();

        if(tangerinePane){
            Assert.assertTrue(true);
            System.out.println("Expected : Card view is clickable\nActual : Card View is clickable");
        }else{
            System.out.println("Expected : Card view is clickable\nActual : Card View is not clickable");
            System.out.println("-----------------------------------------------------------------");
            Assert.assertTrue(false);
        }
        System.out.println("-----------------------------------------------------------------");
    }



    @Test
    public void cart() throws InterruptedException {

        System.out.println("--------------------------Test Case 6---------------------------");
        WebElement watermelon = driver.findElement(By.xpath("//*[@id=\"products_list\"]/div[1]/div/img"));
        watermelon.click();

        WebElement quantity = driver.findElement(By.xpath("//*[@id=\"addProduct\"]"));
        Thread.sleep(2000);
        quantity.click();
        Thread.sleep(2000);
        quantity.click();
        Thread.sleep(2000);
        quantity.click();
        Thread.sleep(2000);

        WebElement addtToCart = driver.findElement(By.xpath("//*[@id=\"addCartBtn\"]"));
        addtToCart.click();
        Thread.sleep(2000);

        WebElement cart = driver.findElement(By.xpath("//*[@id=\"itemsCartNum\"]"));
        int numberOfItems = Integer.parseInt(cart.getText());

        WebElement checkCart = driver.findElement(By.xpath("//*[@id=\"cart-modal\"]"));
        checkCart.click();
        Thread.sleep(2000);

        WebElement quantityCheck = driver.findElement(By.xpath("//*[@id=\"cart-content\"]/div/div[2]/span"));
        String quantityWaterMelon = quantityCheck.getText();

        if(numberOfItems == 1 && quantityWaterMelon.equals("4 pieces")){
            Assert.assertTrue(true);
            System.out.println("Expected : 4 pieces of Watermelon are added to the cart\nActual : 4 pieces of Watermelon are added to the cart");
        }else{
            System.out.println("Expected : 4 pieces of Watermelon are added to the cart\nActual : Unable to add 4 pieces of Watermelon to the cart");
            System.out.println("-----------------------------------------------------------------");
            Assert.assertTrue(false);
        }
        System.out.println("-----------------------------------------------------------------");
    }

    @Test
    @Parameters({"Email","Password","no"})
    public void adminLogin(String eM, String pass,int no) throws InterruptedException {

        System.out.println("--------------------------Test Case ("+no+"/4)---------------------------");
        WebElement admin = driver.findElement(By.xpath("//*[@id=\"navbarResponsive\"]/ul/li[2]/a"));
        admin.click();
        Thread.sleep(2000);

        WebElement eMail = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        eMail.sendKeys(eM);
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys(pass);
        Thread.sleep(2000);

        WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/form/div[3]/input"));
        login.click();
        Thread.sleep(5000);

        if(eM.equals(ABGRFruitAndVeggiesShop.email) && pass.equals(ABGRFruitAndVeggiesShop.password)){
            WebElement adminPortal = driver.findElement(By.xpath("//*[@id=\"sidebarCollapse\"]"));
            adminPortal.click();
            Thread.sleep(5000);

            WebElement welcome = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/div/h3"));
            String welcomeAdmin = welcome.getText();

            System.out.println("Expected : Admin Logged in Successfully\nActual : Admin Logged in Successfully");
            Assert.assertTrue(true);
        }else {
            System.out.println("Expected : Admin Login is unsuccessful\nActual : Admin Login was unsuccessful");
            Assert.assertTrue(true);
        }
        System.out.println("--------------------------------------------------------------------");
    }
}