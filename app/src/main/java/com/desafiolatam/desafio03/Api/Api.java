package com.desafiolatam.desafio03.Api;

import com.desafiolatam.desafio03.pojos.QuestionList;

import retrofit2.Call;
import retrofit2.http.GET;


public interface Api {
    @GET("api.php?amount=1&category=18&difficulty=medium&type=boolean")
    Call<QuestionList> getAllQuestions();
}
