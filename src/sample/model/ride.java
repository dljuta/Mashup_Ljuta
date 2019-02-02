package sample.model;

public class ride {
    private String arrival;

    private String from;

    private String to;

    private String departure;

    private String[] connections;

    public String getArrival ()
    {
        return arrival;
    }

    public void setArrival (String arrival)
    {
        this.arrival = arrival;
    }

    public String getFrom ()
    {
        return from;
    }

    public void setFrom (String from)
    {
        this.from = from;
    }

    public String getTo ()
    {
        return to;
    }

    public void setTo (String to)
    {
        this.to = to;
    }

    public String getDeparture ()
    {
        return departure;
    }

    public void setDeparture (String departure)
    {
        this.departure = departure;
    }

    public String[] getConnections ()
    {
        return connections;
    }

    public void setConnections (String[] connections)
    {
        this.connections = connections;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [arrival = "+arrival+", from = "+from+", to = "+to+", departure = "+departure+", connections = "+connections+"]";
    }
}
