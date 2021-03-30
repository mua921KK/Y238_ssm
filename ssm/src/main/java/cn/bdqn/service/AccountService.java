package cn.bdqn.service;

import cn.bdqn.domain.Account;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {

    // 查询所有账号
    public List<Account> queryAll();

    // 保存账号
    public void save(Account account);

    // 带分页查询
    public PageInfo<Account> queryAllByPage(Integer currentPage, Integer pageSize);

}
