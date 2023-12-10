package ddd.auth.usecase;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowPersonalInfoUseCase {

    @Setter
    @Getter
    public static class Request {
        private String userId;
    }

    @Setter
    @Getter
    public static class Response {
        private String userId;
        private String name;
        private String email;
        private String phoneNumber;
    }
}
