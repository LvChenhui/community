package com.wl.lch.service;

import com.wl.lch.dto.NotificationDTO;

import java.util.List;

public interface NotificationService {

    public int messageCount(String accountNumber);

    public List<NotificationDTO> getNotification(int id);

    public String delNotification(int id);


}
