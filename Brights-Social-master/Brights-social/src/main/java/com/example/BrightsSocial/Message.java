package com.example.BrightsSocial;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Message{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "messagebody")
    private String messageBody;
    private String sender;
   // private LocalTime now;

    @ManyToOne
    private People people;



    private LocalDateTime time;
   // private String date;

    public Message() {
    }

    public Message(Long id, String messageBody, String sender, LocalDateTime time) {
        this.id = id;
        this.messageBody = messageBody;
        this.sender = sender;
        this.time = time;
    }

    public Message( String messageBody, String sender, LocalDateTime time) {
        this.messageBody = messageBody;
        this.sender = sender;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /*  public void setId(long id) {
        this.id = id;
    }*/

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

   /* public String getDate(){
        return date;
    }*/

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTime() {
        String date = time.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        return date;
    }



    @Override
    public String toString() {
        return "Message{" +
                "messageBody='" + messageBody + '\'' +
                ", sender='" + sender + '\'' +
                ", time=" + getTime() +
                '}';
    }
}
