package Source;

public class Search {
    public static boolean existUser(String username) {
        for (User u : User.userArrayList) {
            if (username.equals(u.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public static User whichUser(String username) {
        for (User u : User.userArrayList) {
            if (username.equals(u.getUsername())) {
                return u;
            }
        }
        return null;
    }
}
