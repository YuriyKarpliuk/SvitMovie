package yurii.karpliuk.svitmovie.dto.request;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    private String email;
    private String password;
}
