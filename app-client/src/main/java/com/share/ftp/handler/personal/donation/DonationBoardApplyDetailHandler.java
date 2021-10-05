package com.share.ftp.handler.personal.donation;

import static com.share.util.General.check.Applied;
import static com.share.util.General.check.Rejected;
import static com.share.util.General.check.Waiting;
import java.text.DecimalFormat;
import java.util.Collection;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class DonationBoardApplyDetailHandler implements Command {

  DonationBoardDao donationBoardDao;
  DonationPrompt donationPrompt;

  public DonationBoardApplyDetailHandler(
      DonationBoardDao donationBoardDao,
      DonationPrompt donationPrompt) {
    this.donationBoardDao = donationBoardDao;
    this.donationPrompt = donationPrompt;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    Collection<DonationBoardDTO> donationBoardList = donationBoardDao.findAll();

    if (donationBoardList.isEmpty()) {
      System.out.println();
      System.out.println("[ 현재 승인된 모금함 개설목록이 없습니다. ]");
      return;
    }

    DonationBoardDTO donationBoardDTO = donationPrompt.promptDonation();

    if (donationBoardDTO == null) {
      System.out.println();
      System.out.println("[ 모금함 상세보기를 취소하셨습니다. ]");
      return;
    }

    DecimalFormat formatter = new DecimalFormat("###,###,###");


    if (donationBoardDTO.getIsSigned().equals(Applied)) {
      System.out.println();
      System.out.printf("개설번호: %s\n", donationBoardDTO.getNo());
      System.out.printf("개설분류: %s\n", donationBoardDTO.getSort());
      System.out.printf("제목: %s\n", donationBoardDTO.getTitle());
      System.out.printf("주최자: %s\n", donationBoardDTO.getLeader());
      System.out.printf("내용: %s\n", donationBoardDTO.getContent());
      System.out.printf("첨부파일: %s\n", donationBoardDTO.getFileUpload());
      System.out.printf("시작일: %s\n", donationBoardDTO.getRegisteredStartDate());
      System.out.printf("종료일: %s\n", donationBoardDTO.getRegisteredEndDate());
      System.out.printf("모금함기간 ▶ %d일\n",  ((((donationBoardDTO.getRegisteredEndDate().getTime() - donationBoardDTO.getRegisteredStartDate().getTime()) / 1000)) / (24*60*60)));
      System.out.printf(getRemainTime(donationBoardDTO.getRegisteredEndDate().getTime() - System.currentTimeMillis()));
      System.out.printf("목표금액: %s원\n", formatter.format(donationBoardDTO.getMoneyTarget()));
      System.out.println();
    } else {
      System.out.println("해당 번호의 모금함 개설 신청내역이 없습니다.");
      return;
    }

    if (donationBoardDTO.getIsSigned().equals(Rejected) || donationBoardDTO.getIsSigned().equals(Waiting)) {
      System.out.println();
      System.out.println("해당 번호의 모금함 개설 신청내역이 없습니다.");
      return;
    }


    request.setAttribute("donationBoardDTO", donationBoardDTO);

    while (true) {
      String input = Prompt.inputString("기부하기(U), 모금함 기부자 내역(D), 이전(0)>");
      switch (input) {
        case "U":
        case "u":
          request.getRequestDispatcher("/donationBoardDetailRegister/add").forward(request);
          return;
        case "D":
        case "d":
          request.getRequestDispatcher("/donationBoardRegister/list").forward(request);
          return;
        case "0":
          return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }


  }

  protected static String getRemainTime(long millis) {

    long sec = millis / 1000;
    long min = sec / 60;
    long hour = min / 60;
    long day = millis / 1000 / (24 * 60 * 60);

    hour = hour % 24; 
    sec = sec % 60;
    min = min % 60;

    return String.format("남은시간 ▶ %d일 %d시간 %d분 %d초 남았습니다\n", day, hour, min, sec);
  }
}




















































