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

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

import com.falin.valentin.a3_l2_falin.R;
import com.falin.valentin.a3_l2_falin.data.RestAPI;
import com.falin.valentin.a3_l2_falin.data.UserPojo;
import com.falin.valentin.a3_l2_falin.data.image.ImageLoader;
import com.falin.valentin.a3_l2_falin.data.image.PicassoImageLoader;
import com.falin.valentin.a3_l2_falin.data.realm.UserRealmPojo;
import com.falin.valentin.a3_l2_falin.model.Model;
import com.falin.valentin.a3_l2_falin.presenter.Presenter;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmModel;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    TextView userNickNameTextView;
    ImageView userAvatarImageView;
    Button loadButton;
    Button saveToRealmButton;
    Button loadFromRealmButton;
    Button clearRealmButton;
    ProgressBar loadProgressBar;

    private Presenter presenter;

    private ImageLoader<ImageView> imageLoader;

    UserPojo userPojo;
    Realm realm;

    //private OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //okHttpClient = new OkHttpClient();

        initUI();
        initPresenter();
        imageLoader = new PicassoImageLoader(Picasso.with(this));
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
        saveToRealmButton.findViewById(R.id.save_button);
        saveToRealmButton.setOnClickListener(getListener());
        loadFromRealmButton.findViewById(R.id.load_button);
        loadFromRealmButton.setOnClickListener(getListener());
        clearRealmButton.findViewById(R.id.clear_button);
        clearRealmButton.setOnClickListener(getListener());
    }

    private View.OnClickListener getListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                switch (id) {
                    case R.id.save_button:
                        Single<Bundle> singleSaveAllRealm = Single.create(new SingleOnSubscribe<Bundle>() {
                            @Override
                            public void subscribe(SingleEmitter<Bundle> emitter) throws Exception {
                                String curLogin = "";
                                String curId = "";
                                String curAvatarUrl = "";
                                realm = Realm.getDefaultInstance();
                                Date firstDate = new Date();
                                curLogin = userPojo.getLogin();
                                curId = userPojo.getId();
                                curAvatarUrl = userPojo.getAvatar_url();
                                try {
                                    realm.beginTransaction();
                                    UserRealmPojo userRealmPojo = realm.createObject(UserRealmPojo.class);
                                    userRealmPojo.setUserId(curId);
                                    userRealmPojo.setUserId(curId);
                                    userRealmPojo.setAvatarUrl(curAvatarUrl);
                                    realm.commitTransaction();
                                } catch (Exception e) {
                                    realm.cancelTransaction();
                                    emitter.onError(e);
                                    e.printStackTrace();
                                }
                                Date secondDate = new Date();
                                RealmResults<UserRealmPojo> temp = realm.where(UserRealmPojo.class).findAll();
                                Bundle bundle = new Bundle();
                                bundle.putLong("msek", firstDate.getTime() - secondDate.getTime());
                                emitter.onSuccess(bundle);
                                realm.close();
                            }
                        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                        //singleSaveAllRealm.subscribeWith(CreateO) todo!!!!
                        break;
                    case R.id.load_button:
                        // TODO: 04.04.2018
                        break;
                    case R.id.clear_button:
                        // TODO: 04.04.2018
                        break;
                }
            }
        };
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

    // For List Result
//    public void downloadOneUrl(Call<List<UserRealmPojo>> call) {
//        call.enqueue(new Callback<List<UserRealmPojo>>() {
//            @Override
//            public void onResponse(Call<List<UserRealmPojo>> call, Response<List<UserRealmPojo>> response) {
//                if (response.isSuccessful()) {
//                    if (response != null) {
//                        UserRealmPojo userPojo = null;
//                        for (int i = 0; i < response.body().size(); i++) {
//                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!! " + i);
//                            userPojo = response.body().get(i);
//                            userNickNameTextView.append("\nId " + userPojo.getId() +
//                                    "\nLogin " + userPojo.getLogin() +
//                                    "\nAvatar URL " + userPojo.getAvatar_url());
//                        }
//                    }
//                } else {
//                    System.out.println("onResponse error: " + response.code());
//                }
//                hideProgressBar();
//            }
//
//            @Override
//            public void onFailure(Call<List<UserRealmPojo>> call, Throwable t) {
//                System.out.println("onFailure " + t);
//                hideProgressBar();
//            }
//        });
//    }

    public void downloadOneUrl(Call<UserPojo> call) {
        call.enqueue(new Callback<UserPojo>() {
            @Override
            public void onResponse(Call<UserPojo> call, Response<UserPojo> response) {
                if (response.isSuccessful()) {
                    if (response != null) {
                        userPojo = response.body();
                        userNickNameTextView.append("\nId " + userPojo.getId() +
                                "\nLogin " + userPojo.getLogin() +
                                "\nAvatar URL " + userPojo.getAvatar_url());
                        imageLoader.downloadInfo(userPojo.getAvatar_url(), userAvatarImageView);
                    }
                } else {
                    System.out.println("onResponse error: " + response.code());
                }
                hideProgressBar();
            }

            @Override
            public void onFailure(Call<UserPojo> call, Throwable t) {
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
