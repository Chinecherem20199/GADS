package nigeriandailies.com.ng.gads;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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


public class Skill_IQ_Leaders extends Fragment {



    View view;
   RecyclerView recyclerView;
   Skill_IQ_Adapter skillIQAdapter;
//    private List<Skill_IQ_Response> list;
     LinearLayoutManager layoutManager;


    public Skill_IQ_Leaders(){

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.skill_iq_leaders, container, false);

        return view;
    }


    //test here
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView =  view.findViewById(R.id.recy_skill);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        skillIQAdapter = new Skill_IQ_Adapter();
        getAllUsers();


    }


    public void getAllUsers(){
        Call<List<Skill_IQ_Response>> userList2 = ApiClient.getUserService().getAllSkillQ();
        userList2.enqueue(new Callback<List<Skill_IQ_Response>>() {
            @Override
            public void onResponse(Call<List<Skill_IQ_Response>> call, Response<List<Skill_IQ_Response>> response) {
                if (response.isSuccessful()){
                    List<Skill_IQ_Response> skillIQRespons = response.body();
//                    skillIQAdapter = new Skill_IQ_Adapter(getActivity(), l)
                    skillIQAdapter.setData(skillIQRespons);
                    recyclerView.setAdapter(skillIQAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<Skill_IQ_Response>> call, Throwable t) {

            }
        });

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
