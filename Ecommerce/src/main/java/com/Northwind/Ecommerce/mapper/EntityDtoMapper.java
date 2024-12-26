package com.Northwind.Ecommerce.mapper;

import com.Northwind.Ecommerce.dto.*;
import com.Northwind.Ecommerce.entity.*;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoMapper {

    //user entity to user dto basic

    public UserDto mapUserToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole().name());
        userDto.setName(user.getName());
        return userDto;
    }

    //Address to Dto basic

    public AddressDto mapAddressToDto(Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setCountry(address.getCountry());
        addressDto.setZipcode(address.getZipcode());
        return addressDto;
    }

    //Category to Dto basic

    public CategoryDto mapCategoryToDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    //OrderItem to Dto basic
    public OrderItemDto mapOrderItemToDto(OrderItem orderItem){
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setPrice(orderItem.getPrice());
        orderItemDto.setStatus(orderItemDto.getStatus());
        orderItemDto.setCreatedAt(orderItem.getCreatedAt());
        return orderItemDto;
    }

    //Product to Dto basic
    public ProductDto mapProductToDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(productDto.getName());
        productDto.setDescription(productDto.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        return productDto;
    }

    //user to dto plus address

    public UserDto mapUserToDtoPlusAddress(User user){
        UserDto userDto = mapUserToDto(user);
        if(user.getAddress() !=null){
            AddressDto addressDto = mapAddressToDto(user.getAddress());
            userDto.setAddress(addressDto);
        }
        return userDto;
    }

    //orderItem to dto plus product

    public OrderItemDto mapOrderItemToDtoPlusProduct(OrderItem orderItem){
        OrderItemDto orderItemDto = mapOrderItemToDto(orderItem);
        if(orderItem.getProduct() != null){
            ProductDto productDto = mapProductToDto(orderItem.getProduct());
            orderItemDto.setProduct(productDto);
        }
        return orderItemDto;
    }







}
