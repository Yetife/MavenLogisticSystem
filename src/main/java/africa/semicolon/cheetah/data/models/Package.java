package africa.semicolon.cheetah.data.models;

import lombok.Data;

@Data
public class Package {
    private Integer id;
    private String name;
    private String senderEmail;
    private String receiverName;
    private String deliveryAdresss;
    private double netWeight;
    private String receiverPhone;
}
