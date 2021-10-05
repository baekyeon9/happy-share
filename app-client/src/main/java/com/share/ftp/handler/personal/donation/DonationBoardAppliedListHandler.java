package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.Applied;
import java.text.DecimalFormat;
import java.util.Collection;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class DonationBoardAppliedListHandler implements Command {

  DonationBoardDao donationBoardDao;

  public DonationBoardAppliedListHandler(DonationBoardDao donationBoardDao) {

    this.donationBoardDao = donationBoardDao;

  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    DecimalFormat formatter = new DecimalFormat("###,###,###");

    Collection<DonationBoardDTO> donationBoardList = donationBoardDao.findAll();


    System.out.println();
    System.out.println("[모금함 개설 승인 목록]");

    if (donationBoardList.isEmpty()) {
      System.out.println();
      System.out.println("[  현재 승인된 모금함 개설목록이 없습니다. ]");
      return;
    }

    for (DonationBoardDTO donationBoardApplyDTO : donationBoardList) {
      if (donationBoardApplyDTO.getIsSigned().equals(Applied) && 
          donationBoardApplyDTO.getLeader().equals(AuthLoginHandler.getLoginUser().getName())) {

        System.out.printf("개설번호: %d\n모금함 분류: %s\n제목: %s\n주최자: %s\n내용: %s\n첨부파일: %s\n"
            + "개설기간: %s ~ %s\n목표금액: %s원\n승인여부: %s\n",
            donationBoardApplyDTO.getNo(), 
            donationBoardApplyDTO.getSort(), 
            donationBoardApplyDTO.getTitle(), 
            donationBoardApplyDTO.getLeader(),
            donationBoardApplyDTO.getContent(),
            donationBoardApplyDTO.getFileUpload(), 
            donationBoardApplyDTO.getRegisteredStartDate(),
            donationBoardApplyDTO.getRegisteredEndDate(),
            formatter.format(donationBoardApplyDTO.getMoneyTarget()),
            donationBoardApplyDTO.getIsSigned());
        System.out.println("--------------------------------------------------------------");

      } 
      //      else {
      //        System.out.println();
      //        System.out.println("[  현재 승인된 모금함 개설목록이 없습니다. ]");
      //        return;
      //      }
    } 
  }
}



















































