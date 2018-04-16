package com.falin.valentin.rxjava2training.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.falin.valentin.rxjava2training.R;
import com.falin.valentin.rxjava2training.model.CallableLongAction;
import com.falin.valentin.rxjava2training.model.Model;
import com.falin.valentin.rxjava2training.presenter.Presenter;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;


public class ViewFragment extends Fragment {
    Button firstButton;
    Button secondButton;
    Button thirdButton;
    Button fourthButton;
    Button fifthButton;
    Button sixthButton;
    Button seventhButton;
    Button eighthButton;
    Button ninthButton;
    Button tenthButton;
    Button eleventhButton;
    Button twelfthButton;
    Button thirteenthButton;
    Button fourteenthButton;
    Button fifteenthButton;
    TextView textView;
    ImageView imageView;

    Presenter presenter;


    public ViewFragment() {
        Model model = new Model();
        presenter = new Presenter(model);
        presenter.attachViewFragment(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        firstButton = view.findViewById(R.id.first_button);
        firstButton.setOnClickListener(v -> presenter.firstButtonClick());
        secondButton = view.findViewById(R.id.second_button);
        secondButton.setOnClickListener(v -> presenter.secondButtonClick());
        thirdButton = view.findViewById(R.id.third_button);
        thirdButton.setOnClickListener(v -> presenter.thirdButtonClicked());
        fourthButton = view.findViewById(R.id.fourth_button);
        fourthButton.setOnClickListener(v -> presenter.fourthButtonClicked());
        fifthButton = view.findViewById(R.id.fifth_button);
        fifthButton.setOnClickListener(v -> presenter.fifthButtonClicked());
        sixthButton = view.findViewById(R.id.sixth_button);
        sixthButton.setOnClickListener(v -> presenter.sixthButtonClicked());
        seventhButton = view.findViewById(R.id.seventh_button);
        seventhButton.setOnClickListener(v -> presenter.seventhButtonClicked());
        eighthButton = view.findViewById(R.id.eighth_button);
        eighthButton.setOnClickListener(v -> presenter.eighthButtonClicked());
        ninthButton = view.findViewById(R.id.ninth_button);
        ninthButton.setOnClickListener(v -> presenter.ninthButtonClicked());
        tenthButton = view.findViewById(R.id.tenth_button);
        tenthButton.setOnClickListener(v -> presenter.tenthButtonClicked());
        eleventhButton = view.findViewById(R.id.eleventh_button);
        eleventhButton.setOnClickListener(v -> presenter.eleventhButtonClicked());
        twelfthButton = view.findViewById(R.id.twelfth_button);
        twelfthButton.setOnClickListener(v -> presenter.twelfthButtonClicked());
        thirteenthButton = view.findViewById(R.id.thirteenth_button);
        thirteenthButton.setOnClickListener(v -> presenter.thirteenthButtonClicked());
        fourteenthButton = view.findViewById(R.id.fourteenth_button);
        fourteenthButton.setOnClickListener(v -> presenter.fourteenthButtonClicked());
        fifteenthButton = view.findViewById(R.id.fifteenth_button);
        fifteenthButton.setOnClickListener(v -> presenter.fifteenthButtonClicked());
        textView = view.findViewById(R.id.text);
        imageView = view.findViewById(R.id.image);
    }

    private void clearTextView() {
        textView.setText("");
    }

    public void firstButtonClick(Observable<String> stringObservable) {
        clearTextView();
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
            }

            @Override
            public void onNext(String s) {
                textView.append("- onNext method " + s + "\n");
            }

            @Override
            public void onError(Throwable e) {
                textView.append("- onError method " + e + "\n");
            }

            @Override
            public void onComplete() {
                textView.append("- onComplete method.");
            }
        };
        stringObservable.subscribe(observer);
    }

    public void secondButtonClick(Observable<Integer> integerObservable) {
        clearTextView();
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
            }

            @Override
            public void onNext(Integer integer) {
                textView.append("- onNext method " + integer + "\n");
            }

            @Override
            public void onError(Throwable e) {
                textView.append("- onError method " + e + "\n");
            }

            @Override
            public void onComplete() {
                textView.append("- onComplete method.");
            }
        };
        integerObservable.subscribe(observer);
    }

    public void thirdButtonClicked(Observable<Long> longObserver) {
        clearTextView();
        Observer<Long> observer = new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
            }

            @Override
            public void onNext(Long aLong) {
                textView.append("- onNext method " + aLong + "\n");
            }

            @Override
            public void onError(Throwable e) {
                textView.append("- onError method " + e + "\n");
            }

            @Override
            public void onComplete() {
                textView.append("- onComplete method.");
            }
        };
        longObserver.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }

    public void fourthButtonClicked(Callable<Integer> callable) {
        clearTextView();
        Observable.fromCallable(callable)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        textView.append("- onSubscribe method " + d + "\n");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        textView.append("- onNext method " + integer + "\n");
                    }

                    @Override
                    public void onError(Throwable e) {
                        textView.append("- onError method " + e + "\n");
                    }

                    @Override
                    public void onComplete() {
                        textView.append("- onComplete method.");
                    }
                });
    }

    public void fifthButtonClicked(String[] stringMass) {
        Function<String, Integer> function = Integer::parseInt;

        Observable<Integer> observable = Observable
                .fromArray(stringMass)
                .map(function);
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
                textView.append("Input mass type id String.\n Taken type is Integer \n");
            }

            @Override
            public void onNext(Integer integer) {
                textView.append("- onNext method " + integer + "\n");
            }

            @Override
            public void onError(Throwable e) {
                textView.append("- onError method " + e + "\n");
            }

            @Override
            public void onComplete() {
                textView.append("- onComplete method.");
            }
        };
        observable.subscribe(observer);
    }

    public void sixButtonClicked(final Integer[] integerMass) {
        clearTextView();
        Observable<List<Integer>> observable = Observable
                .fromArray(integerMass)
                .buffer(integerMass.length % 3);

        Observer<List<Integer>> observer = new Observer<List<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
                textView.append("MassSize - " + integerMass.length + "\n");
                textView.append("Elements in row - " + (integerMass.length % 3) + "\n");
            }

            @Override
            public void onNext(List<Integer> list) {
                textView.append("- onNext method " + list.toString() + "\n");
            }

            @Override
            public void onError(Throwable e) {
                textView.append("- onError method " + e + "\n");
            }

            @Override
            public void onComplete() {
                textView.append("- onComplete method.");
            }
        };
        observable.subscribe(observer);
    }

    public void seventhButtonClicked(final Integer[] integerMass) {
        clearTextView();
        Observable<Integer> observable = Observable
                .fromArray(integerMass)
                .take(integerMass.length - 2);
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
                textView.append("MassSize - " + integerMass.length + "\n");
                textView.append("Elements take - " + (integerMass.length - 2) + "\n");
            }

            @Override
            public void onNext(Integer integer) {
                textView.append("- onNext method " + integer + "\n");
            }

            @Override
            public void onError(Throwable e) {
                textView.append("- onError method " + e + "\n");
            }

            @Override
            public void onComplete() {
                textView.append("- onComplete method.");
            }
        };
        observable.subscribe(observer);
    }

    public void eighthButtonClicked(Integer[] integerMass) {
        clearTextView();
        Observable<Integer> observable = Observable
                .fromArray(integerMass)
                .skip(2);
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
                textView.append("Mass - ");
                for (Integer i : integerMass) {
                    textView.append(" " + i);
                }
                textView.append("\n");
                textView.append("Elements skip - " + (2) + "\n");
            }

            @Override
            public void onNext(Integer integer) {
                textView.append("- onNext method " + integer + "\n");
            }

            @Override
            public void onError(Throwable e) {
                textView.append("- onError method " + e + "\n");
            }

            @Override
            public void onComplete() {
                textView.append("- onComplete method.");
            }
        };
        observable.subscribe(observer);
    }

    public void ninthButtonClicked(Integer[] integerMass) {
        clearTextView();
        Observable<Integer> observable = Observable
                .fromArray(integerMass)
                .distinct();
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
                textView.append("Mass - ");
                for (Integer i : integerMass) {
                    textView.append(" " + i);
                }
                textView.append("\n");
            }

            @Override
            public void onNext(Integer integer) {
                textView.append("- onNext method " + integer + "\n");
            }

            @Override
            public void onError(Throwable e) {
                textView.append("- onError method " + e + "\n");
            }

            @Override
            public void onComplete() {
                textView.append("- onComplete method.");
            }
        };
        observable.subscribe(observer);
    }

    public void tenthButtonClicked(Predicate<String> predicate, String[] stringMass) {
        clearTextView();
        Observable<String> observable = Observable
                .fromArray(stringMass)
                .filter(predicate);
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
                textView.append("Mass - ");
                for (String s : stringMass) {
                    textView.append(" " + s);
                }
                textView.append("\nFilter 1 and 3\n");
            }

            @Override
            public void onNext(String s) {
                textView.append("- onNext method " + s + "\n");
            }

            @Override
            public void onError(Throwable e) {
                textView.append("- onError method " + e + "\n");
            }

            @Override
            public void onComplete() {
                textView.append("- onComplete method.");
            }
        };
        observable.subscribe(observer);
    }

    public void eleventhButtonClicked(Integer[] integerMass, Integer[] integerDuplicateMass) {
        clearTextView();
        Observable<Integer> observable = Observable
                .fromArray(integerMass)
                .mergeWith(Observable.fromArray(integerDuplicateMass));
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
                textView.append("Mass1 - ");
                for (Integer i : integerMass) {
                    textView.append(" " + i);
                }
                textView.append("\nMass2 - ");
                for (Integer i : integerDuplicateMass) {
                    textView.append(" " + i);
                }
                textView.append("\n");
            }

            @Override
            public void onNext(Integer integer) {
                textView.append("- onNext method " + integer + "\n");
            }

            @Override
            public void onError(Throwable e) {
                textView.append("- onError method " + e + "\n");
            }

            @Override
            public void onComplete() {
                textView.append("- onComplete method.");
            }
        };
        observable.subscribe(observer);
    }

    public void twelfthButtonClicked(BiFunction<Integer, String, String> stringAndIntegerFunction, Integer[] integerMass, String[] stringMass) {
        clearTextView();
        Observable<Integer> intObservable = Observable.fromArray(integerMass);
        Observable<String> stringObservable = Observable.fromArray(stringMass);
        Observable<String> observable = Observable.zip(intObservable, stringObservable, stringAndIntegerFunction);
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
                textView.append("Integer Mass - ");
                for (Integer i : integerMass) {
                    textView.append(" " + i);
                }
                textView.append("\nString Mass - ");
                for (String s : stringMass) {
                    textView.append(" " + s);
                }
                textView.append("\n");
            }

            @Override
            public void onNext(String s) {
                textView.append("- onNext method " + s + "\n");
            }

            @Override
            public void onError(Throwable e) {
                textView.append("- onError method " + e + "\n");
            }

            @Override
            public void onComplete() {
                textView.append("- onComplete method.");
            }
        };
        observable.subscribe(observer);
    }

    public void thirteenthButtonClicked(Predicate<Integer> predicate, Integer[] integerDuplicateMass) {
        clearTextView();
        Observable<Integer> observable = Observable
                .fromArray(integerDuplicateMass)
                .takeUntil(predicate);
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
                textView.append("Integer Mass - ");
                for (Integer i : integerDuplicateMass) {
                    textView.append(" " + i);
                }
                textView.append("\nStop when item == 4\n");
            }

            @Override
            public void onNext(Integer integer) {
                textView.append("- onNext method " + integer + "\n");
            }

            @Override
            public void onError(Throwable e) {
                textView.append("- onError method " + e + "\n");
            }

            @Override
            public void onComplete() {
                textView.append("- onComplete method.");
            }
        };
        observable.subscribe(observer);
    }

    public void fourteenthButtonClicked(Predicate<Integer> predicate, Integer[] integerDuplicateMass) {
        clearTextView();
        Single<Boolean> single = Observable
                .fromArray(integerDuplicateMass)
                .all(predicate);
        SingleObserver<Boolean> observer = new SingleObserver<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {
                textView.append("- onSubscribe method " + d + "\n");
                textView.append("Integer Mass - ");
                for (Integer i : integerDuplicateMass) {
                    textView.append(" " + i);
                }
                textView.append("\nIs items in mass < 20\n");
            }

            @Override
            public void onSuccess(Boolean aBoolean) {
                textView.append("- onNext method result - " + aBoolean + "\n");
            }

            @Override
            public void onError(Throwable e) {
                textView.append("- onError method " + e + "\n");
            }
        };
        single.subscribe(observer);
    }

    public void fifteenthButtonClicked(String[] stringMass) {
        Observable<String> observable = Observable.fromArray(stringMass);
        Consumer<String> consumer = (string) -> textView.append("- accept method " + string + "\n");
        observable.subscribe(consumer);
    }
}
