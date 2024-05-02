package org.example;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
        private static final List<Product> products = List.of(
                new Product("1", "상품A"),
                new Product("2", "상품B"),
                new Product("3", "상품C"),
                new Product("4", "상품D"),
                new Product("5", "상품E")
        );

        private final WebClient webClient;

        public ProductService(WebClient.Builder webClientBuilder) {
            this.webClient = webClientBuilder.build();
        }

        public List<Product> getProductsForMember(String memberId) {
            // Member Service에서 회원 정보 가져오기
            Member member = webClient.get()
                    .uri("http://localhost:8081/members/" + memberId)
                    .retrieve()
                    .bodyToMono(Member.class)
                    .block();

            if (member == null) return Collections.emptyList();

            // Permission Service에서 해당 회원의 권한 가져오기
            List<String> permittedProductIds = webClient.get()
                    .uri("http://localhost:8082/permissions/" + memberId)
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<String>>() {})
                    .block();

            if (permittedProductIds == null) return Collections.emptyList();

            // 회원의 권한에 따라 상품 필터링
            return products.stream()
                    .filter(p -> permittedProductIds.contains(p.getId()))
                    .collect(Collectors.toList());
        }
}
