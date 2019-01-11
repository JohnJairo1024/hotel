package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "message_id")
    private List<Message> message;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<User> user;

    //------------------------

    public Chat() {
    }

    public Chat(long id) {
        this.setId(id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }


}
