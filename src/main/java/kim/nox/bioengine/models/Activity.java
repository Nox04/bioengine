package kim.nox.bioengine.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "biometric_log")
public class Activity  extends Base {

  public Activity(String causerDocument, String description) {
    super();
    this.causerDocument = causerDocument;
    this.description = description;
  }

  private String causerDocument;
  private String description;

  public String getCauserDocument() {
    return causerDocument;
  }

  public void setCauserDocument(String causerDocument) {
    this.causerDocument = causerDocument;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
