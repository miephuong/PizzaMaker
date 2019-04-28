package com.example.pizzamaker;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadLogo extends AppCompatActivity {
    Button downnload_button;
    ImageView imageView;
    String image_src = "https://via.ritzau.dk/data/images/00819/ee299b6a-8573-4435-99d7-666fdebdba17.jpg";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_logo);

        downnload_button = findViewById(R.id.download_button);
        imageView = findViewById(R.id.imageView);

        downnload_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadLogo.downloadTask downloadTask = new DownloadLogo.downloadTask();
                downloadTask.execute(image_src);
            }
        });
    }

    class downloadTask extends AsyncTask<String, Integer, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(DownloadLogo.this);
            progressDialog.setTitle("Download in progress...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMax(100);
            progressDialog.setProgress(0);
            progressDialog.show();
            //super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressDialog.setProgress(0);

            //super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.hide();
            Toast.makeText(DownloadLogo.this, result, Toast.LENGTH_SHORT).show();
            String path = "sdcard/internet_image/random_image.jpg";
            imageView.setImageDrawable(Drawable.createFromPath(path));

        }

        protected String doInBackground(String... params) {
            String path = params[0];
            int file_length = 0;

            try {
                URL url = new URL(path);
                URLConnection urlConnection = url.openConnection();
                urlConnection.connect();
                file_length = urlConnection.getContentLength();
                File new_folder = new File("sdcard/internet_image");

                if (new_folder.exists()) {
                    new_folder.mkdir();
                }

                File input_file = new File(new_folder, "random_image.jpg");
                InputStream inputStream = new BufferedInputStream(url.openStream(), 8192);
                OutputStream outputStream = new FileOutputStream(input_file);

                byte[] data = new byte[1024];
                int total = 0;
                int count = 0;
                while ((count = inputStream.read(data)) != -1) {
                    total += count;
                    outputStream.write(data, 0, count);
                    int progress = total * 100 / file_length;
                    publishProgress(progress);
                }
                inputStream.close();
                outputStream.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "Download complete.";
        }
    }
}
