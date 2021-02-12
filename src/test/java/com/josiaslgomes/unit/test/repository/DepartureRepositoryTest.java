package com.josiaslgomes.unit.test.repository;

import com.josiaslgomes.unit.test.model.Departure;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class DepartureRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DepartureRepository departureRepository;

    @Test
    public void findAll() throws Exception {
        //given
        Departure firstDeparture = new Departure();
        firstDeparture.setCity("Yerevan");
        entityManager.persist(firstDeparture);
        entityManager.flush();

        Departure secondDeparture = new Departure();
        secondDeparture.setCity("Israel");
        entityManager.persist(secondDeparture);
        entityManager.flush();

        //when
        List<Departure> arrivals = departureRepository.findAll();

        //then
        assertThat(arrivals.size()).isEqualTo(9);
        assertThat(arrivals.get(7)).isEqualTo(firstDeparture);
        assertThat(arrivals.get(8)).isEqualTo(secondDeparture);
    }

    @Test
    public void findAllById() throws Exception {
        //given
        Departure arrival = new Departure();
        arrival.setCity("Yerevan");
        entityManager.persist(arrival);
        entityManager.flush();

        //when
        Departure testArrival = departureRepository.findAllById(arrival.getId());

        //then
        assertThat(testArrival.getCity()).isEqualTo(arrival.getCity());
    }

}