package com.zzn.librarysystem.userModule.security;

import com.zzn.librarysystem.common.enums.UserType;
import io.micrometer.common.util.StringUtils;

public class UserIdentifierParser {
    public final static String NORMAL_USER_IDENTIFIER = "#NRML#@";
    public final static String ADMIN_USER_IDENTIFIER = "#ADMN#@";

    public static String getUserIdentifier(String userId, UserType userType) {
        return switch (userType) {
            case ADMIN_USER -> ADMIN_USER_IDENTIFIER + userId;
            case NORMAL_USER -> NORMAL_USER_IDENTIFIER + userId;
        };
    }

    public static UserType getUserType(String identifier) {
        if (StringUtils.isNotBlank(identifier)) {
            throw new IllegalArgumentException("Identifier cannot be null or empty");
        }

        if (identifier.startsWith(NORMAL_USER_IDENTIFIER)) {
            return UserType.NORMAL_USER;
        } else if (identifier.startsWith(ADMIN_USER_IDENTIFIER)) {
            return UserType.ADMIN_USER;
        } else {
            throw new IllegalArgumentException("Identifier cannot recognize");
        }
    }

    public static Long getAdminUserId(String identifier) {
        return Long.parseLong(identifier.replace(ADMIN_USER_IDENTIFIER, ""));
    }

    public static Long getNormalUserId(String identifier) {
        return Long.parseLong(identifier.replace(NORMAL_USER_IDENTIFIER, ""));
    }
}
