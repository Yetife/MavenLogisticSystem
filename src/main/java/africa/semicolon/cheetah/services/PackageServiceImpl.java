package africa.semicolon.cheetah.services;

import africa.semicolon.cheetah.data.models.Package;
import africa.semicolon.cheetah.data.models.Sender;
import africa.semicolon.cheetah.data.repositories.PackageRepository;
import africa.semicolon.cheetah.data.repositories.PackageRepositoryImpl;
import africa.semicolon.cheetah.dtos.requests.AddPackageRequest;
import africa.semicolon.cheetah.dtos.responses.AddPackageResponse;
import africa.semicolon.cheetah.exceptions.SenderDoesNotExistException;
import africa.semicolon.cheetah.utils.ModelMapper;

import java.util.List;
import java.util.Optional;

public class PackageServiceImpl implements PackageService {
    private static final PackageRepository packageRespository = new PackageRepositoryImpl();
    private final SenderService senderService = new SenderServiceImpl();

    @Override
    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {
        Optional<Sender> senderOptional = senderService.findSenderByEmail((addPackageRequest.getSenderEmail()));
        if (senderOptional.isEmpty())  throw new SenderDoesNotExistException("Sender not registered");
        //convert addpackage request to a package
        Package apackage = ModelMapper.map(addPackageRequest);
        //save package
        Package savedPackage = packageRespository.save(apackage);
        //convert saved package to addpackage response
        AddPackageResponse response = ModelMapper.map(savedPackage);
        //return converted response
        return response;
    }

    @Override
    public Package findPackageWithMy(Integer id) {
        return packageRespository.findById(id);
    }

    @Override
    public List<Package> getAllPackage() {
        return packageRespository.findAll();
    }
}
