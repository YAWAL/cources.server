package com.softgroup.common.dao.api.entities;

import com.softgroup.common.dao.api.util.MessageType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "messages")
public class MessageEntity implements Serializable {

    private static final long serialVersionUID = -6779438608811972046L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "conversation_id")
    private String conversationId;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "message_type")
    private MessageType messageType;

    @Column(name = "payload")
    private String payload;

    @Column(name = "create_time")
    private long createTime;

    @Column(name = "server_receive_time")
    private long serverReceiveTime;

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

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getServerReceiveTime() {
        return serverReceiveTime;
    }

    public void setServerReceiveTime(long serverReceiveTime) {
        this.serverReceiveTime = serverReceiveTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (createTime != that.createTime) return false;
        if (serverReceiveTime != that.serverReceiveTime) return false;
        if (!id.equals(that.id)) return false;
        if (!conversationId.equals(that.conversationId)) return false;
        if (!senderId.equals(that.senderId)) return false;
        if (messageType != that.messageType) return false;
        return payload.equals(that.payload);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + conversationId.hashCode();
        result = 31 * result + senderId.hashCode();
        result = 31 * result + messageType.hashCode();
        result = 31 * result + payload.hashCode();
        result = 31 * result + (int) (createTime ^ (createTime >>> 32));
        result = 31 * result + (int) (serverReceiveTime ^ (serverReceiveTime >>> 32));
        return result;
    }
}
