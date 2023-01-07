package com.example.practice66ezhikov.entity;

import com.example.practice66ezhikov.enums.Countries;
import com.example.practice66ezhikov.enums.Sexes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "footballers", schema = "sport")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FootballerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "first_name", nullable = false)
    @NotNull
    @NotBlank
    String firstName;

    @Column(name = "second_name", nullable = false)
    @NotNull
    @NotBlank
    String secondName;

    @Column(name = "sex", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    Sexes sex;

    @Column(name = "birthday", nullable = false)
    @NotNull
    LocalDate birthday;

    @Column(name = "team_name", nullable = false)
    @NotNull
    String teamName;

    @Column(name = "country", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    Countries country;
}
