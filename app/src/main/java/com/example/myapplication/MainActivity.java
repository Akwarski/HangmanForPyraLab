package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button bt = findViewById(R.id.button);
    ImageView iv;
    int wskaznik;
    ArrayList<String> mysteryWords = new ArrayList<>();
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        iv = findViewById(R.id.imagine_v);

        wskaznik =0;
        choosePicture(wskaznik);

        InputStream is = getResources().openRawResource(R.raw.mystery_words);
        InputStreamReader isr = new InputStreamReader(is);

        LineNumberReader lnr = new LineNumberReader(isr);

        try{
            while((temp = lnr.readLine()) != null){
                if(!temp.equals(""))
                    mysteryWords.add(temp);
            }

            lnr.close();
        }catch (IOException e){
            e.printStackTrace();
        }


        //
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Funkcja która przeszukuje zahaszowany wyraz i zamienia "*" na daną literę jeśli istnieje
                //jeśli wprowadzona litera nie znajduję się w słowie które musimy zgadnąć zmienia nam rysunek przez zwiększenie wskaźnika i wywołanie funkcji która zmienia obrazek
            }
        });

        //button który rozpoczyna grę
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosePicture(wskaznik);

                //zerujemy obrazek przez ustawienie wskaźnika na 0 i wywołanie funkcji zmieniającej obrazek
                //czyścimy TextView
                //losujemy słowo wprowadzone do naszego pliku tekstowego
                //wywołujemy funkcję która haszuje nam nasze słowo

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    int drawable;
    public void choosePicture(int w){
        switch(w){
            case 0:
                drawable = R.drawable.hang_zero;
                break;
            case 1:
                drawable = R.drawable.hang_one;
                break;
            case 2:
                drawable = R.drawable.hang_two;
                break;
            case 3:
                drawable = R.drawable.hang_three;
                break;
            case 4:
                drawable = R.drawable.hang_four;
                break;
            case 5:
                drawable = R.drawable.hang_five;
                break;
            case 6:
                drawable = R.drawable.hang_six;
                break;
            case 7:
                drawable = R.drawable.hang_seven;
                break;
            case 8:
                drawable = R.drawable.hang_eight;
                break;
            default:
                drawable = R.drawable.hang_nine;
        }
        iv.setImageResource(drawable);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //funkcja do sprawdzania czy wprowadzony pełny wyraz jest taki sam jak poszukiwanny wyraz
    public void checkWord(View view) {
        //funkcja sprawdza czy wprowadzone słowo do pola EditText jest takie samo jak zahaszowany wyraz
        //jeśli tak informujemy że gra została wygrana i informację o tym wyświetlamy w Snackbar
        //jeśli nie zmieniamy obrazek przez zwiększenie wskaźnika i wywołaneie funkcji do zmiany obrazku
    }
}
