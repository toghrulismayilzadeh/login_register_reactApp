//package backend.demo.config;
//
//import backend.demo.jwt.JwtService;
//import backend.demo.model.dto.LoginDto;
//import backend.demo.model.dto.RegistrationDto;
//import backend.demo.repoistory.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.java.Log;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import backend.demo.model.entity.User;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class AuthenticationServiceImpl implements AuthenticationService{
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtService jwtService;
//    private final AuthenticationManager authenticationManager;
//    @Override
//    public JwtAuthenticationResponse signup(RegistrationDto request) {
//        var user = User.builder().name(request.getFirstName()).surname(request.getLastName())
//                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
//                .role("ADMIN").build();
//        userRepository.save(user);
//        var jwt = jwtService.generateToken(user);
//        return JwtAuthenticationResponse.builder().token(jwt).build();
//    }
//
//    @Override
//    public JwtAuthenticationResponse signin(LoginDto request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
//        User user = userRepository.findByEmail(request.getUsername());
//        if(user==null) {
//           throw  new IllegalArgumentException("Invalid email or password");
//        }
//
//        String jwt = jwtService.generateToken(user);
//        return JwtAuthenticationResponse.builder().token(jwt).build();
//    }
//}
//
