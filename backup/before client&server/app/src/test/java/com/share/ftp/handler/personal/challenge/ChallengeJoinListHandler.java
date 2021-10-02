package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
//import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class ChallengeJoinListHandler implements Command {


  List<ChallengeDTO> challengeDTOList;
  ChallengeJoinHandler challengeJoinHandler;

  public ChallengeJoinListHandler(List<ChallengeDTO> challengeDTOList,
      ChallengeJoinHandler challengeJoinHandler) {

    this.challengeDTOList = challengeDTOList;
    this.challengeJoinHandler = challengeJoinHandler;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 챌린지 참여자 목록 ]");
    System.out.println();

    int no = (int) request.getAttribute("no");
    System.out.println();

    ChallengeDTO challengeJoinList = findByNo(no); 

    if (challengeJoinList == null) {
      System.out.println("해당 챌린지가 없습니다.");
      return;
    }

    // 관리자 이름이 있으면 제거 (따로 명시되게끔 설정함)
    //    if (challengeJoinList.getMembers().contains(challengeJoinList.getAdmin())) {
    //      challengeJoinList.getMembers().remove(challengeJoinList.getAdmin());
    //    }

    System.out.printf("챌린지 제목 ▶ %s\n참가인원 ▶ %s명\n\n           [  챌린지 참여자명  ]\n\n%s\n",
        challengeJoinList.getTitle(),
        challengeJoinList.getTotalJoinCount(),
        challengeJoinList.getMemberNames());
  }

  private ChallengeDTO findByNo(int no) {
    for (ChallengeDTO challengeJoinList : challengeDTOList) {
      if (challengeJoinList.getNo() == no) {
        return challengeJoinList;
      }
    }
    return null;
  }
}
