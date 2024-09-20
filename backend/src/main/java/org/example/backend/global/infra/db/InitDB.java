package org.example.backend.global.infra.db;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.backend.domain.board.category.model.entity.Category;
import org.example.backend.domain.board.category.repository.CategoryRepository;
import org.example.backend.domain.board.model.entity.ProductBoard;
import org.example.backend.domain.board.model.entity.ProductThumbnailImage;
import org.example.backend.domain.board.product.model.entity.Product;
import org.example.backend.domain.board.product.repository.ProductRepository;
import org.example.backend.domain.board.repository.ProductBoardRepository;
import org.example.backend.domain.board.repository.ProductThumbnailImageRepository;
import org.example.backend.domain.company.model.entity.Company;
import org.example.backend.domain.company.repository.CompanyRepository;
import org.example.backend.domain.orders.model.entity.OrderedProduct;
import org.example.backend.domain.orders.model.entity.Orders;
import org.example.backend.domain.orders.repository.OrderedProductRepository;
import org.example.backend.domain.orders.repository.OrdersRepository;
import org.example.backend.global.common.constants.BoardStatus;
import org.example.backend.global.common.constants.OrderStatus;
import org.example.backend.global.common.constants.PaymentType;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final CategoryRepository categoryRepository;
    private final ProductBoardRepository productBoardRepository;
    private final ProductRepository productRepository;
    private final ProductThumbnailImageRepository productThumbnailImageRepository;
    private final CompanyRepository companyRepository;
    private final OrdersRepository ordersRepository;
    private final OrderedProductRepository orderedProductRepository;
    private List<Category> categories;
    private List<ProductBoard> productBoards;

    private List<Orders> ordersList;


    @PostConstruct
    public void execute() {
        insertCategory();
        insertBoard();
        insertProduct();
        insertProductThumbnailImage();
        insertOrders();
        insertOrderedProducts();
    }
    private void insertCategory(){
        List<String> categoryNames = List.of("식품", "의류", "뷰티", "라이프");
        categories = categoryNames.stream()
                .map(name -> Category.builder().name(name).build())
                .collect(Collectors.toList());

       categoryRepository.saveAll(categories);
    }

    private void insertBoard(){

        if (categories.size() == 0) {
            return;
        }

        Company company = companyRepository.save(Company.builder()
            .idx(1L)
            .email("company@gmail.com")
            .address("address1")
            .addressDetail("addressDetail1")
            .emailStatus(true)
            .mosNumber("mosNumber")
            .companyName("심키즈 업체")
            .regStatus(true)
            .build());

        productBoards = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            productBoards.add(ProductBoard.builder()
                .title("[음성명작]500m 고랭지에서 수확한 사과1.3kg[품종:홍로] " + i)
                .discountRate(23)
                .startedAt(LocalDateTime.now().plusDays(1))
                .endedAt(LocalDateTime.now().plusDays(2))
                .category(categories.get(i % 4))
                .productThumbnailUrl("sample-thumnail-url")
                .productDetailUrl("sample-detail-url")
                .status(BoardStatus.READY.getStatus())
                .minimumPrice(15900)
                .company(company)
                .build());
        }

        for (int i = 0; i < 10; i++) {
            productBoards.add(ProductBoard.builder()
                .title("[음성명작]500m 고랭지에서 수확한 사과1.3kg[품종:홍로] " + (10 + i))
                .discountRate(23)
                .startedAt(LocalDateTime.now())
                .endedAt(LocalDateTime.now().plusDays(1))
                .category(categories.get(i % 4))
                .productThumbnailUrl("sample-thumnail-url")
                .productDetailUrl("sample-detail-url")
                .status(BoardStatus.OPEN.getStatus())
                .minimumPrice(15900)
                .company(company)
                .build());
        }

        for (int i = 0; i < 10; i++) {
            productBoards.add(ProductBoard.builder()
                .title("[음성명작]500m 고랭지에서 수확한 사과1.3kg[품종:홍로] " + (20 + i))
                .discountRate(23)
                .startedAt(LocalDateTime.now().minusMonths(i+1).plusDays(1))
                .endedAt(LocalDateTime.now().minusMonths(i+1).plusDays(3))
                .category(categories.get(i % 4))
                .productThumbnailUrl("sample-thumnail-url")
                .productDetailUrl("sample-detail-url")
                .status(BoardStatus.DONE.getStatus())
                .minimumPrice(15900)
                .company(company)
                .build());
        }

        productBoardRepository.saveAll(productBoards);
    }
    private void insertProduct() {

        if (productBoards.size() == 0) {
            return;
        }

        List<Product> products = new ArrayList<>();
        for (int i=0; i<productBoards.size();i++) {
            for (int j=0;j<2;j++) {
                products.add(Product.builder()
                        .name("상품 " + j)
                        .stock(5)
                        .price(20900) //(i + 1) * 10000
                        .productBoard(productBoards.get(i))
                        .build());
            }
        }

        productRepository.saveAll(products);
    }

    private void insertProductThumbnailImage() {
        if (productBoards.size() == 0) {
            return;
        }
        List<ProductThumbnailImage> productThumbnailImages = new ArrayList<>();
        for (int i=0; i < productBoards.size(); i++) {
            for (int j = 0; j < 2; j++) {
                productThumbnailImages.add(ProductThumbnailImage.builder()
                    .productThumbnailUrl("sample-thumnail-url" + i)
                    .productBoard(productBoards.get(i))
                    .build());
            }
        }
        productThumbnailImageRepository.saveAll(productThumbnailImages);
    }

    private void insertOrders() {
        if (productBoards.isEmpty()) {
            return;
        }

        ordersList = new ArrayList<>();

        for (int i = 0; i < productBoards.size(); i++) {
            ProductBoard board = productBoards.get(i);

            // PaymentType을 번갈아 설정 (짝수: KAKAO_PAY, 홀수: TOSS_PAY)
            PaymentType paymentType = (i % 2 == 0) ? PaymentType.KAKAO_PAY : PaymentType.TOSS_PAY;

            // OrderStatus를 번갈아 설정 (짝수: ORDER_COMPLETE, 홀수: ORDER_CANCEL)
            OrderStatus orderStatus = (i % 2 == 0) ? OrderStatus.ORDER_COMPLETE : OrderStatus.ORDER_CANCEL;

            // createdAt을 1, 3, 6, 9, 12개월 전으로 설정
            LocalDateTime createdAt = LocalDateTime.now().minusMonths((i % 5 + 1) * 3); // 1, 3, 6, 9, 12개월

            Orders order = Orders.builder()
                    .boardIdx(board.getIdx())
                    .receiverName("심키즈")
                    .receiverPhoneNumber("010-1234-5678")
                    .address("서울특별시 중구")
                    .addressDetail("101동 101호")
                    .postNumber("04567")
                    .paymentId("PAY-" + (i + 1))
                    .status(orderStatus) // 설정한 orderStatus 적용
                    .payMethod(paymentType) // 설정한 paymentType 적용
                    .usedPoint(4444)
                    .build();

            ordersList.add(order);
        }

        ordersRepository.saveAll(ordersList);
    }

    private void insertOrderedProducts() {
        if (ordersList.isEmpty()) {
            return;
        }

        List<OrderedProduct> orderedProductsList = new ArrayList<>();
        for (Orders order : ordersList) {
            Product product = productRepository.findById(order.getBoardIdx()).orElse(null);
            if (product == null) {
                continue;
            }

            orderedProductsList.add(OrderedProduct.builder()
                    .quantity(2)
                    .orders(order)
                    .product(product)
                    .build());
        }

        orderedProductRepository.saveAll(orderedProductsList);
    }
}
