package com.myweb.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.myweb.domain.NoticeVO;
import com.myweb.domain.TipVO;

@Component
public class FileProcess {
	private static final Logger log = LoggerFactory.getLogger(FileProcess.class);
	
	@Resource(name="upImages")
	String upImages;
	
	public TipVO filesave(MultipartHttpServletRequest req) throws IllegalStateException, IOException {
		log.info(">>> 파일 저장 - Multi");
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		MultipartFile imgfile = req.getFile("imgfile");
		
		TipVO tvo = new TipVO(title, writer, content);
		if(imgfile.isEmpty()) {
			tvo.setImgfile("NONE");
		}else {
			String orgFileName = imgfile.getOriginalFilename();	//첨부한 파일에서 파일이름 추출
			String saveFileName = UUID.randomUUID().toString() + "_" + orgFileName;	//중복되지 않은 파일이름 생성
			File file = new File(upImages+saveFileName);	//파일객체 생성
			imgfile.transferTo(file);	//파일 객체 복사
			tvo.setImgfile(saveFileName);	//vo객체에 파일명 저장
		}
		return tvo;
	}
	
	public NoticeVO fileUp(MultipartHttpServletRequest req) throws IllegalStateException, IOException {
		log.info(">>> 파일 저장 - Multi");
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		MultipartFile imgfile = req.getFile("imgfile");
		
		NoticeVO nvo = new NoticeVO(title, writer, content);
		if(imgfile.isEmpty()) {
			nvo.setImgfile("NONE");
		}else {
			String orgFileName = imgfile.getOriginalFilename();
			String saveFileName = UUID.randomUUID().toString() + "_" + orgFileName;
			File file = new File(upImages+saveFileName);
			imgfile.transferTo(file);
			nvo.setImgfile(saveFileName);
		}
		return nvo;
	}

	public TipVO fileModify(MultipartHttpServletRequest req) throws IllegalStateException, IOException {
		log.info(">>> 파일 수정 - Multi");
		int tno = Integer.parseInt(req.getParameter("tno"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String imgfile = req.getParameter("imgfile");
		MultipartFile new_imgfile = req.getFile("new_imgfile");

		TipVO tvo = new TipVO(tno, title, content);
		if(new_imgfile.isEmpty()) {
			tvo.setImgfile(imgfile);
		}else {
			String orgFileName = new_imgfile.getOriginalFilename();	//첨부한 파일에서 파일이름 추출
			String saveFileName = UUID.randomUUID().toString() + "_" + orgFileName;	//중복되지 않은 파일이름 생성
			File file = new File(upImages+saveFileName);	//파일객체 생성
			new_imgfile.transferTo(file);	//파일 객체 복사
			tvo.setImgfile(saveFileName);	//vo객체에 파일명 저장
			fileRemove(imgfile);
		}
		return tvo;
	}
	
	public NoticeVO fileReLoad(MultipartHttpServletRequest req) throws IllegalStateException, IOException {
		log.info(">>> 파일 수정 - Multi");
		int num = Integer.parseInt(req.getParameter("num"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String imgfile = req.getParameter("imgfile");
		MultipartFile new_imgfile = req.getFile("new_imgfile");
		
		NoticeVO nvo = new NoticeVO(num, title, content);
		if(new_imgfile.isEmpty()) {
			nvo.setImgfile(imgfile);
		}else {
			String orgFileName = new_imgfile.getOriginalFilename();
			String saveFileName = UUID.randomUUID().toString() + "_" + orgFileName;
			File file = new File(upImages+saveFileName);
			new_imgfile.transferTo(file);
			nvo.setImgfile(saveFileName);
			fileRemove(imgfile);
		}
		return nvo;
	}

	public void fileRemove(String imgfile) {
		log.info(">>> 파일 삭제 - Multi");
		new File(upImages+imgfile).delete();
	}
}
