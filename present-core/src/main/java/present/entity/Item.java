package present.entity;

import javax.persistence.*;
import java.util.Map;

/**
 * Товары
 */
@Entity
@Table(name = "items")
public class Item {

    @GeneratedValue
    @Id
    private int id;

    /**
     * Название товара
     */
    public String title;

    /**
     * Описание товара
     */
    public String description;

    /**
     * Цена товара
     */
    public float price;

    /**
     * Партнер
     */
    @ManyToOne
    public Partner partner;

    /**
     * Свойства
     */
    @OneToMany(mappedBy = "code")
    public Map<String, Property> properties;

    public Map<String, Property> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Property> properties) {
        this.properties = properties;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
