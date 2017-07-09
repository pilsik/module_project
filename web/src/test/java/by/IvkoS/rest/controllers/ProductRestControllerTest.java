package by.IvkoS.rest.controllers;

import by.IvkoS.mongodb.models.Product;
import by.IvkoS.mongodb.services.ProductService;
import javafx.print.Collation;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-rest-config.xml", "classpath:spring-rest-config.xml"})
public class ProductRestControllerTest{

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductRestController productRestController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(productRestController).build();
    }

    @Test
    public void getProductById() throws Exception {
        Product product = new Product("43", "43", "43", new String[]{}, 43, "43");
        when(productService.get(43L)).thenReturn(product);
        this.mockMvc.perform(get("/rest/products/id/43").accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is("43")))
                .andDo(MockMvcResultHandlers.print());
        verify(productService, times(1)).get(43L);
        verifyNoMoreInteractions(productService);

        /*MvcResult result = springMvc.perform(MockMvcRequestBuilders
                .get("/jobsdetails/2").accept(MediaType.APPLICATION_JSON)).andReturn();
        String content = result.getResponse().getContentAsString();*/

    }

}