package com.fastcampus.projectboard.dto;

import com.fastcampus.projectboard.domain.AuditingFields;
import com.fastcampus.projectboard.domain.UserAccount;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

public record UserAccountDto (
    String userId,
    String userPassword,
    String email,
    String nickname,
    String memo,
    LocalDateTime createdAt,
    String createdBy,
    LocalDateTime modifiedAt,
    String modifiedBy
){

    public UserAccountDto of(String userId, String userPassword, String email, String nickname, String memo) {
        return new UserAccountDto(userId,userPassword,email,nickname, memo, null, null, null, null);
    }



    public static UserAccountDto of(String userId, String userPassword, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new UserAccountDto(userId, userPassword, email, nickname, memo, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static UserAccountDto from(UserAccount entity){
        return new UserAccountDto(
                entity.getUserId(),
                entity.getUserPassword(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getMemo(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public UserAccount toEntity(){
        return UserAccount.of(
                userId,
                userPassword,
                email,
                nickname,
                memo
        );
    }

}
