package ntk.demo.vnpay.payload;

import lombok.Data;

@Data
public class MessageResponse {
    private String message;
    private int status;
}
