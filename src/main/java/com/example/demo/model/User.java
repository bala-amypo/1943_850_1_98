package com.example.demo.model;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;

    public static Builder builder() { return new Builder(); }

    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public static class Builder {
        private final User u = new User();
        public Builder id(Long id){u.id=id;return this;}
        public Builder email(String e){u.email=e;return this;}
        public Builder password(String p){u.password=p;return this;}
        public Builder role(String r){u.role=r;return this;}
        public User build(){return u;}
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public void setPassword(String p){this.password=p;}
    public String getRole(){return role;}
    public LocalDateTime getCreatedAt(){return createdAt;}
}
