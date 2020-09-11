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
   private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private List<UserResponse> list;


    public Skill_IQ_Leaders(){

//        recyclerView = view.findViewById(R.id.recy_skill);

//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
//        userAdapter = new UserAdapter();
//
//        getAllUsers();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.skill_iq_leaders, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recy_skill);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        userAdapter = new UserAdapter();
        recyclerView.setAdapter(userAdapter);
        return view;
    }
//    public void getAllUsers(){
//        Call<List<UserResponse>> userList2 = ApiClient.getUserService().getAllSkillQ();
//        userList2.enqueue(new Callback<List<UserResponse>>() {
//            @Override
//            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
//                if (response.isSuccessful()){
//                    List<UserResponse> userResponses = response.body();
//                    userAdapter.setData(userResponses);
//                    recyclerView.setAdapter(userAdapter);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<UserResponse>> call, Throwable t) {
//
//            }
//        });
//
//    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
