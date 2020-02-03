package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int height;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.view1);
        final ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);
        final ViewTreeObserver observer= layout.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        Log.d("Log", "Height: " + layout.getHeight());
                        AnimateDown(layout.getHeight());
                        //AnimateUp(layout.getHeight());

                    }
                });


    }

    void AnimateDown(final Integer height)
    {
        ObjectAnimator animation = ObjectAnimator.ofFloat(view, "translationY", 10f,height-75);
        animation.setDuration(3000);
        animation.setStartDelay(1000);
        //animation.setRepeatCount(-1);
        animation.start();
        animation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator)
            {
                AnimateUp(height);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        //AnimateUp(height);
    }
    void AnimateUp(final Integer height)
    {
        ObjectAnimator animation = ObjectAnimator.ofFloat(view, "translationY", height-75,0f);
        animation.setDuration(3000);
        animation.setStartDelay(1000);
        animation.start();
        animation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

                AnimateDown(height);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
       // AnimateDown(height);
    }




}
