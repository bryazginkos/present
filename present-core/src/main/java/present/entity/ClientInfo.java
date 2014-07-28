package present.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Требуемые свойства о получателе подарка
 */
@Entity
public class ClientInfo {

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * Код (тип) информации о получателе подарка
     */
    public String code;

    /**
     * Название типа информации
     */
    public String title;
}
