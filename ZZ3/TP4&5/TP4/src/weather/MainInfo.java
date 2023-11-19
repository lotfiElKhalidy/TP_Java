package weather;

import com.google.gson.annotations.SerializedName;
import com.sun.tools.javac.Main;

public class MainInfo {
    @SerializedName("temp")
    public double temp;
    @SerializedName("feels_like")
    public double feels_like;
    @SerializedName("temp_min")
    public double temp_min;
    @SerializedName("temp_max")
    public double temp_max;

    public MainInfo() {}

    @Override
    public String toString() {
        return "MainInfo{" +
                "temp=" + temp +
                ", feels_like=" + feels_like +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max + '}';
    }
}
