package Source;

public class UserNormal extends User {
    UserNormal(String name, String pass) {
        super(name, pass);
    }

    public void newPost(PostNormal post) {
        super.newPost((Post) post);
    }
}
