package present.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Description of necessary information about recipient for partner
 */
@Entity
public class RecipientInfo {
    @Id
    @GeneratedValue
    private Integer id;

    private String code;

    private String title;

    /**
     * Returns property's identifier
     * like "age" or "address"
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets property's identifier
     * like "age" or "address"
     * @return
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns property's title
     * like "Age of recipient" or "delivery address"
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets property's title
     * like "Age of recipient" or "delivery address"
     * @return
     */
    public void setTitle(String title) {
        this.title = title;
    }


    public Integer getId() {
        return id;
    }
}
