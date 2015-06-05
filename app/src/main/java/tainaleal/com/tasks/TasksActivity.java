package tainaleal.com.tasks;

import android.app.Fragment;
import android.view.MenuItem;

/*
 * Activity that will host the Task Fragment
 */

public class TasksActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new TasksFragment();
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
