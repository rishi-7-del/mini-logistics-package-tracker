package tracker.model;

public class Package {
    private String id;
    private String customerName;
    private String destination;
    private String deliveryType;
    private DeliveryStatus status;

    public Package(String id, String customerName, String destination, String deliveryType) {
        this.id = id;
        this.customerName = customerName;
        this.destination = destination;
        this.deliveryType = deliveryType;
        this.status = DeliveryStatus.ORDERED;
    }

    public String getId() {
        return id;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public String getCustomerName() {
   	return customerName;
    }

    public String getDestination() {
   	return destination;
    }

    public void moveToNextStatus() {
        switch (status) {
            case ORDERED:
                status = DeliveryStatus.SHIPPED;
                break;
            case SHIPPED:
                status = DeliveryStatus.IN_TRANSIT;
                break;
            case IN_TRANSIT:
                status = DeliveryStatus.OUT_FOR_DELIVERY;
                break;
            case OUT_FOR_DELIVERY:
                status = DeliveryStatus.DELIVERED;
                break;
            case DELIVERED:
                System.out.println("Already Delivered!");
                break;
        }
    }

    @Override
    public String toString() {
        return id + " | " + customerName + " | " + destination +
               " | " + deliveryType + " | " + status;
    }
}