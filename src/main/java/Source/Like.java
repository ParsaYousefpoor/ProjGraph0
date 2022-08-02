package Source;

import java.time.LocalDate;

public class Like {
    private User user;
    private LocalDate time;

    public Like(User user) {
        this.user = user;
        time = LocalDate.now();
    }

    public User getUser() {
        return user;
    }

    public LocalDate getTime() {
        return time;
    }
}
