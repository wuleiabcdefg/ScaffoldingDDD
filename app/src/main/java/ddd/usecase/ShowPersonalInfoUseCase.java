package ddd.usecase;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowPersonalInfoUseCase {

    @Setter
    @Getter
    public static class Request {
        private Long userId;
    }

    @Setter
    @Getter
    public static class Response {
        private Long userId;
        private String userName;
        private String email;
        private String phoneNumber;
    }
}
