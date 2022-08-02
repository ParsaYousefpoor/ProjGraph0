package Source;

public class UserBusiness extends User {
    public UserBusiness(String name, String username, String pass) {
        super(name, username, pass);
    }

    public void newPost(PostBusiness post) {
        super.newPost((Post) post);
    }
}
