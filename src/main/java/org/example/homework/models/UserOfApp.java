package org.example.homework.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserOfApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, max = 100, message = "Ім'я повинно бути від 2 до 100 символів довжиною")
    private String username;

    @Column(nullable = false)
    @Size(min = 2, max = 100, message = "Прізвище повинно бути від 2 до 100 символів довжиною")
    private String surname;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false, unique = true)
    @Size(min = 2, max = 100, message = "Пароль повинен бути від 2 до 100 символів довжиною та унікальним")
    private String password;
}
