package employeeWeb;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employee")
// we use  jpa oo ah  waa class laga abuuray database by Automatic
public class Employee {
    @Id

    private Long id;

    @Column(nullable = false, length = 50)
    private String fullName;

    private String email;

    private String address;

    private String gender;

    private String password;
}
