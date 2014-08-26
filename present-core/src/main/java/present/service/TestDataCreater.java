package present.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.dao.interfaces.*;
import present.entity.*;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class TestDataCreater {

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private PartnerDAO partnerDAO;

    @Autowired
    private PropertyDAO propertyDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @Transactional
    public void createData() {
        Category categoryChild = new Category();
        Category categoryChild1 = new Category();
        Category categoryChild2 = new Category();
        Category categoryChild3 = new Category();
        Category categoryChild4 = new Category();
        Category categoryChild5 = new Category();
        Category categoryChild6 = new Category();
        Category categoryChild6Child1 = new Category();
        Category categoryChild6Child2 = new Category();
        Category categoryChild6Child3 = new Category();
        Category categoryRoot = new Category();

        categoryRoot.setTitle("Категории");
        categoryRoot.setDescription("Корневая категория");

        categoryChild.setTitle("Тестовые товары");
        categoryChild.setDescription("Товары для отладки приложения");
        categoryChild.setParent(categoryRoot);

        categoryChild1.setTitle("Цветы");
        categoryChild1.setDescription("Цветочные товары");
        categoryChild1.setParent(categoryRoot);

        categoryChild2.setTitle("Кондитерские изделия");
        categoryChild2.setDescription("Конфеты, сладости");
        categoryChild2.setParent(categoryRoot);

        categoryChild3.setTitle("Техника");
        categoryChild3.setDescription("Технические товары");
        categoryChild3.setParent(categoryRoot);

        categoryChild4.setTitle("Юмор");
        categoryChild4.setDescription("Намеки");
        categoryChild4.setParent(categoryRoot);

        categoryChild5.setTitle("Мужчинам");
        categoryChild5.setDescription("Мужчинам");
        categoryChild5.setParent(categoryRoot);

        categoryChild6.setTitle("Женщинам");
        categoryChild6.setDescription("Женщинам");
        categoryChild6.setParent(categoryRoot);

        categoryChild6Child1.setTitle("Цветы");
        categoryChild6Child1.setDescription("Розы, тюльпаны");
        categoryChild6Child1.setParent(categoryChild6);

        categoryChild6Child2.setTitle("Косметика");
        categoryChild6Child2.setDescription("Крема, помады");
        categoryChild6Child2.setParent(categoryChild6);

        categoryChild6Child3.setTitle("Украшения");
        categoryChild6Child3.setDescription("Кольца, браслеты");
        categoryChild6Child3.setParent(categoryChild6);

        categoryRoot.setChildren(Arrays.asList(categoryChild, categoryChild1, categoryChild2, categoryChild3, categoryChild4, categoryChild5, categoryChild6));

        categoryDAO.save(categoryRoot);
        categoryDAO.save(categoryChild);
        categoryDAO.save(categoryChild1);
        categoryDAO.save(categoryChild2);
        categoryDAO.save(categoryChild3);
        categoryDAO.save(categoryChild4);
        categoryDAO.save(categoryChild5);
        categoryDAO.save(categoryChild6);
        categoryDAO.save(categoryChild6Child1);
        categoryDAO.save(categoryChild6Child2);
        categoryDAO.save(categoryChild6Child3);


        for (int partnerNum = 1; partnerNum <= 3; partnerNum++) {
            Partner partner = createPartner(partnerNum);

            for (int itemNum =1; itemNum <=4; itemNum++ ) {
                Item item = createItem(categoryChild, itemNum, partnerNum);
                item.setPartner(partner);
                itemDAO.save(item);
            }
            partnerDAO.save(partner);
        }
    }

    private Partner createPartner(int partnerNum){
        Partner partner = new Partner();
        partner.setTitle("Partner #" + partnerNum);
        partner.setDescription("This is partner #" + partnerNum);
        partner.setAddress("Address of partner #" + partnerNum);
        partner.setEmail("partner#"+ partnerNum +"@partners.com");
        partner.setLogin("partner#"+ partnerNum +"'s login");
        partner.setMd5pass("md5string(partner#"+ partnerNum +")");
        partner.setPhone("+7" + partnerNum);
        partner.setUrl("www.partner-"+ partnerNum +".com");
        partner.setProperties(createPartnerPropertis(partnerNum));
        partner.setRecipientInfoMap(createReciepintInfoMap(partnerNum));
        return partner;
    }

    private Map<String,Property> createPartnerPropertis(int partnerNum){
        Map<String,Property> propertyMap = new HashMap<String, Property>(4);
        Property property;

        property = new Property();
        property.setCode("moneyFirst");
        property.setValue("0("+partnerNum+")");
        propertyMap.put("moneyfirst", property);

        property = new Property();
        property.setCode("onlyCash");
        property.setValue("0("+partnerNum+")");
        propertyMap.put("onlyCash", property);

        property = new Property();
        property.setCode("motherCountry");
        property.setValue("Russia("+partnerNum+")");
        propertyMap.put("motherCountry", property);

        property = new Property();
        property.setCode("numPartner");
        property.setValue(String.valueOf(partnerNum));
        propertyMap.put("numPartner", property);
        return propertyMap;
    }

    private Map<String,RecipientInfo> createReciepintInfoMap(int partnerNum) {
        Map<String,RecipientInfo> recipientInfoMap = new HashMap<String, RecipientInfo>(2);

        RecipientInfo recipientInfo;

        recipientInfo = new RecipientInfo();
        recipientInfo.setTitle("homePhone("+partnerNum+")");
        recipientInfo.setCode("hp");
        recipientInfoMap.put("hp",recipientInfo);

        recipientInfo = new RecipientInfo();
        recipientInfo.setTitle("mobilePhone("+partnerNum+")");
        recipientInfo.setCode("mp");
        recipientInfoMap.put("mp",recipientInfo);

        return recipientInfoMap;
    }

    private Map<String,Property> createItemPropertis(int itemNum){
        Map<String,Property> propertyMap = new HashMap<String, Property>(4);
        Property property;

        property = new Property();
        property.setCode("color");
        property.setValue("green("+itemNum+")");
        propertyMap.put("color", property);

        property = new Property();
        property.setCode("onlyCash");
        property.setValue("0("+itemNum+")");
        propertyMap.put("onlyCash", property);

        property = new Property();
        property.setCode("motherCountry");
        property.setValue("Russia("+itemNum+")");
        propertyMap.put("motherCountry", property);

        property = new Property();
        property.setCode("numItem");
        property.setValue(String.valueOf(itemNum));
        propertyMap.put("num", property);
        return propertyMap;
    }

    private Item createItem(Category category, int itemNum, int partnerNum) {
        Item item = new Item();
        item.setTitle("Item #" + itemNum);
        item.setDescription("Item #" + itemNum + "of partner#" + partnerNum );
        item.setCategory(category);
        item.setPrice(10*itemNum);
        item.setProperties(createItemPropertis(itemNum));
        return item;
    }

}
