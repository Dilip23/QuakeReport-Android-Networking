package quakereport;

/**
 * Created by LENOVO on 10-03-2018.
 */

public class Earthquake {

    //Variables for earthquake data
  private double mMagnitude;
    private String mLocation;
    private long mTimeInMillisecs;
    private String mUrl;


    public Earthquake(double magnitude,String location,long time,String Url){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMillisecs = time;
        mUrl = Url;
    }


    public  double getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public long   getmTimeInMillisecs() {
        return mTimeInMillisecs;
    }

    public String getmUrl() {
        return mUrl;
    }




}
