package ntk.demo.vnpay.payload;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseHandler {
    private final String SUCCESS = "success";
    private final String ERROR = "error";
    private ResponseEntity<Object> generateHandler(HttpStatus status, String message, Object data) {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("status", status.value());
        dataMap.put("message", message);
        dataMap.put("data", data);
        return new ResponseEntity<>(dataMap, status);
    }
}
