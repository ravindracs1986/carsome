
package com.carsome.portal.model;


import java.util.HashMap;
import java.util.Map;





public class PopupBox {

	private PopupBox() {
		throw new IllegalStateException("PopupBox class");
	}


	private static final String SUCCESS = "success";

	private static final String INFO = "info";

	private static final String ERROR = "error";

	private static final String WARN = "warn";

	private static final String CONFIRM = "confirm";

	private static final String QUESTION = "question";


	public static Map<String, Object> question(String id, Object content) {
		return question(id, null, content);
	}


	public static Map<String, Object> question(String id, String title, Object content) {
		return getPopup(id, QUESTION, title, content);
	}


	public static Map<String, Object> success(String id, Object content) {
		return success(id, null, content);
	}


	public static Map<String, Object> success(String id, String title, Object content) {
		return getPopup(id, SUCCESS, title, content);
	}


	public static Map<String, Object> success(String id, String title, Object content, String redirectLink) {
		return getPopup(id, SUCCESS, title, content, redirectLink);
	}


	public static Map<String, Object> info(Object content) {
		return info(null, null, content);
	}


	public static Map<String, Object> info(String id, Object content) {
		return info(id, null, content);
	}


	public static Map<String, Object> info(String id, String title, Object content) {
		return getPopup(id, INFO, title, content);
	}


	public static Map<String, Object> info(String id, String title, Object content, String redirectLink) {
		return getPopup(id, INFO, title, content, redirectLink);
	}


	public static Map<String, Object> warn(String id, Object content) {
		return warn(id, null, content);
	}


	public static Map<String, Object> warn(String id, String title, Object content) {
		return getPopup(id, WARN, title, content);
	}


	public static Map<String, Object> warn(String id, String title, Object content, String redirectLink) {
		return getPopup(id, WARN, title, content, redirectLink);
	}


	public static Map<String, Object> confirm(String id, String title, Object content, String redirectLink) {
		return getPopup(id, CONFIRM, title, content, redirectLink);
	}


	public static Map<String, Object> error(Object content) {
		return error(null, null, content);
	}


	public static Map<String, Object> error(String id, Object content) {
		return error(id, null, content);
	}


	public static Map<String, Object> error(String id, String title, Object content) {
		return getPopup(id, ERROR, title, content);
	}


	public static Map<String, Object> error(String id, String title, Object content, String redirectLink) {
		return getPopup(id, ERROR, title, content, redirectLink);
	}


	private static Map<String, Object> getPopup(String id, String type, String title, Object content) {
		return getPopup(id, type, title, content, null);
	}


	private static Map<String, Object> getPopup(String id, String type, String title, Object content,
			String redirectLink) {
		Map<String, Object> map = new HashMap<>();
		map.put("mainPopupId", id);
		map.put("mainMessageType", type);
		if (title!=null) {
			map.put("mainPopupTitle", title);
		}
		if (redirectLink!=null) {
			map.put("redirectLink", redirectLink);
		}
		map.put("mainMessage", content);
		return map;
	}

}