package Tests;

import Base.BaseTests;
import Ellithium.Utilities.assertion.AssertionExecutor;
import Ellithium.Utilities.helpers.ExcelHelper;
import Ellithium.core.logging.LogLevel;
import Ellithium.core.reporting.Reporter;
import Pages.SearchPage;
import io.cucumber.java.it.Ma;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchTests extends BaseTests {
    SearchPage searchPage;
    @BeforeClass
    public void setSearchPage(){
        searchPage=new SearchPage(driver);
    }
    @Test
    public void searchForItem(){
        searchPage.searchForItem("laptop");
        searchPage.clickSearch();
        List<String>itemNames=searchPage.getItemsNames();
        List<String>itemPrices=searchPage.getItemsPrices();
        List<Map<String, String>>data=new ArrayList<>();
        AssertionExecutor.soft soft=new AssertionExecutor.soft();
        for(int count=0; count <10; count++){
            Map<String, String> h=new HashMap<>();
            h.put("Item Name", itemNames.get(count));
            h.put("Item Price", itemPrices.get(count));
            data.add(h);
            soft.assertTrue(itemNames.get(count).toLowerCase().contains("laptop"));
        }
        ExcelHelper.setExcelData("src/test/resources/TestData/Items and Prices.xlsx", "Items and Prices",data);
        soft.assertAll();
    }
}
