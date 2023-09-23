package com.example.deokjideokji.member.domain;


import com.example.deokjideokji.common.domain.BaseEntity;
import com.example.deokjideokji.member.dto.response.MemberResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minidev.json.JSONObject;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String birthday;

    @Builder
    public Member(String email, String name, String birthday){
        this.email = email;
        this.name = name;
        this.birthday = birthday;
    }

    public MemberResponse toResponseDto(){
        return MemberResponse.builder()
                .id(id)
                .email(email)
                .name(name)
                .birthday(birthday)
                .build();
    }
}
