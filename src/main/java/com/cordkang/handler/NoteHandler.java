//package com.cordkang.handler;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import com.cordkang.domain.MemberVO;
//import com.cordkang.domain.NoteVO;
//import com.cordkang.service.NoteService;
//import com.google.gson.Gson;
//
//import lombok.extern.log4j.Log4j;
//// ServerSocat
//@Log4j
//@EnableWebSocket
//public class NoteHandler extends TextWebSocketHandler {
//    // 접속자 관리 객체
//	private List<WebSocketSession> sessions = new ArrayList<WebSocketSession>(); 
//	@Autowired
//	private NoteService noteService;
//	@Override
//	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//		log.warn("입장한사람 : " + getIdBySession(session));
////		sessions.add(session);
////		log.warn("현재 접속자 수 " + sessions.size());
////		log.warn("현재 접속자 정보 ");
//		sessions.forEach(log::warn);
//		
//		log.warn(sessions.stream().map(s->getIdBySession(s)).collect(Collectors.toList()));
//	}
//
//	@Override
//	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//		log.warn(session.getId() + " 로그아웃");
//		sessions.remove(session);
//	}
//	@Override
//	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//	//	log.warn(noteService);
//		String receiver = message.getPayload();  //js, ws.send() 수신자
//		String sender = getIdBySession(session);
//		List<NoteVO> list0 = noteService.getSendList(getIdBySession(session));
//		List<NoteVO> list1 = noteService.getReceiveList(receiver);
//		List<NoteVO> list2 = noteService.getReceiveUnchekedList(receiver);
//		
//		Map<String, Object> map = new HashMap<>();
//		map.put("sendList", list0);
//		map.put("receiveList", list1);
//		map.put("receiveUnchekedList", list2);
//		map.put("sender", sender);
//		
//		Gson gson = new Gson();
//		for(WebSocketSession s : sessions){
//			if(receiver.equals(getIdBySession(s)) || session == s){
//				s.sendMessage(new TextMessage(gson.toJson(map)));
//			}
//		}
//		// A > B
//		
//		
////		String msg = message.getPayload();
////		Gson gson = new Gson();
////		NoteVO vo = gson.fromJson(msg, NoteVO.class);
////		MemberVO memberVO = (MemberVO)session.getAttributes().get("member");
////		log.warn(msg);
////		log.warn(vo);
////		log.warn(memberVO);
////		for(WebSocketSession s : sessions){
////			s.sendMessage(new TextMessage(session.getId() + " :: " + msg));
////		}
//		
//	}
//
//	// lifecycle
//	// 접속 실제할일 종료
//    private String getIdBySession(WebSocketSession session){
//    	Object obj = session.getAttributes().get("member");
//    	String id = null;
//    	if(obj != null && obj instanceof MemberVO){
//    		id = ((MemberVO)obj).getId();
//    	}
//		return id;
//    }
//}
