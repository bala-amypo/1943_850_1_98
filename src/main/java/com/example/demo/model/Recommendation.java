@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    private LocalDateTime generatedAt;
    private String recommendedLessonIds;
    private String basisSnapshot;
    private BigDecimal confidenceScore;

    @PrePersist
    public void prePersist() {
        this.generatedAt = LocalDateTime.now();
    }
}
