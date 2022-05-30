package com.example.airportfarebase;

public class Air {
    public String id, Name, VVP,Location;

    public Air() {
    }
    // Запрос значений
    public Air(String id, String name, String VVP, String location) {
        this.id = id;
        Name = name;
        this.VVP = VVP;
        Location = location;
    }
}
