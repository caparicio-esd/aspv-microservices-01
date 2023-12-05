package es.upm.dit.apsv.transportationorderserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.upm.dit.apsv.transportationorderserver.model.TransportationOrder;
import es.upm.dit.apsv.transportationorderserver.repository.TransportationOrderRepository;
import es.upm.dit.apsv.transportationorderserver.restcontroller.TransportationOrderController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value=TransportationOrderController.class)
public class TransportationOrderControllerTest {
    @InjectMocks
    private TransportationOrderController business;
    @MockBean
    private TransportationOrderRepository repository;
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testGetOrders() throws Exception {
        when(repository.findAll()).thenReturn(getAllTestOrders());
        
        RequestBuilder request = MockMvcRequestBuilders
            .get("/transportationorders")
            .accept(MediaType.APPLICATION_JSON);
        
        MvcResult result = mockMvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(20)))
            .andReturn();
    }
    
    @Test
    public void testGetOrderById() throws Exception {
    
    }
    
    private List<TransportationOrder> getAllTestOrders() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<TransportationOrder> orders = new ArrayList<>();
        TransportationOrder transportationOrder = null;
        File ordersFil = new ClassPathResource("orders.json").getFile();
        
        try (BufferedReader br = new BufferedReader(new FileReader(ordersFil))) {
            for (String line; (line = br.readLine()) != null;) {
                transportationOrder = objectMapper.readValue(line, TransportationOrder.class);
                orders.add(transportationOrder);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
