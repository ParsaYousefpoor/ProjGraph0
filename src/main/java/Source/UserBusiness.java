package Source;

public class UserBusiness extends User {
    UserBusiness(String name, String pass) {
        super(name, pass);
    }

    public void newPost(PostBusiness post) {
        super.newPost((Post) post);
    }
}
