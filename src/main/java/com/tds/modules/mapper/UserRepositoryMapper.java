package com.tds.modules.mapper;



import com.tds.modules.domain.UserEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Author CrazyJay
 * @Date 2019/3/30 22:05
 * @Version 1.0
 */
@Mapper
public interface UserRepositoryMapper {

    UserEntity findByUsername(String username);

    UserEntity findByToken(String token);
}
