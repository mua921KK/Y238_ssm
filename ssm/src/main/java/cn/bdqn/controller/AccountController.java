package cn.bdqn.controller;

import cn.bdqn.domain.Account;
import cn.bdqn.service.AccountService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Transactional
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/queryAll")
    public List<Account> queryAll(){
        List<Account> accounts = accountService.queryAll();
        return accounts;
    }

    @GetMapping("/queryAllList")
    public ModelAndView queryAll(@RequestParam(name = "currentPage",required = false,defaultValue = "1") Integer currentPage){

        PageInfo<Account> pageInfo = accountService.queryAllByPage(currentPage,3);

        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("list");
        return mv;
    }

    @GetMapping("/save")
    public Map<String,Object> save(){

        Account account = new Account();
        account.setBalance(100);
        account.setAge(12);
        account.setName("胡柳妙");

        accountService.save(account);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",200);
        map.put("message","保存成功");
        map.put("data",null);

        return map;
    }

}
