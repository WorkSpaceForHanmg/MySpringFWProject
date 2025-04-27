package mylab.user.di.annot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Value("MySQL")
    private String dbType;

    public boolean saveUser(String userId, String name) {
        System.out.println("Saving user [" + userId + "] to " + dbType + " database.");
        return true;
    }

    public String getDbType() {
        return dbType;
    }
}
