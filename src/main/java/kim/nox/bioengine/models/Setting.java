package kim.nox.bioengine.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "biometric_settings")
public class Setting extends Base {


  /**
   * Setting model.
   * @param key Parameter's key.
   * @param value Parameter's key.
   */
  public Setting(String key, String value) {
    super();
    this.key = key;
    this.value = value;
  }

  private String key;
  private String value;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
