package com.example.jeremy.xmlparserapplication;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeremy on 4/17/2018.
 */

public class XmlAnnouncementHandler {

    List<Announcement> announcements;

    private Announcement a;
    private String text;

    public XmlAnnouncementHandler(){
        announcements = new ArrayList<Announcement>();
    }

    public List<Announcement> getAnnouncements(){
        return announcements;
    }

    public List<Announcement> parse(InputStream is){
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;

        try{
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);

            parser = factory.newPullParser();
            parser.setInput(is, null);
            int eventType = parser.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                String tagName = parser.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if(tagName.equalsIgnoreCase("announcement")){
                            a = new Announcement();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(tagName.equalsIgnoreCase("announcement")){
                            announcements.add(a);
                        }else if (tagName.equals("title")){
                            a.setTitle(text);
                        }else if (tagName.equals("department")){
                            a.setDepartment(text);
                        }else if (tagName.equals("course")){
                            a.setCourse(text);
                        }else if (tagName.equals("date")){
                            a.setDate(text);
                        }else if (tagName.equals("location")){
                            a.setLocation(text);
                        }
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return announcements;
    }
}
