package com.desafiolatam.desafio03;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.desafiolatam.desafio03.Api.Api;
import com.desafiolatam.desafio03.Api.RetrofitClient;
import com.desafiolatam.desafio03.pojos.Question;
import com.desafiolatam.desafio03.pojos.QuestionList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Api service = RetrofitClient.getRetrofit().create(Api.class);
        Call<QuestionList> call = service.getAllQuestions();

        call.enqueue(new Callback<QuestionList>() {
            @Override
            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {
                QuestionList list = response.body();

                if(response != null) {
                    Question question = list.getQuestionList().get(0);

                    TheSuperFragment fragment = TheSuperFragment.newInstance(
                            question.getCategory(),
                            question.getType(),
                            question.getDifficulty(),
                            question.getQuestion(),
                            question.getCorrectAnswer(),
                            question.getIncorrectAnswers()
                    );

                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragment_container, fragment, "FRAGMENTO").commit();
                }
            }

            @Override
            public void onFailure(Call<QuestionList> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: no pudimos recuperar los datos de opentdb",
                        Toast.LENGTH_SHORT).show();
            }
        });




//        private void initialize
    }
}
