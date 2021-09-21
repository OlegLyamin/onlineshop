package com.oleglmn.onlineshop.service;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.oleglmn.onlineshop.domain.dto.CartDto;
import com.oleglmn.onlineshop.domain.dto.ProductDto;
import com.oleglmn.onlineshop.domain.model.Cart;
import com.oleglmn.onlineshop.domain.model.Product;
import com.oleglmn.onlineshop.repository.CartRepository;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
@XRayEnabled
public class OrderService {
    private final AWSCredentialsProvider awsCredentialsProvider;
    private final CartRepository cartRepository;

    {
        String awsAccessKey = "лул";
        String awsSecretKey = "кек";
        awsCredentialsProvider = new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
    }

    AmazonSQS sqs = AmazonSQSClientBuilder.standard().withCredentials(awsCredentialsProvider).withRegion(Regions.EU_CENTRAL_1).build();

    public OrderService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    private static ProductDto mapProductToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setTitle(product.getTitle());
        productDto.setId(product.getId());
        return productDto;
    }

    public void checkout(Long cartId) {
        Optional<Cart> byId = cartRepository.findById(cartId);
        byId.ifPresent(cart -> {
            CartDto cartDto = new CartDto();
            cartDto.setId(cart.getId());
            cartDto.setProducts(cart.getProducts()
                .stream()
                .map(OrderService::mapProductToProductDto)
                .collect(Collectors.toList()));
            System.out.println(cartDto);
            sendMessageToSqs(cartDto);
        });
    }

    private void sendMessageToSqs(CartDto cartDto) {
        SendMessageRequest sendMsgRequest = new SendMessageRequest()
            .withQueueUrl("https://sqs.eu-central-1.amazonaws.com/076837623726/onlineshop-checkout")
            .withMessageBody(cartDto.toString())
            .withDelaySeconds(5);
        sqs.sendMessage(sendMsgRequest);
    }
}
