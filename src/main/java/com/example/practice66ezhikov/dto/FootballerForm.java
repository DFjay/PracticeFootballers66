package com.example.practice66ezhikov.dto;

import com.example.practice66ezhikov.enums.Countries;
import com.example.practice66ezhikov.enums.Sexes;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.example.practice66ezhikov.entity.FootballerEntity} entity
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FootballerForm implements Serializable {
    Integer id;

    @NotBlank(message = "Имя не может отсутствовать")
    @Size(max = 255)
    String firstName;

    @NotBlank(message = "Фамилия не может отсутствовать")
    @Size(max = 255)
    String secondName;

    @NotNull(message = "Пол не может быть null")
    Sexes sex;

    @NotNull(message = "Дата рождения не может быть null")
    @Past(message = "Дата рождения не может быть в будущем")
    LocalDate birthday;

    @Size(max = 255)
    String teamName;

    @Size(max = 255)
    String insteadTeamName;

    @NotNull(message = "Страна не может быть null")
    Countries country;

    @AssertTrue(message = "Имя команды должно быть выбрано из списка или указано новое")
    private boolean isTeamNameOrInsteadTeamNameExists() {
        return (teamName != null && !teamName.isBlank()) || (insteadTeamName != null && !insteadTeamName.isBlank());
    }
}