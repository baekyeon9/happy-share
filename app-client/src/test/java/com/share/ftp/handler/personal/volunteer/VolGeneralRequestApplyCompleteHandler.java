package com.share.ftp.handler.personal.volunteer;

import java.util.Collection;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class VolGeneralRequestApplyCompleteHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolunteerDao volunteerDao;

  public VolGeneralRequestApplyCompleteHandler(VolunteerDao volunteerDao) {

    this.volunteerDao = volunteerDao;

  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  나의 봉사 신청서 목록  ]");
    System.out.println();

    Collection<VolunteerRequestDTO> list = volunteerDao.findAll();

    if (list.isEmpty()) {
      System.out.println("[  현재 등록된 봉사목록이 없습니다. ]");
      return;
    }

    for (VolunteerRequestDTO volunteerRequestDTO : list) {
      System.out.printf("번호: %d\n"
          + "봉사제목: %s\n"
          + "주최자: %s\n"
          + "봉사분류: %s\n"
          + "전화번호: %s\n"
          + "이메일: %s\n"
          + "봉사시작기간: %s\n"
          + "봉사종료기간: %s\n"
          + "봉사시작시간: %s\n"
          + "봉사종료시간: %s\n"
          //          + "봉사목록: %s\n"
          + "봉사인원: %d\n"
          + "봉사내용: %s\n"
          + "첨부파일: %s\n"
          + "승인여부: %s \n\n", 

          volunteerRequestDTO.getNo(), 
          volunteerRequestDTO.getTitle(), 
          volunteerRequestDTO.getOwner().getName(), 
          volunteerRequestDTO.getType(), 
          volunteerRequestDTO.getTel(),
          volunteerRequestDTO.getEmail(),
          volunteerRequestDTO.getStartDate(),
          volunteerRequestDTO.getEndDate(),
          volunteerRequestDTO.getStartTime(),
          volunteerRequestDTO.getEndTime(),
          //          personalRequestDTO.getVolList(),
          volunteerRequestDTO.getLimitNum(),
          volunteerRequestDTO.getContent(),
          volunteerRequestDTO.getFileUpload(),
          //          personalRequestDTO.isChecked(),
          volunteerRequestDTO.getStatus()
          );
    }
  }

}
