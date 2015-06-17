package tainaleal.com.tasks;

import android.app.Fragment;
import android.view.MenuItem;

import java.util.UUID;

/*
 * Activity that will host the Task Fragment
 */

public class TasksActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        UUID taskId = (UUID)getIntent().getSerializableExtra(TasksFragment.EXTRA_TASK_ID);
        return TasksFragment.newInstance(taskId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
