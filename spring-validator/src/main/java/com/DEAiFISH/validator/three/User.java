package com.DEAiFISH.validator.three;

import com.DEAiFISH.validator.four.CannotBlank;
import jakarta.validation.constraints.*;

public class User {
    @NotNull
    private String name;
    @Max(150)
    @Min(0)
    private Integer age;
    @Pattern(regexp = "^1([34578])\\d{9}$", message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")
    private String phone;
    @CannotBlank
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
