package africa.semicolon.cheetah.data.repositories;

import africa.semicolon.cheetah.data.models.Package;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageRepositoryImplTest {
    private PackageRepository packageRespository;
    @BeforeEach
    void setUp() {
        packageRespository = new PackageRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveNewPackageTest() {
        Package savedPackage = saveNewPackage();
        assertEquals(1, savedPackage.getId());
    }

    private Package saveNewPackage() {
        Package apackage = new Package();
        apackage.setName("Slepping Mat");
        apackage.setSenderEmail("Jerry@email.com");
        apackage.setReceiverName("Dami");
        apackage.setReceiverPhone("0987377576");
        apackage.setDeliveryAdresss("312 Herbert Macaulay Way, Sabo Yaba Lagos");
        apackage.setNetWeight(23.5);

        return packageRespository.save(apackage);
    }

    @Test
    void updatePackageTest() {
        Package savedPackage = saveNewPackage();
        savedPackage.setName("Sniper");
        Package updatedPackage = packageRespository.save(savedPackage);
        assertEquals(1, updatedPackage.getId());
    }

    @Test
    void findAll() {
        Package savedPackage = saveNewPackage();
        assertEquals(1, packageRespository.findAll().size());
    }

    @Test
    void delete() {
        Package savedPackage = saveNewPackage();
        assertEquals(1, packageRespository.findAll().size());

        packageRespository.delete(savedPackage);
        assertEquals(0, packageRespository.findAll().size());
    }

    @Test
    void deleteByTrackingNumber() {
        Package savedPackage = saveNewPackage();
        assertEquals(1, packageRespository.findAll().size());

        packageRespository.delete(1);
        assertEquals(0, packageRespository.findAll().size());
    }

    @Test
    void findById() {
        Package savedPackage = saveNewPackage();
    }
}