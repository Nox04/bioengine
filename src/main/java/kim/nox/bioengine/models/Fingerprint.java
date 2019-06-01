package kim.nox.bioengine.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "biometric_fingerprints")
public class Fingerprint extends Base {

    public Fingerprint(String template, Staff staff) {
        super();
        this.template = template;
        this.staff = staff;
    }

    private String template;

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
}
