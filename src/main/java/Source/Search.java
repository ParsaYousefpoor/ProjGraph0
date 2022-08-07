package Source;

import java.util.ArrayList;

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

    public static ArrayList<Post> getPost(User user) {
        ArrayList<Post> posts = new ArrayList<>();
        ArrayList<Post> temp = user.getPosts();
        for (int i = temp.size() - 1; i > -1; i--) {
            posts.add(temp.get(i));
        }
        return posts;
    }

    public static ArrayList<Replay> getReplay(Post post) {
        ArrayList<Replay> posts = new ArrayList<>();
        ArrayList<Replay> temp = post.getReplays();
        for (int i = temp.size() - 1; i > -1; i--) {
            posts.add(temp.get(i));
        }
        return posts;
    }
}
