package com.appvehicle.model;
 
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
//UserRegistrationEntity class
@Entity
@Table(name = "USER_REGISTRATION")
public class UserRegistrationEntity 
{
    
    //UserRegistrationEntity constructor without parameters
    public UserRegistrationEntity() 
    {
        super();
    }
    
    //UserRegistrationEntity constructor with parameters
    public UserRegistrationEntity(String email, int age, String gender, String mobile, String name, String password,
            UserDetailsEntity userdetails) 
    {
        super();
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.mobile = mobile;
        this.name = name;
        this.password = password;
        this.userdetails = userdetails;
    }
    
    //Email should not be null, blank and length should be max=30
    @Id
    @Column(name = "user_email", length = 20)
    @NotNull(message = "Email should not be Null")
    @Email
    @Size(min = 5, max = 20)
    private String email;
 
    //Name should not be null, blank and length should be max=30
    @Column(name = "user_name", length = 20)
    @NotNull(message = "Name should not be Null")
    @Size(min = 3, max = 30)
    private String name;
   
    //Gender should not be null, blank and length should be max=7
    @Column(name = "user_gender", length = 20)
    @NotNull(message = "Gender should not be Null")
    @Size(min = 1, max = 7)
    private String gender;
 
    //Mobile should not be null, blank and length should be max=10
    @Column(name = "user_mobile", length = 20)
    @NotNull(message = "Mobile should not be Null")
    @Size(min=10, max = 10)
    private String mobile;
 
    //Age should not be null
    @Column(name = "user_age")
    @NotNull(message = "Age should not be Null")
    private int age;
 
    //Password should not be null, blank and length should be max=10
    @Column(name = "user_password", length = 20)
    @NotNull(message = "Password should not be Null")
    @Size(min = 5, max = 10)
    private String password;
 
    //UserRegistrationEntity has one to one relation with UserDetailsEntity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_Id")
    private UserDetailsEntity userdetails;
 
    //Getters and setters
    public String getEmail()
    {
        return email;
    }
 
    public void setEmail(String email)
    {
        this.email = email;
    }
 
    public String getName()
    {
        return name;
        }

 
    public void setName(String name) 
    {
        this.name = name;
   }
 
    public String getGender() 
    {
        return gender;
  }
 
    public void setGender(String gender) 
    {
        this.gender = gender;
    }
 
    public String getMobile() {
        return mobile;
   }
 
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
 
    public int getAge() 
    {
        return age;
    }
 
    public void setAge(int age)
    {
        this.age = age;
    }
 
    public String getPassword() 
    {
        return password;
    }
 
    public void setPassword(String password)
    {
        this.password = password;
    }
 
    public UserDetailsEntity getUserdetails()
    {
        return userdetails;
    }
 
    public void setUserdetails(UserDetailsEntity userdetails)
    {
        this.userdetails = userdetails;
    }
}
 