//package backend.demo.serivce;
//
//import backend.demo.map.UserMapper;
//import backend.demo.model.dto.RegistrationDto;
//import backend.demo.model.entity.User;
//import backend.demo.repoistory.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//public class RegistrationService {
//    private final UserRepository repository;
//    private final UserMapper mapper;
//    public boolean existByEmail(String email) {
//        return repository.existsByEmail(email);
//    }
//
//    public void register(RegistrationDto dto) {
//    }
//
////    public void enableUpdate(UUID uuid) {
////        User user=repository.findByUuid(uuid);
////        mapper.updateEnable(user);
////    }
//}
