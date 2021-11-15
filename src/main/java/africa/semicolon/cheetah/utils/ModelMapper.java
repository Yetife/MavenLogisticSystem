package africa.semicolon.cheetah.utils;
import africa.semicolon.cheetah.data.models.Package;
import africa.semicolon.cheetah.data.models.Sender;
import africa.semicolon.cheetah.dtos.requests.AddPackageRequest;
import africa.semicolon.cheetah.dtos.requests.RegisterSenderRequest;
import africa.semicolon.cheetah.dtos.responses.AddPackageResponse;
import africa.semicolon.cheetah.dtos.responses.RegisterSenderResponse;

public class ModelMapper {
    public static Package map(AddPackageRequest addPackageRequest)
    {
        Package apackage = new Package();
        apackage.setName(addPackageRequest.getPackageDescription());
        apackage.setSenderEmail(addPackageRequest.getSenderEmail());
        apackage.setDeliveryAdresss(addPackageRequest.getDeliveryAdresss());
        apackage.setReceiverPhone(addPackageRequest.getReceiverPhone());
        apackage.setReceiverName(addPackageRequest.getReceiverName());
        apackage.setNetWeight(addPackageRequest.getPackageWeight());

        return apackage;
    }

    public static AddPackageResponse map(Package savedPackage)
    {
        AddPackageResponse response = new AddPackageResponse();
        response.setPackageName(savedPackage.getName());
        response.setPackageWeight(savedPackage.getNetWeight());
        response.setReceiverName(savedPackage.getReceiverName());
        response.setTrackingNumber(savedPackage.getId());
        response.setReceiverPhone(savedPackage.getReceiverPhone());

        return response;
    }

    public static Sender map(RegisterSenderRequest registerSenderRequest)
    {
        Sender sender = new Sender();
        sender.setSenderName(registerSenderRequest.getSenderName());
        sender.setPhoneNumber(registerSenderRequest.getPhoneNumber());
        sender.setEmailAddress(registerSenderRequest.getSenderEmail());

        return sender;
    }

    public static RegisterSenderResponse map(Sender sender)
    {
        RegisterSenderResponse response = new RegisterSenderResponse();
        response.setSenderEmail(sender.getEmailAddress());
        return response;
    }
}
