package com.example.services;

import com.example.entity.Hotel;
import com.example.entity.Image;
import com.example.entity.Localization;
import com.example.entity.User;
import com.example.repo.HotelRepo;
import com.example.service.HotelService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class HotelServiceTest {

	private HotelRepo hotelRepo;
	private HotelService hotelService;
	
	@Before
	public void setUp() {
		hotelRepo=mock(HotelRepo.class);
		hotelService= new HotelService(hotelRepo);
	}
	
	@Test
	public void testFindAllByHOwnerId() {
		Hotel first = new Hotel();
		Hotel second = new Hotel();
		User owner = new User(1);
		first.sethOwner(owner);
		second.sethOwner(owner);
		List<Hotel> list = Arrays.asList(first,second);
		when(hotelRepo.findAllByHOwnerId(1)).thenReturn(list);
		List<Hotel> result = hotelService.findAllByHOwnerId(1);
		
		assertEquals(list, result);
		assertThat(result).hasOnlyElementsOfType(Hotel.class);
	}

	@Test
	public void testFindById() {
		Hotel first = new Hotel();
		first.setId(1l);
		
		when(hotelRepo.findOne(1l)).thenReturn(first);
		
		Hotel result = hotelService.findById(1);
		assertEquals(first, result);
		assertThat(result).isExactlyInstanceOf(Hotel.class);
	}

	@Test
	public void testAddHotel() {
		//creates hotel and checks whether attributes added by method are null
		Hotel first = new Hotel();
		when(hotelRepo.findOne(1l)).thenReturn(first);
		Assertions.assertThat(hotelService.findById(1).getAddress()).isNull();
		Assertions.assertThat(hotelService.findById(1).gethOwner()).isNull();
		Assertions.assertThat(hotelService.findById(1).getImages()).isNull();
		
		//creates attributes that are added to hotel while using method
		Image image = new Image();
		Localization localization = new Localization();
		User user = new User();
		
		//adding attributes to hotel and saving the hotel to database
		hotelService.addHotel(first, image, localization, user);
		
		//returns hotel from database
		Hotel result = hotelService.findById(1);
		
		assertThat(result).isNotNull();
		assertEquals(first.getId(), result.getId());
		assertEquals(first.getImages(), result.getImages());
		assertEquals(first.getAddress(), result.getAddress());
		assertEquals(first.gethOwner(), result.gethOwner());
		
	}

}
