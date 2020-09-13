package nigeriandailies.com.ng.gads;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {

    @GET("/api/hours")
    Call<List<Skill_IQ_Response>> getAllHours();

    @GET("/api/skilliq")
    Call<List<Skill_IQ_Response>> getAllSkillQ();
}
