package present.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by Kos on 25.07.2014.
 */
@Entity
public class Partner {
    @GeneratedValue
    @Id
    private Integer id;

    /**
     * Название партнера
     */
    public String title;

    /**
     * Описание партнера
     */
    public String description;

    /**
     * Веб сайт партнера
     */
    public String url;

    /**
     * Адрес партнера
     */
    public String address;

    /**
     * Логин для входа в систему управления товарами
     */
    public String login;

    /**
     * Зашифрованный пароль
     */
    public String md5pass;

    /**
     * Телефон
     */
    public String phone;

    /**
     * email партнера
     */
    public String email;

    /**
     * Товары партнера
     */
    public List<Item> items;

}
