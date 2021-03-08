import com.telran.pages.YandexPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestYandexMarket extends TestBase{

    @Test
    public void test(){

       Assert.assertTrue(new YandexPage(driver)
               .novigateToMarket()
       .selectedComputer()
       .selectTablets()
       .setPriceRange(20000,35000)
       .selectProducer("Apple")
       .varifySearchResult());
    }
}
