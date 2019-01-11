package com.example.services;

import com.example.entity.Chat;
import com.example.entity.User;
import com.example.repo.ChatRepo;
import com.example.service.ChatService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ChatServiceTest {

	private ChatRepo chatRepo;
	private ChatService chatService;
	private User user;
	
	@Before
	public void setUp() {
		chatRepo=mock(ChatRepo.class);
		chatService= new ChatService(chatRepo);
		user = new User(1);
	}
	
	@Test
	public void testFindAllByUserId() {
		
		//given
		Chat first = new Chat();
		Chat second = new Chat();
		first.setUser(new ArrayList(Arrays.asList(user)));
		second.setUser(new ArrayList(Arrays.asList(user)));
		List<Chat> list = Arrays.asList(first, second);
		when(chatRepo.findAllByUserId(1)).thenReturn(list);
		
		//when
		List<Chat> result = chatService.findAllByUserId(1);
		
		//then
		assertEquals(list, result);
		assertEquals(first, result.get(0));
	}

	@Test
	public void testFindOne() {
		
		//given
		Chat first = new Chat(1);
		when(chatRepo.findOne(1l)).thenReturn(first);
		//when
		Chat result = chatService.findOne(1);
		//then
		assertEquals(first, result);
	}

}
