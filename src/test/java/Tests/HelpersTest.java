package Tests;

import Ellithium.Utilities.assertion.AssertionExecutor;
import Ellithium.Utilities.helpers.*;
import Ellithium.core.base.NonBDDSetup;
import org.testng.annotations.Test;

public class HelpersTest extends NonBDDSetup {

    @Test
    public void TestPDFHelper(){
        AssertionExecutor.hard.assertTrue(PDFHelper.comparePdfFiles("src/test/resources/TestData/Introduction_to_Ellithium 1.pdf",
                "src/test/resources/TestData/Introduction_to_Ellithium 2.pdf"));
    }
    @Test
    public void TestTextHelper(){
        AssertionExecutor.soft soft=new AssertionExecutor.soft();
        soft.assertEquals(TextHelper.readLineNumber("src/test/resources/TestData/file text.txt",2),
                "line 2");
        TextHelper.appendAfterLine("src/test/resources/TestData/file text.txt", 5,"line5");
        soft.assertEquals(TextHelper.readLineNumber("src/test/resources/TestData/file text.txt",6),
                "line5");
        soft.assertAll();
    }
    @Test
    public void TestCSVHelper(){
        AssertionExecutor.soft soft=new AssertionExecutor.soft();
        var data= ExcelHelper.getExcelData("src/test/resources/TestData/Items and Prices.xlsx","Items and Prices");
        CSVHelper.setCsvData("src/test/resources/TestData/Items and Prices.csv",data);
        soft.assertEquals(CSVHelper.getCsvData("src/test/resources/TestData/Items and Prices.csv")
                ,data);
        soft.assertAll();
    }

}
