package com.Northwind.Ecommerce.entity;


import com.Northwind.Ecommerce.enums.userRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "password is required")
    private String password;

   @Column(unique = true)
   @NotBlank(message = "email is required")
   private String email;

    @Column(name = "phone_number")
    @NotBlank(message = "phone number is required")
    private String phoneNumber;

    private userRole role;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<orderItems> orderItemsList;

    @Column(name = "created_at")
    private final LocalDateTime createdAt = LocalDateTime.now();
}
