package kim.nox.bioengine.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Utils {

  public static String encodeFileToBase64(String filePath) throws IOException {
    byte[] bytes = FileUtils.readFileToByteArray(new File(filePath));
    return Base64.getEncoder().encodeToString(bytes);
  }

  public static void decodeBase64ToFile(String base64Str, String pathFile) throws IOException {
    byte[] imageByteArray = Base64.getDecoder().decode(base64Str);
    FileUtils.writeByteArrayToFile(new File(pathFile), imageByteArray);
  }

  public static String encodeStringToBase64(String stream) {
    return Base64.getEncoder().encodeToString(stream.getBytes());
  }

  public static String decodeBase64ToString(String base64Str) {
    byte[] imageByteArray = Base64.getDecoder().decode(base64Str);
    return new String(imageByteArray);
  }
}
