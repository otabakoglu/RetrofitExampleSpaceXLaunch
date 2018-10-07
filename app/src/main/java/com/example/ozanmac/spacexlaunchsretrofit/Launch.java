package com.example.ozanmac.spacexlaunchsretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Launch {

    @SerializedName("flight_number")
    @Expose
    public Integer flightNumber;

    @SerializedName("mission_name")
    @Expose
    public String missionName;

    @SerializedName("launch_year")
    @Expose
    public String launchYear;

    @SerializedName("rocket")
    @Expose
    public Rocket rocket;

    @Override
    public String toString() {
        return "Launch{" +
                "flightNumber=" + flightNumber +
                ", missionName='" + missionName + '\'' +
                ", launchYear='" + launchYear + '\'' +
                ", rocketName=" + rocket.rocketName +
                '}';
    }
}
