package kim.nox.bioengine.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "biometric_fingerprints")
public class Fingerprint extends Base {

    public Fingerprint(String template, Staff staff, String position) {
        super();
        this.template = template;
        this.staff = staff;
        this.position = position;
    }

    private String template;

    private String position;

    @ManyToOne(optional=false)
    private Staff staff;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
