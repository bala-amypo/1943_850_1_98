package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Progress {
    private Long id;
    private User user;
    private MicroLesson microLesson;
    private Integer progressPercent;
    private String status;
    private BigDecimal score;
    private LocalDateTime lastAccessedAt;

    public static Builder builder(){return new Builder();}

    public void prePersist(){this.lastAccessedAt=LocalDateTime.now();}

    public static class Builder {
        private final Progress p=new Progress();
        public Builder id(Long id){p.id=id;return this;}
        public Builder user(User u){p.user=u;return this;}
        public Builder microLesson(MicroLesson m){p.microLesson=m;return this;}
        public Builder progressPercent(Integer i){p.progressPercent=i;return this;}
        public Builder status(String s){p.status=s;return this;}
        public Builder score(BigDecimal s){p.score=s;return this;}
        public Progress build(){return p;}
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public User getUser(){return user;}
    public MicroLesson getMicroLesson(){return microLesson;}
    public Integer getProgressPercent(){return progressPercent;}
    public void setProgressPercent(Integer p){this.progressPercent=p;}
    public String getStatus(){return status;}
    public void setStatus(String s){this.status=s;}
    public BigDecimal getScore(){return score;}
    public void setScore(BigDecimal s){this.score=s;}
}
