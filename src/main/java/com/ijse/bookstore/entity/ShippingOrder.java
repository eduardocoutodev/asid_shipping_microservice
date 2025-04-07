package com.ijse.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class ShippingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shippingorder_id")
    private Long id;

    // Associação com a Order confirmada
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Associação com o utilizador que fez a encomenda
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Dados necessários para envio (que podem ou não coincidir com o perfil do user)
    private String address;
    private String city;
    private String postalCode;

    private LocalDate shippingDate;
    private String trackingNumber;
}

    /*
    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String email;

    @Column
    private String postal_code;
    
     */

}
