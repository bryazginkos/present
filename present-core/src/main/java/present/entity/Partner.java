package present.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kos on 25.07.2014.
 */
@Entity
public class Partner {
    @GeneratedValue
    @Id
    private Integer id;

    private String title;

    private String description;

    private String url;

    private String address;

    private String login;

    private String md5pass;

    private String phone;

    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @MapKey(name = "code")
    private Map<String, RecipientInfo> recipientInfoMap = new HashMap<String, RecipientInfo>(0);

    @OneToMany
    private List<Item> items;

    @OneToMany(cascade = CascadeType.ALL)
    @MapKey(name = "code")
    private Map<String, Property> properties = new HashMap<String, Property>(0);;

    public Integer getId() {
        return id;
    }

    /**
     * Returns properties map for partner
     * @return
     */
    public Map<String, Property> getProperties() {
        return properties;
    }

    /**
     * Sets properties map for partner
     * @return
     */
    public void setProperties(Map<String, Property> properties) {
        this.properties = properties;
    }

    /**
     * Return items list of partner
     * @return
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Sets items list of partner
     * @return
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Return partner's email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets partner's email
     * @return
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns partner's login for administration
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets partner's login for administration
     * @return
     */
    public void setLogin(String login) {
        this.login = login;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns partner's encrypted password for administration
     * @return
     */
    public String getMd5pass() {
        return md5pass;
    }

    /**
     * Sets partner's encrypted password for administration
     * @return
     */
    public void setMd5pass(String md5pass) {
        this.md5pass = md5pass;
    }

    /**
     * Returns partner's address
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets partner's address
     * @return
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns partner's website
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets partner's website
     * @return
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Returns partner's description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets partner's description
     * @return
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns partner's title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets partner's title
     * @return
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns map of information types which is neccessary for partner about recipient
     * For example <"homeAddress",RecipientInfo>
     * @return
     */
    public Map<String, RecipientInfo> getRecipientInfoMap() {
        return recipientInfoMap;
    }

    /**
     * Sets map of information types which is neccessary for partner about recipient
     * For example <"homeAddress",RecipientInfo>
     * @return
     */
    public void setRecipientInfoMap(Map<String, RecipientInfo> recipientInfoMap) {
        this.recipientInfoMap = recipientInfoMap;
    }
}
