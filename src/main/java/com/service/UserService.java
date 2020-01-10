package com.service;

import com.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
   List<User> queryAllUserList();
  }


