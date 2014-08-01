package present.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Товары
 */
@Entity
public class Item {

    @GeneratedValue
    @Id
    private int id;

    private String title;

    private String description;

    private float price;

    private Category category;

    @ManyToOne
    private Partner partner;

    @OneToMany (cascade = CascadeType.ALL)
    @MapKey(name = "code")
    public Map<String, Property> properties = new HashMap<String, Property>(0);

    /**
     * Returns properties map for item.
     * @return
     */
    public Map<String, Property> getProperties() {
        return properties;
    }

    /**
     * Sets properties map for item.
     * @return
     */
    public void setProperties(Map<String, Property> properties) {
        this.properties = properties;
    }

    /**
     * Returns partner (item seller)
     * @return
     */
    public Partner getPartner() {
        return partner;
    }

    /**
     * Sets partner (item seller)
     * @param partner
     */
    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    /**
     * Returns item category
     * @return
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets item category
     * @return
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Returns item's price
     * @return
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets item's price
     * @return
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Returns item's description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets item's description
     * @return
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns item's title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets item's title
     * @return
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }
}
