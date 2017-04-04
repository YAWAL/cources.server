package com.softgroup.common.dao.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "conversation_members")
public class ConversationMemberEntity implements Serializable{

    private static final long serialVersionUID = -1904453545312427708L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "conversation_id")
    private String conversationId;

    @Column(name = "profile_id")
    private String profileId;

    @Column(name = "last_message_id")
    private String lastMessageId;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "join_date")
    private long joinDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getLastMessageId() {
        return lastMessageId;
    }

    public void setLastMessageId(String lastMessageId) {
        this.lastMessageId = lastMessageId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public long getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(long joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConversationMemberEntity that = (ConversationMemberEntity) o;

        if (isDeleted != that.isDeleted) return false;
        if (joinDate != that.joinDate) return false;
        if (!id.equals(that.id)) return false;
        if (!conversationId.equals(that.conversationId)) return false;
        if (!profileId.equals(that.profileId)) return false;
        return lastMessageId.equals(that.lastMessageId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + conversationId.hashCode();
        result = 31 * result + profileId.hashCode();
        result = 31 * result + lastMessageId.hashCode();
        result = 31 * result + (isDeleted ? 1 : 0);
        result = 31 * result + (int) (joinDate ^ (joinDate >>> 32));
        return result;
    }
}
