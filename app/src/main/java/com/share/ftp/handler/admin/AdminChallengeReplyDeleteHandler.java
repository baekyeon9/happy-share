package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.personal.challenge.AbstractChallengeQuestionHandler;
import com.share.util.Prompt;

public class AdminChallengeReplyDeleteHandler extends AbstractChallengeQuestionHandler {




  public AdminChallengeReplyDeleteHandler(List<ChallengeQuestionDTO> challengeQuestionDTOList,
      List<ChallengeDTO> challengeDTOList, List<ChallengeQuestionDTO> challengeReplyList) {
    super(challengeQuestionDTOList, challengeDTOList, challengeReplyList);

  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    while (true) {
      System.out.println("[ 문의답글 삭제 ]");
      System.out.println();

      int challengeNo = (int) request.getAttribute("no");

      ChallengeDTO challengeList = findByChallengeNo(challengeNo); 

      if (challengeList == null) {
        System.out.println("해당 챌린지가 없습니다.");
        return;
      }

      int deleteNo = (int) request.getAttribute("questionNo");

      ChallengeQuestionDTO challengeQuestion = findByQuestionNo(deleteNo);

      try {
        if (challengeQuestion == null) {
          System.out.println("해당 번호의 답글이 없습니다.");
          return;
        }


        String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
        if (input.equalsIgnoreCase("n") || input.length() == 0) {
          System.out.println("답글 삭제를 취소하였습니다.");
          return; 

        } else if (challengeQuestion.getContent().equals("삭제된 댓글입니다")) {
          System.out.println("이미 삭제 된 댓글입니다!");
          return;

        } else if (input.equals("y")) {
          System.out.println("해당 문의답글을 삭제하였습니다.");
          challengeList.setQuestionCount(challengeList.getQuestionCount() - 1);
          challengeQuestion.setContent("삭제된 답글입니다");


          //          challengeQuestion.setQuestionNo(challengeQuestion.getQuestionNo() - 1);
          //          challengeQuestionDTOList.remove(challengeQuestion);
          return;
        } else {
          System.out.println("y 또는 n을 입력하세요.");
          continue;
        } 
      } catch (Exception e) {
        e.printStackTrace();

      }
    }
  }
}
