package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Recommendation {
    private Long id;
    private String recommendedLessonIds;
    private BigDecimal confidenceScore;
    private String basisSnapshot;
    private LocalDateTime generatedAt;

    public static Builder builder(){return new Builder();}

    public void prePersist(){this.generatedAt=LocalDateTime.now();}

    public static class Builder {
        private final Recommendation r=new Recommendation();
        public Builder id(Long id){r.id=id;return this;}
        public Builder recommendedLessonIds(String s){r.recommendedLessonIds=s;return this;}
        public Builder confidenceScore(BigDecimal c){r.confidenceScore=c;return this;}
        public Builder basisSnapshot(String b){r.basisSnapshot=b;return this;}
        public Builder generatedAt(LocalDateTime t){r.generatedAt=t;return this;}
        public Recommendation build(){return r;}
    }

    public BigDecimal getConfidenceScore(){return confidenceScore;}
    public String getBasisSnapshot(){return basisSnapshot;}
    public String getRecommendedLessonIds(){return recommendedLessonIds;}
    public LocalDateTime getGeneratedAt(){return generatedAt;}
}
