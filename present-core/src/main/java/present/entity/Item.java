package present.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Товары
 */
@Entity
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
    public Partner partner;

}
