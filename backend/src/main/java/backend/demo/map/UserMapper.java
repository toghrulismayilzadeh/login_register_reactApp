package backend.demo.map;

import backend.demo.model.dto.RegistrationDto;
import backend.demo.model.dto.UserDto;
import backend.demo.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.Random;

@Mapper(imports = {LocalDateTime.class})
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "code", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "creatDate", ignore = true)
    @Mapping(target = "accountNonLocked", ignore = true)
    @Mapping(target = "accountNonExpired", ignore = true)
    public abstract User dtoToEntity(UserDto userDto);

    public abstract UserDto entityToDto(User user);

//    @Mapping(target = "id",ignore = true)
//    @Mapping(target = "password",ignore = true)
//    @Mapping(target = "company",ignore = true)
//    @Mapping(target = "positionList",ignore = true)
//    public abstract void updateEntityFromDto(@MappingTarget User user, UserDto userDto);
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "enabled", constant = "false")
    @Mapping(target = "accountNonLocked", constant = "true")
    @Mapping(target = "accountNonExpired", constant = "true")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "surname", ignore = true)
    @Mapping(target = "code", expression = "java(codegenerator())")
    @Mapping(target = "creatDate", expression = "java(LocalDateTime.now())")
    User registerToEntity(RegistrationDto registrationDto);

//    @Mapping(target = "surname", ignore = true)
//    @Mapping(target = "password", ignore = true)
//    @Mapping(target = "name", ignore = true)
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "email", ignore = true)
//    @Mapping(target = "creatDate", ignore = true)
//    @Mapping(target = "code", ignore = true)
//    @Mapping(target = "accountNonLocked", ignore = true)
//    @Mapping(target = "accountNonExpired", ignore = true)
//    @Mapping(target = "enabled", constant = "true")
//    default void updateEnable(@MappingTarget User user) {
//
//    }

    default Long codegenerator(){
        Random random=new Random();
        return (long) (random.nextInt(900000) + 100000);
    }
}
