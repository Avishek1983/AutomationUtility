package roy.java.learm;

public class OfferValidation implements IFlightDetails {
    private String flightDetails ;
    private String flightNumber ;

    public String getFlightDetails() {
        return flightDetails;
    }

    public void setFlightDetails(String flightDetails) {
        this.flightDetails = flightDetails;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }


    public OfferValidation(String flightDetails, String flightNumber) {
        this.flightDetails = flightDetails;
        this.flightNumber = flightNumber;
    }

    public boolean isSegmentAvailable() {
        return false;
    }

    public String getBrand() {
        return null;
    }
}
