package com.falin.valentin.a3_l2_falin.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.falin.valentin.a3_l2_falin.R;
import com.falin.valentin.a3_l2_falin.data.RestAPI;
import com.falin.valentin.a3_l2_falin.data.UserPojo;
import com.falin.valentin.a3_l2_falin.model.Model;
import com.falin.valentin.a3_l2_falin.presenter.Presenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    TextView userNickNameTextView;
    ImageView userAvatarImageView;
    Button loadButton;
    ProgressBar loadProgressBar;

    private Presenter presenter;

    private RestAPI restAPI;

    //private OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //okHttpClient = new OkHttpClient();

        initUI();
        initPresenter();
    }

    private void initPresenter() {
        Model model = new Model();
        presenter = new Presenter(model);
        presenter.attachView(this);
    }

    private void initUI() {
        textView = findViewById(R.id.content_text);
        editText = findViewById(R.id.content_edit_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                textView.setText(editable.toString());
            }
        });
        userNickNameTextView = findViewById(R.id.content_user_nickname);
        userAvatarImageView = findViewById(R.id.content_user_image);
        loadButton = findViewById(R.id.content_start_load_button);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadButtonClick();
            }
        });
        loadProgressBar = findViewById(R.id.content_load_progress_bar);
    }

    private void loadButtonClick() {
        presenter.loadButtonClick();
    }

    public void changeNickName(String newUserName) {
        userNickNameTextView.setText(newUserName);
    }

    public void showProgressBar() {
        loadProgressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar() {
        loadProgressBar.setVisibility(View.GONE);
    }

    public void downloadOneUrl(Call<List<UserPojo>> call) {
        call.enqueue(new Callback<List<UserPojo>>() {
            @Override
            public void onResponse(Call<List<UserPojo>> call, Response<List<UserPojo>> response) {
                if (response.isSuccessful()) {
                    if (response != null) {
                        UserPojo userPojo = null;
                        for (int i = 0; i < response.body().size(); i++) {
                            userPojo = response.body().get(i);
                            userNickNameTextView.append("\nId " + userPojo.getId() +
                                    "\nLogin " + userPojo.getLogin() +
                                    "\nAvatar URL " + userPojo.getAvatar_url());
                        }
                    }
                } else {
                    System.out.println("onResponse error: " + response.code());
                }
                hideProgressBar();
            }

            @Override
            public void onFailure(Call<List<UserPojo>> call, Throwable t) {
                System.out.println("onFailure " + t);
                hideProgressBar();
            }
        });
    }

//    public void downloadOneUrl(Request request) {
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (!response.isSuccessful()) {
//                    throw new IOException("Unknown request code " + response);
//                }
//                Headers headers = response.headers();
//                for (int i = 0; i < headers.size(); i++) {
//                    System.out.println(headers.name(i) + ": " + headers.value(i));
//                }
//                final String data = response.body().string();
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        userNickNameTextView.setText(data);
//                        loadProgressBar.setVisibility(View.GONE);
//                    }
//                });
//            }
//        });
//    }
}
