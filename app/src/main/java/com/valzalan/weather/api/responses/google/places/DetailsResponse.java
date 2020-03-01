package com.valzalan.weather.api.responses.google.places;

import com.google.gson.annotations.SerializedName;

public class DetailsResponse {
    @SerializedName("result")
    private DetailsResult result;

    public DetailsResponse(DetailsResult result) {
        this.result = result;
    }

    public double getLatitude() {
        return result.getGeometry().getLocation().getLatitude();
    }

    public double getLongitude() {
        return result.getGeometry().getLocation().getLongitude();
    }

    private class DetailsResult {
        @SerializedName("geometry")
        private Geometry geometry;

        public DetailsResult(Geometry geometry) {
            this.geometry = geometry;
        }

        Geometry getGeometry() {
            return geometry;
        }
    }

    private class Geometry {
        @SerializedName("location")
        private Location location;

        public Geometry(Location location) {
            this.location = location;
        }

        Location getLocation() {
            return location;
        }
    }

    private class Location {
        @SerializedName("lat")
        private double latitude;
        @SerializedName("lng")
        private double longitude;

        public Location(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        double getLatitude() {
            return latitude;
        }

        double getLongitude() {
            return longitude;
        }
    }
}
