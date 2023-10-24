package com.dhriti.orderservice.orderDTO;

import lombok.*;

@Builder
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {
    private String skuCode;
    private boolean isInStock;

}
