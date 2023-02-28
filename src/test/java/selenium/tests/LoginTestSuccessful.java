package selenium.tests;

import Base.TestUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LoginTestSuccessful extends TestUtil {

    @Test(dataProvider = "correctUsers")
    public void successfulLogin(String userName, String password){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage prPage = loginPage.login(userName, password);
    }
    @DataProvider(name = "correctUsers")
    public static Object[][] readUsersFromCsv() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/correctUsers.csv"));
            List<String[]> csvData = csvReader.readAll();
            Object[] [] csvDataObj = new Object[csvData.size()][2];
            for (int i = 0; i < csvData.size(); i++) {
                csvDataObj[i] = csvData.get(i);
            }
            return csvDataObj;
        } catch (IOException e){
            System.out.println("Not possible to find CSV!");
            return null;
        }
        catch (CsvException e){
            return null;
        }
    }
}
