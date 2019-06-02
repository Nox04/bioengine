package kim.nox.bioengine.biometrics;

import com.machinezoo.sourceafis.FingerprintTemplate;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

class Extractor {

  static FingerprintTemplate extractTemplate(String filePath) throws IOException {
    FingerprintTemplate fingerprintTemplate;
    byte[] fileBytes = FileUtils.readFileToByteArray(new File(filePath));
    fingerprintTemplate = new FingerprintTemplate().dpi(500.0).create(fileBytes);
    return fingerprintTemplate;
  }
}
