package shopping.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminGoodsController {
    private static final Logger log = LoggerFactory.getLogger(AdminGoodsController.class);

    @RequestMapping("goods")
    public String goodsLists(){
        log.debug("view goods list");
        return "admin_itemsList.html";
    }

    @RequestMapping("stock/list")
    public String stockLists(){
        log.debug("view stock list");
        return "admin_stockList.html";
    }
}
