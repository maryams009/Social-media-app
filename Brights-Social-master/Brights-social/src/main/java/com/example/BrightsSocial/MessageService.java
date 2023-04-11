package com.example.BrightsSocial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    PeopleService peopleService;

    List<Message> getAllMessages(){
        List<Message> allMessages =messageRepository.findAllMessages();
        return allMessages;
    }

    void saveMessage(Message message, String name){
        LocalDateTime time = LocalDateTime.now();

        if(message.getId() ==0){
            message = new Message( message.getId(), message.getMessageBody(),name,time);
            message.setPeople(peopleService.findUser(name));
            messageRepository.save(message);
        }else{
            message.setMessageBody(message.getMessageBody());
            message.setTime(time);
            message.setPeople(peopleService.findUser(name));
            message.setSender(message.getSender());
            message.setId(message.getId());
            messageRepository.save(message);
        }
        messageRepository.save(message);
    }

    void deleteMessage(Long id){
        Message message = getMessageById(id);
        messageRepository.delete(message);
    }

    Message getMessageById(long id){
        Message message = messageRepository.findById(id).get();
        return message;
    }

}
