package nyc.c4q.midterm;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.splash_textview);
        DoSomeTask doSomeTask = new DoSomeTask(this);
        doSomeTask.execute(0);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private class DoSomeTask extends AsyncTask<Integer, Integer, Integer> {
        private Activity activity;

        public DoSomeTask(Activity activity) {
            this.activity = activity;
        }

        @Override
        protected void onPreExecute() {
            //Setup precondition to execute some task
        }

        @Override
        protected Integer doInBackground(Integer[] objects) {

            int i;
            for (i = objects[0]; i < 100000; i++) {
                publishProgress(i);
            }
            return i;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            textView.setText("Loops completed: " + values[0]);
        }

        @Override
        protected void onPostExecute(Integer o) {
            super.onPostExecute(o);
            textView.setText("Loops completed: " + o);

            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
