package com.share.ftp.handler.personal.community;

import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.community.CommBoardDTO;
import com.share.ftp.domain.community.CommBoardReplyDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommBoardReplyDeleteHandler implements Command {

  CommunityDao communityDao;

  public CommBoardReplyDeleteHandler (CommunityDao communityDao) {
    this.communityDao = communityDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    while (true) {
      System.out.println();
      System.out.println("[  나눔이야기 댓글 삭제  ]");

      int commBoardNo = (int) request.getAttribute("commBoardNo");
      CommBoardDTO commBoardDTO = communityDao.findByCommNo(commBoardNo);

      int updateNo = (int) request.getAttribute("commBoardReplyNo");
      CommBoardReplyDTO commBoardReplyDTO = communityDao.findByCommReplyNo(commBoardNo, updateNo);

      try {

        if (commBoardReplyDTO == null) {
          System.out.println("[ 해당 번호의 댓글이 없습니다.  ]");
          return;
        }

        if (!commBoardReplyDTO.getOwner().getId().contains(AuthLoginHandler.getLoginUser().getId())) {
          System.out.println("삭제 권한이 없습니다.");
          return;
        }

        while (true) {
          String input = Prompt.inputString("[  정말 삭제하시겠습니까?(y/N)  ]");
          if (input.equalsIgnoreCase("n") || input.length() == 0) {
            System.out.println();
            System.out.println("[  댓글 삭제를 취소하였습니다.  ]");
            return;

          } else if(input.equals("y")) {
            System.out.println();
            System.out.println("[  댓글을 삭제하였습니다.  ]");

            communityDao.updateCommReply(commBoardReplyDTO);
            communityDao.deleteCommeReply(commBoardReplyDTO);

            return;
          }

          else  {
            System.out.println("[  y 또는 n을 입력하세요.  ]");
            continue;  
          } 
        }

      } catch (Throwable e) {

      }
    }
  }
}



