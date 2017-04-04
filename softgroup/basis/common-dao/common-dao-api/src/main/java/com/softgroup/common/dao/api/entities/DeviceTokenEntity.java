package com.softgroup.common.dao.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "device_tokens")
public class DeviceTokenEntity implements Serializable{
    private static final long serialVersionUID = -1113598978656645638L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "create_time")
    private long createTime;

    @Column(name = "profile_id")
    private String profileId;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "token_type")
    private String tokenType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceTokenEntity that = (DeviceTokenEntity) o;

        if (createTime != that.createTime) return false;
        if (!id.equals(that.id)) return false;
        if (!profileId.equals(that.profileId)) return false;
        if (!deviceId.equals(that.deviceId)) return false;
        return tokenType.equals(that.tokenType);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (int) (createTime ^ (createTime >>> 32));
        result = 31 * result + profileId.hashCode();
        result = 31 * result + deviceId.hashCode();
        result = 31 * result + tokenType.hashCode();
        return result;
    }
}
