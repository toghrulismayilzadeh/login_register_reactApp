package backend.demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    @NotBlank
    @Pattern(regexp = "[\\w.-]+@[\\w.-]+.\\w+$")
    private String email;
    @NotBlank
    private String password;

    private String firstName;
    private String lastName;

    private String role;

}