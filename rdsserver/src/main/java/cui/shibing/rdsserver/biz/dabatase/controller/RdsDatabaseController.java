package cui.shibing.rdsserver.biz.dabatase.controller;

import cui.shibing.rdsserver.biz.dabatase.RdsDatabaseInfoService;
import cui.shibing.rdsserver.biz.dabatase.domain.RdsDatabaseInfo;
import cui.shibing.rdsserver.biz.dabatase.dto.DatabaseInfoParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/database")
public class RdsDatabaseController {

    @Autowired
    private RdsDatabaseInfoService databaseInfoService;

    @GetMapping("/all")
    public List<RdsDatabaseInfo> findAll() {
        return databaseInfoService.findAll();
    }

    @PostMapping("/create")
    public boolean create(@RequestBody DatabaseInfoParam param) {
        return databaseInfoService.createDatabaseInfo(param);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody DatabaseInfoParam param) {
        return databaseInfoService.updateDatabaseInfo(param);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestBody DatabaseInfoParam param) {
        return databaseInfoService.deleteDatabaseInfo(param);
    }

}
