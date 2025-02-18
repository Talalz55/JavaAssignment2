package ca.sheridan.alzuhait.assignment2.beans;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="PASSWORD_RECORD")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    private String title;
    private String username;
    private String password;
    private String url;
    private String email;
    private String notes;
}
