package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void canFindWhiskiesOfYear12(){
		List<Whisky> foundWhiskies = whiskyRepository.findByYear(12);
		assertEquals(6, foundWhiskies.size());
	}

	@Test
	void canGetDistilleriesFromSpeyside(){
		List<Distillery> foundDistilleries = distilleryRepository.findByRegion("Speyside");
		assertEquals(3, foundDistilleries.size());
	}

	@Test
	void canGetSpecificAgeWhiskyFromSpecificDistillery(){
		List<Whisky> foundWhiskies = whiskyRepository.findByAgeAndDistilleryId(2014, 13L);
		assertEquals(1, foundWhiskies.size());
	}

	@Test
	void canGetAllWhiskyFromSpecificRegion(){
		List<Whisky> foundWhiskies = whiskyRepository.findByDistilleryRegion("Speyside");
		assertEquals(3, foundWhiskies.size());
	}

	@Test
	void canGetDistilleriesThatHaveWhiskiesThatAre12YearsOld(){
		List<Distillery> foundDistilleries = distilleryRepository.findByWhiskiesYear(12);
		assertEquals(6, foundDistilleries.size());
	}
}
