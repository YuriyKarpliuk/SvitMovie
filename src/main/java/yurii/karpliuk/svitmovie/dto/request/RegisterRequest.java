package yurii.karpliuk.svitmovie.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String phone;
    private String email;
    private String password;
}
