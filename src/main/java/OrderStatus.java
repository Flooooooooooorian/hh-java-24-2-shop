public enum OrderStatus {

    NEW(10),
    IN_PROGRESS(50),
    IN_DELIVERY(1),
    COMPLETED(0);

    private int deliveryTime;

    OrderStatus(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }
}
