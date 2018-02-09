package integration;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.netcracker.travelplanner.TravelPlannerApplication;
import com.netcracker.travelplanner.entities.Edge;
import com.netcracker.travelplanner.service.EdgeRepositoryService;
import com.netcracker.travelplanner.service.KiwiService;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TravelPlannerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class KiwiIntegrationTest {


    @Autowired
    private EdgeRepositoryService edgeRepositoryService;

    @Test
    public void edgesSavingTest(){


        KiwiService kiwiService = new KiwiService();

        List<Edge> edges = kiwiService.getEdgesFlights("Moscow"
                ,"Voronezh"
                ,LocalDate.of(2018,02,10)
                ,LocalDate.of(2018,02,10));

        edges.forEach(l -> System.out.println(l.toString()));

        edgeRepositoryService.addAll(edges);
    }

}
