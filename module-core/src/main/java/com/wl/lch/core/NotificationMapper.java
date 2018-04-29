package com.wl.lch.core;

import com.wl.lch.entity.Notification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NotificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notification record);

    int insertSelective(Notification record);

    Notification selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notification record);

    int updateByPrimaryKey(Notification record);

    public int selectMessageCount(@Param("toUserId") int toUserId);

    public List<Notification> selectByToUserId(@Param("toUserId") int toUserId);

    public int updateByToUserId(@Param("toUserId") int toUserId);
}