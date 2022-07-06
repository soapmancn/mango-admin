package com.soapman.vo;

import com.soapman.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel("登录入参")
public class LoginVo extends User {

    @ApiModelProperty("验证码")
    private String verificationCode;

}
