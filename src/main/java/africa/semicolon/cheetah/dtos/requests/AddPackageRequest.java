package africa.semicolon.cheetah.dtos.requests;

import lombok.Data;

@Data
public class AddPackageRequest {
    private String senderName;
    private String senderPhonenumber;
    private String receiverName;
    private String deliveryAdresss;
    private double packageWeight;
    private String packageDescription;
    private String receiverPhone;
}
