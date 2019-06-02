package kim.nox.bioengine.biometrics;

import com.machinezoo.sourceafis.FingerprintTemplate;
import io.ebean.Ebean;
import java.io.IOException;
import kim.nox.bioengine.Singleton;
import kim.nox.bioengine.io.Utils;
import kim.nox.bioengine.logs.ActivityLogger;
import kim.nox.bioengine.models.Fingerprint;
import kim.nox.bioengine.models.Staff;

public class Enroller {
  private String document;
  private String imagePath;
  private String position;
  private Staff staff;
  private Singleton singleton;

  /**
   * Enroller constructor.
   * @param document Staff's document.
   * @param imagePath Path of the fingerprint image.
   * @param position Position of the fingerprint.
   */
  public Enroller(String document, String imagePath, String position) {
    this.singleton = Singleton.getInstance();
    this.document = document;
    this.imagePath = imagePath;
    this.position = position;
    this.staff = findOrCreateStaff();
  }

  /**
   * Enroll biometric template to database.
   * @return Result of the enrollment.
   */
  public BioResult enrollBioTemplateToDatabase() {
    try {
      FingerprintTemplate fingerprintTemplate = Extractor.extractTemplate(this.imagePath);
      Fingerprint fingerprint = new Fingerprint(
              Utils.encodeStringToBase64(fingerprintTemplate.serialize()),
              this.staff,
              this.position
      );
      this.singleton.server.save(fingerprint);
      ActivityLogger.logFingerprintCreated(
              this.staff.getDocument(),
              fingerprint.getId(),
              fingerprint.getPosition()
      );
    } catch (IOException e) {
      return BioResult.UNABLE_TO_LOAD_IMAGE;
    }
    return BioResult.ENROLLMENT_SUCCESSFUL;
  }

  private Staff findOrCreateStaff() {
    Staff staff = Ebean.find(Staff.class)
            .select("document")
            .where()
            .eq("document", document)
            .findOne();

    if (staff == null) {
      staff = new Staff(document);
      this.singleton.server.save(staff);
      ActivityLogger.logStaffCreated(document, staff.getId());
    }

    return staff;
  }
}
