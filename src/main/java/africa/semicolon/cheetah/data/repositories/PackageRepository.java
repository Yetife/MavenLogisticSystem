package africa.semicolon.cheetah.data.repositories;

import africa.semicolon.cheetah.data.models.Package;

import java.util.List;
import java.util.Optional;

public interface PackageRepository {
    Package save(Package apackage);

    List<Package> findAll();

    void delete(Package apackage);

    void delete(Integer id);

    Package findById(Integer id);
}
