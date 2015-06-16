package tainaleal.com.tasks;

import android.app.Fragment;

/**
 * Created by tainaleal on 6/5/15.
 * Hosts TaskListFragment
 */
public class TaskListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new TaskListFragment();
    }
}
