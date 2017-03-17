package vn.framgia.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import vn.framgia.bean.ItemBean;
import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IItemDAO;
import vn.framgia.model.Item;

import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 08/03/2017.
 *
 */
public class ItemDAOImpl extends GenericDAO<Item, Integer> implements IItemDAO {
    public ItemDAOImpl() {
        super.setPersistentClass(Item.class);
    }

    @Override
    public List<ItemBean> findItemByName(String serviceName) {
        if(serviceName.isEmpty()) {
            return null;
        }
        Criteria criteria = getSession().createCriteria(Item.class);
        criteria.add(Restrictions.like("name","%"+serviceName+"%"));
        List<ItemBean> list = criteria.list();
        return list;
    }
}
