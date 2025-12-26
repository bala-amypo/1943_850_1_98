package com.example.demo.model;

import java.time.LocalDateTime;

public class Course {
    private Long id;
    private String title;
    private String description;
    private User instructor;
    private LocalDateTime createdAt;

    public static Builder builder(){return new Builder();}

    public void prePersist(){this.createdAt=LocalDateTime.now();}

    public static class Builder {
        private final Course c=new Course();
        public Builder id(Long id){c.id=id;return this;}
        public Builder title(String t){c.title=t;return this;}
        public Builder description(String d){c.description=d;return this;}
        public Builder instructor(User u){c.instructor=u;return this;}
        public Course build(){return c;}
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getTitle(){return title;}
    public void setTitle(String t){this.title=t;}
    public String getDescription(){return description;}
    public User getInstructor(){return instructor;}
    public void setInstructor(User u){this.instructor=u;}
}
