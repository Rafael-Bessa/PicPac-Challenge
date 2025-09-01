package bessa.morangon.rafael.picpay.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "full_name")
    private String fullName;
    @NotBlank
    @Column(unique = true)
    @Pattern(regexp = "\\d{11}")
    private String cpf;
    @NotBlank
    @Column(unique = true)
    @Email
    private String email;
    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres")
    @Pattern(regexp = ".*[A-Z].*", message = "Deve conter pelo menos uma letra maiúscula")
    @Pattern(regexp = ".*[a-z].*", message = "Deve conter pelo menos uma letra minúscula")
    @Pattern(regexp = ".*\\d.*", message = "Deve conter pelo menos um número")
    @Pattern(regexp = ".*[@$!%*?&].*", message = "Deve conter pelo menos um caractere especial (@$!%*?&)")
    private String password;
    @NotNull(message = "O saldo não pode ser nulo")
    @DecimalMin(value = "0.0", inclusive = true, message = "O saldo não pode ser negativo")
    private BigDecimal balance = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "type_user")
    private Type typeUser;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", typeUser=" + typeUser +
                '}';
    }

}
