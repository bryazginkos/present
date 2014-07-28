package present.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Подарок
 */
@Entity
public class Present {
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * Уникальный кол доступа для дарителя
     */
    public String uin;

    /**
     * Уникальный код доступа для получателя
     */
    public String code;

    /**
     * Время оплаты
     */
    public Date payTime;

    /**
     * Статус подарка
     */
    public Integer status;

    /**
     * Признак блокировки
     */
    public Boolean blocked;

    /**
     * Возможен ли выбор из группы itemов (иначе определенный item)
     */
    public Boolean possibleChoice;

    /**
     * итем для подарка
     */
    public Item item;

    /**
     * количество итемов
     */
    public Integer quantity;

    /**
     * Условия на группу итемов
     */
    public String items_conditions;

    /**
     * Можно ли дарителю узнать какой подарок был выбран получателем
     */
    public Boolean seeResult;

}
