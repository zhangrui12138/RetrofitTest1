package com.example.pc252.mydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;


import com.example.pc252.mydemo.bean.APIInterface;
import com.example.pc252.mydemo.bean.TestModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
//免费url：https://api.github.com/users/Guolei1130
//http://japi.juhe.cn/qqevaluate/qq?key=96efc220a4196fafdfade0c9d1e897ac&qq=295424589
    @BindView(R.id.showDetail)
    Button showDetial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.showDetail)
    public void showDetail(){
        Toast.makeText(this,"fdhfgdhfg",Toast.LENGTH_SHORT).show();
       requestWebSite();//以get方式请求
        requestWebSitePost();////以post方式请求
    }
    private void requestWebSite(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://japi.juhe.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIInterface service = retrofit.create(APIInterface.class);
        Call<TestModel> model = service.repo("96efc220a4196fafdfade0c9d1e897ac","295424589");
        model.enqueue(new Callback<TestModel>() {
            @Override
            public void onResponse(Call<TestModel> call, Response<TestModel> response) {
                 Log.d("zhangrui",response.body().getErrorCode()+"\n"+response.body().getReason()+"\n"+response.body().getResult().getData().getConclusion()+"\n"+response.body().getResult().getData().getAnalysis());
                TestModel translation = response.body();
//                 Log.d("zhangrui",translation.getResult().getData().getAnalysis());
            }

            @Override
            public void onFailure(Call<TestModel> call, Throwable t) {
                Log.d("zhangrui",t.getMessage());
            }
        });
    }

    private void requestWebSitePost(){
        Retrofit retrofitPost=new Retrofit.Builder().baseUrl("http://japi.juhe.cn").addConverterFactory(GsonConverterFactory.create()).build();
        APIInterface postService = retrofitPost.create(APIInterface.class);
        Call<TestModel> model = postService.repoPost("96efc220a4196fafdfade0c9d1e897ac","295424589");
        model.enqueue(new Callback<TestModel>() {
            @Override
            public void onResponse(Call<TestModel> call, Response<TestModel> response) {
                Log.d("zhangrui",response.body().getErrorCode()+"\n"+response.body().getReason()+"\n"+response.body().getResult().getData().getConclusion()+"\n"+response.body().getResult().getData().getAnalysis());
                TestModel translation = response.body();
//                Log.d("zhangrui",translation.getResult().getData().getAnalysis());
            }

            @Override
            public void onFailure(Call<TestModel> call, Throwable t) {
                Log.d("zhangrui",t.getMessage());
            }
        });
    }
}


