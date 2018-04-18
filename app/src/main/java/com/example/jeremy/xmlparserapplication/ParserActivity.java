package com.example.jeremy.xmlparserapplication;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ParserActivity extends Activity implements View.OnClickListener{

    Button aButton;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parser);

        aButton = findViewById(R.id.aButton);
        listView = findViewById(R.id.list);
    }

    @Override
    public void onClick(View view) {
        List<Announcement> announcements = null;
        try {
            XmlAnnouncementHandler parser = new XmlAnnouncementHandler();
            announcements = parser.parse(getAssets().open("announcements.xml"));
            ArrayAdapter<Announcement> adapter =
                    new ArrayAdapter<Announcement>(this, R.layout.item,R.id.list);

            listView.setAdapter(adapter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public void pullAnnouncementData(){
//        List<Announcement> announcements = null;
//        try {
//            XmlAnnouncementHandler parser = new XmlAnnouncementHandler();
//            announcements = parser.parse(getAssets().open("announcements.xml"));
//            ArrayAdapter<Announcement> adapter =
//                    new ArrayAdapter<Announcement>(this, R.layout.item,R.id.list);
//
//            listView.setAdapter(adapter);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
}
