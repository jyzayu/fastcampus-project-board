package com.fastcampus.projectboard.dto;

import com.fastcampus.projectboard.domain.AuditingFields;
import com.fastcampus.projectboard.domain.UserAccount;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

public class UserAccountDto {

    @Id
    @Column(length = 50)
    private String userId;

    @Setter
    private String userPassword;

    @Setter
    @Column(length = 100)
    private String email;
    @Setter
    @Column(length = 100)
    private String nickname;

    @Setter
    private String memo;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime modifiedAt;

    private String modifiedBy;

    protected UserAccountDto of() {
    }



    private UserAccountDto of(String userId, String userPassword, String email, String nickname, String memo) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.email = email;
        this.nickname = nickname;
        this.memo = memo;
        this.createdAt = null;
        createdBy = null;

    }



    private UserAccountDto of(String userId, String userPassword, String email, String nickname, String memo) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.email = email;
        this.nickname = nickname;
        this.memo = memo;
    }

    public static com.fastcampus.projectboard.domain.UserAccount of(String userId, String userPassword, String email, String nickname, String memo) {
        return new com.fastcampus.projectboard.domain.UserAccount(userId, userPassword, email, nickname, memo);
    }

    public static UserAccountDto from(UserAccount entity){
        return new UserAccountDto(
                entity.getUserId(),
                entity.getUserPassword(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getMemo()
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.fastcampus.projectboard.domain.UserAccount that = (com.fastcampus.projectboard.domain.UserAccount) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
