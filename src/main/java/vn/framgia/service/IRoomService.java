package vn.framgia.service;

import vn.framgia.bean.RoomBean;
import java.io.Serializable;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public interface IRoomService extends Serializable {

    public List<RoomBean> findAllRooms();
    public boolean addRoom(RoomBean roomBean);
    public boolean deleteRoom(int id);
    public RoomBean getRoomById(int id);
    public boolean udpateRoom(RoomBean roomBean);
    public List<RoomBean> getRoomByRoomName(String roomNameSearch);
}
