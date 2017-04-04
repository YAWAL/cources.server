package com.softgroup.common.dao.api.entities;

import com.softgroup.common.dao.api.util.MessageStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "message_statuses")
public class MessageStatusEntity implements Serializable {

    private static final long serialVersionUID = 4094556399039981410L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "message_status")
    private MessageStatus messageStatus;

    @Column(name = "status_update_time")
    private long statusUpdateTime;

    @Column(name = "profile_id")
    private String profileId;

    @Column(name = "sender_id")
    private String senderId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MessageStatus getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(MessageStatus messageStatus) {
        this.messageStatus = messageStatus;
    }

    public long getStatusUpdateTime() {
        return statusUpdateTime;
    }

    public void setStatusUpdateTime(long statusUpdateTime) {
        this.statusUpdateTime = statusUpdateTime;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageStatusEntity that = (MessageStatusEntity) o;

        if (statusUpdateTime != that.statusUpdateTime) return false;
        if (!id.equals(that.id)) return false;
        if (messageStatus != that.messageStatus) return false;
        if (!profileId.equals(that.profileId)) return false;
        return senderId.equals(that.senderId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + messageStatus.hashCode();
        result = 31 * result + (int) (statusUpdateTime ^ (statusUpdateTime >>> 32));
        result = 31 * result + profileId.hashCode();
        result = 31 * result + senderId.hashCode();
        return result;
    }
}
