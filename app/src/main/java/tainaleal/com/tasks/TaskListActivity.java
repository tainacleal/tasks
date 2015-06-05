package tainaleal.com.tasks;

import android.app.Fragment;

/**
 * Created by tainaleal on 6/5/15.
 */
public class TaskListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new TaskListFragment();
    }
}
