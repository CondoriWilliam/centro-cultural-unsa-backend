package com.galaxy.bakendapirest.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class PictureItem {
    private Integer id;

    @NotNull
    @Positive
    private Integer author_id;

    @NotNull
    @Positive
    private Integer room_id;

    @NotBlank(message = "asd") //-> no nulo, no cadena vacia, no cadeana con espacios
    private String name;

    @NotNull
    private String technique;

    @NotNull
    private String category;

    @NotNull
    private String description;

    @NotNull
    private LocalDate year;

    @NotNull
    private String link_image;

    @NotNull
    private String link_qr;

    @NotNull
    private String link_audio;

    @NotNull(message = "Value not NULL")
    @Positive(message = "Value not Negative")
    private Integer pos_x;

    @NotNull(message = "Value not NULL")
    @Positive(message = "Value not Negative")
    private Integer pos_y;
}
