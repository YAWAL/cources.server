package com.softgroup.common.dao.api.entities;

import com.softgroup.common.dao.api.util.ConversationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "conversations")
public class ConversationEntity implements Serializable {

    private static final long serialVersionUID = -8700529675793334330L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "conversation_name")
    private String conversationName;

    @Column(name = "admin_id")
    private String adminId;

    @Column(name = "logo_uri")
    private String logoUri;

    @Column(name = "type")
    private ConversationType conversationType;

    @Column(name = "is_exist")
    private boolean isExist;

    @Column(name = "create_time")
    private long createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConversationName() {
        return conversationName;
    }

    public void setConversationName(String conversationName) {
        this.conversationName = conversationName;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getLogoUri() {
        return logoUri;
    }

    public void setLogoUri(String logoUri) {
        this.logoUri = logoUri;
    }

    public ConversationType getConversationType() {
        return conversationType;
    }

    public void setConversationType(ConversationType conversationType) {
        this.conversationType = conversationType;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConversationEntity that = (ConversationEntity) o;

        if (isExist != that.isExist) return false;
        if (createTime != that.createTime) return false;
        if (!id.equals(that.id)) return false;
        if (!conversationName.equals(that.conversationName)) return false;
        if (!adminId.equals(that.adminId)) return false;
        if (!logoUri.equals(that.logoUri)) return false;
        return conversationType == that.conversationType;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + conversationName.hashCode();
        result = 31 * result + adminId.hashCode();
        result = 31 * result + logoUri.hashCode();
        result = 31 * result + conversationType.hashCode();
        result = 31 * result + (isExist ? 1 : 0);
        result = 31 * result + (int) (createTime ^ (createTime >>> 32));
        return result;
    }
}
