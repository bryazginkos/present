package present.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Property
 */
@Entity
public class Property {
    @Id
    @GeneratedValue
    private Integer id;

    private String code;

    private String value;

    public Integer getId() {
        return id;
    }

    /**
     * Returns property code
     * like "isSafeForChildren" of "weight"
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets property code
     * like "isSafeForChildren" of "weight"
     * @return
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns property value
     * like "yes" of "12"
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets property value
     * like "yes" of "12"
     * @return
     */
    public void setValue(String value) {
        this.value = value;
    }
}
