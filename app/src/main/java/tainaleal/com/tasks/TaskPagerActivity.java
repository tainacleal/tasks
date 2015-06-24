package tainaleal.com.tasks;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by tainaleal on 6/19/15.
 */
public class TaskPagerActivity extends Activity{

    private ViewPager mViewPager;
    private ArrayList<Task> mTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);

        mTasks = TaskBox.get(this).getTasks();
        FragmentManager fm = getFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Task task = mTasks.get(position);
                return TasksFragment.newInstance(task.getId());
            }

            @Override
            public int getCount() {
                return mTasks.size();
            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Task task = mTasks.get(position);
                if (task.getTitle() != null)
                    setTitle(task.getTitle());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        UUID taskId = (UUID)getIntent().getSerializableExtra(TasksFragment.EXTRA_TASK_ID);
        for (int i=0; i<mTasks.size(); i++){
            if (mTasks.get(i).getId().equals(taskId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }


    }
}
