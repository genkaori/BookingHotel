package vn.framgia.service;

import vn.framgia.bean.ItemBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 08/03/2017.
 *
 */
public interface IItemService extends Serializable {

    public List<ItemBean> getAllItems();
    public boolean addItem(ItemBean serviceBean);
    public boolean updateItem(ItemBean serviceBean);
    public boolean deleteItem(int id);
    public ItemBean getItemBeanById(int id);
    public List<ItemBean> findItemByName(String seriveName);
}
