package myPackage.services;
import myPackage.db.catalogue;
import myPackage.db.catalogueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class cataServ {
    @Autowired
    catalogueRepo crepo;

    final Map<Long,catalogue> mp=new HashMap<>();

    public catalogue findByCustId(long custid){
        if(mp.containsKey(custid)){
            return mp.get(custid);
        }
        else {
            mp.put(custid, crepo.findByCustid(custid));
            return crepo.findByCustid(custid);
        }
    }
}
