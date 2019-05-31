package kim.nox.bioengine.biometrics;

import com.machinezoo.sourceafis.FingerprintTemplate;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Extractor {

    public static FingerprintTemplate extractTemplate(String filePath) {
        FingerprintTemplate fingerprintTemplate = null;
        try {
            byte[] fileBytes = FileUtils.readFileToByteArray(new File(filePath));
            fingerprintTemplate = new FingerprintTemplate().dpi(500.0).create(fileBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fingerprintTemplate;
    }
}
