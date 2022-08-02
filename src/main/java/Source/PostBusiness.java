package Source;

import java.util.ArrayList;

public class PostBusiness extends Post {
    private ArrayList<Integer> views = new ArrayList<>();
    private ArrayList<ArrayList<Like>> likes = new ArrayList<>();

    public PostBusiness(User user1, String text) {
        super(user1, text);
    }

    public void addView() {
        Integer temp = views.get(views.size()-1);
        temp++;
    }

    public void newDay() {
        Integer integer = 0;
        views.add(integer);
    }
}
