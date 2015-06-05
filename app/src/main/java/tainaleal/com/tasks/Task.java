package tainaleal.com.tasks;

import java.util.UUID;

/**
 * Created by tainaleal on 6/3/15.
 */
public class Task {
    private UUID mId;
    private String mTitle;
    private String mDetail;
    private boolean mCompleted;

    public Task() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getDetail() {
        return mDetail;
    }

    public void setDetail(String detail) {
        this.mDetail = detail;
    }

    public boolean isCompleted() {
        return mCompleted;
    }

    public void setCompleted(boolean completed) {
        this.mCompleted = completed;
    }

    @Override
    public String toString() {
        return mTitle;
    }
}
