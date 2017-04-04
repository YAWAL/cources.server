package com.softgroup.common.dao.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "devices")
public class DeviceEntity implements Serializable {

    private static final long serialVersionUID = -506229924089552354L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "profile_id")
    private String profileId;

    @Column(name = "last_confirmation_data")
    private long lastConfirmationData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public long getLastConfirmationData() {
        return lastConfirmationData;
    }

    public void setLastConfirmationData(long lastConfirmationData) {
        this.lastConfirmationData = lastConfirmationData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceEntity that = (DeviceEntity) o;

        if (lastConfirmationData != that.lastConfirmationData) return false;
        if (!id.equals(that.id)) return false;
        if (!deviceId.equals(that.deviceId)) return false;
        return profileId.equals(that.profileId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + deviceId.hashCode();
        result = 31 * result + profileId.hashCode();
        result = 31 * result + (int) (lastConfirmationData ^ (lastConfirmationData >>> 32));
        return result;
    }
}
