package com.cobra.domain.entirty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo
{
    private Integer id;
    private String userName;
    private String password;

}
