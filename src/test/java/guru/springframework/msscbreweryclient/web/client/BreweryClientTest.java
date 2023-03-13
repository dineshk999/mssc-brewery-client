package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void createNewBeer() {
        BeerDto beerDto = new BeerDto();
        beerDto.setBeerName("Corona");
        beerDto.setBeerStyle("Can");
        URI uri = breweryClient.createNewBeer(beerDto);
        assertNotNull(uri);
    }

    @Test
    void updateBeer() {
        BeerDto beerDto = new BeerDto();
        beerDto.setBeerName("Corona");
        beerDto.setBeerStyle("Can");
        breweryClient.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    void deleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
       CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());
       assertNotNull(customerDto);
    }

    @Test
    void saveCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("DINESH KANDIMALLA").build();
        URI uri = breweryClient.saveCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("DINESH").build();
        breweryClient.updateCustomer(UUID.randomUUID(),customerDto);
    }
}