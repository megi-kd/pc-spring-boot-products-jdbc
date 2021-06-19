package com.pc.product;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pc.product.controller.ProductParams;
import com.pc.product.controller.ProductParams.ProductType;
import com.pc.product.controller.ProductParams.PropertyName;
import com.pc.product.controller.PropertyValue;
import com.pc.product.model.ProductResource;
import com.pc.product.repository.ProductJdbcRepository;

@SpringBootTest
class ProductRepositoryTests {

	@Autowired
	private ProductJdbcRepository productRepo;

	@Test
	void contextLoads() {
		assertNotNull(this.productRepo, "the productRepo should be non-null");
	}

	@Test
	public void testLoadingResultInDatabase() {
		List<ProductResource> result = productRepo.findByProductParams(new ProductParams());
		assertNotNull(result, "there are product found in the database");
		assertTrue(result.size() == 100, "there are exact 100 elements in the product table");
	}

	@Test
	public void testFindByType() {
		List<ProductResource> resultSubscriptions = productRepo
				.findByProductParams(new ProductParams(ProductType.subscription, null, null, null, null));
		assertTrue(resultSubscriptions.size() == 58, "there are 58 product with type=subscription");

		List<ProductResource> resultPhones = productRepo
				.findByProductParams(new ProductParams(ProductType.phone, null, null, null, null));
		List<ProductResource> checkForSubscriptionType = resultPhones.stream()
				.filter(p -> p.getType().equals(ProductType.subscription.name())).collect(Collectors.toList());
		assertTrue(resultPhones.size() == 42, "there are 42 product with type=phone");
		assertTrue(checkForSubscriptionType.isEmpty(), "there are no product with type=subcription");
	}

	@Test
	public void testFindByTypeAndColor() {
		PropertyValue propertyVal = new PropertyValue(PropertyName.color, "brun", null, null);
		List<ProductResource> results = productRepo
				.findByProductParams(new ProductParams(ProductType.phone, null, null, null, propertyVal));
		assertTrue(results.size() == 5, "there are 5 products with type=phone, properties= color:brun");
	}



	@Test
	public void testByTypeCityMaxPriceAndMinPrice() {

		List<ProductResource> result = productRepo.findByProductParams(new ProductParams(ProductType.subscription, 700d, 1000d, "Stockholm", null));
		assertTrue(result.size() == 9,
				"there are 9 products with type=subscription and price >=700 and price<=1000 and city=Stockholm");
		
		List<ProductResource> checkForPriceLessThan = result.stream().filter(p -> {return Double.valueOf(p.getPrice()) < 700d ; }).collect(Collectors.toList());
		assertTrue(checkForPriceLessThan.isEmpty(), " there are no product which price is less than 700");
	}

}
