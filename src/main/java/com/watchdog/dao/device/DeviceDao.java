package com.watchdog.dao.device;

import com.watchdog.business.Device;

import java.util.List;

/**
 * Created by BBuck on 10/4/16.
 */

// CRUD operations
public interface DeviceDao {


    //Create
    void save (Device device);


    //Read
    Device getById (int id);

    public String getDeviceNameByVidId(int id);

    boolean checkDeviceNameExists(String deviceName);

    boolean checkMacExists(String mac);

    //Update
    void update (Device device);

    //Delete
    void deleteById (int id);


    //Get all
    List<Device> getAll();
}
