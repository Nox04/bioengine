package kim.nox.bioengine.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "biometric_staff")
public class Staff extends Base {

  public Staff(String document) {
    super();
    this.document = document;
  }

  private String document;

  @OneToMany(mappedBy = "staff")
  List<Fingerprint> fingerprints;

  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  public List<Fingerprint> getFingerprints() {
    return fingerprints;
  }

  public void setFingerprints(List<Fingerprint> fingerprints) {
    this.fingerprints = fingerprints;
  }
}
