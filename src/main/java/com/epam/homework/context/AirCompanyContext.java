package main.java.com.epam.homework.context;

import main.java.com.epam.homework.domain.*;

import java.util.ArrayList;
import java.util.List;

public class AirCompanyContext {

    private final static AirCompanyContext INSTANCE = new AirCompanyContext();

    private AirCompanyContext() {
    }

    public static AirCompanyContext getINSTANCE() {
        return INSTANCE;
    }

    private List<Blimp> blimpList = new ArrayList<>() {{
        add(new Blimp(10, 10, "Blimp1", 150f, 100f));
        add(new Blimp(12, 8, "Blimp2", 100f, 120f));
    }};
    private List<Glider> gliderList = new ArrayList<>() {{
        add(new Glider(150, 2, "Glider1", 200f, 2f));
        add(new Glider(90, 1, "Glider2", 250f, 3f));
    }};
    private List<Helicopter> helicopterList = new ArrayList<>() {{
        add(new Helicopter(400, 6, "Helicopter1", 300f, 5));
        add(new Helicopter(300, 4, "Helicopter2", 400f, 4));

    }};
    private List<Plain> plainList = new ArrayList<>() {{
        add(new Plain(4000, 50, "Plain1", 600f, 6));
        add(new Plain(4000, 40, "Plain2", 800f, 8));
    }};
    private List<Quadcopter> quadcopterList = new ArrayList<>() {{
        add(new Quadcopter(5, 0, "Quadcopter1", 600f, 120));
        add(new Quadcopter(3, 0, "Quadcopter2", 100f, 200));

    }};

    public <T extends AirTransport> List<T> retrieveAirTransportList(Class<T> tClass) {
        if (tClass.getName().equals(Blimp.class.getName()))
            return (List<T>) blimpList;
        if (tClass.getName().equals(Glider.class.getName()))
            return (List<T>) gliderList;
        if (tClass.getName().equals(Helicopter.class.getName()))
            return (List<T>) helicopterList;
        if (tClass.getName().equals(Plain.class.getName()))
            return (List<T>) plainList;
        if (tClass.getName().equals(Quadcopter.class.getName()))
            return (List<T>) quadcopterList;
        return null;
    }

    public List<AirTransport> retrieveAllAirTransport() {
        List<AirTransport> airTransportList = new ArrayList<>();
        airTransportList.addAll(blimpList);
        airTransportList.addAll(gliderList);
        airTransportList.addAll(helicopterList);
        airTransportList.addAll(plainList);
        airTransportList.addAll(quadcopterList);
        return airTransportList;
    }

}
