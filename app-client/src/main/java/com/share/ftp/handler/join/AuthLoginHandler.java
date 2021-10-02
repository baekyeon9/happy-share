package com.share.ftp.handler.join;

import static com.share.menu.Menu.ACCESS_ADMIN;
import static com.share.menu.Menu.ACCESS_LOGOUT;
import static com.share.menu.Menu.ACCESS_MEMBER;
import static com.share.menu.Menu.ACCESS_MEMBER_ADMIN;
import static com.share.menu.Menu.ACCESS_ORG;
import static com.share.menu.Menu.ACCESS_PERSONAL;
import static com.share.util.General.member.ORG;
import static com.share.util.General.member.PERSONAL;
import java.sql.Date;
import java.util.HashMap;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.request.RequestAgent;
import com.share.util.Prompt;

public class AuthLoginHandler implements Command {

  RequestAgent requestAgent;

  public static JoinDTO loginUser;

  public static int userAccessLevel = ACCESS_LOGOUT;

  public static JoinDTO getLoginUser() {
    return loginUser;
  }

  public static int getUserAccessLevel() {
    return userAccessLevel;
  }

  public AuthLoginHandler(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[로그인]");

    String id = Prompt.inputString("아이디? ");
    String password = Prompt.inputString("비밀번호? ");
    System.out.println();

    if (id.equals("admin") && password.equals("111")) {
      JoinDTO admin = new JoinDTO();
      admin.setId("admin");
      admin.setName("관리자");
      admin.setEmail("admin@test.com");
      admin.setPassword("111");
      admin.setTel("010-1111-1111");
      admin.setAddress("no");
      admin.setRegisterDate(new Date(System.currentTimeMillis()));

      loginUser = admin;
      userAccessLevel = ACCESS_ADMIN | ACCESS_MEMBER_ADMIN;
      return;
    } 

    HashMap<String,String> params = new HashMap<>();
    params.put("loginId", id);
    params.put("loginPassword", password);

    requestAgent.request("join.selectOneByIdPassword", params);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {

      JoinDTO joinDTO = requestAgent.getObject(JoinDTO.class);

      if (joinDTO == null) {
        System.out.println("아이디와 암호가 일치하는 회원을 찾을 수 없습니다.");
        return;
      } else if (joinDTO.getType() == PERSONAL) {
        userAccessLevel = ACCESS_MEMBER | ACCESS_PERSONAL | ACCESS_MEMBER_ADMIN;

        System.out.printf("[  %s님 환영합니다!  ]\n", joinDTO.getName());

      } else if (joinDTO.getType() == ORG) {
        userAccessLevel = ACCESS_MEMBER | ACCESS_ORG | ACCESS_MEMBER_ADMIN;

        System.out.printf("[  %s님 환영합니다!  ]\n", joinDTO.getName());
      }

      loginUser = joinDTO;
    } 
  }
}

