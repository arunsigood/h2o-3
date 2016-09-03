package water.parser;

import org.junit.BeforeClass;
import org.junit.Test;
import water.TestUtil;
import water.fvec.Frame;

import java.io.IOException;

public class ClientParserZipGzipTest2 extends TestUtil {
  //
  // BIG WARNING: this test is not executed in client mode if it is run
  // under regular H2O test infrastructure. See [PUBDEV-2643]
  //
  @BeforeClass static public void setup() {
    stall_till_cloudsize(1);
  }

  @Test public void testBasic() throws IOException {

//    Frame one_zip_file = parse_test_file("smalldata/parser/hexdev_497/airlines_small_csv_zip/airlines1.csv.zip");
/*    Frame one_csv_file = parse_test_file("smalldata/parser/hexdev_497/airlines_small_csv/airlines1.csv");

    assertTrue(TestUtil.isBitIdentical(one_zip_file, one_csv_file));*/

    Frame one_zip_directory = parse_test_file("smalldata/parser/hexdev_497/airlines_small_csv.zip");
//    Frame one_csv_directory = parse_test_folder("smalldata/parser/hexdev_497/airlines_small_csv");
    Frame one_csv_directory = parse_test_file("smalldata/parser/hexdev_497/airlines_small_csv/airlines1.csv");


//    assertTrue(TestUtil.isBitIdentical(one_zip_directory, one_csv_directory));

    if (one_zip_directory != null) one_zip_directory.delete();
    if (one_csv_directory != null) one_csv_directory.delete();

  }
}
