package digital.inforce.userprofile.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class UserSaveDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}