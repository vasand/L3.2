package accounts;

import dbService.DBException;
import dbService.DBService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountService {

    private final DBService dbService;

    public AccountService() {
        dbService = new DBService();
        dbService.printConnectInfo();
    }

    public void addNewUser(UserProfile userProfile) {
        try {
            userProfile.setId(dbService.addUser(userProfile));
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public UserProfile getUserByLogin(String login) {

        try {
            return dbService.getUser(login);
        } catch (DBException e) {
            return null;
        }

    }

    public UserProfile getUserBySessionId(String sessionId) {
        return null;
    }

    public void addSession(String sessionId, UserProfile userProfile) {
        //do this
    }

    public void deleteSession(String sessionId) {
        //do this
    }
}
