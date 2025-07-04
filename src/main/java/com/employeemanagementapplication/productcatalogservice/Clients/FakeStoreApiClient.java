package com.employeemanagementapplication.productcatalogservice.Clients;

import com.employeemanagementapplication.productcatalogservice.Services.FakeStoreProductService;
import com.employeemanagementapplication.productcatalogservice.dtos.FakeStoreProductDto;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreApiClient {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductDto replaceFakeStoreProduct(FakeStoreProductDto fakeStoreProductDtoInput, Long id){
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = requestForEntity(HttpMethod.PUT, "https://fakestoreapi.com/products/{id}", fakeStoreProductDtoInput, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDtoOutput = fakeStoreProductDtoResponseEntity.getBody();

        if(validateResponse(fakeStoreProductDtoResponseEntity))
        {
            return fakeStoreProductDtoOutput;
        }
        return null;
    }

    private boolean validateResponse(ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity) {
        if(fakeStoreProductDtoResponseEntity.getBody() != null && fakeStoreProductDtoResponseEntity.getStatusCode() == HttpStatusCode.valueOf(200)) {
            return true;
        }
        return false;
    }

    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url,httpMethod, requestCallback, responseExtractor, uriVariables);
    }
}
