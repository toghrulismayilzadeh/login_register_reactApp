package backend.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User //implements UserDetails
         {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "surname", length = 60)
    private String surname;

    @Column(name = "password")
    private String password;
    @Column(name = "e_mail")
    private String email;
    @Column(name = "creatdate")
    private LocalDateTime creatDate;


    @Column(name ="nonexpired" )
    private boolean accountNonExpired;//HESABINVAXTIBITMEYIB
    @Column(name = "nonlocked")
    private boolean accountNonLocked;//HESABBLOKLANMAYIB
    @Column(name = "enabled")
    private boolean enabled;//AKTIVLESDIRILIB
    @Column(name = "code")
    private Long  code;
//  @Column(name = "roles")
//    private String role;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Arrays.stream(role.split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
}
