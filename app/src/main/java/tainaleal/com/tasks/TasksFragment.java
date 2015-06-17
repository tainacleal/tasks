package tainaleal.com.tasks;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by tainaleal on 6/3/15.
 */
public class TasksFragment extends Fragment {

    private Task mTask;
    private EditText mTaskTitle;
    private CheckBox mTaskCompleted;
    public static String EXTRA_TASK_ID = "tainaleal.com.tasks.task_id";

    public static TasksFragment newInstance(UUID taskId){
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_TASK_ID, taskId);

        TasksFragment fragment = new TasksFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID taskId = (UUID)getArguments().getSerializable(EXTRA_TASK_ID);
        mTask = TaskBox.get(getActivity()).getTask(taskId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tasks, container, false);
        mTaskTitle = (EditText)v.findViewById(R.id.task_title);
        mTaskTitle.setText(mTask.getTitle());
        mTaskTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTask.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mTaskCompleted = (CheckBox)v.findViewById(R.id.task_completed);
        mTaskCompleted.setChecked(mTask.isCompleted());
        mTaskCompleted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mTask.setCompleted(isChecked);
            }
        });
        return v;
    }
}
