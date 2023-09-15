//package backend.demo.controller;
//
//import backend.demo.model.dto.RegistrationDto;
//import backend.demo.serivce.RegistrationService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.UUID;
//@RestController
//@RequestMapping("/app/v1/registration")
//@RequiredArgsConstructor
//public class RegistrationController {
//    private final RegistrationService service;
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity register(@Valid @RequestBody RegistrationDto dto){
//        boolean b=service.existByEmail(dto.getEmail());
//        if (b==true){return ResponseEntity.badRequest().build();}
//        service.register(dto);
//    return ResponseEntity.ok().build();}
//
////    @GetMapping("confirmation/{uuid}")
////    public void confitmation(@PathVariable UUID uuid){
////        service.enableUpdate(uuid);
////    }
//}
