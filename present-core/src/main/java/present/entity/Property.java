package present.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Свойство товара
 */
@Entity
public class Property {
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * Код свойства
     */
    public String code;

    /**
     * Название свойства
     */
    public String title;

    /**
     * Значение свойства
     */
    public String value;

}
