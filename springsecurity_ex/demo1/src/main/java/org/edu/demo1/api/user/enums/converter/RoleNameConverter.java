package org.edu.demo1.api.user.enums.converter;

import org.edu.demo1.api.user.enums.RoleName;
import org.springframework.core.convert.converter.Converter;

/**
 * String to Enum Converter
 */
public class RoleNameConverter implements Converter<String, RoleName> {

    @Override
    public RoleName convert(String roleName) {
        return RoleName.fromRole(roleName);
    }

}
