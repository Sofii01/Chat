package com.app.chat.infrastructure.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class ChatRoomRequestDto {

    @Schema(description = "Nombre de la sala", example = "Sala de programación")
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;
}
