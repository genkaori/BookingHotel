package vn.framgia.dao.impl;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import vn.framgia.bean.RoomBean;
import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IRoomDAO;
import vn.framgia.model.Room;

import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class RoomDAOImpl extends GenericDAO<Room, Integer> implements IRoomDAO {
    public RoomDAOImpl() {
        super.setPersistentClass(Room.class);
    }

    @Override
    public List<RoomBean> getRoomByRoomName(String roomName) {
        if(roomName.isEmpty()) {
            return null;
        }
        Criteria criteria = getSession().createCriteria(Room.class);
        criteria.add(Restrictions.like("name","%"+roomName+"%"));
        List<RoomBean> roomBeanList = criteria.list();
        return roomBeanList;
    }
}
