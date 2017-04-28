package demo;

import java.time.Instant;

public class EsDocument {

    String id;
    String messageText;
    Instant instant;

    public EsDocument(String id, String messageText) {
        this.id = id;
        this.messageText = messageText;
    }

    public EsDocument() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }
}
