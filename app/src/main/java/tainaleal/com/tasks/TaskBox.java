package tainaleal.com.tasks;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by tainaleal on 6/4/15.
 * Singleton to store all the tasks created
 */
public class TaskBox {
    private ArrayList<Task> mTasks;
    private static TaskBox sTaskBox;
    private Context mAppContext;

    private TaskBox(Context appContext){
        mAppContext = appContext;
        mTasks = new ArrayList<>();
        for (int i=0; i<100; i++){
            Task t = new Task();
            t.setTitle("Task #"+i);
            t.setCompleted(i%2==0);
            mTasks.add(t);
        }
    }

    public Task getTask(UUID id){
        for (Task t : mTasks){
            if (t.getId().equals(id))
                return t;
        }
        return null;
    }

    public ArrayList<Task> getTasks(){
        return mTasks;
    }

    public static TaskBox get(Context context){
        if (sTaskBox == null)
            sTaskBox = new TaskBox(context.getApplicationContext());

        return sTaskBox;
    }
}
