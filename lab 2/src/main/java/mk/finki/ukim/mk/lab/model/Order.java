package mk.finki.ukim.mk.lab.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Order {

    private String balloonColor;
    private String balloonSize;

    private String clientName;

    private String clientAddress;

    private Long orderId;

    public Order( String balloonColor, String balloonSize, String clientName, String clientAddress) {
        this.orderId = (long) (Math.random() * 1000);
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
    }

    public String getBalloonColor() {
        return balloonColor;
    }

    public String getBalloonSize() {
        return balloonSize;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public Long getOrderId() {
        return orderId;
    }
}
