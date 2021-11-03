package africa.semicolon.cheetah.utils;
import africa.semicolon.cheetah.data.models.Package;
import africa.semicolon.cheetah.dtos.requests.AddPackageRequest;
import africa.semicolon.cheetah.dtos.responses.AddPackageResponse;

public class ModelMapper {
    public static Package map(AddPackageRequest addPackageRequest)
    {
        Package apackage = new Package();
        apackage.setName(addPackageRequest.getPackageDescription());
        apackage.setSenderPhone(addPackageRequest.getSenderPhone());
        apackage.setDeliveryAdresss(addPackageRequest.getDeliveryAdresss());
        apackage.setSenderName(addPackageRequest.getSenderName());
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
}
