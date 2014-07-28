package present.play;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import present.dao.interfaces.ItemDAO;
import present.entity.Item;

/**
 * Created by Kos on 22.07.2014.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Starter starter = (Starter)applicationContext.getBean("Starter");
        ItemDAO itemDAO = (ItemDAO)applicationContext.getBean("itemDAO");
        Item item = new Item();
        item.description="Descript";
        itemDAO.save(item);
        starter.doProgram();
    }

}
