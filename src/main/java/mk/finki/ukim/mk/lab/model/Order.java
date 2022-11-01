package mk.finki.ukim.mk.lab.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {

    private String balloonColor;
    private String balloonSize;

    private String clientName;

    private String clientAddress;

    private Long orderId;

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
