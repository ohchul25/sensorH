///**
// *
// */
//package com.sensor.interceptor;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
///**
// * @author 윤정욱
// *
// */
//public class CommonInterceptorExample extends HandlerInterceptorAdapter {
//
//	@Autowired
//	private DefaultListableBeanFactory defaultListableBeanFactory;
//
//	/** Log */
//	private static final Logger LOGGER = LoggerFactory.getLogger(CommonInterceptorExample.class);
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse reponse, Object handler) throws Exception{
//		//먼저 세션처리
////        HttpSession session = request.getSession();
////        SessionVO sessionVO = (SessionVO)session.getAttribute(SessionInfo.SSN_KEY);
////
////        if(sessionVO == null) {
////			LOGGER.debug("########## 세션정보가 없습니다. ##########");
////			throw new SessionException();
////        	//reponse.sendRedirect("/main.do");
////        	//return false;
////        }
//
//        //접속 IP
////        String clientIP1 = EgovClntInfo.getClntIP(request);
////        String clientIP = InetAddress.getLocalHost().getHostAddress();
////        String clientIP = EgovClntInfo.getClntIP(request);
//
////        LOGGER.debug("clientIP ====>" + clientIP);
//
//        //임의의 허용 IP -- DB에서 가져와서 처리해야함.... 캐쉬사용 검토해야 할것으로 보임
//        //ArrayList accessIP = new ArrayList();
//        //accessIP.add("192.1.1.1");
////        List<PermIpEstbsVO> resultList = permIpEstbsService.searchPermIpEstbsCashAjaxList();
////        boolean chkIp = false;
////        String cmpIp ="";
////        if(resultList.size()>0) {
////        	for(int i=0;i<resultList.size();i++) {
////        		//먼저 C타입인 경우 *뺴고 시작하는 IP이거나 일반인 경우 IP 같으면 TRUE
////        		if("Y".equals(resultList.get(i).getIpScopeEstbsAt())) {
////        			cmpIp = resultList.get(i).getPermIp().replaceAll("\\*", "");
////        			if(clientIP.startsWith(cmpIp)) {
////        				chkIp = true;
////        				break;
////        			}
////        		}else {
////        			if(clientIP.equals(resultList.get(i).getPermIp())) {
////        				chkIp = true;
////        				break;
////        			}
////        		}
////            }
////        }
////
////        //개발서버에서 클라이언트 IP체크 후 지울것
////        //chkIp = true;
////        if(!chkIp) {
////        	//reponse.sendRedirect("/main.do");
////        	session.invalidate();
////        	throw new IpAllowException();
////        }
//
//        //header.jsp의 fnGoMenu()로 넘어온 경우 메뉴ID를 session에 저장한다.
////        if(!"".equals(StringUtil.nvl(request.getParameter("menuAt")))) {
////        	session.setAttribute("upperMenuId", request.getParameter("upperMenuId"));
////        	session.setAttribute("menuId", request.getParameter("menuId"));
////        	session.setAttribute("groupCode", sessionVO.getGroupCode());
////        }
//
//        /**
//         * 2. 메뉴 권한 체크
//         */
//        String serverName = "";
//        String requestUri = "";
//
////		if (request != null) {
////			serverName = request.getServerName();
////			requestUri = StringUtil.nvl(request.getRequestURI());
////
////			LOGGER.debug("serverName || requestUri = > " + serverName + "||" + requestUri);
////		}
//
//		RequestMappingHandlerMapping requestMappingHandlerMapping = defaultListableBeanFactory.getBean(RequestMappingHandlerMapping.class);
//        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
//
//        //RequestMapping의 MenuDescription 정보를 가져온다.
////        Map<String, MenuDescVO> menuDescMap = commonService.getMenuDescList(map);
////        String groupCode = SessionInfo.getLoginGroupCode();
////
////        if("".equals(groupCode)) {
////			LOGGER.debug("########## 세션정보가 없습니다. ##########");
////			throw new SessionException();
////        }
//
//    	//1) 해당 URL의 RequestMapping 정보를 가져온다.
//    	//MenuDescVO menuDescVO = menuDescMap.get(requestUri);
//
////		if(menuDescVO == null) {
////			LOGGER.debug("########## @MenuDiscription 이 작성되지 않은 주소입니다. ########## Call Url => " + requestUri);
////			//throw new Exception();
////		}
////
////		//2) menuDescVO.getMenuId()로 DB에 등록된 계정의 메뉴 권한 정보를 가져온다.
////		List<MenuMgtVO> menuMgtList = new ArrayList<MenuMgtVO>();
////
////		MenuMgtVO menuMgtVO = new MenuMgtVO();
////		menuMgtVO.setGroupCode(groupCode);
////
////    	if(menuDescVO != null) {
//
//    		/*
//    		//게시판의 경우 requestUri는 동일하기 때문에 파라미터 체크하여 selectMenuAuthInfoByMenuId조회 시 where 절에 포함한다.
//			if("bbsTyCode".equals(request.getQueryString())) {
//				requestUri +=  "?bbsTyCode=" + request.getParameter("bbsTyCode");
//				menuMgtVO.setWebPath(requestUri);
//			}
//			*/
//
////    		menuMgtVO.setArrMenuId(menuDescVO.getMenuId());
////
////    		menuMgtList = menuMgtService.selectMenuAuthInfoByMenuId(menuMgtVO);
////    	}
////
////		//3) (2)에서 가져온 권한 정보와 menuDescMap을 비교하여 권한 여부를 판단한다.
////		boolean menuAuthAt = false;
////
////		loopOut:
////		for(MenuMgtVO mmVO : menuMgtList) {
////			//게시판의 경우 파라미터로 게시판(공지사항,자료실,주요일정..) 구분하기 때문에 URL 체크까지 추가할 것!!
////			if(menuDescVO != null && menuDescVO.getRoleCode() != null) {
////
////				String referer = request.getHeader("referer");
////				if (referer == null) { // URL로 직접치고 들어왔을 경우
////					String menuId = StringUtil.nvl(mmVO.getMenuId());
////					if (!StringUtil.isEmpty(menuId)) {
////						session.setAttribute("upperMenuId", getUpperMenuId(StringUtil.nvl(mmVO.getMenuId()), StringUtil.nvl(sessionVO.getGroupCode())));
////						session.setAttribute("menuId", mmVO.getMenuId());
////						session.setAttribute("groupCode", sessionVO.getGroupCode());
////					}
////				}
////
////				for(int i=0;i<menuDescVO.getRoleCode().length();i++) {
////					if(mmVO != null && mmVO.getRoleCode().contains(StringUtil.nvl(menuDescVO.getRoleCode().charAt(i)))) {
////						menuAuthAt = true;
////						break loopOut;
////					}
////				}
////			}
////		}
////
////		if(!menuAuthAt && !"Admin".equals(menuMgtVO.getGroupCode())) {
////			LOGGER.debug("########## 접근 권한이 없거나, @MenuDiscription의 menuId 와 DB에 등록된 menuId가 일치하는지 확인해주세요. ########## Call Url => " + requestUri);
////			//메뉴 권한 적용할 시 주석 풀어줄것!!
////			throw new AuthException();
////		}
////
//////        /**
//////         * 3. 로그 저장
//////         */
//////		String fnName = "";
//////		if(menuDescVO != null) {
//////			fnName = menuDescVO.getMethodName();
//////		}
//////		stdntLogService.makeLog(sessionVO, request, fnName);
//////
//        return true;
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse reponse, Object handler, ModelAndView modelAndView) throws Exception{
//		if(modelAndView != null) {
//			HttpSession session = request.getSession();
//
////			if(session != null) {
////				LOGGER.debug("##############InterCeptor - postHandle"+request.getParameter("upperMenuId")+","+request.getParameter("groupCode"));
////				modelAndView.addObject("upperMenuId", session.getAttribute("upperMenuId"));
////				modelAndView.addObject("upperMenuNm", getMenuNm(StringUtil.nvl(session.getAttribute("upperMenuId")), StringUtil.nvl(session.getAttribute("groupCode"))));
////				modelAndView.addObject("menuId", session.getAttribute("menuId"));
////				modelAndView.addObject("menuNm", getMenuNm(StringUtil.nvl(session.getAttribute("menuId")), StringUtil.nvl(session.getAttribute("groupCode"))));
////			}
//		}
//	}
//
//	// 메뉴코드로 메뉴명 가져오기
//	public String getMenuNm(String menuId, String groupCode) throws Exception{
//		String menuNm = "";
////	    MenuMgtVO mVO = new MenuMgtVO();
////
////	    if(groupCode == null || "".equals(groupCode)) {
////	    	groupCode = SessionInfo.getLoginGroupCode();
////	    }
////	    mVO.setGroupCode(groupCode);
////	    List<MenuMgtVO> resultList = menuMgtService.searchMenuAjaxList(mVO);
////	    for(int i=0;i<resultList.size();i++) {
////	    	if(menuId != null){
////	    		if(menuId.equals(resultList.get(i).getMenuId())) {
////	    			menuNm = resultList.get(i).getSj();
////	         		break;
////	         	}
////	    	}
////	   }
//
//		return menuNm;
//	}
//
//	// 메뉴코드로 상위메뉴ID 가져오기
//	public String getUpperMenuId(String menuId, String groupCode) throws Exception{
//		String upperMenuId = "";
////	    MenuMgtVO mVO = new MenuMgtVO();
////
////	    if(groupCode == null || "".equals(groupCode)) {
////	    	groupCode = SessionInfo.getLoginGroupCode();
////	    }
////	    mVO.setGroupCode(groupCode);
////	    List<MenuMgtVO> resultList = menuMgtService.searchMenuAjaxList(mVO);
////	    for(int i=0;i<resultList.size();i++) {
////	    	if(menuId != null){
////	    		if(menuId.equals(resultList.get(i).getMenuId())) {
////	    			upperMenuId = resultList.get(i).getUpperMenuId();
////	         		break;
////	         	}
////	    	}
////	   }
//
//		return upperMenuId;
//	}
//}