package ru.isaevisa05.urlshrinker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddRequest(
        @NotBlank(message = "URL cannot be empty")
        @Pattern(
                regexp = "^https?://[\\p{L}\\p{N}-+&@#/%?=~_|!:,.;]*[\\p{L}\\p{N}-+&@#/%=~_|]$",
                message = "Invalid URL structure or illegal characters"
        )
        String url) {
}
