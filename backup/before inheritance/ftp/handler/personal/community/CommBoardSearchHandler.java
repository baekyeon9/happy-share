package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.util.Prompt;

public class CommBoardSearchHandler extends AbstractCommBoardHandler {

  public CommBoardSearchHandler(List<CommBoardDTO> commBoardDTOList) {
    super(commBoardDTOList);
  }

  @Override
  public void execute() {
    String input = Prompt.inputString("검색어? ");

    for(CommBoardDTO commBoardDTO : commBoardDTOList) {
      if(!commBoardDTO.getTitle().contains(input) &&
          !commBoardDTO.getContent().contains(input)) {
        continue;
      }

      System.out.printf("제목 ▶ %s\n", commBoardDTO.getTitle());
      System.out.printf("내용 ▶ %s\n", commBoardDTO.getContent());
    }
  }
}
