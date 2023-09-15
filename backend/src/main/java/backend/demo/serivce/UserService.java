package backend.demo.serivce;

import backend.demo.map.UserMapper;
import backend.demo.model.dto.RegistrationDto;
import backend.demo.model.dto.UserDto;
import backend.demo.model.entity.User;
import backend.demo.repoistory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final MailSender mailSender;
    private boolean isSending = false;
    private Queue<SimpleMailMessage> queue = new ConcurrentLinkedQueue<>();
    public void save(RegistrationDto dto) {
        User entity = mapper.registerToEntity(dto);
        User save = repository.save(entity);
        String usercode=""+save.getCode()+""+save.getId();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(save.getEmail());
        message.setFrom("togrul.ismayilzada.2003@gmail.com");
        message.setSubject("Registration Code");
        message.setText(usercode);
        queue.add(message);
    }
    public boolean existByEmail(String email) {
        return repository.existsByEmail(email);
    }

//    public List<UserDto> findAll() {
//        return repository.findAll().stream()
//                .map(mapper :: entityToDto)
//                .toList();
//    }
    @Scheduled(fixedDelay = 5000)
    public void sendMail() {
        while (!isSending && !queue.isEmpty()) {
            isSending = true;
            mailSender.send(queue.poll());
        }
        isSending = false;
    }

    public boolean enableupdate(String codee) {
    String b=codee.substring(0,6);
    String c=codee.substring(6);
    Long code=Long.valueOf(b);
    Long id=Long.valueOf(c);
        User user = repository.findById(id).orElse(null);
        boolean bo= Objects.equals(user.getCode(), code);
        if (bo) {
            user.setEnabled(true);
            repository.save(user);
            return true;
        }else return false;
    }

    public List<UserDto> findAll() {
        List<UserDto> userDtos = repository.findAll().stream()
                .map(mapper::entityToDto)
                .toList();
        return userDtos;

    }
}
