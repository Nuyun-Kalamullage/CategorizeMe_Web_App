package edu.nuyun.categorizeme.models.mappers;

import edu.nuyun.categorizeme.models.DTO.UserDTO;
import edu.nuyun.categorizeme.models.User;
import org.mapstruct.Mapper;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 05/05/2024
 * @package edu.nuyun.categorizeme.models.mapper
 * @project_Name CategorizeMe
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDto(User user);
}
