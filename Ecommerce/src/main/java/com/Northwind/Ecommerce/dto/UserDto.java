package com.Northwind.Ecommerce.dto;

import com.Northwind.Ecommerce.entity.Address;
import com.Northwind.Ecommerce.entity.orderItems;
import com.Northwind.Ecommerce.enums.userRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private String role;

    private AddressDto address;
    private List<OrderItemDto> orderItemList;
}