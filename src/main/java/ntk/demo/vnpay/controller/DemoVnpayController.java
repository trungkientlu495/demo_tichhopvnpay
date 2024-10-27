package ntk.demo.vnpay.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ntk.demo.vnpay.services.vnpay.VnPayServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DemoVnpayController {
    private final VnPayServices vnpayServices;
    @PostMapping("/thanhtoan")
    public String thanhtoan(HttpServletRequest request) {
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + 8080;
        String vnpayUrl = vnpayServices.createOrder(2, "kIEN", baseUrl);
        return vnpayUrl;
    }

    @PostMapping("/returnOrder")
    public Boolean returnOrder(HttpServletRequest request) {
        return (vnpayServices.orderReturn(request) == 1) ? true : false;
    }
}
