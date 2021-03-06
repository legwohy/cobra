package com.cobra.domain.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class QueryUserInfoDTO {

    private String userId;

    private String userName;

    private Date createdAt;

}