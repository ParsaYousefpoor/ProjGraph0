package Source;

import java.time.LocalDate;
import java.util.ArrayList;

public class ShowPosts {
    public ArrayList<Post> showLatestPosts(User user) {
        ArrayList<Post> tempPost = new ArrayList<>();
        LocalDate a = user.getLogout();
        ArrayList<User> temp1 = user.getFollowings();
        for (User u : temp1) {
            ArrayList<Post> temp2 = u.getPosts();
            for (Post p : temp2) {
                if (a.compareTo(p.getTime()) >= 0) {
                    tempPost.add(p);
                }
            }
        }
        return tempPost;
    }
}
