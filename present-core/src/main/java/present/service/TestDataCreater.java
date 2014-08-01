package present.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import present.dao.interfaces.*;
import present.entity.*;
import javax.transaction.Transactional;
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
        Category categoryRoot = new Category();

        categoryRoot.setTitle("Root category");
        categoryRoot.setDescription("Root categody (description)");
        categoryChild.setTitle("Child category");
        categoryChild.setDescription("Child category (description)");
    //  categoryChild.setParent(categoryRoot);

        categoryDAO.save(categoryRoot);
        categoryDAO.save(categoryChild);

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
