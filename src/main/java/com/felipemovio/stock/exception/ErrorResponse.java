package com.felipemovio.stock.exception;

import lombok.Builder;

@Builder
public record ErrorResponse(
        String message,
        Integer status
) {
}
