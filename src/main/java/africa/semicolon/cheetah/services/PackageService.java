package africa.semicolon.cheetah.services;

import africa.semicolon.cheetah.data.models.Package;
import africa.semicolon.cheetah.dtos.requests.AddPackageRequest;
import africa.semicolon.cheetah.dtos.responses.AddPackageResponse;

import java.util.Collection;
import java.util.List;

public interface PackageService {

    AddPackageResponse addPackage(AddPackageRequest addPackageRequest);

    Package findPackageWithMy(Integer id);

    List<Package> getAllPackage();
}
