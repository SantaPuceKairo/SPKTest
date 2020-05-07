package model; //OBJEKS kuram jāsakrīt ar scratch.json struktūru klašu un mainīgo ziņā (nosaukumiem jāsakrīt)

public class Coord {
    private float lon;
    private float lat;

    public float getLon() { //Alt+insert+getter and setter
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }
}
