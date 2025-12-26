@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Progress {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private MicroLesson microLesson;

    private String status;
    private Integer progressPercent;
    private LocalDateTime lastAccessedAt;
    private BigDecimal score;

    @PrePersist
    public void prePersist() {
        this.lastAccessedAt = LocalDateTime.now();
    }
}
