package com.zzn.librarysystem.userModule.mapper;

import com.zzn.librarysystem.userModule.domain.NormalUser;
import com.zzn.librarysystem.userModule.model.AuthResponseDto;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(NormalUser.class, AuthResponseDto.class)
                .byDefault()
                .register();
    }
}
