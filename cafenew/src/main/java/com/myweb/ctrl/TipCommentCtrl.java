package com.myweb.ctrl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.domain.Criteria;
import com.myweb.domain.TipCommentDTO;
import com.myweb.domain.TipCommentVO;
import com.myweb.service.TipCmtService;

@RestController
@RequestMapping("/tcomment/*")
public class TipCommentCtrl {
	private static final Logger log = LoggerFactory.getLogger(TipCommentCtrl.class);
	
	@Inject
	private TipCmtService tcsv;
	
	@PostMapping(value="/new", consumes="application/json", produces="application/text; charset=utf-8")
	public ResponseEntity<String> write(@RequestBody TipCommentVO tcvo){
		log.info(">>> 댓글 기록 - POST");
		boolean isOk = tcsv.write(tcvo);
		return isOk == true ? new ResponseEntity<>("댓글이 등록되었습니다!", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/t/{tno}/{page}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<TipCommentDTO> list(@PathVariable("tno")int tno, @PathVariable("page")int page){
		log.info(">>> 댓글 리스트 페이징 - GET >>> "+tno+"번글의 "+page+"페이지 댓글 리스트");
		Criteria cri = new Criteria(page, 10);
		return new ResponseEntity<TipCommentDTO>(tcsv.list(tno, cri), HttpStatus.OK);
	}
	
	@RequestMapping(method={RequestMethod.PUT, RequestMethod.PATCH}, value="/{tcno}", consumes="application/json", produces="application/text; charset=utf-8")
	public ResponseEntity<String> modify(@PathVariable("tcno")int tcno, @RequestBody TipCommentVO tcvo){
		log.info(">>> 댓글 수정 - PUT/PATCH : " + tcno);
		tcvo.setTcno(tcno);
		return tcsv.modify(tcvo) == 1 ? new ResponseEntity<String>("댓글이 수정되었습니다.", HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value="/{tcno}", produces="application/text; charset=utf-8")
	public ResponseEntity<String> remove(@PathVariable("tcno")int tcno){
		log.info(">>> 댓글 삭제 - DELETE : " + tcno);
		return tcsv.remove(tcno) > 0 ? new ResponseEntity<>("댓글이 삭제되었습니다.", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
