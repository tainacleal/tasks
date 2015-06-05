package tainaleal.com.tasks;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

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

        ArrayAdapter<Task> adapter = new ArrayAdapter<Task>(getActivity(), android.R.layout.simple_list_item_1, mTasks);
        setListAdapter(adapter);
    }
}
