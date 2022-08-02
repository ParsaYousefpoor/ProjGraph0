package Source;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    private String name;
    private String username; //   @ ...
    private String password;
    private int id; // for internal use
    private String passrecov;
    private LocalDate login;
    private LocalDate logout;
    private ArrayList<Post> posts = new ArrayList<>();
    private ArrayList<Post> likes = new ArrayList<>();
    private ArrayList<User> followers = new ArrayList<>();
    private ArrayList<User> followings = new ArrayList<>();
    private ArrayList<Chat> chats = new ArrayList<>();
    private ArrayList<Group> groups = new ArrayList<>();
    public static ArrayList<User> userArrayList = new ArrayList<>();

    User(String name, String username, String pass) {
        this.name = name;
        this.username = username;
        password = pass;
        userArrayList.add(this);
        login = LocalDate.now();
    }

    //information
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String input) {
        password = input;
    }

    public String getPassword() {
        return password;
    }

    public void setPassrecov(String string) {
        passrecov = string;
    }

    public String getPassrecov() {
        return passrecov;
    }

    //post
    public void newPost(Post post) {
        posts.add(post);
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    //follower
    public void addFollowing(User user1) {
        if (!followings.contains(user1)) {
            followings.add(user1);
            user1.addFollower(this);
        }
    }

    public void removeFollowing(User user1) {
        if (followings.contains(user1)) {
            followings.remove(user1);
            user1.removeFollower(user1);
        }
    }

    public ArrayList<User> getFollowings() {
        return followings;
    }

    public void addFollower(User user1) {
        if (!followers.contains(user1)) {
            followers.add(user1);
        }
    }

    public void removeFollower(User user1) {
        if (followers.contains(user1)) {
            followers.remove(user1);
        }
    }

    //chat and group
    public void startChat(User user) {
        Chat chat = new Chat(this, user);
        chats.add(chat);
        user.addChat(chat);
    }

    public void addChat(Chat chat) {
        chats.add(chat);
    }

    public void startGroup(ArrayList<User> users, String name) {
        Group group = new Group(this, name);
        for (User u : users) {
            group.addUser(u);
            u.addGroup(group);
        }
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    //likes
    public void addLikes(Post post) {
        likes.add(post);
    }

    public ArrayList<Post> getLikes() {
        return likes;
    }

    //logout
    public void saveLogout() {
        logout = LocalDate.now();
    }

    public LocalDate getLogout() {
        return logout;
    }

    public boolean equals(User user) {
        if (user.getId() == id) {
            return true;
        }
        return false;
    }
}
