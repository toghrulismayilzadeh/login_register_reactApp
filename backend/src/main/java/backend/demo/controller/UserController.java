package backend.demo.controller;

//import backend.demo.config.AuthenticationService;
//import backend.demo.config.JwtAuthenticationResponse;
import backend.demo.model.dto.LoginDto;
import backend.demo.model.dto.RegistrationDto;
import backend.demo.model.dto.UserDto;
import backend.demo.model.entity.User;
import backend.demo.serivce.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/app/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
//    private final AuthenticationService authenticationService;
    @PostMapping
    public ResponseEntity create(@RequestBody RegistrationDto dto){
        boolean b=service.existByEmail(dto.getEmail());
        if (b){return ResponseEntity.badRequest().build();}
        service.save(dto);
        return ResponseEntity.ok().build();
    }
//    @PostMapping("/login")
//    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody LoginDto dto){
//        System.out.println("____------------------------------------________");
//        JwtAuthenticationResponse jwtAuthenticationResponse = authenticationService.signin(dto);
//
//        return ResponseEntity.ok(jwtAuthenticationResponse);
//    }
    @GetMapping("/{code}")
    public ResponseEntity enableupdate(@PathVariable String code){
        System.out.println(code);
        boolean enableupdate = service.enableupdate(code);
        if (enableupdate){
            return ResponseEntity.ok().build();
        }else {return ResponseEntity.badRequest().build();}
    }
    @GetMapping
    public List<UserDto> findAll(){
        return service.findAll();
    }
//    @GetMapping
//    public List<UserDto> findall(){
//        return service.findAll();
//    }
}
