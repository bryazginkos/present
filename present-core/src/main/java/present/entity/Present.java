package present.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Подарок
 */
@Entity
public class Present implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * Уникальный кол доступа для дарителя
     */
    private String uin;

    /**
     * Уникальный код доступа для получателя
     */
    private String code;

    /**
     * Время оплаты
     */
    private Date payTime;

    /**
     * Статус подарка
     */
    private Integer status;

    /**
     * Признак блокировки
     */
    private Boolean blocked;

    /**
     * Возможен ли выбор из группы itemов (иначе определенный item)
     */
    private Boolean possibleChoice;

    /**
     * итем для подарка
     */
    private Item item;

    /**
     * количество итемов
     */
    private Integer quantity;

    /**
     * Условия на группу итемов
     */
    private String itemsConditions;

    /**
     * Можно ли дарителю узнать какой подарок был выбран получателем
     */
    private Boolean seeResult;

    /**
     * Свойства
     */
    @OneToMany(mappedBy = "code")
    private Map<String, Property> properties;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns unique string for access to present for donator
     * @return
     */
    public String getUin() {
        return uin;
    }

    /**
     * Sets unique string for access to present for donator
     * @return
     */
    public void setUin(String uin) {
        this.uin = uin;
    }

    /**
     * Returns unique string for access to present for recipient
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets unique string for access to present for recipient
     * @return
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns datetime of payment for present
     * @return
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * Sets datetime of payment for present
     * @return
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
//todo connect method or javadoc with statusClass
    /**
     * Return status of present
     * @return
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets status of present
     * @return
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Returns true if present is blocked for any actions
     * @return
     */
    public Boolean getBlocked() {
        return blocked;
    }

    /**
     * Sets present block for any actions
     * @param blocked
     */
    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    /**
     * Returns true if recipient can get a group of Items
     * In that case property itemConditions determines a group
     * -----------------------------------
     * Returns false if recipient can get only one Item (chosen by donator)
     * In that case property Item shows on chosen Item.
     * @return
     */
    public Boolean getPossibleChoice() {
        return possibleChoice;
    }

    /**
     * Sets  if recipient can get a group of Items or
     * recipient can get only one Item (chosen by donator)
     * ------------------------------------------
     * true: recipient can get a group of Items
     * In that case property itemConditions determines a group
     * -----------------------------------
     * false: recipient can get only one Item (chosen by donator)
     * In that case property Item shows on chosen Item.
     * @return
     */
    public void setPossibleChoice(Boolean possibleChoice) {
        this.possibleChoice = possibleChoice;
    }

    /**
     * If possibleChoice property is false returns Item chosen by donator
     * Else returns null
     * @return
     */
    public Item getItem() {
        return item;
    }

    /**
     * Sets Item chosen by donator
     * Works if possibleChoice property is false
     * @return
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * If possibleChoice property is false returns Item's quantity chosen by donator
     * Else returns 0
     * @return
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets Item's quantity chosen by donator
     * Works if possibleChoice property is false
     * @return
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns conditions string determines group of items chosen by donator
     * (works if possibleChoice property is true)
     * For example "type=flower&price<40"
     * Symbol "=" can be used for equals condition
     * Symbold '>='  '<='  '<'   '>'  '!=' can be used for compare condition
     * @return
     */
    public String getItemsConditions() {
        return itemsConditions;
    }

    public void setItemsConditions(String itemsConditions) {
        this.itemsConditions = itemsConditions;
    }

    public Boolean getSeeResult() {
        return seeResult;
    }

    public void setSeeResult(Boolean seeResult) {
        this.seeResult = seeResult;
    }

    public Map<String, Property> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Property> properties) {
        this.properties = properties;
    }
}
