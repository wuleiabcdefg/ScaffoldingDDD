package ddd.auth.usecase;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowPersonalInfoUseCase {

    @Setter
    @Getter
    public static class Request {
        private String userId;
    }

    @Setter
    @Getter
    public static class Response{
        private String userId;
        private String userName;
        private String email;
        private String phoneNumber;
    }
}
