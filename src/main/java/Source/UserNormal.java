package Source;

public class UserNormal extends User {
    public UserNormal(String name, String username, String pass) {
        super(name, username, pass);
    }

    public void newPost(PostNormal post) {
        super.newPost((Post) post);
    }
}
