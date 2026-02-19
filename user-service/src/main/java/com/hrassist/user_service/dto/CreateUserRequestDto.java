package com.hrassist.user_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateUserRequestDto {

    @NotBlank(message = "firstName is mandatory field")
    private String firstName;

    @NotBlank(message = "lastName is mandatory field")
    private String lastName;

    private String middleName;

    @NotNull(message = "roleId is mandatory field")
    private Integer roleId;

    @NotBlank(message = "username is mandatory field")
    private String username;

    @Email(message = "Invalid email format")
    private String email;

    private String password;

    public CreateUserRequestDto(){

    }

    public CreateUserRequestDto(String firstName, String lastName, String middleName, Integer roleId, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.roleId = roleId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
