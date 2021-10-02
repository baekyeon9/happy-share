package com.share.ftp.handler.join;

import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class AuthDisplayUserInfoHandler implements Command {


  // 마이페이지의 나의정보보기
  @Override
  public void execute(CommandRequest request) throws Exception {

    JoinDTO loginUser = AuthLoginHandler.getLoginUser();

    if (loginUser == null) {
      System.out.println("로그인 하지 않았습니다.");
      return;
    }
    System.out.println();
    System.out.printf("[ %s님의 정보입니다 ]\n", loginUser.getName());

    System.out.printf("이름: %s\n", loginUser.getName());
    System.out.printf("전화: %s\n", loginUser.getTel());
    System.out.printf("이메일: %s\n", loginUser.getEmail());
    System.out.printf("주소: %s\n", loginUser.getAddress());
    System.out.printf("등록일: %s\n", loginUser.getRegisterDate());
  }
}

