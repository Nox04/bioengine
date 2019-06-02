package kim.nox.bioengine.biometrics;

import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;
import io.ebean.Ebean;
import kim.nox.bioengine.Singleton;
import kim.nox.bioengine.io.Utils;
import kim.nox.bioengine.logs.ActivityLogger;
import kim.nox.bioengine.models.Fingerprint;
import kim.nox.bioengine.models.Staff;

import java.io.IOException;

public class Matcher {

  private double score = 0.0;
  private FingerprintTemplate probeTemplate;
  private FingerprintTemplate candidateTemplate;
  private Singleton singleton;

  public Matcher() {
    this.singleton = Singleton.getInstance();
  }

  public BioResult matchAgainstDatabase(String document, String imagePath) {
    try {
      probeTemplate = Extractor.extractTemplate(imagePath);
    } catch (IOException e) {
      return BioResult.UNABLE_TO_LOAD_IMAGE;
    }

    Staff staff = Ebean.find(Staff.class).where().eq("document", document).findOne();

    if (staff != null) {

      for (Fingerprint fingerprint : staff.getFingerprints()) {
        if (match(fingerprint) == BioResult.MATCH_SUCCESSFUL) {
          ActivityLogger.logMatchSuccesful(document, fingerprint.getPosition());
          return BioResult.MATCH_SUCCESSFUL;
        }
      }
      ActivityLogger.logMatchFailed(document);
      return BioResult.MATCH_FAILED;
    } else {
      ActivityLogger.logUserNotFound(document);
      return BioResult.STAFF_NOT_FOUND;
    }
  }

  private BioResult match(Fingerprint fingerprint) {
    candidateTemplate = new FingerprintTemplate()
            .dpi(500.0)
            .deserialize(Utils.decodeBase64ToString(fingerprint.getTemplate()));
    score = new FingerprintMatcher().index(probeTemplate).match(candidateTemplate);
    return score > 40 ? BioResult.MATCH_SUCCESSFUL : BioResult.MATCH_FAILED;
  }

  public double getScore() {
    return score;
  }
}
