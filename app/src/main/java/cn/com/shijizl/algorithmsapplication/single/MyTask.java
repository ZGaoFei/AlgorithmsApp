package cn.com.shijizl.algorithmsapplication.single;

import android.os.AsyncTask;


public class MyTask extends AsyncTask<Void, Integer, String> {

    public MyTask() {
        super();
    }

    @Override
    protected String doInBackground(Void... params) {

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

    }
}
