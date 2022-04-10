package com.appvehicle.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
@Entity
@Table (name="ADMIN_REGISTRATION")
public class AdminEntity
{
    public AdminEntity()
    {
        super();
        // TODO Auto-generated constructor stub
    }
 
    public AdminEntity(String email, String name, String password) 
    {
        super();
 
        this.email = email;
        this.name = name;
        this.password = password;
    }
    @Id
    @Column(name="admin_email", length=20)
    @NotNull(message = "Email should not be Null")
    @NotBlank(message = "Email should not be Blank")
    @Size(min = 1, max = 20)
    @Email
    private String email;
 
    @Column(name="admin_name",length=20)
    @NotNull(message = "Name should not be Null")
    @NotBlank(message = "Name should not be Blank")
    @Size(min = 1, max = 20)
        private String name;
 
    @Column(name="admin_password",length=20)
    @NotNull(message = "Password should not be Null")
    @NotBlank(message = "Password should not be Blank")
    @Size(min = 1, max = 20)
    private String password;
    public String getEmail() 
    {
        return email;
    }
 
    public String getName() 
    {
        return name;
    }
    public String getPassword() 
    {
        return password;
    }
 
    public void setEmail(String email)
    {
        this.email = email;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
 

}