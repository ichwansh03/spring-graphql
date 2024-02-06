package com.ichwan.graphspring.dto;

import jakarta.validation.constraints.NotBlank;

public record BookInput(@NotBlank String title, @NotBlank String publisher, @NotBlank Long authorId) {
}
