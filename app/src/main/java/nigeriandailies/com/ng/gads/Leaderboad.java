package nigeriandailies.com.ng.gads;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
//import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Leaderboad extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboad);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("LEADERBOAD");

        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //add fragment here
        adapter.addFragment(new LearningLeaders(), "Learning Leaders");
        adapter.addFragment(new Skill_IQ_Leaders(), "Skill IQ Leaders");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        Call<List<UserResponse>> userList = ApiClient.getUserService().getAllHours();
        userList.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                if (response.isSuccessful()){
                    Log.e("success", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());


            }
        });
        //Start again
        Call<List<UserResponse>> userList2 = ApiClient.getUserService().getAllSkillQ();
        userList2.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {

            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {

            }
        });


//        toolbar = findViewById(R.id.toolbar);
//
//        setSupportActionBar(toolbar);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("LEADERBOAD");
//        actionBar.setElevation(0);
    }
}
