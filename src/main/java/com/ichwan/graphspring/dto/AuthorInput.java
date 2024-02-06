package com.ichwan.graphspring.dto;

import com.ichwan.graphspring.entity.Book;
import jakarta.validation.constraints.NotBlank;

public record AuthorInput(@NotBlank String name) {
}
