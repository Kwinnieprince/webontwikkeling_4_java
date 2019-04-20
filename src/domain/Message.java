package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.Date;

public class Message {
    @JsonIgnore
    private Person sender;
    @JsonIgnore
    private Person receiver;
    @JsonIgnore
    private String message;
    @JsonIgnore
    private Date now;

    public Message(Person sender, Person receiver, String message){
        setSender(sender);
        setReceiver(receiver);
        setMessage(message);
        now = new Date();
    }

    public Message(){}

    private void setSender(Person sender){
        if (sender != null){
            this.sender = sender;
        }else {
            throw new IllegalArgumentException("Sender is empty");
        }
    }

    private void setMessage(String message) {
        if (message != null){
            this.message = message;
        }else {
            throw new IllegalArgumentException("Message is empty");
        }
    }

    private void setReceiver(Person receiver) {
        if (receiver != null){
            this.receiver = receiver;
        }else {
            throw new IllegalArgumentException("Receiver is empty");
        }
    }

    public Person getSender(){
        return sender;
    }

    public Person getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public Date getDateOfCreation(){
        return now;
    }
}

