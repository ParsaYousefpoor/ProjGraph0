package Source;

public class Search {
    public static boolean existUser(String name) {
        for (User u : User.userArrayList) {
            if (name.equals(u.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public static User whichUser(String name) {
        for (User u : User.userArrayList) {
            if (name.equals(u.getUsername())) {
                return u;
            }
        }
        return null;
    }
}
