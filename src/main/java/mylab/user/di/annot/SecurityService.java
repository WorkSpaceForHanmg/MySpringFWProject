package mylab.user.di.annot;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public boolean authenticate(String userId, String password) {
        // 아주 간단한 인증 로직 (진짜 인증 아님)
        return userId != null && password != null && !userId.isEmpty() && !password.isEmpty();
    }

    public boolean authorize(String userId, String resource) {
        // 권한 검사 간단히 true
        return true;
    }
}
