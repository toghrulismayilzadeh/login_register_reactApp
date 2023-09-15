//package backend.demo.jwt;
//import backend.demo.model.entity.User;
//import backend.demo.repoistory.UserRepository;
//import backend.demo.serivce.UserAuthService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserDetailsService {
//    private final UserRepository userRepository;
//
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByEmail(username);
//    }
//}