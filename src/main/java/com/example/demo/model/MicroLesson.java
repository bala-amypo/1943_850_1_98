package com.example.demo.model;

public class MicroLesson {
    private Long id;
    private String title;
    private String difficulty;
    private String contentType;
    private String tags;
    private Integer durationMinutes;
    private Course course;

    public static Builder builder(){return new Builder();}

    public static class Builder {
        private final MicroLesson m=new MicroLesson();
        public Builder id(Long id){m.id=id;return this;}
        public Builder title(String t){m.title=t;return this;}
        public Builder difficulty(String d){m.difficulty=d;return this;}
        public Builder contentType(String c){m.contentType=c;return this;}
        public Builder tags(String t){m.tags=t;return this;}
        public Builder durationMinutes(Integer d){m.durationMinutes=d;return this;}
        public Builder course(Course c){m.course=c;return this;}
        public MicroLesson build(){return m;}
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getDifficulty(){return difficulty;}
    public String getContentType(){return contentType;}
    public String getTags(){return tags;}
    public Integer getDurationMinutes(){return durationMinutes;}
    public Course getCourse(){return course;}
    public void setCourse(Course c){this.course=c;}
}
