package com.ijes.bookstore;

import com.ijse.bookstore.config.RabbitMQConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {RabbitMQConfig.class})
class BookstoreApplicationTests {

	@Test
	void contextLoads() {
	}

}
