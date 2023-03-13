package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery",ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String hostname;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(hostname + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }

    public URI createNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(hostname + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto){
         restTemplate.put(hostname + BEER_PATH_V1 + "/" + uuid.toString(), beerDto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(hostname + BEER_PATH_V1 + "/" + uuid.toString());
    }

    public CustomerDto getCustomerById(UUID uuid){
        return restTemplate.getForObject(hostname + CUSTOMER_PATH_V1 + uuid.toString(),CustomerDto.class);
    }

    public URI saveCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(hostname + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto){
        restTemplate.put(hostname + CUSTOMER_PATH_V1 + "/" + uuid.toString(), customerDto);
    }
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }


}
