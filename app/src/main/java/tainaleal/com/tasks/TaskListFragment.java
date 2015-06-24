package tainaleal.com.tasks;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tainaleal on 6/4/15.
 * Fragment showing a list of tasks created
 */
public class TaskListFragment extends ListFragment {
    private ArrayList<Task> mTasks;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.app_name);
        mTasks = TaskBox.get(getActivity()).getTasks();

        TaskAdapter adapter = new TaskAdapter(mTasks);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Task t = ((TaskAdapter)getListAdapter()).getItem(position);
        Intent intent = new Intent(getActivity(), TaskPagerActivity.class);
        intent.putExtra(TasksFragment.EXTRA_TASK_ID, t.getId());
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((TaskAdapter)getListAdapter()).notifyDataSetChanged();
    }

    public class TaskAdapter extends ArrayAdapter<Task>{
        public TaskAdapter(ArrayList<Task> tasks){
            super(getActivity(), 0, tasks);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_task, null);
            }

            Task t = getItem(position);

            TextView taskTitle = (TextView)convertView.findViewById(R.id.list_item_title);
            taskTitle.setText(t.getTitle());

            CheckBox taskCompleted = (CheckBox)convertView.findViewById(R.id.list_item_concluded);
            taskCompleted.setChecked(t.isCompleted());
            return convertView;
        }
    }
}
