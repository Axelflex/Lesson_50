package com.example.lesson50.utils;

import com.example.lesson50.dao.*;
import com.example.lesson50.model.Event;
import com.example.lesson50.model.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@AllArgsConstructor
@Configuration
public class InitDatabase {

    private final EventDAO eventDao;
    private final SubscribeEventDAO subscriptionDao;
    private final UserDAO userDao;
    private final PublicationDAO publicationDAO;
    private final LikeDAO likeDAO;
    private final CommentDAO commentDAO;
    private final FollowDAO followDAO;
    private final PasswordEncoder encoder;


    @Bean
    public CommandLineRunner fillData() {
        return (args) -> {
            subscriptionDao.deleteAll();
            eventDao.deleteAll();

            eventDao.createEvent(Event.builder().name("Make the shelter").description("Make it sturdy").dateTime(LocalDateTime.now().minusDays(1)).build());
            eventDao.createEvent(Event.builder().name("Repair the shelter").description("Make it safe and cozy.").dateTime(LocalDateTime.now().plusDays(1)).build());
            eventDao.createEvent(Event.builder().name("Gather some firewood").description("To keep the fireplace running").dateTime(LocalDateTime.now().plusDays(1)).build());
            eventDao.createEvent(Event.builder().name("Winter is coming!").description("Survive the winter!").dateTime(LocalDateTime.now().plusDays(1)).build());

            followDAO.deleteAll();
            commentDAO.deleteAll();
            likeDAO.deleteAll();
            publicationDAO.deleteAll();
            userDao.deleteAll();

            User user1 = new User();
            user1.setNickname("TestT");
            user1.setEmail("test@test");
            user1.setName("test");
            user1.setPassword(encoder.encode("test"));
            userDao.save(user1);

            User user2 = new User();
            user2.setNickname("GuestG");
            user2.setEmail("guest@test");
            user2.setName("guest");
            user2.setPassword(encoder.encode("guest"));
            userDao.save(user2);

            User user3 = new User();
            user3.setNickname("AdminN");
            user3.setEmail("admin@test");
            user3.setName("admin");
            user3.setPassword(encoder.encode("admin"));
            userDao.save(user3);

        };
    }
}
