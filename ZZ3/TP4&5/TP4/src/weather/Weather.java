package weather;

import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("description")
    public String description;

    @Override
    public String toString() {
        return "{ description='" + description + '\'' + '}';
    }
}
