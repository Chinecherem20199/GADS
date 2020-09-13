package nigeriandailies.com.ng.gads;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeaders extends Fragment {


    View view;
    RecyclerView recyclerView2;
    LearningAdapter adapter;

    public LearningLeaders(){

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.learning_leaders, container, false);

        return view;



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView2 = view.findViewById(R.id.recy_learning);

        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView2.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        adapter = new LearningAdapter();
        getAllUsers();
    }

    public void getAllUsers(){
        Call<List<Skill_IQ_Response>> userList2 = ApiClient.getUserService().getAllHours();
        userList2.enqueue(new Callback<List<Skill_IQ_Response>>() {
            @Override
            public void onResponse(Call<List<Skill_IQ_Response>> call, Response<List<Skill_IQ_Response>> response) {
                if (response.isSuccessful()){
                    List<Skill_IQ_Response> skillIQRespons = response.body();
//                    skillIQAdapter = new Skill_IQ_Adapter(getActivity(), l)
                    adapter.setData(skillIQRespons);
                    recyclerView2.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<Skill_IQ_Response>> call, Throwable t) {

            }
        });

    }
}
