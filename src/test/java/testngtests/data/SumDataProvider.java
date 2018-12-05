package testngtests.data;

import org.testng.annotations.DataProvider;

public class SumDataProvider {
  @DataProvider (name = "dp", parallel = true)
  public static Object[][] testData() {
    return new Object[][]{{1,2,3},{2,3,5},{255,100,355},{-15,4,-11}};
  }

  @DataProvider (name = "dpn", parallel = true)
  public static Object[][] testDataN(){
    return new Object[][]{{"a","v",0}, {"", "", 0}};
  }
}
