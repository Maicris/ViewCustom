package br.com.appdev.viewcustom;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Tela tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tela = new Tela(this);
        setContentView(tela);
    }

    public class Tela extends View {

        Random rnd = new Random();
        long startTime = 0;
        float elapsedTime = 0;
        int R = 0, G = 0, B = 0;

        public Tela(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            elapsedTime += (System.nanoTime() - startTime) / 1000000.0f;
            startTime = System.nanoTime();
            if (elapsedTime > 1000) {
                elapsedTime = 0;
                R = rnd.nextInt(256);
                G = rnd.nextInt(256);
                B = rnd.nextInt(256);
            }
            canvas.drawRGB(R, G, B);
            invalidate();
        }
    }
}
