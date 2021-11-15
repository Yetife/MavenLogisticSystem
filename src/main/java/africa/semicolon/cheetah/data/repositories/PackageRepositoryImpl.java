package africa.semicolon.cheetah.data.repositories;

import africa.semicolon.cheetah.data.models.Package;
import lombok.Data;

import java.util.*;

@Data
public class PackageRepositoryImpl implements PackageRepository {
    private final Map<Integer, Package> database = new HashMap<>();

    @Override
    public Package save(Package apackage) {
        Integer id = null;
        if (apackage.getId() == null) {
            id = database.size() + 1;
            apackage.setId(id);
        }
        id = apackage.getId();
        database.put(id, apackage);
        return database.get(id);
    }

    @Override
    public List<Package> findAll() {
        List<Package> all = new ArrayList<>();
        Set<Integer> keys = database.keySet();
        for (Integer key : keys) {
            all.add(database.get(key));
        }
//        keys.forEach(key -> all.add(database.get(key)));
        return all;
    }

    @Override
    public void delete(Package apackage) {
        database.remove(apackage.getId());
    }

    @Override
    public void delete(Integer id) {
        database.remove(id);
    }

    @Override
    public Package findById(Integer id) {
        return null;
    }

}
