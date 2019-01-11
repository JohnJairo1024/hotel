package com.example.repo;

import com.example.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepo extends JpaRepository<Chat, Long> {


    /**
     * Gives chat between users, where:
     *
     * @param idTo   - id of sender of the message.
     * @param idFrom - id of receiver of the message.
     * @return chat between two users;
     */
    Chat findByMessageSendToIdAndMessageSendFromId(long idTo, long idFrom);

    /**
     * Gives list of chats of given user.
     *
     * @param id - id of user whose chats are on the list.
     * @return
     */
    List<Chat> findAllByUserId(long id);


}
